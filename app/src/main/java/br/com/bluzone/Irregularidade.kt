package br.com.bluzone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import br.com.bluzone.databinding.ActivityMainBinding

class Irregularidade : AppCompatActivity() {
    private lateinit var backBtn: AppCompatButton
    private lateinit var homeBtn: AppCompatButton
    private lateinit var enviarBtn: AppCompatButton
    private lateinit var firstBtn: AppCompatButton
    private lateinit var secondBtn: AppCompatButton
    private lateinit var thirdBtn: AppCompatButton
    private lateinit var fourthBtn: AppCompatButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_irregularidade)



        //botão para voltar para a home
        homeBtn = findViewById(R.id.homeButton)
        homeBtn.setOnClickListener{
            IrHome()
        }

        //Botão para voltar a tela
        backBtn = findViewById(R.id.IrregularBackBtn)
        backBtn.setOnClickListener{
            IrParaConsulta()
        }

        //Botão para adicionar a primeira foto
        firstBtn = findViewById(R.id.first)
        firstBtn.setOnClickListener{
            IrParaCaptura()
        }
        //Botão para adicionar a segunda foto
        secondBtn = findViewById(R.id.second)
        secondBtn.setOnClickListener{
            IrParaCaptura()
        }
        //Botão para adicionar a terceira foto
        thirdBtn = findViewById(R.id.third)
        thirdBtn.setOnClickListener{
            IrParaCaptura()
        }
        //Botão para adicionar a quarta foto
        fourthBtn = findViewById(R.id.fourth)
        fourthBtn.setOnClickListener{
            IrParaCaptura()
        }



        //Botão para enviar a irregularide
        //enviarBtn = findViewById(R.id.enviarBtn)
    }

    //Função para Retornar a home
    private fun IrHome() {
        val telaHome = Intent(this, MainActivity::class.java)
        startActivity(telaHome)
    }

    //Função para voltar a tela de consulta
    private fun IrParaConsulta() {
        val telaConsulta = Intent(this, StatusVeiculo::class.java)
        startActivity(telaConsulta)
    }
    //Função para acessar a tela de captura
    private fun IrParaCaptura() {
        val telaCaptura = Intent(this, TelaCaptura::class.java)
        startActivity(telaCaptura)
    }


}