import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id("commons.android-library")
}

android {
    defaultConfig {
        buildConfigField("String", "API_BASE_URL", "\"https://content.viaplay.se/\"")
        buildConfigField("String", "DATABASE_NAME", "\"app-db\"")
        buildConfigField("int", "DATABASE_VERSION", "1")
        buildConfigField("boolean", "DATABASE_EXPORT_SCHEMA", "false")
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

    kapt(AnnotationProcessorsDependencies.HILT)
    kapt(AnnotationProcessorsDependencies.ROOM)
}