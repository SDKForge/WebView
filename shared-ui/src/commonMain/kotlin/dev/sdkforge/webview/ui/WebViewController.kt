package dev.sdkforge.webview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.sdkforge.webview.domain.RequestInterceptor
import dev.sdkforge.webview.domain.WebPageState
import dev.sdkforge.webview.domain.WebViewConfig
import dev.sdkforge.webview.ui.internal.PlatformWebView

@Stable
abstract class WebViewController : WebViewState {
    internal abstract val interceptors: List<RequestInterceptor>
    internal abstract val config: WebViewConfig

    abstract val platformWebView: PlatformWebView

    override var pageState: WebPageState by mutableStateOf(WebPageState.Empty)
        internal set
    override var title: String? by mutableStateOf(null)
        internal set

    internal abstract fun attach()
    internal abstract fun detach()

    internal fun shouldIntercept(
        url: String,
    ): Boolean = interceptors.any { it.intercept(url) }
}

@Stable
interface WebViewState {
    val pageState: WebPageState
    val title: String?
}

@Composable
expect fun rememberWebViewController(
    interceptors: List<RequestInterceptor> = emptyList(),
    config: WebViewConfig = WebViewConfig(),
): WebViewController
