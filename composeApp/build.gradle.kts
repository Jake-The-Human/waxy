import com.android.build.gradle.internal.tasks.factory.dependsOn
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.konan.target.KonanTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    kotlin("plugin.serialization") version "1.9.22"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm("desktop") {
        compilations.getByName("main") {
            if (target.name.startsWith("Windows")) {
                mingwX64 {
                    compilations.getByName("main") {
                        cinterops  {
                            val miniaudio by creating {
                                defFile("src/nativeInterop/cinterop/miniaudio.def")
                                includeDirs {
                                    allHeaders("lib/miniaudio")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
//
//    targets {
//        val hostOs = System.getProperty("os.name")
//        val isArm64 = System.getProperty("os.arch") == "aarch64"
//        val isMingwX64 = hostOs.startsWith("Windows")
//        val desktopTarget = when {
//            hostOs == "Mac OS X" && isArm64 -> macosArm64("desktop")
//            hostOs == "Mac OS X" && !isArm64 -> macosX64("desktop")
//            hostOs == "Linux" && isArm64 -> linuxArm64("desktop")
//            hostOs == "Linux" && !isArm64 -> linuxX64("desktop")
//            isMingwX64 -> mingwX64("desktop")
//            else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
//        }
//
//        desktopTarget.apply {
//            compilations.getByName("main") {
//                cinterops {
//                    val miniaudio by creating {
//                        defFile("src/nativeInterop/cinterop/miniaudio.def")
//                        includeDirs {
//                            allHeaders("lib/miniaudio")
//                        }
//                    }
//                }
//            }
//        }
//    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.preferences)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

android {
    namespace = "org.jake_the_human.waxy"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.jake_the_human.waxy"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            macOS {
                iconFile.set(project.file("src/commonMain/composeResources/drawable/waxy_icon.icns"))
            }
            windows {
                iconFile.set(project.file("src/commonMain/composeResources/drawable/waxy_icon.ico"))
            }
            linux {
                iconFile.set(project.file("src/commonMain/composeResources/drawable/waxy_icon.png"))
            }
            modules("jdk.unsupported")

            targetFormats(TargetFormat.Msi)
            packageName = "org.jake_the_human.waxy"
            packageVersion = "1.0.0"
        }
    }
}
