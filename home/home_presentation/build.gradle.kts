apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.coreUi))
    "testImplementation"(project(Modules.coreTesting))
    "androidTestImplementation"(project(Modules.coreTesting))
    "implementation"(project(Modules.home_domain))
    "implementation"(Coil.coilCompose)
}
