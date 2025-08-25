package dev.sdkforge.webview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.sdkforge.webview.domain.RequestInterceptor
import dev.sdkforge.webview.domain.WebViewConfig
import dev.sdkforge.webview.ui.internal.PlatformWebView

internal class NativeWebViewController(
    internal override val interceptors: List<RequestInterceptor> = emptyList(),
    internal override val config: WebViewConfig = WebViewConfig(),
) : WebViewController() {

    override val platformWebView: PlatformWebView = PlatformWebView()

    internal override fun attach() {
        with(platformWebView.wkWebView) {
            navigationDelegate = NativeNavigationDelegate(
                webViewController = this@NativeWebViewController,
            )
            UIDelegate = NativeUIDelegate()
        }
    }

    internal override fun detach() {
        with(platformWebView.wkWebView) {
            navigationDelegate = null
            UIDelegate = null
        }
    }
}

@Composable
actual fun rememberWebViewController(
    interceptors: List<RequestInterceptor>,
    config: WebViewConfig,
): WebViewController = remember(interceptors, config) {
    NativeWebViewController(interceptors = interceptors, config = config)
}
