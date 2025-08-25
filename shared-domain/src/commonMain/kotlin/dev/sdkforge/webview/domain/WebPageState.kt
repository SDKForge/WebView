package dev.sdkforge.webview.domain

sealed interface WebPageState {
    data object Empty : WebPageState
    data class Loading(val url: String) : WebPageState
    data class Loaded(val url: String) : WebPageState
}
