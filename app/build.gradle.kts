plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinExtensions)
    id(Plugins.googleServices)
    id(Plugins.firebaseCrashlytics)
    id(Plugins.hilt)
    id(Plugins.navigationSafeArgs)
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.asif.mvvmcleanarchitecturekotlin"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = Versions.jvmTarget
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Android
    implementation(Android.coreKtx)
    implementation(Android.appCompat)
    implementation(Android.materialDesign)
    implementation(Android.constraintLayout)
    implementation(Android.multiDex)
    implementation(Android.sdp)
    implementation(Android.ssp)
    implementation(Android.recyclerView)
    implementation(Android.fragmentKtx)
    implementation(Android.activityKtx)
    implementation(Android.workMangerKtx)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
//    kapt(Android.dataBindingCompiler)
    testImplementation(Android.junit)
    androidTestImplementation(Android.junitTest)
    androidTestImplementation(Android.espressoCore)

    implementation(Gson.gson)
    // Firebase
    implementation(platform(Firebase.firebaseBom))
    implementation(Firebase.firebaseCrashlytics)
    implementation(Firebase.firebaseAnalytics)
    implementation(Firebase.firebaseConfig)
    implementation(Firebase.firebaseInstallations)

    // DaggerHilt
    implementation(DaggerHilt.daggerHilt)
    kapt(DaggerHilt.daggerHiltCompiler)
    implementation(DaggerHilt.hiltViewmodel)
    kapt(DaggerHilt.hiltCompiler)
    implementation(DaggerHilt.hiltNavigation)

    // Retrofit
    implementation(Retrofit.retrofit2)
    implementation(Retrofit.retrofit2Converter)
    implementation(Retrofit.okhttp3)
    implementation(Retrofit.loggingInterceptor)

    // Glide
    implementation(Glide.glide)
    annotationProcessor(Glide.glideCompiler)

    // Coroutine
    implementation(Coroutine.core)
    implementation(Coroutine.android)

    // SharedPreference
    implementation(SharedPreference.preferenceKts)

    // LifeCycle
    implementation(LifeCycle.viewmodelKtx)
    implementation(LifeCycle.livedataKtx)
    implementation(LifeCycle.lifecycleExtensions)
    implementation(LifeCycle.runtimeKtx)

    // Navigation
    implementation(Navigation.fragmentKtx)
    implementation(Navigation.uiKtx)

    // Room
    implementation(Room.roomRuntime)
    kapt(Room.roomCompiler)
    implementation(Room.roomKtx)

    // Timber
    api("com.jakewharton.timber:timber:4.7.1")

}
kapt {
    correctErrorTypes = true
}