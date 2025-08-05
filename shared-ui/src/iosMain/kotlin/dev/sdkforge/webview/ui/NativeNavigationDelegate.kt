package dev.sdkforge.webview.ui

import kotlinx.cinterop.ObjCSignatureOverride
import platform.Foundation.NSError
import platform.Foundation.NSURLAuthenticationChallenge
import platform.Foundation.NSURLCredential
import platform.Foundation.NSURLSessionAuthChallengeDisposition
import platform.Foundation.NSURLSessionAuthChallengePerformDefaultHandling
import platform.WebKit.WKDownload
import platform.WebKit.WKNavigation
import platform.WebKit.WKNavigationAction
import platform.WebKit.WKNavigationActionPolicy
import platform.WebKit.WKNavigationDelegateProtocol
import platform.WebKit.WKNavigationResponse
import platform.WebKit.WKNavigationResponsePolicy
import platform.WebKit.WKWebView
import platform.WebKit.WKWebpagePreferences
import platform.darwin.NSObject

@Suppress("ktlint:standard:class-signature")
internal class NativeNavigationDelegate(
    internal val webViewController: WebViewController,
) : NSObject(),
    WKNavigationDelegateProtocol {

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didStartProvisionalNavigation: WKNavigation?,
    ) {
        println("didStartProvisionalNavigation")
    }

    override fun webView(
        webView: WKWebView,
        didReceiveAuthenticationChallenge: NSURLAuthenticationChallenge,
        completionHandler: (NSURLSessionAuthChallengeDisposition, NSURLCredential?) -> Unit,
    ) {
        println("didReceiveAuthenticationChallenge+completionHandler")

        completionHandler.invoke(NSURLSessionAuthChallengePerformDefaultHandling, null)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFailNavigation: WKNavigation?,
        withError: NSError,
    ) {
        println("didFailNavigation+withError")
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFailProvisionalNavigation: WKNavigation?,
        withError: NSError,
    ) {
        println("didFailProvisionalNavigation+withError")
    }

    override fun webView(
        webView: WKWebView,
        decidePolicyForNavigationAction: WKNavigationAction,
        decisionHandler: (WKNavigationActionPolicy) -> Unit,
    ) {
        println("decidePolicyForNavigationAction+decisionHandler")
    }

    override fun webView(
        webView: WKWebView,
        decidePolicyForNavigationAction: WKNavigationAction,
        preferences: WKWebpagePreferences,
        decisionHandler: (WKNavigationActionPolicy, WKWebpagePreferences?) -> Unit,
    ) {
        println("decidePolicyForNavigationAction+preferences+decisionHandler")

        decisionHandler.invoke(WKNavigationActionPolicy.WKNavigationActionPolicyAllow, null)
    }

    override fun webView(
        webView: WKWebView,
        navigationAction: WKNavigationAction,
        didBecomeDownload: WKDownload,
    ) {
        println("navigationAction+didBecomeDownload")
    }

    override fun webView(
        webView: WKWebView,
        decidePolicyForNavigationResponse: WKNavigationResponse,
        decisionHandler: (WKNavigationResponsePolicy) -> Unit,
    ) {
        println("decidePolicyForNavigationResponse+decisionHandler")

        decisionHandler.invoke(WKNavigationResponsePolicy.WKNavigationResponsePolicyAllow)
    }

    override fun webView(
        webView: WKWebView,
        navigationResponse: WKNavigationResponse,
        didBecomeDownload: WKDownload,
    ) {
        println("navigationResponse+didBecomeDownload")
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didReceiveServerRedirectForProvisionalNavigation: WKNavigation?,
    ) {
        println("didReceiveServerRedirectForProvisionalNavigation")
    }

    override fun webView(
        webView: WKWebView,
        authenticationChallenge: NSURLAuthenticationChallenge,
        shouldAllowDeprecatedTLS: (Boolean) -> Unit,
    ) {
        println("authenticationChallenge+shouldAllowDeprecatedTLS")
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFinishNavigation: WKNavigation?,
    ) {
        println("didFinishNavigation")

        webViewController.pageState = WebPageState.Loaded(url = webView.URL?.absoluteString.orEmpty())
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didCommitNavigation: WKNavigation?,
    ) {
        println("didCommitNavigation")

        webViewController.pageState = WebPageState.Loading(url = webView.URL?.absoluteString.orEmpty())
    }

    override fun webViewWebContentProcessDidTerminate(
        webView: WKWebView,
    ) {
        println("webViewWebContentProcessDidTerminate")
    }
}
