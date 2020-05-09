package com.test.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.data.post.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private val postRepository: PostRepository): ViewModel() {
    fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            Timber.d("posts: ${postRepository.getPosts()[0].title}")
        }
    }
}