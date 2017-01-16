package com.czt.saisam.unittest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tv = null;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = (TextView) this.findViewById(R.id.text1);
        this.findViewById(R.id.id_btn_fun).setOnClickListener(mOnClickListener);

    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.id_btn_fun:
                    fun();
                    break;
                default:

            }
        }
    };

    private void fun() {
        tv.setText(android.os.Build.MODEL + android.os.Build.getRadioVersion());
        Log.d("点击次数" + count++, "---------------------");
    }

}