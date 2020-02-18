plugins {
    java
    `maven-publish`
    id("com.jfrog.bintray") version "1.8.4"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.3.1")
    implementation("com.squareup.moshi:moshi:1.9.2")
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

java {
    withSourcesJar()
    withJavadocJar()
}

group = "io.pokemontcg"
version = "1.1.2"

val publicationName = "pokemontcg-io-java-sdk"

val artifactGroup = group.toString()
val artifactName = project.name
val artifactVersion = version.toString()

val pomUrl = "https://github.com/veekose/pokemontcg-io-java-sdk"
val pomDesc = "A Java SDK for the Pokemon TCG API at pokemontcg.io"
val pomIssueUrl = "https://github.com/veekose/pokemontcg-io-java-sdk/issues"
val pomScmUrl = "https://github.com/veekose/pokemontcg-io-java-sdk"
val pomScmConnection = "scm:git@github.com:veekose/pokemontcg-io-java-sdk.git"
val pomScmDevConnection = "scm:git@github.com:veekose/pokemontcg-io-java-sdk.git"

val githubRepository = "veekose/pokemontcg-io-java-sdk"
val githubReadme = "README.md"

val pomLicenseName = "MIT"
val pomLicenseUrl = "https://opensource.org/licenses/mit-license.php"
val pomLicenseDist = "repo"

val pomDeveloperId = "vkos"
val pomDeveloperName = "Adam Cleveland"
val pomDeveloperEmail = "krvkos@gmail.com"

publishing {
    publications {
        create<MavenPublication>(publicationName) {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["java"])

            pom.withXml {
                asNode().apply {
                    appendNode("description", pomDesc)
                    appendNode("name", rootProject.name)
                    appendNode("url", pomUrl)


                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", pomLicenseName)
                        appendNode("url", pomLicenseUrl)
                        appendNode("distribution", pomLicenseDist)
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", pomDeveloperId)
                        appendNode("name", pomDeveloperName)
                        appendNode("email", pomDeveloperEmail)
                    }
                    appendNode("scm").apply {
                        appendNode("url", pomScmUrl)
                        appendNode("connection", pomScmConnection)
                        appendNode("developerConnection", pomScmDevConnection)
                    }
                }
            }
        }
    }
}

bintray {
    user = project.findProperty("bintrayUser").toString()
    key = project.findProperty("bintrayKey").toString()
    setPublications(publicationName)
    publish = true

    pkg.apply {
        repo = publicationName
        name = publicationName
        userOrg = pomDeveloperId
        vcsUrl = pomScmUrl
        publicDownloadNumbers = true

        version.apply {
            name = artifactVersion
            desc = pomDesc
            vcsTag = "v$artifactVersion"
        }

        description = pomDesc
        desc = description

        websiteUrl = pomUrl
        issueTrackerUrl = pomIssueUrl
        githubRepo = githubRepository
        githubReleaseNotesFile = githubReadme

        setLabels("java", "sdk", "pokemon", "pokemontcg", "api")
        setLicenses("MIT")
    }
}