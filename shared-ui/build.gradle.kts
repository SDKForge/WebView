plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.binaryCompatibilityValidator)
    alias(libs.plugins.dokka)
    alias(libs.plugins.build.logic.library.kmp)
    alias(libs.plugins.build.logic.library.android)
    alias(libs.plugins.build.logic.library.publishing)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidLibrary {
        namespace = "dev.sdkforge.webview.ui"
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.sharedDomain)

                implementation(compose.foundation)
            }
        }
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        androidMain {
            dependencies {
                implementation("androidx.webkit:webkit:1.14.0")
            }
        }
    }
}
