package net.winsion.cohttp

import net.winsion.cohttp.support.ExtensionHelper


/**
 * Created by zhoucong on 2017/7/4.
 */
open class CreateDebugCohttpImplementClassTask : BaseCreateCohttpImplementClassTask() {
    override fun getBasePath(): String {
        return (ExtensionHelper.ext[ExtensionHelper.BUILD_DIR] + ExtensionHelper.DEBUG_KOTLIN_CLASS_DIR).replace("\\", "/") + "/"
    }
}