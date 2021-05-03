package ru.eyelog.webviewgames.chromeweb

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import ru.eyelog.webviewgames.R
import ru.eyelog.webviewgames.simpleweb.CustomWebClient
import ru.eyelog.webviewgames.utils.NavigationUtils

class ChromeFragment: Fragment(), NavigationUtils {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView.webChromeClient = CustomWebChrome(
                loadingListener = { progress -> showLoading(progress) }
        )
        webView.webViewClient = CustomWebClient()
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://yandex.ru")
    }

    private fun showLoading(progress: Int){
        viewToolbarProgressBar.isVisible = progress in 0..99
        viewToolbarProgressBar.progress = progress
    }

    override fun backPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        }
    }
}
