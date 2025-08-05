package dev.sdkforge.webview.ui

interface RequestInterceptor {
    fun intercept(
        url: String,
    ): Boolean
}
