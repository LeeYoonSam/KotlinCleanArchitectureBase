package com.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.test.data.photo.PhotoRepository
import com.test.data.post.PostRepository
import com.test.main.MainViewModel
import com.test.model.Photo
import com.test.model.Post
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

import org.junit.Rule

class MainViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private val mockPostRepository: PostRepository = mock()
    private val mockPhotoRepository: PhotoRepository = mock()
    private val postObserver: Observer<List<Post>> = mock()
    private val photoObserver: Observer<List<Photo>> = mock()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setupViewModel() {
        viewModel = MainViewModel(mockPostRepository, mockPhotoRepository)
        viewModel.posts.observeForever(postObserver)
        viewModel.photos.observeForever(photoObserver)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getPostRepository() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val dummyPosts = listOf(
            Post(1, 1, "title1", "body1"),
            Post(2, 2, "title2", "body2")
        )
        whenever(mockPostRepository.getPosts()).thenReturn(dummyPosts)
        viewModel.getPostData()

        verify(postObserver).onChanged(dummyPosts)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getPhotoRepository() = coroutinesTestRule.testDispatcher.runBlockingTest {
        val dummyPhotos = listOf(
            Photo(1, 1, "title1", "body1", "thumb1"),
            Photo(2, 2, "title2", "body2", "thumb2")
        )
        whenever(mockPhotoRepository.getPhotos()).thenReturn(dummyPhotos)
        viewModel.getPhotoData()

        verify(photoObserver).onChanged(dummyPhotos)
    }
}