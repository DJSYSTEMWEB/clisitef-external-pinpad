plugins {
    id("com.android.library")
    id("kotlin-android")
}

group = "com.loopmarket.clisitef"
version = "1.5"

android {
    compileSdk = 35
    namespace = "com.loopmarket.clisitef"

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
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
    implementation("br.com.djsystem:clisitef_external:1.0.0@jar")
}
