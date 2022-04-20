package br.com.bluzone

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Module {
    val module = module {
        viewModel { BaseViewModel() }
    }
}