package br.com.bluzone

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConsultaFragment: Fragment(R.layout.fragment_consulta) {
    private lateinit var registraBtn: AppCompatButton
    private lateinit var consultarBtn: AppCompatButton

    private val navigator get() = findNavController()

    private val viewModel: BaseViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupButtons()
    }

    private fun initViews(view: View) {
        with(view) {
            registraBtn = findViewById(R.id.registraBtn)
            consultarBtn = findViewById(R.id.consultarBtn)
        }
    }

    private fun setupButtons() {

        consultarBtn.setOnClickListener {
            viewModel.setUriImg1("URI DA IMAGEM 1")
            //ToDo not implemented
        }

        registraBtn.setOnClickListener {
            navigator.navigate(R.id.irregularidadeFragment)
        }
    }
}