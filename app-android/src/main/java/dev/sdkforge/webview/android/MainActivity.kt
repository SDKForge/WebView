package dev.sdkforge.webview.android

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import dev.sdkforge.webview.app.App
import dev.sdkforge.webview.ui.rememberWebViewController

class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT),
        )
        setContent {
            val webViewController = rememberWebViewController()

            BackHandler(
                enabled = webViewController.platformWebView.canGoBack(),
                onBack = { webViewController.platformWebView.goBack() },
            )

            App(
                webViewController = webViewController,
                modifier = Modifier
                    .systemBarsPadding()
                    .fillMaxSize(),
            )
        }
    }
}
