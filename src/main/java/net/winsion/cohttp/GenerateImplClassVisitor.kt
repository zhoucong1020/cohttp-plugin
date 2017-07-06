package net.winsion.cohttp

import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.Opcodes
import java.io.FileOutputStream

/**
 * Created by zhoucong on 2017/7/4.
 */
class GenerateImplClassVisitor(cv: ClassVisitor, private val path: String) : ClassVisitor(Opcodes.ASM4, cv) {
    override fun visitAnnotation(desc: String, visible: Boolean): AnnotationVisitor {
        if (desc == "Lwinsion/net/kotlinandroid/cohttp/markers/CohttpInterface;") {
            val file = path.replace(".class", "Impl.class")
            val fos = FileOutputStream(file)
            fos.write(ConfigurationImplDump.dump())
            fos.close()
        }

        return super.visitAnnotation(desc, visible)
    }
}