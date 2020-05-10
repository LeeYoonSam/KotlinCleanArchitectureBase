package com.test.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.test.data.util.viewModelProvider
import com.test.databinding.ActivityMainBinding
import com.test.model.Photo
import dagger.android.AndroidInjection
import org.threeten.bp.ZoneId
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            lifecycleOwner = this@MainActivity
        }

        setContentView(binding.root)

        mainViewModel = viewModelProvider(viewModelFactory)
        binding.mainVm = mainViewModel
        mainViewModel.getPhotoData()
    }
}