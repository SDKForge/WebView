package dev.sdkforge.webview.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun WebView(
    webViewController: WebViewController = rememberWebViewController(),
    modifier: Modifier = Modifier,
)
