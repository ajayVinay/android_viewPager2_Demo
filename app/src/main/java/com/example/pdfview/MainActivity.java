package com.example.pdfview;

import android.app.ProgressDialog;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        WebView web_view = findViewById(R.id.webView);
        web_view.requestFocus();
        web_view.getSettings().setJavaScriptEnabled(true);

      /*  String myPdfUrl = "gymnasium-wandlitz.de/vplan/vplan.pdf";
        String url = "https://docs.google.com/viewer?embedded=true&url="+myPdfUrl;

*/
        String myPdfUrl = "http://www.africau.edu/images/default/sample.pdf";
        final String url = "http://docs.google.com/gview?embedded=true&url=" + myPdfUrl;



        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        web_view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });

        web_view.loadUrl(url);
    }
}
       /* WebView webView = findViewById(R.id.webView);
        final ProgressBar progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        webView = new WebView(this);
        String url = "http://www.africau.edu/images/default/sample.pdf";
        final String finalUrl = "http://docs.google.com/gview?embedded=true&url=" + url;


      *//*  Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
*//*

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                getSupportActionBar().setTitle("Loading...");

                // indicates that url loading is complete
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                    getSupportActionBar().setTitle(R.string.app_name);

                }
            }
        });
        webView.loadUrl(finalUrl);


    */

