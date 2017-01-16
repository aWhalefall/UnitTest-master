package com.czt.saisam.unittest.uiautomotor;

import android.content.Context;
import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ChangeTextBehaviorTest {

    private static final String BASIC_SAMPLE_PACKAGE
            = "com.czt.saisam.unittest.MainActivity";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;


    //    @Ignore
//    public void startMainActivityFromHomeScreen() {
//        // Initialize UiDevice instance

//
//        // Start from the home screen
//        mDevice.pressHome();
//
//        // Wait for launcher
//        final String launcherPackage = mDevice.getLauncherPackageName();
//        assertThat(launcherPackage, notNullValue());
//        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
//                LAUNCH_TIMEOUT);
//
//        // Launch the app
//        Context context = InstrumentationRegistry.getContext();
//        final Intent intent = context.getPackageManager()
//                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
//        // Clear out any previous instances
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//
//        // Wait for the app to appear
//        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
//                LAUNCH_TIMEOUT);
//    }
//
//    @Test
//    public void testClickTinker() {
//        // Launch a simple calculator app
//        Context context = getInstrumentation().getContext();
//        Intent intent = context.getPackageManager()
//                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        // Clear out any previous instances
//        context.startActivity(intent);
//        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
//                LAUNCH_TIMEOUT);
//    }
//
    @BeforeClass
    public void testStart() {
        mDevice = UiDevice.getInstance(getInstrumentation());
        Context context = getInstrumentation().getContext();
        Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Clear out any previous instances
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
        Log.d("DDD", "DDDD");
    }

    private static final String CALC_PACKAGE = "com.myexample.calc";

    @Test
    public void testTwoPlusThreeEqualsFive() {
        // Enter an equation: 2 + 3 = ?
        try {
            mDevice.findObject(new UiSelector()
                    .packageName(CALC_PACKAGE).resourceId("two")).click();
            mDevice.findObject(new UiSelector()
                    .packageName(CALC_PACKAGE).resourceId("plus")).click();
            mDevice.findObject(new UiSelector()
                    .packageName(CALC_PACKAGE).resourceId("three")).click();
            mDevice.findObject(new UiSelector()
                    .packageName(CALC_PACKAGE).resourceId("equals")).click();

            // Verify the result = 5
            UiObject2 result = mDevice.findObject(By.res(CALC_PACKAGE, "result"));
            assertEquals("5", result.getText());
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

    }

}