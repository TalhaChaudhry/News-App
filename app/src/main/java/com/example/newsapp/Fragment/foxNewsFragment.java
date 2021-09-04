package com.example.newsapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.newsapp.BackPress.BackPressHandler;
import com.example.newsapp.R;
import com.example.newsapp.WenViewController;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link foxNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class foxNewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public foxNewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment foxNewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static foxNewsFragment newInstance(String param1, String param2) {
        foxNewsFragment fragment = new foxNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_fox_news,container,false);
        WebView webView;
        webView=root.findViewById(R.id.webView_fox);
        webView.loadUrl("https://www.foxnews.com/");
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WenViewController());
        new BackPressHandler(webView).backPressing(getActivity());
        return root;
    }



}
