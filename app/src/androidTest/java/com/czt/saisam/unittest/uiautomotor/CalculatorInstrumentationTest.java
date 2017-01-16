package com.czt.saisam.unittest.uiautomotor;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.czt.saisam.unittest.MainActivity;
import com.czt.saisam.unittest.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@Deprecated
@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentationTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public CalculatorInstrumentationTest() {
        super("com.czt.saisam.unittest.MainActivity", MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        // Injecting the Instrumentation instance is required
        // for your test to run with AndroidJUnitRunner.
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    @Test
    public void typeOperandsAndPerformAddOperation() {
        // Call the CalculatorActivity add() method and pass in some operand values, then
        // check that the expected value is returned.
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void greeterSaysHello() {
        onView(withId(R.id.name_field)).perform(typeText("Steve"));

        onView(withId(R.id.id_btn_fun)) .perform(click());

        onView(withText("Hello Steve!")).check(matches(isDisplayed()));

    }
}