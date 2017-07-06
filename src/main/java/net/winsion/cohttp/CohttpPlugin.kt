package net.winsion.cohttp

import net.winsion.cohttp.support.ExtensionHelper
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by zhoucong on 2017/7/4.
 */
class CohttpPlugin : Plugin<Project> {
    private val DEBUG = "createDebugCohttpImplementClass"
    private val DEBUG_PRE = "compileDebugKotlin"
    private val DEBUG_POST = "copyDebugKotlinClasses"

    private val RELEASE = "createReleaseCohttpImplementClass"
    private val RELEASE_PRE = "compileReleaseKotlin"
    private val RELEASE_POST = "copyReleaseKotlinClasses"

    override fun apply(project: Project) {
        prepareDirs(project)

        createTasks(project)
    }

    private fun prepareDirs(project: Project) {
        ExtensionHelper.ext[ExtensionHelper.BUILD_DIR] = project.buildDir.absolutePath
    }

    private fun createTasks(project: Project) {
        project.afterEvaluate {
            project.tasks.create(DEBUG, CreateDebugCohttpImplementClassTask::class.java)
                    .dependsOn(DEBUG_PRE)

            project.tasks.getByName(DEBUG_POST)
                    .dependsOn(DEBUG)

            project.tasks.create(RELEASE, CreateReleaseCohttpImplementClassTask::class.java)
                    .dependsOn(RELEASE_PRE)

            project.tasks.getByName(RELEASE_POST)
                    .dependsOn(RELEASE)
        }
    }
}