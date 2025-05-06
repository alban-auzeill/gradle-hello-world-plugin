plugins {
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.1"
    signing
}

repositories {
    mavenLocal()
    mavenCentral()
}

val junitJupiterVersion = "5.12.2"
val junitPlatformLauncherVersion = "1.12.2"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:${junitJupiterVersion}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:${junitPlatformLauncherVersion}")
}

group = "com.auzeill.gradle"
version = "1.0"

gradlePlugin {
    website = "https://github.com/alban-auzeill/gradle-hello-world-plugin"
    vcsUrl = "https://github.com/alban-auzeill/gradle-hello-world-plugin"
    plugins {
        create("greetingPlugin") {
            id = "com.auzeill.gradle.greeting"
            implementationClass = "com.auzeill.gradle.GradleHelloWorldPluginPlugin"
            displayName = "Hello World Gradle Plugin"
            description = "A plugin to test the publication to Gradle Plugin Portal"
            tags = listOf("hello", "world", "greeting")
        }
    }
}

val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

configurations["functionalTestImplementation"].extendsFrom(configurations["testImplementation"])
configurations["functionalTestRuntimeOnly"].extendsFrom(configurations["testRuntimeOnly"])

val functionalTest by tasks.registering(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
    useJUnitPlatform()
}

gradlePlugin.testSourceSets.add(functionalTestSourceSet)

tasks.named<Task>("check") {
    dependsOn(functionalTest)
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

publishing {
    repositories {
        mavenCentral()
    }
}
