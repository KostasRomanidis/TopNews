plugins {
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.KOTLIN_PLUGIN)
    implementation(Libs.COROUTINES_CORE)

    implementation("javax.inject:javax.inject:1")
    testImplementation(Libs.JUNIT)
}

