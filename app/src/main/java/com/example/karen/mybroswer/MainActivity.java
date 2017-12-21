package com.example.karen.mybroswer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webView);
        Intent intent = getIntent();
        Uri url = intent.getData();
        URL url1 = null;
        try {
            url1 = new URL(url.getScheme(),url.getHost(),url.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        startBrowser(url1);
    }

    private void startBrowser(URL url) {
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(url.toString());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                 return true;
            }
        });
    }
}
