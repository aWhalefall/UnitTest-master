package com.czt.saisam.unittest.android;

import android.test.ActivityInstrumentationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.KeyEvent;
import android.widget.Button;

import com.czt.saisam.unittest.MainActivity;
import com.czt.saisam.unittest.R;

/**
 * 测试单独一个Activity
 * ActivityInstrumentationTestCase2
 */

public class InstrumentationTestCase extends ActivityInstrumentationTestCase<MainActivity> {
    private Button mLeftButton;
    private Button mCenterButton;
    private Button mRightButton;
    private MainActivity a;

//      使用自动生成构造方法回导致异常
    //Exception Class com.czt.saisam.unittest.android.Focus2ActivityTest has no public constructor TestCase(String name) or TestCase() 没有重写
//    public Focus2ActivityTest(Class<MainActivity> activityClass) {
//        super("com.czt.saisam.unittest.MainActivity", activityClass);
//    }

    public InstrumentationTestCase() {
        super("com.czt.saisam.unittest.MainActivity", MainActivity.class);
    }

    @Override
    protected void tearDown() throws Exception {
        a.finish();
        super.tearDown();

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        a = getActivity();
        mLeftButton = (Button) a.findViewById(R.id.leftButton);
        mCenterButton = (Button) a.findViewById(R.id.centerButton);
        mRightButton = (Button) a.findViewById(R.id.rightButton);
    }

    @SmallTest
    public void testPreconditions() {
        assertFalse("center button should be right of left button", mLeftButton.getRight() > mCenterButton.getLeft());
        assertFalse("right button should be right of center button", mCenterButton.getRight() < mRightButton.getLeft());
        assertFalse("left button should be focused", mLeftButton.isFocused());
    }

    @MediumTest
    public void testGoingRightFromLeftButtonJumpsOverCenterToRight() {
        sendKeys(KeyEvent.KEYCODE_DPAD_RIGHT);
        assertTrue("right button should be focused", mRightButton.isFocused());
    }

    @MediumTest
    public void testGoingLeftFromRightButtonGoesToCenter() {
        getActivity().runOnUiThread(
                new Runnable() {
                    public void run() {
                        mRightButton.requestFocus();
                    }
                }
        );
        getInstrumentation().waitForIdleSync();
        assertTrue(mRightButton.isFocused());
        sendKeys(KeyEvent.KEYCODE_DPAD_LEFT);
        assertTrue("center button should be focused", mCenterButton.isFocused());
    }
}