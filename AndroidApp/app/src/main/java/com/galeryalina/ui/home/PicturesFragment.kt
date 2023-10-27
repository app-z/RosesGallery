package com.galeryalina.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.galeryalina.ui.theme.ComposeGalleryAppTheme
import com.galeryalina.MainActivity
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.databinding.FragmentHomeBinding
import com.galeryalina.domain.model.Picture
import com.galeryalina.ui.PictureCardList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class PicturesFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val picturesViewModel: PicturesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    private fun itemClick(itemId: Int) {
        Timber.d("Item click $itemId")
        (requireActivity() as MainActivity).navigateToDetail(itemId)
    }

    @Composable
    fun Pictures(pictureList: List<Picture>) {
        PictureCardList(pictureList, ::itemClick)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                picturesViewModel.pictures.collect { pictures ->
                    Timber.d("pictures = {$pictures}")

                    when (pictures) {
                        is ResponseResult.Success -> showPictureList(pictures.response)
                        is ResponseResult.Error -> pictures.exception
                        is ResponseResult.Loading -> Timber.d("Loading...")
                    }
                }
            }
        }

        picturesViewModel.requestPictures()
    }


    private fun showPictureList(pictures: List<Picture>) {
        binding.composeView.apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeGalleryAppTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier
                            .statusBarsPadding()
                            .navigationBarsPadding(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Pictures(pictures)
                    }
                }

            }
        }
    }

    @Preview
    @Composable
    fun ShowPicturesPreview() {
        Pictures(listOf(
            Picture(id = 1, authorId = 2, "Pic1", null, "", 10000),
            Picture(id = 2, authorId = 3, "Pic2", null,"", 20000))
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}