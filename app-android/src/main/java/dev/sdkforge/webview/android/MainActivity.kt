package dev.sdkforge.webview.android

import android.graphics.Color
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import dev.sdkforge.webview.app.ApplicationTheme
import dev.sdkforge.webview.ui.WebView
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

            LaunchedEffect(Unit) {
                webViewController.platformWebView.load("https://github.com/SDKForge/WebView")
            }

            LaunchedEffect(webViewController.pageState) {
                println("Page state: ${webViewController.pageState}")
            }
            LaunchedEffect(webViewController.title) {
                println("Title: ${webViewController.title}")
            }

            ApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    WebView(
                        webViewController = webViewController,
                    )
                }
            }
        }
    }
}
