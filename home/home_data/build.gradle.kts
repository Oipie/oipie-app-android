apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(project(Modules.home_domain))
    "implementation"(Coroutines.coroutines)

    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.moshiConverter)
}
