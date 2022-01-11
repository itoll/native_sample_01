package com.example.nativesample01.di.qualifier

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutineScopeModule {

    @Singleton
    @Provides
    fun provideCoroutineScope(
        @DefaultDispatcher coroutineDispatcher: CoroutineDispatcher,
    ): CoroutineScope =
        CoroutineScope(SupervisorJob() + coroutineDispatcher)

}