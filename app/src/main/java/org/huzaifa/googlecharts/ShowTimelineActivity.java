package org.huzaifa.googlecharts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class ShowTimelineActivity extends AppCompatActivity {

    WebView webView;
    String item1, item2, item3, title;
    String date1,date11,date2,date22,date3,date33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_timeline);

        Intent intent = getIntent();
        item1 = intent.getStringExtra("ITEM1");
        item2 = intent.getStringExtra("ITEM2");
        item3 = intent.getStringExtra("ITEM3");
        title = intent.getStringExtra("TITLE");
        date1 = intent.getStringExtra("FROM_DATE1");
        date11 = intent.getStringExtra("TO_DATE1");
        date2 = intent.getStringExtra("FROM_DATE2");
        date22 = intent.getStringExtra("TO_DATE2");
        date3 = intent.getStringExtra("FROM_DATE3");
        date33 = intent.getStringExtra("TO_DATE3");

        webView = (WebView) findViewById(R.id.web);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/timeline.html");
    }

    private class WebAppInterface {

        @JavascriptInterface
        public String getItem1() {
            return item1;
        }

        @JavascriptInterface
        public String getItem2() {
            return item2;
        }

        @JavascriptInterface
        public String getItem3() {
            return item3;
        }

        @JavascriptInterface
        public String getChartTitle() {
            return title;
        }

        @JavascriptInterface
        public String getDate1() {
            return date1;
        }

        @JavascriptInterface
        public String getDate2() {
            return date2;
        }

        @JavascriptInterface
        public String getDate3() {
            return date3;
        }

        @JavascriptInterface
        public String getDate11() {
            return date11;
        }

        @JavascriptInterface
        public String getDate22() {
            return date22;
        }

        @JavascriptInterface
        public String getDate33() {
            return date33;
        }
    }
}
