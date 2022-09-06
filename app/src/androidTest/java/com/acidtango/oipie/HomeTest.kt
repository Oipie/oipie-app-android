package com.acidtango.oipie

import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.acidtango.core_ui.theme.OipieTheme
import com.acidtango.home_data.di.ReceiptsModule
import com.acidtango.home_data.network.ReceiptsApi
import com.acidtango.home_data.repositories.ReceiptRepositoryApi
import com.acidtango.home_domain.GetReceiptsUseCase
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptDetail
import com.acidtango.home_domain.ReceiptRepository
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource
import com.acidtango.home_domain.di.HomeDomainModule
import com.acidtango.home_presentation.HomeScreen
import com.acidtango.home_presentation.HomeViewModel
import com.acidtango.oipie.fakes.RecipesRepositoryFake
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject
import javax.inject.Singleton

@UninstallModules(ReceiptsModule::class)
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@HiltAndroidTest
class HomeTest() {

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createComposeRule()

    @Before
    fun setup() {
        hiltTestRule.inject()
        composeTestRule.setContent {
            HomeScreen(viewModel = HomeViewModel(GetReceiptsUseCase(RecipesRepositoryFake())))
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class ReceiptsTestModule {
        @Singleton
        @Binds
        abstract fun provideReceiptsRepository(apiRepository: RecipesRepositoryFake): ReceiptRepository
    }


    @Test
    fun test_titleIsDisplayed() {
        val text = "Slutty Pumpkin"
        composeTestRule.onNodeWithText(text.uppercase()).assertIsDisplayed()
    }
}
