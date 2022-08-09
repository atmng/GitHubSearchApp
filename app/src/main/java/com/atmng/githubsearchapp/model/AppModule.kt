package com.atmng.githubsearchapp.model

import com.atmng.githubsearchapp.BuildConfig
import com.atmng.githubsearchapp.net.GitHubSearchApiClient
import com.atmng.githubsearchapp.net.GitHubSearchApiClientImpl
import com.atmng.githubsearchapp.net.GitHubSearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
            OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        } else {
            OkHttpClient.Builder().build()
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideGitHubSearchService(retrofit: Retrofit): GitHubSearchService {
        return retrofit.create(GitHubSearchService::class.java)
    }

    @Singleton
    @Provides
    fun provideApiClient(apiClient: GitHubSearchApiClientImpl): GitHubSearchApiClient {
        return apiClient
    }
}