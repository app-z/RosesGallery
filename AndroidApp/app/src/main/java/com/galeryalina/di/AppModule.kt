package com.galeryalina.di

import android.content.Context
import com.galeryalina.remote.ApiServices
import com.galeryalina.Constants
import com.galeryalina.db.GaleryDao
import com.galeryalina.local.LocalDataSource
import com.galeryalina.db.GaleryDatabase
import com.galeryalina.domain.repository.GalleryRepository
import com.galeryalina.domain.repository.GalleryRepositoryImpl
import com.galeryalina.remote.RemoteDataSourceImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): GaleryDatabase = GaleryDatabase.getDatabase(appContext, CoroutineScope(SupervisorJob()))

    @Singleton
    @Provides
    fun provideBookingDao(db: GaleryDatabase): GaleryDao = db.dao()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(Constants.DB_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideDefaultOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().callTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).addInterceptor(loggingInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideApiServices(retrofitClient: Retrofit): ApiServices {
        return retrofitClient.create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideAppRepository(
        api: ApiServices, localDataSource: LocalDataSource
    ): GalleryRepository {
        val remoteDataSourceImpl = RemoteDataSourceImpl(api)
        return GalleryRepositoryImpl(remoteDataSourceImpl, localDataSource = localDataSource)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(spaceXDao: GaleryDao): LocalDataSource {
        return LocalDataSource(spaceXDao)
    }
}
