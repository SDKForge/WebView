package dev.sdkforge.webview.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackHandler
import androidx.compose.ui.window.ComposeUIViewController
import dev.sdkforge.webview.ui.rememberWebViewController
import kotlin.experimental.ExperimentalObjCName

@OptIn(ExperimentalObjCName::class, ExperimentalComposeUiApi::class)
@Suppress("FunctionName")
@ObjCName("create")
fun ComposeAppViewController() = ComposeUIViewController(
    configure = {
        enforceStrictPlistSanityCheck = false
    },
) {
    val webViewController = rememberWebViewController()

    BackHandler(
        enabled = webViewController.platformWebView.canGoBack(),
        onBack = { webViewController.platformWebView.goBack() },
    )

    App(
        webViewController = webViewController,
        modifier = Modifier
            .fillMaxSize(),
    )
}
