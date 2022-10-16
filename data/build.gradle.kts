plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp") version ("1.6.10-1.0.4")
}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isJniDebuggable = true
            buildConfigField("String", "BASE_URL", "\"https://gnews.io/api/v4/\"")
        }

        getByName("release") {
            isMinifyEnabled = true
            isJniDebuggable = false
            buildConfigField("String", "BASE_URL", "\"https://gnews.io/api/v4/\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }


    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }
    namespace = "com.kroman.presentation.data"
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.KOTLIN_PLUGIN)
    implementation(Libs.CORE_KTX)
    implementation(Libs.MOSHI)
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_MOSHI_CONVERTER)
    ksp(Libs.MOSHI_CODEGEN)
    implementation(Libs.COROUTINES_CORE)
    implementation(Libs.COROUTINES_ANDROID)
    implementation(Libs.TIMBER)
    implementation(Libs.ROOM)
    kapt(Libs.ROOM_COMPILER)
    implementation(Libs.ROOM_KTX)
    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)

    // Test Libraries
    testImplementation(Libs.JUNIT)
    androidTestImplementation(Libs.RUNNER)
    androidTestImplementation(Libs.ESPRESSO_CORE)
    testImplementation(Libs.ROOM_TEST)

    implementation(project(":domain"))
}

