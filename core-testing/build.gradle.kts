apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation"(DaggerHilt.hiltTest)
    "implementation"(Testing.coroutines)
    "implementation"(Testing.testRunner)
}
