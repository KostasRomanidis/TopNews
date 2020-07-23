object ApplicationId {
    const val id = "com.kroman.hiitimer"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val kotlin = "1.3.72"

    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29

    const val appcompat = "1.1.0"
    const val coreKtx = "1.3.0"
    const val material = "1.1.0"
    const val recyclerview = "1.1.0"
    const val constraintlayout = "1.1.3"
    const val koinAndroid = "2.1.5"
    const val koinViewModel = "2.1.5"
    const val retrofit = "2.9.0"
    const val okhttpLogging = "4.8.0"
    const val gson = "2.8.6"
    const val navigation = "2.3.0"
    const val lifecycle = "2.2.0"
    const val stetho = "1.5.1"
    const val safeArgs = "2.3.0"
    const val coroutines = "1.3.8"
    const val timber = "4.7.1"
    const val room = "2.2.5"
    const val fragment = "1.2.5"
    const val swipeRefreshLayout = "1.1.0"
    const val googlePlayServices = "4.3.3"
    const val fabric = "1.31.2"
    const val firebaseAnalytics = "17.2.3"
    const val firebaseCrashlytics = "2.10.1"

    // Test Libraries
    const val junit = "4.12"
    const val runner = "1.2.0"
    const val espressoCore = "3.2.0"
    const val mockitoKotlin = "2.2.0"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val swipeRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    // Fragments
    const val fragmentRuntime = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentRuntimeKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"

    // Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleKapt = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    // Dependency Injection
    const val koin = "org.koin:koin-android:${Versions.koinAndroid}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koinViewModel}"

    // Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    // Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    //    const val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"

    // Navigation Components
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val safeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.safeArgs}"

    // Stetho
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Firebase
    const val googlePlayServices = "com.google.gms:google-services:${Versions.googlePlayServices}"
    const val fabric = "io.fabric.tools:gradle:${Versions.fabric}"
    const val firebaseAnalytics =
        "com.google.firebase:firebase-analytics:${Versions.firebaseAnalytics}"
    const val firebaseCrashlytics =
        "com.crashlytics.sdk.android:crashlytics:${Versions.firebaseCrashlytics}"
}

object TestLibraries {
    const val junit = "junit:junit:${Versions.junit}"
    const val runner = "androidx.test:runner:${Versions.runner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val room = "androidx.room:room-testing:${Versions.room}"
    const val koinTest = "org.koin:koin-test:${Versions.koinAndroid}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
}