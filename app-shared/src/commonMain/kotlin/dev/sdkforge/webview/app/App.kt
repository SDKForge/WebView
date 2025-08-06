package dev.sdkforge.webview.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import dev.sdkforge.webview.ui.WebView
import dev.sdkforge.webview.ui.WebViewController

@Composable
fun App(
    webViewController: WebViewController,
    modifier: Modifier = Modifier,
) = ApplicationTheme {
    LaunchedEffect(Unit) {
        webViewController.platformWebView.load("https://github.com/SDKForge/WebView")
    }
    LaunchedEffect(webViewController.pageState) {
        println("Page state: ${webViewController.pageState}")
    }
    LaunchedEffect(webViewController.title) {
        println("Title: ${webViewController.title}")
    }

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
    ) {
        WebView(
            webViewController = webViewController,
        )
    }
}
