object Libs {
    const val KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN_PLUGIN}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"

    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"

    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val SWIPE_REFRESH_LAYOUT =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_TO_REFRESH_LAYOUT}"

    // Fragments
    const val FRAGMENT = "androidx.fragment:fragment:${Versions.FRAGMENT}"
    const val FRAGMENTKTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"

    // Coroutines
    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val LIFECYCLE = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE}"
    const val LIFECYCLE_KAPT = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"

    // Dependency Injection
    const val KOIN = "org.koin:koin-android:${Versions.KOIN_VERSION}"
    const val KOIN_VIEWMODEL = "org.koin:koin-android-viewmodel:${Versions.KOIN_VERSION}"

    // Room
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"

    // Network
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"

    const val OKHTTPLOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTPLOGGING}"

    // Navigation Components
    const val NAVIGATION = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

    // Timber
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"

    // Firebase
    const val GOOGLE_PLAY_SERVICES = "com.google.gms:google-services:${Versions.GOOGLE_PLAY_SERVICES}"
    const val FABRIC = "io.fabric.tools:gradle:${Versions.FABRIC}"
    const val FIREBASE_ANALYTICS =
        "com.google.firebase:firebase-analytics:${Versions.FIREBASE_ANALYTICS}"
    const val FIREBASE_CRASHLYTICS =
        "com.crashlytics.sdk.android:crashlytics:${Versions.FIREBASE_CRASHLYTICS}"

    // TestLibraries
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val RUNNER = "androidx.test:runner:${Versions.RUNNER}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    const val ROOM_TEST = "androidx.room:room-testing:${Versions.ROOM}"
    const val KOIN_TEST = "org.koin:koin-test:${Versions.KOIN_VERSION}"
    const val MOCKIT_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
}