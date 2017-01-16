package com.czt.saisam.unittest.android;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.widget.Spinner;

import com.czt.saisam.unittest.MainActivity;
import com.czt.saisam.unittest.R;

/**
 * Created by weichyang on 2016/12/27.
 * 1.一种是直接用泛型类型制定测试Activity
 * 2.使用Intent进行跳转 来指定具体
 * 3.构造函数的复写，不能使用系统生成，需要使用其他类型，why？
 * 4.运行一个测试序列
 */

public class SpinneInstrumentTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity; // MyActivity is the class name of the app under test
    private Spinner mSpinner;
    private Instrumentation mInstrumentation;

    public SpinneInstrumentTest() {
        super("com.czt.saisam.unittest.MainActivity", MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity(); // get a references to the app under test
        mInstrumentation = getInstrumentation();
      /*
       * Get a reference to the main widget of the app under test, a Spinner
       */
        mSpinner = (Spinner) mActivity.findViewById(R.id.Spinner01);
    }

    @SmallTest //必须调用 在ui线程中操作的方法
    public void testTest() {
      /*
       * request focus for the Spinner, so that the test can send key events to it
       * This request must be run on the UI thread. To do this, use the runOnUiThread method
       * and pass it a Runnable that contains a call to requestFocus on the Spinner.
       */
        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                mSpinner.requestFocus();
            }
        });
        mInstrumentation.waitForIdleSync();
        this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);  //测试一个击键序列
    }



    @Override
    protected void tearDown() throws Exception {
        mActivity.finish();
        super.tearDown();
    }
}
