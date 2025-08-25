package dev.sdkforge.webview.ui

import dev.sdkforge.webview.domain.WebPageState
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
        println(didStartProvisionalNavigation)
    }

    override fun webView(
        webView: WKWebView,
        didReceiveAuthenticationChallenge: NSURLAuthenticationChallenge,
        completionHandler: (NSURLSessionAuthChallengeDisposition, NSURLCredential?) -> Unit,
    ) {
        println("didReceiveAuthenticationChallenge+completionHandler")
        println(didReceiveAuthenticationChallenge)

        webViewController.title = webView.title

        completionHandler.invoke(NSURLSessionAuthChallengePerformDefaultHandling, null)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFailNavigation: WKNavigation?,
        withError: NSError,
    ) {
        println("didFailNavigation+withError")
        println(didFailNavigation)
        println(withError)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFailProvisionalNavigation: WKNavigation?,
        withError: NSError,
    ) {
        println("didFailProvisionalNavigation+withError")
        println(didFailProvisionalNavigation)
        println(withError)
    }

    override fun webView(
        webView: WKWebView,
        decidePolicyForNavigationAction: WKNavigationAction,
        decisionHandler: (WKNavigationActionPolicy) -> Unit,
    ) {
        println("decidePolicyForNavigationAction+decisionHandler")
        println(decidePolicyForNavigationAction)
    }

    override fun webView(
        webView: WKWebView,
        decidePolicyForNavigationAction: WKNavigationAction,
        preferences: WKWebpagePreferences,
        decisionHandler: (WKNavigationActionPolicy, WKWebpagePreferences?) -> Unit,
    ) {
        println("decidePolicyForNavigationAction+preferences+decisionHandler")
        println(decidePolicyForNavigationAction)
        println(preferences)

        decisionHandler.invoke(WKNavigationActionPolicy.WKNavigationActionPolicyAllow, null)
    }

    override fun webView(
        webView: WKWebView,
        navigationAction: WKNavigationAction,
        didBecomeDownload: WKDownload,
    ) {
        println("navigationAction+didBecomeDownload")
        println(navigationAction)
        println(didBecomeDownload)
    }

    override fun webView(
        webView: WKWebView,
        decidePolicyForNavigationResponse: WKNavigationResponse,
        decisionHandler: (WKNavigationResponsePolicy) -> Unit,
    ) {
        println("decidePolicyForNavigationResponse+decisionHandler")
        println(decidePolicyForNavigationResponse)

        decisionHandler.invoke(WKNavigationResponsePolicy.WKNavigationResponsePolicyAllow)
    }

    override fun webView(
        webView: WKWebView,
        navigationResponse: WKNavigationResponse,
        didBecomeDownload: WKDownload,
    ) {
        println("navigationResponse+didBecomeDownload")
        println(navigationResponse)
        println(didBecomeDownload)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didReceiveServerRedirectForProvisionalNavigation: WKNavigation?,
    ) {
        println("didReceiveServerRedirectForProvisionalNavigation")
        println(didReceiveServerRedirectForProvisionalNavigation)
    }

    override fun webView(
        webView: WKWebView,
        authenticationChallenge: NSURLAuthenticationChallenge,
        shouldAllowDeprecatedTLS: (Boolean) -> Unit,
    ) {
        println("authenticationChallenge+shouldAllowDeprecatedTLS")
        println(authenticationChallenge)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didFinishNavigation: WKNavigation?,
    ) {
        println("didFinishNavigation")
        println(didFinishNavigation)

        webViewController.pageState = WebPageState.Loaded(url = webView.URL?.absoluteString.orEmpty())
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        didCommitNavigation: WKNavigation?,
    ) {
        println("didCommitNavigation")
        println(didCommitNavigation)

        webViewController.pageState = WebPageState.Loading(url = webView.URL?.absoluteString.orEmpty())
    }

    override fun webViewWebContentProcessDidTerminate(
        webView: WKWebView,
    ) {
        println("webViewWebContentProcessDidTerminate")
    }
}
