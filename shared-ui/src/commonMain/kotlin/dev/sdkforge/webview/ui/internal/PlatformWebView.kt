package dev.sdkforge.webview.ui.internal

expect class PlatformWebView {
    fun canGoBack(): Boolean
    fun goBack()

    fun canGoForward(): Boolean
    fun goForward()

    fun reload()

    fun load(
        url: String,
        headers: Map<String, String> = emptyMap(),
    )
}
