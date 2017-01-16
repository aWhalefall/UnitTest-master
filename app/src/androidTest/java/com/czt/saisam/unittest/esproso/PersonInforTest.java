package com.czt.saisam.unittest.esproso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.czt.saisam.unittest.MainActivity;
import com.czt.saisam.unittest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


//设置测试运行环境
@RunWith(AndroidJUnit4.class)
public class PersonInforTest {

    private static final String TAG = PersonInforTest.class.getName();
    //设置启动的Activity
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    //模拟用户的点击行为
    private void clicktest(final int id) {
        onView(withId(id)).perform(click());
    }

    //改变View的文本显示
    private String changetexttest(final int id, String text) {
        onView(withId(id)).perform(clearText(), typeText(text), closeSoftKeyboard());
        return text;
    }

    //检查View文本变化是否正确
    private void checktexttest(final int id, String text) {
        onView(withId(id)).check(matches(withText(text)));
    }

    //测试方法
    @Test
    public void NickNameTest() {
        clicktest(R.id.id_btn_day);
        clicktest(R.id.id_btn_night);
        clicktest(R.id.leftButton);
        final String text = changetexttest(R.id.id_btn_day, "test");
        checktexttest(R.id.id_btn_day, text);
    }

}