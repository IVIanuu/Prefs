@file:Suppress("ClassName", "unused")

object Build {
    const val applicationId = "com.ivianuu.kprefs.sample"
    const val buildToolsVersion = "28.0.3"
    const val compileSdk = 28
    const val minSdk = 14
    const val targetSdk = 28

    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Publishing {
    const val groupId = "com.ivianuu.kprefs"
    const val vcsUrl = "https://github.com/IVIanuu/kprefs"
    const val version = "${Build.versionName}-dev-8"
}

object Versions {
    const val androidGradlePlugin = "3.4.0"
    const val androidxAppCompat = "1.1.0-alpha04"
    const val androidxLifecycle = "2.1.0-alpha04"
    const val bintray = "1.8.4"
    const val closeable = "0.0.1-dev-2"
    const val coroutines = "1.2.0"
    const val junit = "4.12"
    const val kotlin = "1.3.31"
    const val mockitoKotlin = "2.0.0"
    const val mavenGradle = "2.1"
    const val moshi = "1.8.0"
    const val roboelectric = "4.0.2"
    const val rxJava = "2.2.8"
}

object Deps {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"

    const val androidxLifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata:${Versions.androidxLifecycle}"

    const val bintrayGradlePlugin =
        "com.jfrog.bintray.gradle:gradle-bintray-plugin:${Versions.bintray}"

    const val closeable =
        "com.ivianuu.closeable:closeable:${Versions.closeable}"

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    const val junit = "junit:junit:${Versions.junit}"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val mavenGradlePlugin =
        "com.github.dcendents:android-maven-gradle-plugin:${Versions.mavenGradle}"

    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

    const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
}