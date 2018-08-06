package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class URL extends AppCompatActivity {

    WebView wvURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        wvURL = findViewById(R.id.WebViewURL);
        wvURL.setWebViewClient(new WebViewClient());

//        wvURL.getSettings().setJavaScriptEnabled(true);
//        wvURL.getSettings().setAllowFileAccess(false);
//        wvURL.getSettings().setBuiltInZoomControls(true);

        Intent intentReceived = getIntent();
        String urlSelected = intentReceived.getStringExtra("url");
        wvURL.loadUrl(urlSelected);
    }
}
