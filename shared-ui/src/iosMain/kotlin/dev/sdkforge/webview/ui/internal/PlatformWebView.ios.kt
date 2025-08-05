package dev.sdkforge.webview.ui.internal

import platform.Foundation.NSMutableURLRequest
import platform.Foundation.NSURL
import platform.Foundation.setAllHTTPHeaderFields
import platform.WebKit.WKWebView

actual class PlatformWebView {
    internal val wkWebView: WKWebView = WKWebView.new()!!

    actual fun canGoBack(): Boolean = wkWebView.canGoBack()
    actual fun goBack() = wkWebView.goBack().let { Unit }

    actual fun canGoForward(): Boolean = wkWebView.canGoForward()
    actual fun goForward() = wkWebView.goForward().let { Unit }

    actual fun reload() = wkWebView.reload().let { Unit }

    actual fun load(
        url: String,
        headers: Map<String, String>,
    ) {
        wkWebView.loadRequest(
            request = NSMutableURLRequest(
                uRL = NSURL.URLWithString(url)!!,
            ).apply {
                setAllHTTPHeaderFields(allHTTPHeaderFields = headers.toMutableMap())
            },
        )
    }
}
