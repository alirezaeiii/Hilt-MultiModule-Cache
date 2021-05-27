import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id("commons.android-library")
}

dependencies {
    api(Dependencies.APPCOMPAT)
    api(Dependencies.CORE_KTX)
    api(Dependencies.TIMBER)
    api(Dependencies.RECYCLE_VIEW)
    api(Dependencies.SWIPE_REFRESH_LAYOUT)
    implementation(Dependencies.RX_JAVA)
    implementation(Dependencies.RX_ANDROID)
    kapt(AnnotationProcessorsDependencies.HILT)
}