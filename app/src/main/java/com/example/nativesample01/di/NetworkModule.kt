package com.example.nativesample01.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl(): String = ""

    //provide moshi for serialization and deserialization
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    //provide moshi convertor for converting http response to objects
    @Provides
    fun provideMoshiConvertor(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)


    @Provides
    @Singleton
    @OkHttpClient2
    fun provideHttpClient(okHttpClient: OkHttpClient): OkHttpClient =
        okHttpClient
            .newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    @OkHttpClient1
    fun provideHttpClient2(): OkHttpClient =
        OkHttpClient
            .Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @OkHttpClient1 client: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
        baseUrl: String,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(moshiConverterFactory)
            .client(client)
            .build()


}


@Qualifier
annotation class OkHttpClient1

@Qualifier
annotation class OkHttpClient2