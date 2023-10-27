package com.galeryalina.ui.authors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.galeryalina.data.common.ResponseResult
import com.galeryalina.databinding.FragmentAuthorsBinding
import com.galeryalina.domain.model.Author
import com.galeryalina.ui.theme.ComposeGalleryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Date

@AndroidEntryPoint
class AuthorsFragment : Fragment() {

    private var _binding: FragmentAuthorsBinding? = null

    private val authorsViewModel: AuthorsViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAuthorsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                authorsViewModel.authors.collect { result ->
                    when (result) {
                        is ResponseResult.Success -> showAuthors(result.response)
                        is ResponseResult.Error -> result.exception
                        is ResponseResult.Loading -> Timber.d("Loading...")
                    }
                    Timber.d("authors =  $result")
                }
            }
        }

        authorsViewModel.requestAuthors()

    }


    private fun showAuthors(authors: List<Author>) {
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
                        color = androidx.compose.material3.MaterialTheme.colorScheme.background
                    ) {
                        AuthorList(authors = authors, onClicker = {})
                    }
                }

            }
        }
    }

    @Composable
    fun AuthorList(authors: List<Author>, onClicker: (Int) -> Unit) {
        LazyColumn {
            items(
                items = authors,
                key = { author ->
                    // Return a stable + unique key for the item
                    author.id
                }
            ) { author ->
                AuthorRow(author)
            }
        }
    }

    @Composable
    private fun AuthorRow(author: Author) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp)
        ) {
            Text(
                style = MaterialTheme.typography.h5,
                text = author.name)
            author.story?.let {
                Text(
                    style = MaterialTheme.typography.body2,
                    maxLines = 2,
                    text = it,
                )
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Preview
    @Composable
    fun authorRowPreview() {
        val author = Author(
            1L, "Author",
            "Story about author", "", listOf(1, 2, 3), null
        )
        AuthorRow(author)

    }

}