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
    const val LIFECYLCE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIFECYLCE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_SAVEDSTATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFECYCLE}"
    const val LIFECYCLE_KAPT = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"

    // Dependency Injection
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT}"

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

    // Coil-Compose
    const val COIL = "io.coil-kt:coil-compose:${Versions.COIL}"


    // Firebase
    const val GOOGLE_PLAY_SERVICES = "com.google.gms:google-services:${Versions.GOOGLE_PLAY_SERVICES}"
    const val FABRIC = "io.fabric.tools:gradle:${Versions.FABRIC}"
    const val FIREBASE_ANALYTICS =
        "com.google.firebase:firebase-analytics:${Versions.FIREBASE_ANALYTICS}"
    const val FIREBASE_CRASHLYTICS =
        "com.crashlytics.sdk.android:crashlytics:${Versions.FIREBASE_CRASHLYTICS}"

    // Jetpack Compose
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE_UI}"
    // Tooling Support (Previews etc...)
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_UI_TOOLING}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
    // Compose Material Design
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE_MATERIAL_DESIGN}"
    const val COMPOSE_MATERIAL_ICONS = "androidx.compose.material:material-icons-core:${Versions.COMPOSE_MATERIAL_DESIGN}"
    const val COMPOSE_MATERIAL_ICONS_EXT = "androidx.compose.material:material-icons-extended:${Versions.COMPOSE_MATERIAL_DESIGN}"
    // Animations
    const val COMPOSE_ANIMATION = "androidx.compose.animation:animation:${Versions.COMPOSE_ANIMATIONS}"
    // Integration with ViewModels
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.COMPOSE_VIEW_MODEL}"
    // Navigation Component
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"

    // Foundation (Border, Background, Box, Image, Scroll, Shapes, Animation, etc...)
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE_UI}"

    // Integration with observables
    const val COMPOSE_LIVE_DATA = "androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE_UI}"

    // TestLibraries
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val RUNNER = "androidx.test:runner:${Versions.RUNNER}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    const val ROOM_TEST = "androidx.room:room-testing:${Versions.ROOM}"
    const val MOCKIT_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
    const val UI_TEST_COMPOSE = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_UI_TEST}"
}