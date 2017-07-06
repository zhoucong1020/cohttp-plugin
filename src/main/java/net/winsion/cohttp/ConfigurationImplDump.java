package net.winsion.cohttp;

import org.objectweb.asm.*;

/**
 * Created by zhoucong on 2017/7/4.
 */
public class ConfigurationImplDump implements Opcodes {
    public static byte[] dump() throws Exception {
        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(V1_6, ACC_PUBLIC + ACC_FINAL + ACC_SUPER, "winsion/net/kotlinandroid/ConfigurationImpl", null, "winsion/net/kotlinandroid/cohttp/RequestBaseImpl", new String[]{"winsion/net/kotlinandroid/Configuration"});

        {
            av0 = cw.visitAnnotation("Lkotlin/Metadata;", true);
            av0.visit("mv", new int[]{1, 1, 6});
            av0.visit("bv", new int[]{1, 0, 1});
            av0.visit("k", new Integer(1));
            {
                AnnotationVisitor av1 = av0.visitArray("d1");
                av1.visit(null, "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0009\u0082\u0002\u0004\n\u0002\u0008\u0009\u00a8\u0006\n");
                av1.visitEnd();
            }
            {
                AnnotationVisitor av1 = av0.visitArray("d2");
                av1.visit(null, "Lwinsion/net/kotlinandroid/ConfigurationImpl;");
                av1.visit(null, "Lwinsion/net/kotlinandroid/cohttp/RequestBaseImpl;");
                av1.visit(null, "Lwinsion/net/kotlinandroid/Configuration;");
                av1.visit(null, "()V");
                av1.visit(null, "fetchAll");
                av1.visit(null, "");
                av1.visit(null, "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;");
                av1.visit(null, "fetchGetByKey");
                av1.visit(null, "key");
                av1.visit(null, "(Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;");
                av1.visit(null, "app_debug");
                av1.visitEnd();
            }
            av0.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "fetchAll", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/experimental/Continuation<-Ljava/lang/String;>;)Ljava/lang/Object;", null);
            {
                av0 = mv.visitAnnotation("Lorg/jetbrains/annotations/Nullable;", false);
                av0.visitEnd();
            }
            {
                av0 = mv.visitParameterAnnotation(0, "Lorg/jetbrains/annotations/NotNull;", false);
                av0.visitEnd();
            }
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("$continuation");
            mv.visitMethodInsn(INVOKESTATIC, "kotlin/jvm/internal/Intrinsics", "checkParameterIsNotNull", "(Ljava/lang/Object;Ljava/lang/String;)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitLdcInsn("http://121.42.48.201:12666/fetch/all");
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "winsion/net/kotlinandroid/ConfigurationImpl", "coroutineWebRequest", "(Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 2);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "fetchGetByKey", "(Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation<-Ljava/lang/String;>;)Ljava/lang/Object;", null);
            {
                av0 = mv.visitAnnotation("Lorg/jetbrains/annotations/Nullable;", false);
                av0.visitEnd();
            }
            {
                av0 = mv.visitParameterAnnotation(0, "Lorg/jetbrains/annotations/NotNull;", false);
                av0.visitEnd();
            }
            {
                av0 = mv.visitParameterAnnotation(1, "Lorg/jetbrains/annotations/NotNull;", false);
                av0.visitEnd();
            }
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
            mv.visitLdcInsn("key");
            mv.visitMethodInsn(INVOKESTATIC, "kotlin/jvm/internal/Intrinsics", "checkParameterIsNotNull", "(Ljava/lang/Object;Ljava/lang/String;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitLdcInsn("$continuation");
            mv.visitMethodInsn(INVOKESTATIC, "kotlin/jvm/internal/Intrinsics", "checkParameterIsNotNull", "(Ljava/lang/Object;Ljava/lang/String;)V", false);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
            mv.visitLdcInsn("http://121.42.48.201:12666/fetch/getByKey?key=");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitMethodInsn(INVOKEVIRTUAL, "winsion/net/kotlinandroid/ConfigurationImpl", "coroutineWebRequest", "(Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "winsion/net/kotlinandroid/cohttp/RequestBaseImpl", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
