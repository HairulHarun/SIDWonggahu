package com.chairul.sidwonggahu.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chairul.sidwonggahu.R;
import com.chairul.sidwonggahu.adapter.BrowserAdapter;
import com.chairul.sidwonggahu.adapter.KoneksiAdapter;
import com.chairul.sidwonggahu.adapter.URLAdapter;
import com.chairul.sidwonggahu.adapter.WebInterfaceAdapter;

public class HomeFragment extends Fragment {
    private KoneksiAdapter koneksiAdapter;
    private WebView webView;
    private ProgressBar progress;
    private Boolean isInternetPresent = false;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        progress = (ProgressBar) view.findViewById(R.id.progressBar);
        progress.setVisibility(View.GONE);
        webView = (WebView) view.findViewById(R.id.webView);

        koneksiAdapter = new KoneksiAdapter(getActivity().getApplicationContext());
        if (isInternetPresent = koneksiAdapter.isConnectingToInternet()) {
            loadWeb();
        }else{
            Toast.makeText(getActivity().getApplicationContext(), "Not Internet Connection", Toast.LENGTH_LONG).show();
        }
        return view;
    }

    private void loadWeb(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAppCachePath(getActivity().getApplicationContext().getCacheDir().getPath());
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.addJavascriptInterface(new WebInterfaceAdapter(getActivity()), "Android");
        webView.setWebViewClient(new BrowserAdapter(getActivity().getApplicationContext(), progress));
        webView.loadUrl(new URLAdapter().getMain());
    }
}