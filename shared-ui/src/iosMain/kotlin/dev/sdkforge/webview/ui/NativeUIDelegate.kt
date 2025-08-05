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
    ) = Unit

    override fun webView(
        webView: WKWebView,
        requestDeviceOrientationAndMotionPermissionForOrigin: WKSecurityOrigin,
        initiatedByFrame: WKFrameInfo,
        decisionHandler: (WKPermissionDecision) -> Unit,
    ) = Unit

    override fun webView(
        webView: WKWebView,
        commitPreviewingViewController: UIViewController,
    ) = Unit

    override fun webView(
        webView: WKWebView,
        shouldPreviewElement: WKPreviewElementInfo,
    ): Boolean = false

    override fun webView(
        webView: WKWebView,
        createWebViewWithConfiguration: WKWebViewConfiguration,
        forNavigationAction: WKNavigationAction,
        windowFeatures: WKWindowFeatures,
    ): WKWebView = webView

    override fun webView(
        webView: WKWebView,
        runJavaScriptAlertPanelWithMessage: String,
        initiatedByFrame: WKFrameInfo,
        completionHandler: () -> Unit,
    ) = Unit

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        contextMenuWillPresentForElement: WKContextMenuElementInfo,
    ) = Unit

    override fun webView(
        webView: WKWebView,
        requestMediaCapturePermissionForOrigin: WKSecurityOrigin,
        initiatedByFrame: WKFrameInfo,
        type: WKMediaCaptureType,
        decisionHandler: (WKPermissionDecision) -> Unit,
    ) = Unit

    override fun webView(
        webView: WKWebView,
        runJavaScriptTextInputPanelWithPrompt: String,
        defaultText: String?,
        initiatedByFrame: WKFrameInfo,
        completionHandler: (String?) -> Unit,
    ) = Unit

    override fun webView(
        webView: WKWebView,
        contextMenuForElement: WKContextMenuElementInfo,
        willCommitWithAnimator: UIContextMenuInteractionCommitAnimatingProtocol,
    ) = Unit

    override fun webView(
        webView: WKWebView,
        previewingViewControllerForElement: WKPreviewElementInfo,
        defaultActions: List<*>,
    ): UIViewController? = null

    override fun webView(
        webView: WKWebView,
        contextMenuConfigurationForElement: WKContextMenuElementInfo,
        completionHandler: (UIContextMenuConfiguration?) -> Unit,
    ) = Unit

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        willDismissEditMenuWithAnimator: UIEditMenuInteractionAnimatingProtocol,
    ) = Unit

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        willPresentEditMenuWithAnimator: UIEditMenuInteractionAnimatingProtocol,
    ) = Unit

    override fun webView(
        webView: WKWebView,
        runJavaScriptConfirmPanelWithMessage: String,
        initiatedByFrame: WKFrameInfo,
        completionHandler: (Boolean) -> Unit,
    ) = Unit

    @ObjCSignatureOverride
    override fun webView(
        webView: WKWebView,
        contextMenuDidEndForElement: WKContextMenuElementInfo,
    ) = Unit

    override fun webViewDidClose(
        webView: WKWebView,
    ) = Unit
}
