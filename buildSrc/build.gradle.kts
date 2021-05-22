plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

object PluginsVersions {
    const val GRADLE_ANDROID = "4.2.1"
    const val KOTLIN = "1.4.31"
    const val NAVIGATION = "2.3.4"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${PluginsVersions.NAVIGATION}")
}