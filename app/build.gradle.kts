plugins {
    id("com.android.application")
    kotlin("android")
    id(Linter.ktlint)
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.appId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "com.acidtango.oipie.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    lint {
        textReport = true
        textOutput = File("stdout")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("**/attach_hotspot_windows.dll")
        exclude("META-INF/licenses/ASM")
    }
    testOptions {
        unitTests.apply {
            isIncludeAndroidResources = true
        }
        packagingOptions {
            jniLibs {
                useLegacyPackaging = true
            }
        }
    }
}

dependencies {
    implementation(project(Modules.coreUi))
    implementation(project(Modules.core))
    implementation(project(Modules.home_presentation))
    implementation(project(Modules.home_domain))
    implementation(project(Modules.home_data))
    implementation(project(Modules.search_presentation))
    implementation(project(Modules.favorites_presentation))
    implementation(project(Modules.receipts_presentation))
    implementation(project(Modules.profile_presentation))
    implementation(project(Modules.auth_presentation))
    implementation (DataStore.dataStorePreferences)

    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.hiltNavigationCompose)
    implementation(Compose.material)
    implementation(Compose.runtime)
    implementation(Compose.navigation)
    implementation(Compose.viewModelCompose)
    implementation(Compose.activityCompose)
    implementation (Compose.viewModelCompose)
    androidTestImplementation(Compose.composeJUnit)
    debugImplementation(Compose.composeManifest)

    // Hilt
    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)
    kaptTest(DaggerHilt.hiltCompiler)
    kaptAndroidTest(DaggerHilt.hiltCompiler)
    androidTestImplementation(DaggerHilt.hiltTest)


    // TESTING
    testImplementation(Testing.robolectric)
    testImplementation(Testing.junit4)
    testImplementation(Testing.junitAndroidExt)
    testImplementation(Testing.truth)
    testImplementation(Testing.coroutines)

    testImplementation(Testing.composeUiTest)
    testImplementation(Testing.mockk)
    testImplementation(Testing.mockWebServer)

    androidTestImplementation(Testing.junit4)
    androidTestImplementation(Testing.junitAndroidExt)
    androidTestImplementation(Testing.truth)
    androidTestImplementation(Testing.coroutines)
    androidTestImplementation(Testing.composeUiTest)
    androidTestImplementation(Testing.mockkAndroid)
    androidTestImplementation(Testing.mockWebServer)
    androidTestImplementation(Testing.testRunner)
    androidTestImplementation(Testing.espressoCore)
}
