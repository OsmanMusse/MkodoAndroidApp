

plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-kapt")
    kotlin("plugin.serialization") version "1.8.10"
    id("kotlin-parcelize")

}

android {
    namespace = "com.example.mkodo_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mkodo_app"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility =  JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
//    implementation("androidx.compose.ui:ui-test:1.6.8")
    implementation("androidx.test:core-ktx:1.6.1")

//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Local Unit tests
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    testImplementation ("io.mockk:mockk:1.13.10")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.8")

    // Instrumentation tests
    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.44")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.44")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.6.8")
    androidTestImplementation ("androidx.test.ext:junit:1.2.1")
    implementation("androidx.test:core-ktx:1.6.1")


    //Hilt Dependency Injection
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation ("androidx.hilt:hilt-navigation-fragment:1.0.0")

    implementation("androidx.compose.runtime:runtime-livedata:1.6.8")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.8.0-beta01")


    testImplementation("org.mockito:mockito-core:3.6.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")


    //Hilt Dependency Injection
    implementation ("com.google.dagger:hilt-android:2.44")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    kapt ("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Json Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")


    //Gson Json Parser
    implementation ("com.google.code.gson:gson:2.11.0")
    testImplementation ("org.robolectric:robolectric:4.7.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}