package com.asif.mvvmcleanarchitecturekotlin.di

import com.asif.mvvmcleanarchitecturekotlin.common.Constants
import com.asif.mvvmcleanarchitecturekotlin.data.remote.CoinPaprikaApi
import com.asif.mvvmcleanarchitecturekotlin.data.repository.CoinRepositoryImpl
import com.asif.mvvmcleanarchitecturekotlin.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideOkkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(Constants.APP_REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.APP_REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constants.APP_REQUEST_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providePaprikaApi(client: OkHttpClient): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}