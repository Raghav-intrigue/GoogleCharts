package org.huzaifa.googlecharts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText val1, val2, val3, val4, val5;
    EditText item1, item2, item3, item4, item5;
    EditText title;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.num1);
        val2 = findViewById(R.id.num2);
        val3 = findViewById(R.id.num3);
        val4 = findViewById(R.id.num4);
        val5 = findViewById(R.id.num5);
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        item5 = findViewById(R.id.item5);
        title = findViewById(R.id.title);
        btnShow = findViewById(R.id.show);

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

}
