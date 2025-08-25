package dev.sdkforge.webview.ui

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dev.sdkforge.webview.domain.RequestInterceptor
import dev.sdkforge.webview.domain.WebViewConfig
import dev.sdkforge.webview.ui.internal.PlatformWebView

internal class NativeWebViewController(
    internal override val interceptors: List<RequestInterceptor>,
    internal override val config: WebViewConfig,
    context: Context,
) : WebViewController() {

    override val platformWebView: PlatformWebView = PlatformWebView(
        context = context,
    )

    @SuppressLint("SetJavaScriptEnabled")
    override fun attach() {
        with(platformWebView.webView) {
            webViewClient = NativeWebViewClient(
                webViewController = this@NativeWebViewController,
            )
            webChromeClient = NativeWebChromeClient(
                webViewController = this@NativeWebViewController,
            )

            with(settings) {
                javaScriptEnabled = true
                domStorageEnabled = true
            }
        }
    }

    override fun detach() {
        with(platformWebView.webView) {
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
        }
    }
}

@Composable
actual fun rememberWebViewController(
    interceptors: List<RequestInterceptor>,
    config: WebViewConfig,
): WebViewController {
    val context = LocalContext.current

    return remember(interceptors, config, context) {
        NativeWebViewController(interceptors = interceptors, config = config, context = context)
    }
}
