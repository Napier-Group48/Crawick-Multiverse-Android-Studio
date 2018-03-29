package com.example.work.crawickmultiverse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdBurgerFragment extends Fragment {



    public ThirdBurgerFragment() {
        // Required empty public constructor
    }
  //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_third_burger, container, false);
       WebView webView = (WebView)v.findViewById(R.id.wv);
       webView.getSettings().setJavaScriptEnabled(true);
       webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.crawickmultiverse.co.uk/events/");

        // Inflate the layout for this fragment
        return v;
    }

}
