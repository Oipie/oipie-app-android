package com.acidtango.auth_presentation.viewModels

import com.acidtango.core_testing.MainCoroutineRule
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RegistrationVMTest {
    private lateinit var registrationVW: RegistrationVM

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        registrationVW =
            RegistrationVM()
    }

    @Test
    fun `Nickname is empty at the beginning`() {
        runBlocking {
            Truth.assertThat(registrationVW.nickName).isEmpty()
        }
    }

    @Test
    fun `Email is empty at the beginning`() {
        runBlocking {
            Truth.assertThat(registrationVW.email).isEmpty()
        }
    }

    @Test
    fun `Password is empty at the beginning`() {
        runBlocking {
            Truth.assertThat(registrationVW.password).isEmpty()
        }
    }

    @Test
    fun `Write nickname`() {
        runBlocking {
            val nickName = "XxLocoxX"
            registrationVW.onNickNameChange(nickName)
            Truth.assertThat(registrationVW.nickName).isEqualTo(nickName)
        }
    }

    @Test
    fun `Write email`() {
        runBlocking {
            val email = "maxverst@rb.com"
            registrationVW.onEmailChange(email)
            Truth.assertThat(registrationVW.email).isEqualTo(email)
        }
    }

    @Test
    fun `Write password`() {
        runBlocking {
            val password = "password"
            registrationVW.onPasswordChange(password)
            Truth.assertThat(registrationVW.password).isEqualTo(password)
        }
    }
}
