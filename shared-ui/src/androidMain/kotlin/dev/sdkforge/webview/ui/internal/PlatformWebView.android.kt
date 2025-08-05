package dev.sdkforge.webview.ui.internal

import android.content.Context
import android.webkit.WebView

@Suppress("ktlint:standard:class-signature")
actual class PlatformWebView(
    context: Context,
) {
    internal val webView: WebView = WebView(context)

    actual fun canGoBack(): Boolean = webView.canGoBack()
    actual fun goBack() = webView.goBack()

    actual fun canGoForward(): Boolean = webView.canGoForward()
    actual fun goForward() = webView.goForward()

    actual fun reload() = webView.reload()

    actual fun load(
        url: String,
        headers: Map<String, String>,
    ) {
        webView.loadUrl(url, headers)
    }
}
