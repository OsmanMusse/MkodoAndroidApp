package com.example.mkodo_app.di

import android.app.Application
import android.content.Context
import com.example.mkodo_app.data.repo.DrawRepository
import com.example.mkodo_app.data.repo.DrawRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {
    @Provides
    fun provideRepository(): DrawRepository {
        return DrawRepository_Impl()
    }
}