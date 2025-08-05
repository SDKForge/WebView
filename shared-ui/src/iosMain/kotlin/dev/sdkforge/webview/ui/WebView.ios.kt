package dev.sdkforge.webview.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitView

@Composable
actual fun WebView(
    webViewController: WebViewController,
    modifier: Modifier,
) {
    UIKitView(
        factory = { webViewController.platformWebView.wkWebView },
        modifier = modifier,
        update = { webViewController.attach() },
        onRelease = { webViewController.detach() },
        onReset = { webViewController.detach() },
    )
}
