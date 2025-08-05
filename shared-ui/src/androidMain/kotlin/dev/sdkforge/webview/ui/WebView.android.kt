package dev.sdkforge.webview.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
actual fun WebView(
    webViewController: WebViewController,
    modifier: Modifier,
) {
    AndroidView(
        factory = { webViewController.platformWebView.webView },
        modifier = modifier,
        update = { webViewController.attach() },
    )

    DisposableEffect(webViewController) { onDispose { webViewController.detach() } }
}
