package br.com.bluzone

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class IrregularidadeFragment : Fragment(R.layout.fragment_irregularidade) {
    private val viewModel: BaseViewModel by viewModel()

    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carregaImagem()
    }


    fun carregaImagem() {
        val uri1 = viewModel.getUriImg1()
//        val uri2 = viewModel.getUriImg2()
//        val uri3 = viewModel.getUriImg3()
//        val uri4 = viewModel.getUriImg4()

        img1.setImageURI(Uri.parse(uri1))
    }
}

