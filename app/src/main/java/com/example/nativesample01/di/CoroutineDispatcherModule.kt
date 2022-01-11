package com.example.nativesample01.di

import com.example.nativesample01.di.qualifier.DefaultDispatcher
import com.example.nativesample01.di.qualifier.IoDispatcher
import com.example.nativesample01.di.qualifier.MainDispatcher
import com.example.nativesample01.di.qualifier.MainImmediateDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object CoroutineDispatcherModule {

    @IoDispatcher
    @Provides
    fun provideIoDispatcher():CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun provideMainDispatcher():CoroutineDispatcher = Dispatchers.Main

    @DefaultDispatcher
    @Provides
    fun provideDefaultDispatcher():CoroutineDispatcher = Dispatchers.Default

    @MainImmediateDispatcher
    @Provides
    fun provideMainImmediateDispatcher():CoroutineDispatcher = Dispatchers.Main.immediate
}