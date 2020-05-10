package com.test.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.data.photo.PhotoRepository
import com.test.data.post.PostRepository
import com.test.model.Photo
import com.test.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val postRepository: PostRepository,
    private val photoRepository: PhotoRepository
): ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    fun getPostData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = postRepository.getPosts()
            Timber.d("posts: ${result[0].title}")
            _posts.postValue(result)
        }
    }

    fun getPhotoData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = photoRepository.getPhotos()

            withContext(Dispatchers.Main) {
                _photos.value = result
            }
        }
    }
}