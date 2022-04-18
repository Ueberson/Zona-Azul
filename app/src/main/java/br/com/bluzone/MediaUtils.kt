package br.com.bluzone

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.util.Base64
import androidx.fragment.app.Fragment
import java.io.ByteArrayOutputStream


class MediaUtils () {
    companion object {
        const val CAMERA_REQUEST_CODE = 1
    }

    fun showCameraDialog(context: Context, fragment: Fragment) {
        val dialog = Dialog(context)
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("Choose Image Source")
        builder.setItems(
            arrayOf<CharSequence>("Camera")
        ) { _, which ->
            when (which) {

                CAMERA_REQUEST_CODE -> {
                    val cameraIntent = Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE
                    )
                    fragment.startActivityForResult(
                        cameraIntent,
                        CAMERA_REQUEST_CODE
                    )
                }
                else -> {}
            }
        }
        builder.show()
        dialog.dismiss()
    }

    fun parseBitmapToBase64(bitmap: Bitmap?): String {
        var base64 = ""

        if (bitmap != null) {
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            val byteArray = byteArrayOutputStream.toByteArray()

            base64 = Base64.encodeToString(byteArray, Base64.DEFAULT)
        }

        return base64
    }
}