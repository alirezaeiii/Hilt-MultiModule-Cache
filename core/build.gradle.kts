import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id("commons.android-library")
}

android {
    defaultConfig {
        buildConfigField("String", "VIAPLAY_API_BASE_URL", "\"https://content.viaplay.se/\"")
        buildConfigField("String", "VIAPLAY_DATABASE_NAME", "\"viaplay-db\"")
        buildConfigField("int", "VIAPLAY_DATABASE_VERSION", "1")
        buildConfigField("boolean", "VIAPLAY_DATABASE_EXPORT_SCHEMA", "false")
    }
}

dependencies {
    api(project(BuildModules.COMMON))

    api(Dependencies.RETROFIT)
    api(Dependencies.MOSHI)
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.RETROFIT_ADAPTER)
    implementation(Dependencies.RETROFIT_CONVERTER)
    implementation(Dependencies.RX_JAVA)
    implementation(Dependencies.LOGGING)
    implementation(Dependencies.MOSHI_KTX)

    kapt(AnnotationProcessorsDependencies.ROOM)
}