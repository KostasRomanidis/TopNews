plugins {
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.KOTLIN_PLUGIN)
    implementation(Libs.COROUTINES_CORE)

    testImplementation(Libs.JUNIT)
}

