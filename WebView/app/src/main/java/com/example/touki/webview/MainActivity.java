package com.example.touki.webview;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final Activity activity=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview = (WebView) findViewById(R.id.webView1);
        if(!isConnected(MainActivity.this)) {
            Toast.makeText(MainActivity.this,"Connect to Internet",Toast.LENGTH_LONG).show();
            String summary = "<html><body><p>No <b>Internet</b>? Don't worry.</p></body></html>";
            webview.loadData(summary, "text/html", null);
        }
        else
        {
            Toast.makeText(MainActivity.this,"Internet is OK",Toast.LENGTH_LONG).show();
            //webview.loadUrl("https://www.aiub.edu");
            webview.loadUrl("file:///android_asset/web/myHtml.html");
            webview.getSettings().setJavaScriptEnabled(true);
            webview.setWebViewClient(new WebViewClient());
        }
    }

    public boolean isConnected(Context context)
    {
        ConnectivityManager cm =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=cm.getActiveNetworkInfo();

        if(networkInfo !=null && networkInfo.isConnectedOrConnecting())
        {
            android.net.NetworkInfo wifi=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile !=null && mobile.isConnectedOrConnecting())||(wifi!=null&&wifi.isConnectedOrConnecting())) return true;
            else return false;
        }
        else return false;
    }
}
