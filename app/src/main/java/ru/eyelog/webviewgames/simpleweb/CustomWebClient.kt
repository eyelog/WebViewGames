package ru.eyelog.webviewgames.simpleweb

import android.graphics.Bitmap
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class CustomWebClient(
        private val loadingListener: ((Boolean) -> Unit) = {}
) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return if (view != null) {
            view.loadUrl(request?.url.toString())
            true
        } else {
            false
        }
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        loadingListener.invoke(true)
    }

    override fun onPageCommitVisible(view: WebView?, url: String?) {
        super.onPageCommitVisible(view, url)
        loadingListener.invoke(false)
    }

}
