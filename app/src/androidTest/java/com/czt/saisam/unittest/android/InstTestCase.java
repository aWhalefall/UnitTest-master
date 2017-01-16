package com.czt.saisam.unittest.android;

import android.content.Intent;
import android.os.SystemClock;
import android.test.InstrumentationTestCase;
import android.widget.Button;
import android.widget.TextView;

import com.czt.saisam.unittest.MainActivity;
import com.czt.saisam.unittest.R;

/**
 * 2016/12/26
 * 早期的还需要 test开头才能识别
 * junit 4  则可以使用注解
 */

public class InstTestCase extends InstrumentationTestCase {

    MainActivity mActivity = null;

    private Button button = null;

    private TextView text = null;

    @Override
    protected void tearDown() throws Exception {
        // TODO Auto-generated method stub  
        mActivity.finish();

        super.tearDown();
    }

    @Override
    protected void setUp() throws Exception {
        // TODO Auto-generated method stub  
        super.setUp();
        Intent intent = new Intent();

        intent.setClassName("com.czt.saisam.unittest", MainActivity.class.getName());

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        mActivity = (MainActivity) getInstrumentation().startActivitySync(intent);

        text = (TextView) mActivity.findViewById(R.id.text1);

        button = (Button) mActivity.findViewById(R.id.id_btn_fun);

    }  
  
    /* 
     *  
     * 活动功能测试 
     */

    public void testActivity() throws Exception {
        // 测试键壮性，连续运行某项功能100次，点击Button 100次  
        for (int i = 0; i < 100; ++i) {
            getInstrumentation().runOnMainSync(new PerformClick(button));
            SystemClock.sleep(10); // 中间间隔 0.5秒
        }
        assertEquals("SM-G9250G9250ZCU2DPJ2", text.getText().toString()); //检查运行后的输出结果
    }
    /*
     *  
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