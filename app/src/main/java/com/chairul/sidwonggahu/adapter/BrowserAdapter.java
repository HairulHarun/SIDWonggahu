package com.chairul.sidwonggahu.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class BrowserAdapter extends WebViewClient {
    private ProgressBar progress;
    private Context context;

    public BrowserAdapter(Context c, ProgressBar p) {
        this.progress=p;
        this.context=c;
    }

    @Override
    public  boolean shouldOverrideUrlLoading(WebView view, String url){
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        progress.setVisibility(View.GONE);
        progress.setProgress(100);
        super.onPageFinished(view, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        progress.setVisibility(View.VISIBLE);
        progress.setProgress(0);
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Toast.makeText(context, "Server Sedang Sibuk !", Toast.LENGTH_LONG).show();
    }

}
