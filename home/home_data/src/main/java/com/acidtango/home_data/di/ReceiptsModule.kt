package com.acidtango.home_data.di

import com.acidtango.home_data.network.ReceiptsApi
import com.acidtango.home_data.repositories.ReceiptRepositoryApi
import com.acidtango.home_domain.ReceiptRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReceiptsModule {
    @Singleton
    @Provides
    fun provideReceiptsApi(): ReceiptsApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
            )
            .build()
        return Retrofit.Builder()
            .baseUrl("https://oipie.herokuapp.com/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ReceiptsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideReceiptsRepository(
        network: ReceiptsApi
    ): ReceiptRepository {
        return ReceiptRepositoryApi(
            api = network
        )
    }
}
