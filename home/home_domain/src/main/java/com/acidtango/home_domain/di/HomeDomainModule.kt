package com.acidtango.home_domain.di

import com.acidtango.home_domain.GetReceiptsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object HomeDomainModule {

    @ViewModelScoped
    @Provides
    fun provideReceiptsUseCase(): GetReceiptsUseCase {
        return GetReceiptsUseCase()
    }
}