package br.com.bluzone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    private var img1 = ""
    private var img2 = ""
    private var img3 = ""
    private var img4 = ""

    private val _test = MutableLiveData<String>()
    val test: LiveData<String> = _test

    fun test(string: String) {
      _test.value = string
    }

    fun setUriImg1 (uri: String) {
        img1 = uri
    }

    fun setUriImg2 (uri: String) {
        img2 = uri
    }

    fun setUriImg3 (uri: String) {
        img3 = uri
    }

    fun setUriImg4 (uri: String) {
        img4 = uri
    }

}