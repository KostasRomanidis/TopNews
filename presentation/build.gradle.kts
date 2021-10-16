import java.lang.System.load

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

val properties = File(rootDir, "keys.properties").inputStream().use {
    java.util.Properties().apply { load(it) }
}
val gNewsApiKey = properties.getValue("GNEWS_API_KEY") as String


android {
    compileSdk = Versions.COMPILE_SDK
    defaultConfig {
        applicationId = "com.kroman.topnews"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            versionNameSuffix = "-debug"
            isMinifyEnabled = false
            isDebuggable = true
            buildConfigField("String", "GNEWS_API_KEY", gNewsApiKey)
            buildConfigField("String", "BASE_URL", "\"https://gnews.io/api/v4\"")
        }

        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            buildConfigField("String", "NEWS_API_KEY", gNewsApiKey)
            buildConfigField("String", "BASE_URL", "\"https://gnews.io/api/v4\"")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        val options = this
        options.jvmTarget = "1.8"
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
        getByName("test") {
            java.srcDirs("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDirs("src/androidTest/kotlin")
        }
    }

    lintOptions {
        // Eliminates UnusedResources false positives for resources used in DataBinding layouts
        isCheckGeneratedSources = true
        // Running lint over the debug variant is enough
        isCheckReleaseBuilds = false
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.KOTLIN_PLUGIN)
    implementation(Libs.APP_COMPAT)
    implementation(Libs.RECYCLER_VIEW)
    implementation(Libs.MATERIAL)
    implementation(Libs.CORE_KTX)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.GSON)
    implementation(Libs.LIFECYCLE)
    kapt(Libs.LIFECYCLE_KAPT)

    // Coroutines
    implementation(Libs.COROUTINES_CORE)
    implementation(Libs.COROUTINES_ANDROID)

    // DI
    implementation(Libs.KOIN)
    implementation(Libs.KOIN_VIEWMODEL)

    // Networking
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_CONVERTER)
    implementation(Libs.OKHTTPLOGGING)

    // Room
    implementation(Libs.ROOM)
    implementation(Libs.ROOM_KTX)
    kapt(Libs.ROOM_COMPILER)

    // Navigation
    implementation(Libs.NAVIGATION)
    implementation(Libs.NAVIGATION_UI)

    // Timber
    implementation(Libs.TIMBER)

    implementation(Libs.SWIPE_REFRESH_LAYOUT)

    // Testing
    testImplementation(Libs.JUNIT)
    testImplementation(Libs.KOIN_TEST)
    androidTestImplementation(Libs.RUNNER)
    androidTestImplementation(Libs.ESPRESSO_CORE)

    implementation(project(":domain"))
    implementation(project(":data"))

    androidTestImplementation("com.android.support.test.espresso:espresso-core:2.2.2") {
        exclude(group = "com.android.support", module = "support-annotations")
    }
}
