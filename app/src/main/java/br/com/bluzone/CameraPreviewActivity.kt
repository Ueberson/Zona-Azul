package br.com.bluzone

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import br.com.bluzone.databinding.ActivityCameraPreviewBinding
import com.google.common.util.concurrent.ListenableFuture
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class CameraPreviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraPreviewBinding

    //processamento de imagem - Controle do driver da camera
    private lateinit var cameraProviderFeature: ListenableFuture<ProcessCameraProvider>

    //Selecionar a camera desejada
    private lateinit var cameraSelector: CameraSelector

    //executor de thread separada
    private lateinit var imgCaptureExecutor: ExecutorService

    private lateinit var first: AppCompatButton
    private lateinit var second: AppCompatButton
    private lateinit var third: AppCompatButton
    private lateinit var fourth: AppCompatButton

    //imagem capturada
    private var imageCapture: ImageCapture? = null

    private val viewModel: BaseViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_preview)

        binding = ActivityCameraPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Botão para adicionar a primeira foto
        // first = findViewById(R.id.first)


        //Botão para adicionar a segunda foto
        //second = findViewById(R.id.second)


        //Botão para adicionar a terceira foto
        // third = findViewById(R.id.third)


        //Botão para adicionar a quarta foto
        // fourth = findViewById(R.id.fourth)


        cameraProviderFeature = ProcessCameraProvider.getInstance(this)
        cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        imgCaptureExecutor = Executors.newSingleThreadExecutor()

        //Metodo start camera
        startCamera()

        //evento do clique para chamar o metodo de tirar foto
        binding.btnTirarFoto.setOnClickListener {
//            takePhoto()
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//                blinkPreview()
        }
    }


    private fun startCamera() {
        cameraProviderFeature.addListener({

            imageCapture = ImageCapture.Builder().build()


            val cameraProvider = cameraProviderFeature.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(binding.cameraPreview.surfaceProvider)
            }
            try {
                //abrir o preview
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageCapture)

            } catch (e: Exception) {
                Log.e("CameraPreview", "Falha ao abrir a camera")
            }


        }, ContextCompat.getMainExecutor(this))
    }

    private fun takePhoto() {
        //codigo para tirar a foto
        imageCapture?.let {

            //nome do arquivo
            val filename = "FOTO_JPEG_${System.currentTimeMillis()}"
            val file = File(externalMediaDirs[0], filename)

            val outputFileOptions = ImageCapture.OutputFileOptions.Builder(file).build()

            it.takePicture(
                outputFileOptions,
                imgCaptureExecutor,
                object : ImageCapture.OnImageSavedCallback {
                    override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                        Log.i("CameraPreview", "A imagem foi salva no diretorio: ${file.toURI()}")
                        //para bitmap
                        val bitmap =
                            MediaStore.Images.Media.getBitmap(
                                contentResolver,
                                outputFileResults.savedUri
                            )

                    }

                    override fun onError(exception: ImageCaptureException) {
                        Toast.makeText(
                            binding.root.context,
                            "Erro ao salvar a foto",
                            Toast.LENGTH_LONG
                        ).show()
                        Log.e("CameraPreview", "Excecao ao gravar arquivo da foto: ${exception}")
                    }
                }
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == MediaUtils.CAMERA_REQUEST_CODE) {
                val photo: Bitmap? = data?.extras?.get("data") as Bitmap?
                val uri = ""
                val base64 = MediaUtils().parseBitmapToBase64(photo)

                //ToDo converter de base64 para Bitmap (MediaUtils)

                when (viewModel.getImageIdentifier()) {
                    1 -> {
                        //1a ação
                        viewModel.setUriImg1("banana")
                    }

                    2 -> {
                        //1a ação
                        viewModel.setUriImg2(base64)
                    }

                    3 -> {

                    }

                    4 -> {

                    }

                    else -> {
                        //
                    }
                }


                //  this.finish()
                // val intent = Intent()   //
                //startActivity()
                //todo use photo para carregar a view
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun blinkPreview() {
        binding.root.postDelayed({
            binding.root.foreground = ColorDrawable(Color.WHITE)
            binding.root.postDelayed({
                binding.root.foreground = null
            }, 50)
        }, 100)
    }
}