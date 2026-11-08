plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.shuvo.smarttrainbookingassistant"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.shuvo.smarttrainbookingassistant"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
