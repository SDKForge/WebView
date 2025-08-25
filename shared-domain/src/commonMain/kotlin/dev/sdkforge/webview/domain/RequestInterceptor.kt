package dev.sdkforge.webview.domain

interface RequestInterceptor {
    fun intercept(
        url: String,
    ): Boolean
}
