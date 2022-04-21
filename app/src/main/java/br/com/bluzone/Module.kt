package br.com.bluzone

import org.koin.dsl.module

object Module {
    val module = module {
        single { BaseViewModel() }
    }
}