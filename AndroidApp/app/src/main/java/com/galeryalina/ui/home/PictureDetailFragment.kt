package com.galeryalina.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.composegenapp.ui.theme.ComposeGalleryAppTheme
import com.galeryalina.data.Picture
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.databinding.FragmentNotificationsBinding
import com.galeryalina.databinding.FragmentPictureDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class PictureDetailFragment : Fragment() {

    private var _binding: FragmentPictureDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val pictureDetailViewModel: PictureDetailViewModel by viewModels()

    private val args: NavArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPictureDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            pictureDetailViewModel.picture.collect { result ->

                when (result) {
                    is ResponseResult.Success -> {
                        if (result.response != null) {
                            showPicture(picture = result.response)
                        }
                    }
                    is ResponseResult.Error -> Timber.d("${result}")
                    is ResponseResult.Loading -> Timber.d("Loading...")
                }
                Timber.d("picture = {$result}")
            }
        }

        val pictureId = arguments?.getString("pictureId", "0")
        Timber.d("arguments = ${arguments}")

        pictureDetailViewModel.requestPictureById(pictureId?.toInt()!!)
    }

    private fun showPicture(picture: Picture) {
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
                        Text(text = picture.name)
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}