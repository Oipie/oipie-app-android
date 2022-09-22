package com.acidtango.auth_presentation.viewModels

import com.acidtango.core_testing.MainCoroutineRule
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginVMTest {
    private lateinit var loginVM: LoginVM

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        loginVM =
            LoginVM(FakeDataStore())
    }


    @Test
    fun `Token is empty at the beginning`() {
        runBlocking {
            Truth.assertThat(loginVM.token).isEmpty()
        }
    }

    @Test
    fun `Email is empty at the beginning`() {
        runBlocking {
            Truth.assertThat(loginVM.email).isEmpty()
        }
    }

    @Test
    fun `Password is empty at the beginning`() {
        runBlocking {
            Truth.assertThat(loginVM.password).isEmpty()
        }
    }

    @Test
    fun `Write email`() {
        runBlocking {
            val email = "maxverst@rb.com"
            loginVM.onEmailChange(email)
            Truth.assertThat(loginVM.email).isEqualTo(email)
        }
    }

    @Test
    fun `Write password`() {
        runBlocking {
            val password = "password"
            loginVM.onPasswordChange(password)
            Truth.assertThat(loginVM.password).isEqualTo(password)
        }
    }

    @Test
    fun `Read token`() {
        runBlocking {
            loginVM.readToken()
            Truth.assertThat(loginVM.token).isEqualTo("fake-token")
        }
    }
}
