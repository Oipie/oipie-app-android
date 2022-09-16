package com.acidtango.home_data.repositories

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.acidtango.home_data.R
import com.acidtango.home_data.network.ReceiptsApi
import com.acidtango.home_domain.ErrorEntity
import com.acidtango.home_domain.Meta
import com.acidtango.home_domain.ReceiptDetail
import com.acidtango.home_domain.Receipts
import com.acidtango.home_domain.Resource
import com.acidtango.home_domain.UiText
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"], sdk = [32], manifest = Config.NONE)
class ReceiptRepositoryApiTest {

    private lateinit var receiptsRepository: ReceiptRepositoryApi
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: ReceiptsApi

    lateinit var instrumentationContext: Context

    @Before
    fun setUp() {
        ShadowLog.stream = System.out
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()

        api = Retrofit.Builder()
            .addConverterFactory(
                MoshiConverterFactory.create()
            )
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(ReceiptsApi::class.java)

        receiptsRepository = ReceiptRepositoryApi(
            api = api
        )
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Get receipts from json`() {
        runBlocking {
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(200)
                    .setBody(receiptsJson)
            )

            val response = receiptsRepository.getAllReceipts(0, 10)

            response.collectLatest {
                if (it is Resource.Success) {
                    assertThat(it.data!!).isEqualTo(
                        Receipts(
                            meta = Meta(totalItems = 343),
                            items = listOf(
                                ReceiptDetail(
                                    id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                                    name = "Pumpkin soup",
                                    cover = "https://i.imgur.com/ISxVZHA.png",
                                    favourite = true,
                                    favouriteAmount = 245,
                                    preparationTime = 900000,
                                ),
                                ReceiptDetail(
                                    id = "b16d63bf-39eb-45bd-bfbd-7631220ae3f2",
                                    name = "French toast",
                                    cover = "https://i.imgur.com/GNw5TTl.png",
                                    favourite = false,
                                    favouriteAmount = 124,
                                    preparationTime = 600000,
                                )
                            )
                        )
                    )
                } else throw Exception("Something went wrong")
            }
        }
    }

    @Test
    fun `Error 404`() {
        runBlocking {
            mockWebServer.enqueue(
                MockResponse()
                    .setResponseCode(404)
            )

            val response = receiptsRepository.getAllReceipts(0, 1)

            response.collect {
                when (it.error) {
                    is ErrorEntity.ApiError -> {
                        val errorCodeFromJson = (it.error as ErrorEntity.ApiError).code
                        assertThat(errorCodeFromJson).isEqualTo(
                            404
                        )
                    }
                    is ErrorEntity.UnknownError -> throw Exception("Something went wrong")
                    null -> throw Exception("Something went wrong")
                }
            }
        }
    }

    @Test
    fun `Error Unknown`() {
        runBlocking {
            val response = receiptsRepository.getAllReceipts(0, 1)
            response.collect {
                when (it.error) {
                    is ErrorEntity.ApiError -> throw Exception("Something went wrong http")
                    is ErrorEntity.UnknownError -> {
                        val unknownError = (it.error as ErrorEntity.UnknownError).message
                        assertThat(unknownError).isEqualTo(
                            UiText.StringResource(R.string.unknown_error)
                        )
                    }
                    null -> throw Exception("Something went wrong")
                }
            }
        }
    }
}
