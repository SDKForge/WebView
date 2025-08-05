package dev.sdkforge.webview.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.union
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeUIViewController

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalComposeUiApi::class)
fun MainViewController() = ComposeUIViewController(
    configure = { enforceStrictPlistSanityCheck = false },
) {
    val webViewController = rememberWebViewController()

    BackHandler(
        enabled = webViewController.platformWebView.canGoBack(),
        onBack = { webViewController.platformWebView.goBack() },
    )

    LaunchedEffect(Unit) {
        webViewController.platformWebView.load("https://github.com/SDKForge/WebView")
    }

    LaunchedEffect(webViewController.pageState) {
        println("Page state: ${webViewController.pageState}")
    }
    LaunchedEffect(webViewController.title) {
        println("Title: ${webViewController.title}")
    }

    WebView(
        webViewController = webViewController,
        modifier = Modifier
            .consumeWindowInsets(WindowInsets.statusBars.union(WindowInsets.systemBars))
            .background(Color.White)
            .fillMaxSize()
            .systemBarsPadding(),
    )
}
