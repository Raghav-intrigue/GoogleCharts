package org.huzaifa.googlecharts;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText val1, val2, val3, val4, val5;
    EditText item1, item2, item3, item4, item5;
    EditText title;
    EditText name1,name2,name3;
    EditText fdate1,fdate2,fdate3,tdate1,tdate2,tdate3;
    Button btnShow,btnTimeline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = (EditText) findViewById(R.id.num1);
        val2 = (EditText) findViewById(R.id.num2);
        val3 = (EditText) findViewById(R.id.num3);
        val4 = (EditText) findViewById(R.id.num4);
        val5 = (EditText) findViewById(R.id.num5);
        item1 = (EditText) findViewById(R.id.item1);
        item2 = (EditText) findViewById(R.id.item2);
        item3 = (EditText) findViewById(R.id.item3);
        item4 = (EditText) findViewById(R.id.item4);
        item5 = (EditText) findViewById(R.id.item5);
        name1 = (EditText) findViewById(R.id.name1);
        name2 = (EditText) findViewById(R.id.name2);
        name3 = (EditText) findViewById(R.id.name3);
        fdate1 = (EditText) findViewById(R.id.fDate1);
        fdate2 = (EditText) findViewById(R.id.fDate2);
        fdate3 = (EditText) findViewById(R.id.fDate3);
        tdate1 = (EditText) findViewById(R.id.tDate1);
        tdate2 = (EditText) findViewById(R.id.tDate2);
        tdate3 = (EditText) findViewById(R.id.tDate3);
        title = (EditText) findViewById(R.id.title);
        btnShow = (Button) findViewById(R.id.show);
        btnTimeline = (Button) findViewById(R.id.showTimeline);

        btnTimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        ShowTimelineActivity.class);

                intent.putExtra("ITEM1", getItemName(name1));
                intent.putExtra("ITEM2", getItemName(name2));
                intent.putExtra("ITEM3", getItemName(name3));
                intent.putExtra("FROM_DATE1", getDate(fdate1));
                intent.putExtra("FROM_DATE2", getDate(fdate2));
                intent.putExtra("FROM_DATE3", getDate(fdate3));
                intent.putExtra("TO_DATE1",getDate(tdate1));
                intent.putExtra("TO_DATE2",getDate(tdate2));
                intent.putExtra("TO_DATE3",getDate(tdate3));
                intent.putExtra("TITLE", getChartTitle());
                startActivity(intent);
            }
        });
        btnShow.setOnClickListener(btnShowOnClickListener);
    }


    View.OnClickListener btnShowOnClickListener =
            new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            ShowWebChartActivity.class);

                    intent.putExtra("VAL1", getVal(val1));
                    intent.putExtra("VAL2", getVal(val2));
                    intent.putExtra("VAL3", getVal(val3));
                    intent.putExtra("VAL4", getVal(val4));
                    intent.putExtra("VAL5", getVal(val5));
                    intent.putExtra("ITEM1", getItemName(item1));
                    intent.putExtra("ITEM2", getItemName(item2));
                    intent.putExtra("ITEM3", getItemName(item3));
                    intent.putExtra("ITEM4", getItemName(item4));
                    intent.putExtra("ITEM5", getItemName(item5));
                    intent.putExtra("TITLE", getChartTitle());
                    startActivity(intent);
                }

            };

    private String getItemName(EditText editText) {
        String item;
        String stringItemName = editText.getText().toString();
        if(stringItemName.equals("")){
            item="Item";
        } else {
            item = stringItemName;
        }
        return item;
    }

    private int getVal(EditText editText) {

        int num = 0;

        String stringNum = editText.getText().toString();
        if (!stringNum.equals("")) {
            num = Integer.valueOf(stringNum);
        }

        return (num);
    }

    public String getChartTitle() {
        String chartTitle;
        String name = title.getText().toString();
        if(name.equals("")){
            chartTitle="Google Charts Example";
        } else {
            chartTitle = name;
        }
        return chartTitle;
    }

    public String getDate (EditText editText){
        String date;
        String d = editText.getText().toString();
        if(d.equals("")){
            date="";
        } else {
            date = d;
        }
        return date;
    }
}
