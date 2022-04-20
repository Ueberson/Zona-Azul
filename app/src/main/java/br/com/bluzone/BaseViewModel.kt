package br.com.bluzone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    private val _test = MutableLiveData<String>()
    val test: LiveData<String> = _test

    fun test(string: String) {
      _test.value = string
    }

}