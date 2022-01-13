package com.example.nativesample01.di

import com.example.nativesample01.data.dataSource.detail.local.DetailLocalDataSource
import com.example.nativesample01.data.dataSource.detail.local.DetailLocalDataSourceImpl
import com.example.nativesample01.data.dataSource.home.local.HomeLocalDataSource
import com.example.nativesample01.data.dataSource.home.local.HomeLocalDataSourceImpl
import com.example.nativesample01.data.repository.detail.DetailRepositoryImpl
import com.example.nativesample01.data.repository.home.HomeRepositoryImpl
import com.example.nativesample01.domain.repository.detail.DetailRepository
import com.example.nativesample01.domain.repository.home.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Binds
    abstract fun bindHomeLocalDataSource(homeLocalDataSourceImpl: HomeLocalDataSourceImpl): HomeLocalDataSource

    @Binds
    abstract fun bindDetailLocalDataSource(detailLocalDataSourceImpl: DetailLocalDataSourceImpl): DetailLocalDataSource

    @Binds
    abstract fun bindDetailRepository(detailRepositoryImpl: DetailRepositoryImpl): DetailRepository
}