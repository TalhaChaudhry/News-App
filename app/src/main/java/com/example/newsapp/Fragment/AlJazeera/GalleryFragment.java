package com.example.newsapp.Fragment.AlJazeera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.newsapp.BackPress.BackPressHandler;
import com.example.newsapp.R;
import com.example.newsapp.WenViewController;

public class GalleryFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        WebView webView;
        webView=root.findViewById(R.id.webView_alJazeera);
        webView.loadUrl("https://www.aljazeera.com/");
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WenViewController());
        new BackPressHandler(webView).backPressing(getActivity());
        return root;
    }
}