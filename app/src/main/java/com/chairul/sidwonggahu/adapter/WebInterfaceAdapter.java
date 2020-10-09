package com.chairul.sidwonggahu.adapter;

import android.app.Activity;
import android.content.Intent;
import android.webkit.JavascriptInterface;

import com.chairul.sidwonggahu.RequestSuratActivity;

public class WebInterfaceAdapter {
    private Activity mActivity;

    /** Instantiate the interface and set the context */
    public WebInterfaceAdapter(Activity a) {
        mActivity = a;
    }

    @JavascriptInterface
    public void goToMain(){
        Intent intent = new Intent(mActivity, RequestSuratActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        mActivity.startActivity(intent);
    }
}
