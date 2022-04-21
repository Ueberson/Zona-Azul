package br.com.bluzone

import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    private var imageIdentifier = 1

    private var img1 = ""
    private var img2 = ""
    private var img3 = ""
    private var img4 = ""

    //Setter
    fun setImageIdentifier(int: Int) {
        imageIdentifier = int
    }

    //Getter
    fun getImageIdentifier(): Int {
        return imageIdentifier
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

    fun getUriImg1(): String {
        return this.img1
    }
}