// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion = "1.5.31"

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.SAFE_ARGS}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}