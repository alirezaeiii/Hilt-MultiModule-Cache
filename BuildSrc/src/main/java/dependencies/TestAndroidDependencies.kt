package dependencies

/**
 * Project test android dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object TestAndroidDependencies {
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.ESPRESSO}"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${BuildDependenciesVersions.ESPRESSO}"
    const val RUNNER = "androidx.test:runner:${BuildDependenciesVersions.TEST}"
    const val RULES = "androidx.test:rules:${BuildDependenciesVersions.TEST}"
    const val JUNIT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT}"
    const val RX_IDLER  = "com.squareup.rx.idler:rx2-idler:${BuildDependenciesVersions.RX_IDLER}"
}