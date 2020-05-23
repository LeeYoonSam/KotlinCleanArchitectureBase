package com.test.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.test.BaseViewModel
import com.test.data.photo.PhotoRepository
import com.test.data.post.PostRepository
import com.test.model.Photo
import com.test.model.Post
import com.test.model.Result
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val postRepository: PostRepository,
    private val photoRepository: PhotoRepository
): BaseViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun getPostData() {
        startLoading()

        viewModelScope.launch(IO) {
            val result = postRepository.getPosts()
            Timber.d("posts: ${result[0].title}")
            _posts.postValue(result)

            stopLoading()
        }
    }

    fun getPhotoData() {
        startLoading()

        viewModelScope.launch(Main) {
            when(val result = withContext(IO) { photoRepository.getPhotos() }) {
                is Result.Success -> _photos.value = result.data
                is Result.Error -> logError(result.exception)
                else -> Result.Loading
            }

            stopLoading()
        }
    }
}