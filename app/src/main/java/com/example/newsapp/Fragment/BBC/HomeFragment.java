package com.example.newsapp.Fragment.BBC;

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

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      /*  homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

       */
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        WebView webView;
        webView = root.findViewById(R.id.webView_bbc);
        webView.loadUrl("https://www.bbc.com/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WenViewController());
        new BackPressHandler(webView).backPressing(getActivity());
        return root;
    }
}