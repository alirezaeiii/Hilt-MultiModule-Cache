import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies
import extensions.addTestsDependencies

plugins {
    id("commons.android-library")
    id(BuildPlugins.NAVIGATION)
    id(BuildPlugins.HILT)
}

dependencies {
    api(project(BuildModules.CORE))

    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_FEATURE)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAIN_LAYOUT)
    kapt(AnnotationProcessorsDependencies.HILT)

    addTestsDependencies()
}
