package com.example.jayhind.lecture_app.webviewdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.jayhind.lecture_app.R;

public class WebViewActivity extends AppCompatActivity {
    WebView wv;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        String url="https://www.google.com";
        wv=findViewById(R.id.webview);
        pb=findViewById(R.id.pbar);
        wv.setWebViewClient(new MyWebViewClient());
        wv.loadUrl(url);
    }
    @Override
    public void onBackPressed() {
        if(wv.canGoBack())
        {
            wv.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pb.setVisibility(View.GONE);
        }
    }
}
