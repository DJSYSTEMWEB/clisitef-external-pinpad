plugins {
    id("com.android.library")
    kotlin("android")
}

group = "com.loopmarket.clisitef_external_pinpad"
version = "1.5"

repositories {
    google()
    mavenCentral()
}

rootProject.allprojects {
    repositories {
        google()
        mavenCentral()
        flatDir {
            dirs(project(":clisitef_external_pinpad").file("libs"))
        }
    }
}

android {
    compileSdk = 35
    namespace = "com.loopmarket.clisitef_external_pinpad"

    defaultConfig {
        minSdk = 21
        targetSdk = 35
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    sourceSets["main"].java.srcDirs("src/main/kotlin")

    packagingOptions {
        doNotStrip("**/libclisitef.so")
    }

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
            it.testLogging.apply {
                events("passed", "skipped", "failed", "standardOut", "standardError")
                showStandardStreams = true
            }
        }
    }
}

dependencies {
    implementation(mapOf("name" to "clisitef_external-1.0.0", "ext" to "jar"))
}
