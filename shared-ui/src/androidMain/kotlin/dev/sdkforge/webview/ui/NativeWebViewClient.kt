package dev.sdkforge.webview.ui

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.ClientCertRequest
import android.webkit.HttpAuthHandler
import android.webkit.RenderProcessGoneDetail
import android.webkit.SafeBrowsingResponse
import android.webkit.SslErrorHandler
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import dev.sdkforge.webview.domain.WebPageState

@Suppress("ktlint:standard:class-signature")
internal class NativeWebViewClient(
    internal val webViewController: WebViewController,
) : WebViewClient() {

    override fun doUpdateVisitedHistory(
        view: WebView?,
        url: String?,
        isReload: Boolean,
    ) {
        println("doUpdateVisitedHistory")
        println("url -> $url")
        println("isReload -> $isReload")
    }

    override fun onFormResubmission(
        view: WebView?,
        dontResend: Message?,
        resend: Message?,
    ) {
        println("onFormResubmission")
        println("dontResend -> $dontResend")
        println("resend -> $resend")
    }

    override fun onLoadResource(
        view: WebView?,
        url: String?,
    ) {
        println("onFormResubmission")
        println("url -> $url")
    }

    override fun onPageCommitVisible(
        view: WebView?,
        url: String?,
    ) {
        println("onPageCommitVisible")
        println("url -> $url")
    }

    override fun onPageFinished(
        view: WebView?,
        url: String?,
    ) {
        println("onPageFinished")
        println("url -> $url")

        webViewController.pageState = WebPageState.Loaded(url = url.orEmpty())
    }

    override fun onPageStarted(
        view: WebView?,
        url: String?,
        favicon: Bitmap?,
    ) {
        println("onPageStarted")
        println("url -> $url")
        println("favicon -> $favicon")

        webViewController.pageState = WebPageState.Loading(url = url.orEmpty())
    }

    override fun onReceivedClientCertRequest(
        view: WebView?,
        request: ClientCertRequest?,
    ) {
        println("onReceivedClientCertRequest")
        println("request -> $request")
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?,
    ) {
        println("onReceivedClientCertRequest")
        println("request -> $request")
        println("error -> $error")
    }

    override fun onReceivedError(
        view: WebView?,
        errorCode: Int,
        description: String?,
        failingUrl: String?,
    ) {
        println("onReceivedClientCertRequest")
        println("errorCode -> $errorCode")
        println("description -> $description")
        println("failingUrl -> $failingUrl")
    }

    override fun onReceivedHttpAuthRequest(
        view: WebView?,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?,
    ) {
        println("onReceivedHttpAuthRequest")
        println("handler -> $handler")
        println("host -> $host")
        println("realm -> $realm")
    }

    override fun onReceivedHttpError(
        view: WebView?,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?,
    ) {
        println("onReceivedHttpError")
        println("request -> $request")
        println("errorResponse -> $errorResponse")
    }

    override fun onReceivedLoginRequest(
        view: WebView?,
        realm: String?,
        account: String?,
        args: String?,
    ) {
        println("onReceivedLoginRequest")
        println("realm -> $realm")
        println("account -> $account")
        println("args -> $args")
    }

    override fun onReceivedSslError(
        view: WebView?,
        handler: SslErrorHandler?,
        error: SslError?,
    ) {
        println("onReceivedSslError")
        println("handler -> $handler")
        println("error -> $error")
    }

    override fun onRenderProcessGone(
        view: WebView?,
        detail: RenderProcessGoneDetail?,
    ): Boolean {
        println("onRenderProcessGone")
        println("detail -> $detail")

        return super.onRenderProcessGone(view, detail)
    }

    override fun onSafeBrowsingHit(
        view: WebView?,
        request: WebResourceRequest?,
        threatType: Int,
        callback: SafeBrowsingResponse?,
    ) {
        println("onSafeBrowsingHit")
        println("request -> $request")
        println("threatType -> $threatType")
        println("callback -> $callback")
    }

    override fun onScaleChanged(
        view: WebView?,
        oldScale: Float,
        newScale: Float,
    ) {
        println("onScaleChanged")
        println("oldScale -> $oldScale")
        println("newScale -> $newScale")
    }

    override fun onTooManyRedirects(
        view: WebView?,
        cancelMsg: Message?,
        continueMsg: Message?,
    ) {
        println("onTooManyRedirects")
        println("cancelMsg -> $cancelMsg")
        println("continueMsg -> $continueMsg")
    }

    override fun onUnhandledKeyEvent(
        view: WebView?,
        event: KeyEvent?,
    ) {
        println("onUnhandledKeyEvent")
        println("event -> $event")
    }

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?,
    ): WebResourceResponse? {
        println("shouldInterceptRequest")
        println("request -> $request")

        return super.shouldInterceptRequest(view, request)
    }

    override fun shouldInterceptRequest(
        view: WebView?,
        url: String?,
    ): WebResourceResponse? {
        println("shouldInterceptRequest")
        println("url -> $url")

        return super.shouldInterceptRequest(view, url)
    }

    override fun shouldOverrideKeyEvent(
        view: WebView?,
        event: KeyEvent?,
    ): Boolean {
        println("shouldOverrideKeyEvent")
        println("event -> $event")

        return super.shouldOverrideKeyEvent(view, event)
    }

    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?,
    ): Boolean {
        println("shouldOverrideUrlLoading")
        println("request -> $request")

        return webViewController.shouldIntercept(url = request?.url?.toString().orEmpty())
    }

    override fun shouldOverrideUrlLoading(
        view: WebView?,
        url: String?,
    ): Boolean {
        println("shouldOverrideUrlLoading")
        println("url -> $url")

        return webViewController.shouldIntercept(url = url.orEmpty())
    }
}
