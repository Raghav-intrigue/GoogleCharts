package org.huzaifa.googlecharts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

@SuppressLint("SetJavaScriptEnabled")
public class ShowWebChartActivity extends ActionBarActivity {

    WebView webView;
    int num1, num2, num3, num4, num5;
    String item1, item2, item3, item4, item5, title;

    Spinner spCharts;
    List<String> listCharts;
    List<String> listHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_web_chart);

        Intent intent = getIntent();
        num1 = intent.getIntExtra("VAL1", 0);
        num2 = intent.getIntExtra("VAL2", 0);
        num3 = intent.getIntExtra("VAL3", 0);
        num4 = intent.getIntExtra("VAL4", 0);
        num5 = intent.getIntExtra("VAL5", 0);
        item1 = intent.getStringExtra("ITEM1");
        item2 = intent.getStringExtra("ITEM2");
        item3 = intent.getStringExtra("ITEM3");
        item4 = intent.getStringExtra("ITEM4");
        item5 = intent.getStringExtra("ITEM5");
        title = intent.getStringExtra("TITLE");

        spCharts = (Spinner) findViewById(R.id.spcharts);

        listCharts = new ArrayList<String>();
        listCharts.add("Pie Chart");
        listCharts.add("Pie Chart 3D");
        listCharts.add("Scatter Chart");
        listCharts.add("Column Chart");
        listCharts.add("Bar Chart");
        listCharts.add("Histogram");
        listCharts.add("Line Chart");
        listCharts.add("Area Chart");

        listHtml = new ArrayList<String>();
        listHtml.add("file:///android_asset/pie_chart.html");
        listHtml.add("file:///android_asset/pie_chart_3d.html");
        listHtml.add("file:///android_asset/scatter_chart.html");
        listHtml.add("file:///android_asset/column_chart.html");
        listHtml.add("file:///android_asset/bar_chart.html");
        listHtml.add("file:///android_asset/histogram.html");
        listHtml.add("file:///android_asset/line_chart.html");
        listHtml.add("file:///android_asset/area_chart.html");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listCharts);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCharts.setAdapter(dataAdapter);
        spCharts.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String chartHtml = listHtml.get(parent.getSelectedItemPosition());
                webView.loadUrl(chartHtml);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        webView = (WebView) findViewById(R.id.web);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");

        webView.getSettings().setJavaScriptEnabled(true);

    }

    public class WebAppInterface {

        @JavascriptInterface
        public int getNum1() {
            return num1;
        }

        @JavascriptInterface
        public int getNum2() {
            return num2;
        }

        @JavascriptInterface
        public int getNum3() {
            return num3;
        }

        @JavascriptInterface
        public int getNum4() {
            return num4;
        }

        @JavascriptInterface
        public int getNum5() {
            return num5;
        }

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
        public String getItem4() {
            return item4;
        }

        @JavascriptInterface
        public String getItem5() {
            return item5;
        }

        @JavascriptInterface
        public String getChartTitle() {
            return title;
        }
    }

}