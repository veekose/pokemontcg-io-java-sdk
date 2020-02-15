plugins {
    java
}

group = "io.pokemon"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.3.1")
    implementation("com.squareup.moshi:moshi:1.9.2")
    testImplementation("io.rest-assured:rest-assured:4.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.5.2")
    testImplementation("org.junit.platform:junit-platform-runner:1.5.2")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
}