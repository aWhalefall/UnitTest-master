package com.czt.saisam.unittest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;


public class EventBusActivity extends Activity implements View.OnClickListener {
    private Button butPress;
    private TextView tvShow;
    public static int numberPress = 0;
    private AsyncTask asyncTask;
    private ArrayBlockingQueue arrayBlockingQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        butPress = (Button) findViewById(R.id.but_eventbus);
        tvShow = (TextView) findViewById(R.id.tv_show);

        butPress.setOnClickListener(this);

        numberPress = 0;

        Method[] methods = EventBusActivity.class.getMethods();

        for (int i = 0; i < methods.length; i++) {

            Log.v("kotlonM", methods[i].getName() + "--->" + methods[i].getModifiers());

        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.but_eventbus:
                numberPress++;
                Toast.makeText(this, "press" + numberPress, Toast.LENGTH_LONG).show();
                EventBus.getDefault().post(new TextReleaseEvent(numberPress, "i,m title" + numberPress, "i'm content" + numberPress));
                Log.d("执行", "-------------------------------");
                break;

        }

    }

    // 实际上却不会给出自动的代码提示
    @Subscribe
    public void onEventMainThread(TextReleaseEvent event) {
        tvShow.setText(event.getTitle() + event.getContent());
    }

    public int getNumberPress() {

        return numberPress;
    }

}