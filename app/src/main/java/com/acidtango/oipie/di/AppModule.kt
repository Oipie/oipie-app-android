package com.acidtango.oipie.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.acidtango.core.connectivity.ConnectivityObserver
import com.acidtango.core.connectivity.NetworkConnectivityObserver
import com.acidtango.core.dataStore.DataStoreDefaults
import com.acidtango.core.dataStore.DataStoreInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore("settings")

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataStore(app: Application): DataStore<Preferences> {
        return app.dataStore
    }

    @Provides
    @Singleton
    fun provideDefaultDataStore(dataStore: DataStore<Preferences>): DataStoreInterface {
        return DataStoreDefaults(dataStore)
    }

    @Provides
    @Singleton
    fun provideConnectivityChecks(app: Application): ConnectivityObserver {
        return NetworkConnectivityObserver(app)
    }
}
