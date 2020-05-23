package com.test.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
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

        mainViewModel.error.observe(this, Observer { Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show() })
        binding.mainVm = mainViewModel
        mainViewModel.getPhotoData()
    }
}