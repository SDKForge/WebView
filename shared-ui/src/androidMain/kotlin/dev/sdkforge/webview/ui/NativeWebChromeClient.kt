package dev.sdkforge.webview.ui

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.ConsoleMessage
import android.webkit.GeolocationPermissions
import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.PermissionRequest
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebStorage
import android.webkit.WebView

@Suppress("ktlint:standard:class-signature")
internal class NativeWebChromeClient(
    internal val webViewController: WebViewController,
) : WebChromeClient() {

    override fun getDefaultVideoPoster(): Bitmap? {
        println("getDefaultVideoPoster")

        return super.getDefaultVideoPoster()
    }

    override fun getVideoLoadingProgressView(): View? {
        println("getVideoLoadingProgressView")

        return super.getVideoLoadingProgressView()
    }

    override fun getVisitedHistory(
        callback: ValueCallback<Array<out String?>?>?,
    ) {
        println("getVisitedHistory+callback")
    }

    override fun onCloseWindow(
        window: WebView?,
    ) {
        println("onCloseWindow+window")
    }

    override fun onConsoleMessage(
        consoleMessage: ConsoleMessage?,
    ): Boolean {
        println("onConsoleMessage")
        println("consoleMessage= -> $consoleMessage")

        return super.onConsoleMessage(consoleMessage)
    }

    override fun onConsoleMessage(
        message: String?,
        lineNumber: Int,
        sourceID: String?,
    ) {
        println("onConsoleMessage")
        println("message -> $message")
        println("lineNumber -> $lineNumber")
        println("sourceID -> $sourceID")
    }

    override fun onCreateWindow(
        view: WebView?,
        isDialog: Boolean,
        isUserGesture: Boolean,
        resultMsg: Message?,
    ): Boolean {
        println("onCreateWindow")
        println("isDialog -> $isDialog")
        println("isUserGesture -> $isUserGesture")
        println("resultMsg -> $resultMsg")

        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
    }

    override fun onExceededDatabaseQuota(
        url: String?,
        databaseIdentifier: String?,
        quota: Long,
        estimatedDatabaseSize: Long,
        totalQuota: Long,
        quotaUpdater: WebStorage.QuotaUpdater?,
    ) {
        println("onExceededDatabaseQuota")
        println("url -> $url")
        println("databaseIdentifier -> $databaseIdentifier")
        println("quota -> $quota")
        println("estimatedDatabaseSize -> $estimatedDatabaseSize")
        println("totalQuota -> $totalQuota")
        println("quotaUpdater -> $quotaUpdater")
    }

    override fun onGeolocationPermissionsHidePrompt() {
        println("onGeolocationPermissionsHidePrompt")
    }

    override fun onGeolocationPermissionsShowPrompt(
        origin: String?,
        callback: GeolocationPermissions.Callback?,
    ) {
        println("onGeolocationPermissionsShowPrompt")
        println("origin -> $origin")
        println("callback -> $callback")
    }

    override fun onHideCustomView() {
        println("onHideCustomView")
    }

    override fun onJsAlert(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?,
    ): Boolean {
        println("onJsAlert")
        println("url -> $url")
        println("message -> $message")
        println("result -> $result")

        return super.onJsAlert(view, url, message, result)
    }

    override fun onJsBeforeUnload(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?,
    ): Boolean {
        println("onJsBeforeUnload")
        println("url -> $url")
        println("message -> $message")
        println("result -> $result")

        return super.onJsBeforeUnload(view, url, message, result)
    }

    override fun onJsConfirm(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?,
    ): Boolean {
        println("onJsConfirm")
        println("url -> $url")
        println("message -> $message")
        println("result -> $result")

        return super.onJsConfirm(view, url, message, result)
    }

    override fun onJsPrompt(
        view: WebView?,
        url: String?,
        message: String?,
        defaultValue: String?,
        result: JsPromptResult?,
    ): Boolean {
        println("onJsPrompt")
        println("url -> $url")
        println("message -> $message")
        println("defaultValue -> $defaultValue")
        println("result -> $result")

        return super.onJsPrompt(view, url, message, defaultValue, result)
    }

    override fun onJsTimeout(): Boolean {
        println("onJsTimeout")

        return super.onJsTimeout()
    }

    override fun onPermissionRequest(
        request: PermissionRequest?,
    ) {
        println("onPermissionRequest")
        println("request -> $request")
    }

    override fun onPermissionRequestCanceled(
        request: PermissionRequest?,
    ) {
        println("onPermissionRequestCanceled")
        println("request -> $request")
    }

    override fun onProgressChanged(
        view: WebView?,
        newProgress: Int,
    ) {
        println("onProgressChanged")
        println("newProgress -> $newProgress")
    }

    override fun onReceivedIcon(
        view: WebView?,
        icon: Bitmap?,
    ) {
        println("onReceivedIcon")
        println("icon -> $icon")
    }

    override fun onReceivedTitle(
        view: WebView?,
        title: String?,
    ) {
        println("onReceivedTitle")
        println("title -> $title")

        webViewController.title = title
    }

    override fun onReceivedTouchIconUrl(
        view: WebView?,
        url: String?,
        precomposed: Boolean,
    ) {
        println("onReceivedTouchIconUrl")
        println("url -> $url")
        println("precomposed -> $precomposed")
    }

    override fun onRequestFocus(
        view: WebView?,
    ) {
        println("onRequestFocus")
    }

    override fun onShowCustomView(
        view: View?,
        callback: CustomViewCallback?,
    ) {
        println("onShowCustomView")
        println("callback -> $callback")
    }

    override fun onShowCustomView(
        view: View?,
        requestedOrientation: Int,
        callback: CustomViewCallback?,
    ) {
        println("onShowCustomView")
        println("requestedOrientation -> $requestedOrientation")
        println("callback -> $callback")
    }

    override fun onShowFileChooser(
        webView: WebView?,
        filePathCallback: ValueCallback<Array<out Uri?>?>?,
        fileChooserParams: FileChooserParams?,
    ): Boolean {
        println("onShowFileChooser")
        println("filePathCallback -> $filePathCallback")
        println("fileChooserParams -> $fileChooserParams")

        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }
}
