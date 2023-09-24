package buildSrc.plugins

import com.android.build.gradle.BaseExtension
import buildSrc.Config
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.applyRepositories()
        project.applyKotlinCompilerArgs()
        project.extensions.configure<BaseExtension> {
            compileSdkVersion(Config.Sdk.compile)
            defaultConfig {
                minSdk = Config.Sdk.min
                targetSdk = Config.Sdk.target
                multiDexEnabled = true
                versionCode = Config.Build.versionCode
                versionName = Config.Build.versionName
                vectorDrawables.useSupportLibrary = true
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
    }
}
