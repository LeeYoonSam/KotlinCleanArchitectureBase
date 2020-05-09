package com.test.di

import com.test.AppApplication
import com.test.data.di.DataModule
import com.test.data.di.NetworkModule
import com.test.data.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        DataModule::class,
        NetworkModule::class
    ])
interface ApplicationComponent : AndroidInjector<AppApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: AppApplication): ApplicationComponent
    }
}