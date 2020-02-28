object ApplicationId {
    const val id = "com.kroman.hiitimer"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val kotlin = "1.3.50"

    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29

    const val appcompat = "1.1.0"
    const val coreKtx = "1.1.0"
    const val material = "1.1.0-alpha09"
    const val recyclerview = "1.1.0-beta04"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

}

object TestLibraries {

}