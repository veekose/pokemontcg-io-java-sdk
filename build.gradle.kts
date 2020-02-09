plugins {
    java
}

group = "io.pokemon"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    compile("com.squareup.okhttp3:okhttp:4.3.1")
    compile("com.squareup.moshi:moshi:1.9.2")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}