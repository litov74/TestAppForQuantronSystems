package ru.litov74dev.testapplication

import android.content.Context
import java.io.File
import kotlin.jvm.internal.Intrinsics


object Utils {

    fun generateFile(context: Context, path: String, fileName: String): File? {
        var file: File? = null
        val root = File(
            context.getExternalFilesDir(null),
            path
        )
        var dirExists = true
        if (!root.exists()) {
            dirExists = root.mkdirs()
        }
        if (dirExists) {
            file = File(root, fileName)
        }
        return file
    }

}