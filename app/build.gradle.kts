plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("cgoit.gradle.elasticsearch").version("0.2.3.1")
}

repositories {
    // Use JCenter for resolving dependencies.
    jcenter()
}

dependencies {
    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")
}

application {
    // Define the main class for the application.
    mainClass.set("com.example.App")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()

    doFirst {
        startElasticsearch {
//            elasticsearchVersion = "7.8.0"
//            httpScheme = "http"
//            httpHost = "localhost"
//            httpPort = 9200
//            transportPort = 9300
//            dataDir = file("$buildDir/elastic")
//            logsDir = file("$buildDir/elastic/logs")
//            forceShutdownBeforeStart = false
        }
    }

    doLast {
        stopElasticsearch {
//            httpScheme = "http"
//            httpHost = "localhost"
//            httpPort = 9200
        }
    }
}