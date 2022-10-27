apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.coreUi))
    "androidTestImplementation"(project(Modules.coreTesting))
    "testImplementation"(project(Modules.coreTesting))
    "implementation"(project(Modules.core))
    "implementation"(Coil.coilCompose)
    "implementation"(Biometric.biometric)
}
