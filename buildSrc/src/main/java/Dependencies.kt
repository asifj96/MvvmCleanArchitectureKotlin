object Versions {
    const val minSdk = 21
    const val compileSdk = 32
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0"
    const val coreKtx = "1.7.0"
    const val appCompat = "1.5.1"
    const val materialDesign = "1.6.1"
    const val constraintLayout = "2.1.4"
    const val junit = "4.13.2"
    const val junitTest = "1.1.3"
    const val espressoCore = "3.4.0"
    const val jvmTarget = "1.8"
    const val firebaseBom = "29.0.1"
    const val gradle = "7.2.2"
    const val gradlePlugin = "1.6.10"
    const val googleServices = "4.3.10"
    const val firebaseCrashlytics = "2.7.1"
    const val multiDex = "2.0.1"
    const val dimension = "1.0.6"
    const val glide = "4.12.0"
//    const val coroutine = "1.6.0"
    const val coroutine = "1.5.1"
    const val preferenceKts = "1.2.0"
    const val recyclerView = "1.2.1"
    const val lifecycle = "2.4.1"
    const val lifecycleExtensions = "2.2.0"
    const val navigation = "2.4.1"
    const val navigationGradlePlugin = "2.5.0-alpha01"
    const val activityKtx = "1.4.0"
    const val fragmentKtx = "1.4.0"
    const val workMangerKtx = "2.7.1"
    const val room = "2.4.2"
    const val dataBindingCompiler = "3.4.0"
    const val gson = "2.8.8"
    const val hilt = "2.38.1"
    const val daggerHiltCompiler = "2.37"
    const val hiltViewmodel = "1.0.0-alpha03"
    const val hiltCompiler = "1.0.0"
    const val hiltNavigation = "1.0.0"
    const val retrofit = "2.9.0"
    const val okhttp3 = "5.0.0-alpha.2"
}

object Android {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val junitTest = "androidx.test.ext:junit:${Versions.junitTest}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"
    const val sdp = "com.intuit.sdp:sdp-android:${Versions.dimension}"
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.dimension}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val workMangerKtx = "androidx.work:work-runtime-ktx:${Versions.workMangerKtx}"
    const val dataBindingCompiler =
        "com.android.databinding:compiler:${Versions.dataBindingCompiler}"
}


object Room {
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}

object Gson {

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object Navigation {
    const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Firebase {
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseConfig = "com.google.firebase:firebase-config-ktx"
    const val firebaseInstallations = "com.google.firebase:firebase-installations-ktx"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinExtensions = "kotlin-android-extensions"
    const val googleServices = "com.google.gms.google-services"
    const val firebaseCrashlytics = "com.google.firebase.crashlytics"
    const val navigationSafeArgs = "androidx.navigation.safeargs"
    const val hilt = "dagger.hilt.android.plugin"
}

object Classpath {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.gradlePlugin}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
    const val firebaseCrashlytics =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlytics}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val navigationGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2"
}

object DaggerHilt {
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val daggerHiltCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltCompiler}"
    const val hiltViewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewmodel}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:${Versions.hiltNavigation}"
}

object Retrofit {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit2Converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"

}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object Coroutine {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
}

object LifeCycle {
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
}

object SharedPreference {
    const val preferenceKts = "androidx.preference:preference-ktx:${Versions.preferenceKts}"
}