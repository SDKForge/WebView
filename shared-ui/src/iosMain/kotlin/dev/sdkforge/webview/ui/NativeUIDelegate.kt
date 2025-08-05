package dev.sdkforge.webview.ui

import kotlinx.cinterop.ObjCSignatureOverride
import platform.UIKit.UIContextMenuConfiguration
import platform.UIKit.UIContextMenuInteractionCommitAnimatingProtocol
import platform.UIKit.UIEditMenuInteractionAnimatingProtocol
import platform.UIKit.UIViewController
import platform.WebKit.WKContextMenuElementInfo
import platform.WebKit.WKDialogResult
import platform.WebKit.WKFrameInfo
import platform.WebKit.WKMediaCaptureType
import platform.WebKit.WKNavigationAction
import platform.WebKit.WKPermissionDecision
import platform.WebKit.WKPreviewElementInfo
import platform.WebKit.WKSecurityOrigin
import platform.WebKit.WKUIDelegateProtocol
import platform.WebKit.WKWebView
import platform.WebKit.WKWebViewConfiguration
import platform.WebKit.WKWindowFeatures
import platform.darwin.NSObject

class NativeUIDelegate :
    NSObject(),
    WKUIDelegateProtocol {
    override fun webView(
        webView: WKWebView,
        showLockdownModeFirstUseMessage: String,
        completionHandler: (WKDialogResult) -> Unit,
    ) {
        println("showLockdownModeFirstUseMessage+completionHandler")
        println(showLockdownModeFirstUseMessage)
    }

    override fun webView(
        webView: WKWebView,
        requestDeviceOrientationAndMotionPermissionForOrigin: WKSecurityOrigin,
        initiatedByFrame: WKFrameInfo,
        decisionHandler: (WKPermissionDecision) -> Unit,
    ) {
        println("requestDeviceOrientationAndMotionPermissionForOrigin+decisionHandler")
        println(requestDeviceOrientationAndMotionPermissionForOrigin)
        println(initiatedByFrame)
    }

    override fun webView(
        webView: WKWebView,
        commitPreviewingViewController: UIViewController,
    ) {
        println("commitPreviewingViewController")
        println(commitPreviewingViewController)
    }

    override fun webView(
        webView: WKWebView,
        shouldPreviewElement: WKPreviewElementInfo,
    ): Boolean {
        println("shouldPreviewElement")
        println(shouldPreviewElement)

        return false
    }

    override fun webView(
        webView: WKWebView,
        createWebViewWithConfiguration: WKWebViewConfiguration,
        forNavigationAction: WKNavigationAction,
        windowFeatures: WKWindowFeatures,
    ): WKWebView {
        println("createWebViewWithConfiguration+forNavigationAction+windowFeatures")
        println(createWebViewWithConfiguration)
        println(forNavigationAction)
        println(windowFeatures)

        return webView
    }

    override fun webView(
        webView: WKWebView,
        runJavaScriptAlertPanelWithMessage: String,
        initiatedByFrame: WKFrameInfo,
        completionHandler: () -> Unit,
    ) {
        println("runJavaScriptAlertPanelWithMessage+completionHandler")
        println(runJavaScriptAlertPanelWithMessage)
        println(initiatedByFrame)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        contextMenuWillPresentForElement: WKContextMenuElementInfo,
    ) {
        println("contextMenuWillPresentForElement")
        println(contextMenuWillPresentForElement)
    }

    override fun webView(
        webView: WKWebView,
        requestMediaCapturePermissionForOrigin: WKSecurityOrigin,
        initiatedByFrame: WKFrameInfo,
        type: WKMediaCaptureType,
        decisionHandler: (WKPermissionDecision) -> Unit,
    ) {
        println("requestMediaCapturePermissionForOrigin+decisionHandler")
        println(requestMediaCapturePermissionForOrigin)
        println(initiatedByFrame)
        println(type)
    }

    override fun webView(
        webView: WKWebView,
        runJavaScriptTextInputPanelWithPrompt: String,
        defaultText: String?,
        initiatedByFrame: WKFrameInfo,
        completionHandler: (String?) -> Unit,
    ) {
        println("runJavaScriptTextInputPanelWithPrompt+completionHandler")
        println(runJavaScriptTextInputPanelWithPrompt)
        println(defaultText)
        println(initiatedByFrame)
    }

    override fun webView(
        webView: WKWebView,
        contextMenuForElement: WKContextMenuElementInfo,
        willCommitWithAnimator: UIContextMenuInteractionCommitAnimatingProtocol,
    ) {
        println("contextMenuForElement+willCommitWithAnimator")
        println(contextMenuForElement)
        println(willCommitWithAnimator)
    }

    override fun webView(
        webView: WKWebView,
        previewingViewControllerForElement: WKPreviewElementInfo,
        defaultActions: List<*>,
    ): UIViewController? {
        println("previewingViewControllerForElement+defaultActions")
        println(previewingViewControllerForElement)
        println(defaultActions)

        return null
    }

    override fun webView(
        webView: WKWebView,
        contextMenuConfigurationForElement: WKContextMenuElementInfo,
        completionHandler: (UIContextMenuConfiguration?) -> Unit,
    ) {
        println("contextMenuConfigurationForElement+completionHandler")
        println(contextMenuConfigurationForElement)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        willDismissEditMenuWithAnimator: UIEditMenuInteractionAnimatingProtocol,
    ) {
        println("willDismissEditMenuWithAnimator")
        println(willDismissEditMenuWithAnimator)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        willPresentEditMenuWithAnimator: UIEditMenuInteractionAnimatingProtocol,
    ) {
        println("willPresentEditMenuWithAnimator")
        println(willPresentEditMenuWithAnimator)
    }

    override fun webView(
        webView: WKWebView,
        runJavaScriptConfirmPanelWithMessage: String,
        initiatedByFrame: WKFrameInfo,
        completionHandler: (Boolean) -> Unit,
    ) {
        println("runJavaScriptConfirmPanelWithMessage+completionHandler")
        println(runJavaScriptConfirmPanelWithMessage)
        println(initiatedByFrame)
    }

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        contextMenuDidEndForElement: WKContextMenuElementInfo,
    ) {
        println("contextMenuDidEndForElement")
        println(contextMenuDidEndForElement)
    }

    override fun webViewDidClose(
        webView: WKWebView,
    ) {
        println("webViewDidClose")
    }
}
