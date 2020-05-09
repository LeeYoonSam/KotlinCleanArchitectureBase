package com.test.di

import android.content.Context
import com.test.AppApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    fun provideContext(application: AppApplication): Context {
        return application.applicationContext
    }
}