package com.czt.saisam.unittest.android;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.czt.saisam.unittest.EventBusActivity;
import com.czt.saisam.unittest.R;

/**
 * Created by kotlon on 2015/8/11.
 * 测试调用 待测代码入口，执行输出值与期望的值进行对比验证。
 */
public class TestEventBusActivity extends ActivityInstrumentationTestCase2<EventBusActivity> {
    private Activity eventBusActivity;
    private Button button;
    private TextView textView;

    public TestEventBusActivity() {
        super("com.wbiao.whistle.work", EventBusActivity.class);
    }

//

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        eventBusActivity = getActivity();
        button = (Button) eventBusActivity.findViewById(R.id.but_eventbus);
        textView = (TextView) eventBusActivity.findViewById(R.id.tv_show);
//
//        eventBusActivity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                button.requestFocus();
//                button.performClick();
//            }
//        });

    }

    // 所有的测试方法必须以 test 开头，不然 Android Instrumented Unit test 无法识别
    @LargeTest
    public void testperClick() {
        EventBusActivity eventBusActivity;
        final Button button;
        final TextView textView;
        eventBusActivity = getActivity();
        button = (Button) eventBusActivity.findViewById(R.id.but_eventbus);
        textView = (TextView) eventBusActivity.findViewById(R.id.tv_show);
        button.setOnClickListener(eventBusActivity);
        eventBusActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                button.setText("wo shi");
                for (int i = 0; i < 150; i++) {
                    button.requestFocus();
                    button.performClick();
                }
                textView.setText("finished");
            }
        });
//        eventBusActivity.ru
//        eventBusActivity.finish();
//        setActivity(null);
//        int kol = eventBusActivity.num
//        assertEquals(150, eventBusActivity.numberPrss);
        // assert
        assertNotNull(button);
        assertEquals("i,m title150i'm content150", textView.getText().toString());
    }

    @Override
    protected void tearDown() throws Exception {
        eventBusActivity.finish();
        super.tearDown();

    }

    /*
     * 活动功能测试 测试点击和最终效果
     */
    public void testActivity() throws Exception {
        Log.v("testActivity", "test the Activity");
        for (int i = 0; i < 150; i++) {
            getInstrumentation().runOnMainSync(new PerformClick(button));
        }
        assertNotNull(button);
        assertEquals("i,m title150i'm content150", textView.getText().toString());
    }

    /*
     * 模拟按钮点击的接口
     */
    private class PerformClick implements Runnable {
        Button btn;

        public PerformClick(Button button) {
            btn = button;
        }

        public void run() {
            btn.performClick();
        }
    }
}