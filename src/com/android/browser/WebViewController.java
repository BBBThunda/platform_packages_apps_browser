/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.browser;

import com.android.browser.IntentHandler.UrlData;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * WebView aspect of the controller
 */
public interface WebViewController {

    Activity getActivity();

    TabControl getTabControl();

    void onPageStarted(Tab tab, WebView view, String url, Bitmap favicon);

    void onPageFinished(Tab tab, String url);

    void onProgressChanged(Tab tab, int newProgress);

    void onReceivedTitle(Tab tab, final String title);

    void onFavicon(Tab tab, WebView view, Bitmap icon);

    boolean shouldOverrideUrlLoading(WebView view, String url);

    boolean shouldOverrideKeyEvent(KeyEvent event);

    void onUnhandledKeyEvent(KeyEvent event);

    void doUpdateVisitedHistory(Tab tab, String url, boolean isReload);

    void getVisitedHistory(final ValueCallback<String[]> callback);

    void onReceivedHttpAuthRequest(Tab tab, WebView view, final HttpAuthHandler handler,
            final String host, final String realm);

    void onDownloadStart(Tab tab, String url, String useragent, String contentDisposition,
            String mimeType, long contentLength);

    void showCustomView(Tab tab, View view, WebChromeClient.CustomViewCallback callback);

    void hideCustomView();

    Bitmap getDefaultVideoPoster();

    View getVideoLoadingProgressView();

    void showSslCertificateOnError(WebView view, SslErrorHandler handler,
            SslError error);

    void activateVoiceSearchMode(String title);

    void revertVoiceSearchMode(Tab tab);

    boolean shouldShowErrorConsole();

    void resetTitleAndRevertLockIcon(Tab tab);

    void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType);

    void endActionMode();

    void attachSubWindow(Tab tab);

    void dismissSubWindow(Tab tab);

    Tab openTabAndShow(UrlData urlData, boolean closeOnExit, String appId);

    boolean switchToTab(int tabindex);

    void closeTab(Tab tab);

}
