package com.galeryalina.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.composegenapp.ui.theme.ComposeGalleryAppTheme
import com.galeryalina.MainActivity
import com.galeryalina.data.Picture
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.databinding.FragmentHomeBinding
import com.galeryalina.ui.PictureCardList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class PicturesFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

//    var mutableshowDetail = false
// var showDetail by remember { mutableStateOf(mutableshowDetail) }


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
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Pictures(pictures)
                    }

//                    if(showDetail) {
//                        DetailScreen()
//                    }
                }

            }
        }
    }


    @Preview
    @Composable
    fun ShowPicturesPreview() {
//        showPicture(listOf(
//            Picture(id = 1, authorId = 2, "Pic1", "", 10000),
//            Picture(id = 2, authorId = 3, "Pic2", "", 20000))
//        )

//        PictureItem(Picture(id = 1, authorId = 2, "Pic1", "", 10000), clicker = null)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}