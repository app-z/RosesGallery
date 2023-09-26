package com.galeryalina.db

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }


    @TypeConverter
    fun fromLongList(value: List<Long>?): String?{
        value?.let { longs ->
            var str = ""
            longs.forEach {
                str += it.toString().plus(';')
            }
            return str
        }
        return null
    }

    @TypeConverter
    fun toLongList(value: String?): List<Long>?{
        value?.let { str ->
            // do refactor it!
            return str.split(";").filter { it.isNotEmpty() }.map {
                it.toLong()
            }
        }
        return null
    }
}
