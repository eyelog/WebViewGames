package ru.eyelog.webviewgames.chromeweb

import android.webkit.WebChromeClient
import android.webkit.WebView

class CustomWebChrome(
        private val loadingListener: ((Int) -> Unit) = {}
) : WebChromeClient() {

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        loadingListener.invoke(newProgress)
    }
}
