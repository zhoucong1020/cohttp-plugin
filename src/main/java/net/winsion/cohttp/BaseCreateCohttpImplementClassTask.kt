package net.winsion.cohttp

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.File
import java.io.FileInputStream

/**
 * Created by zhoucong on 2017/7/4.
 */
abstract class BaseCreateCohttpImplementClassTask : DefaultTask() {
    abstract fun getBasePath(): String

    @TaskAction
    fun generateClass() {
        val root = File(getBasePath())
        findClass(root)
    }

    private fun findClass(root: File) {
        root.listFiles().forEach {
            if (it.isDirectory) {
                findClass(it)
            } else if (it.name.endsWith(".class") && !it.name.contains("$")) {
                try {
                    val cw = ClassWriter(ClassWriter.COMPUTE_MAXS)
                    val cr = ClassReader(readClassBytes(it))
                    val visitor = GenerateImplClassVisitor(cw, it.absolutePath)
                    cr.accept(visitor, ClassReader.SKIP_CODE)
                } catch (e: ClassNotFoundException) {
                    //ignore
                }
            }
        }
    }

    private fun readClassBytes(file: File): ByteArray {
        val fis = FileInputStream(file)
        val bytes = ByteArray(fis.available())
        fis.read(bytes, 0, fis.available())
        return bytes
    }
}