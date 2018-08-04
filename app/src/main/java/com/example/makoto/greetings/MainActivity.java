package com.example.makoto.greetings;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.TimePickerDialog);
        button.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.Seyana);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    public void showTimePickerDialog() {


        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //時間を取得して、４桁に直す。
                        int tmpTime = 100 * hourOfDay + minute;

                        if (tmpTime < 200) {
                            mTextView.setText("こんばんは");
                        } else if (tmpTime < 1000) {
                            mTextView.setText("おはよう");
                        } else if (tmpTime < 1800 ) {
                            mTextView.setText("こんにちは");
                        } else {
                            mTextView.setText("こんばんは");
                        }
                    }
                },
                13,
                0,
                true);
        timePickerDialog.show();
    }
}
