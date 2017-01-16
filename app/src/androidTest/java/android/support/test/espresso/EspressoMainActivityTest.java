package android.support.test.espresso;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.czt.saisam.unittest.Base.MyAppcontext;
import com.czt.saisam.unittest.EspressoMainActivity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by weichyang on 2016/12/28.
 * 1.如果一个类使用另一个类的资源，可以使用测试套件来设置，log的打印可以使用Log 或则 System.out.print()
 * 2.几个注解的使用
 * 3.application单元测试的用法
 */

@RunWith(AndroidJUnit4.class)
public class EspressoMainActivityTest {

    @Rule
    public ActivityTestRule<EspressoMainActivity> activityRule = new ActivityTestRule<>(
            EspressoMainActivity.class);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("---BeforeClass---");
    }

    @AfterClass
    public static void afterClass() {

        System.out.println("---AfterClass---");
    }

    @Before
    public void printMyAppcontext() {
        Log.d("printMyAppcontext", MyAppcontext.getInstance() != null ? MyAppcontext.getInstance().toString() : "null Exception");
    }

    @Test
    public void greet() {
        onView(withId(com.czt.saisam.unittest.R.id.greeting))
                .check(matches(withText("")));
        onView(withId(com.czt.saisam.unittest.R.id.greet_button))
                .check(matches(withText(com.czt.saisam.unittest.R.string.greet)))
                .perform(click());

        onView(withId(com.czt.saisam.unittest.R.id.greeting));

    }
}