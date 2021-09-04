package com.example.newsapp.BackPress;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;

import androidx.fragment.app.FragmentActivity;

public class BackPressHandler {

    WebView webView;
    public BackPressHandler(WebView webView) {
        this.webView=webView;
    }
    public  void backPressing(FragmentActivity activity){
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN){
                    if(keyCode==KeyEvent.KEYCODE_BACK){
                        if(webView!=null){
                            if(webView.canGoBack()){
                                webView.goBack();
                            }
                            else {
                                activity.onBackPressed();
                            }
                        }
                    }
                }
                return true;
            }
        });
    }
}
