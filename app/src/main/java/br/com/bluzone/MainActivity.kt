package br.com.bluzone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.bluzone.databinding.ActivityMainBinding
import br.com.bluzone.databinding.ActivityStatusveiculoBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflar a activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTelaConsultar.setOnClickListener{
            abrirTelaConsulta()
        }

        binding.btnTelaItinerario.setOnClickListener {
            abrirTelaItinerario()
        }
    }

    private fun abrirTelaConsulta(){
        //navegar pra activity de tela de consulta
        val intentTelaConsulta = Intent(this, StatusVeiculo::class.java)
        startActivity(intentTelaConsulta)
    }

    private fun abrirTelaItinerario(){
        //navegar pra activity de tela de Itinerario
        val intentTelaItinerario = Intent(this, MapsActivity::class.java)
        startActivity(intentTelaItinerario)
    }
}