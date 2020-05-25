plugins {
    kotlin("jvm") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.javalin:javalin:3.8.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
    implementation("org.slf4j:slf4j-simple:1.7.28")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("com.konghq:unirest-java:3.4.00")
    testImplementation("com.konghq:unirest-objectmapper-jackson:3.7.02")
    testImplementation("com.konghq:unirest-object-mappers-gson:3.7.02")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}