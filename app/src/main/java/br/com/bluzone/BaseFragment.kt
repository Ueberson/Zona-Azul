package br.com.bluzone

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class BaseFragment : Fragment(R.layout.fragment_base) {
    private lateinit var btnTelaConsultar: AppCompatButton

    private val navigator get() = findNavController()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupButtons()
    }

    private fun initViews(view: View) {
        //ToDo inicialize suas views aqui

        with(view) {
            btnTelaConsultar = findViewById(R.id.btnTelaConsultar)
        }
    }

    private fun setupButtons() {
        //ToDo configure seus botões aqui

        btnTelaConsultar.setOnClickListener {
            navigator.navigate(R.id.consultaFragment)
        }
    }
}
