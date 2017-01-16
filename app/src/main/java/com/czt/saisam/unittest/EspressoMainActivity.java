package com.czt.saisam.unittest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 进行espresso 测试
 */
public class EspressoMainActivity extends Activity {
    private TextView greetingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_main);
        greetingView = (TextView) findViewById(R.id.greeting);
    }

    public void greet(View v) {
        greetingView.setText(R.string.hello_world);
    }
}

