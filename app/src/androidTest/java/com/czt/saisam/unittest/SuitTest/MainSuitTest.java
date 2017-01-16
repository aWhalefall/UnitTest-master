package com.czt.saisam.unittest.SuitTest;

import android.support.test.espresso.EspressoMainActivityTest;
import android.support.test.espresso.MyAppcontextTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by weichyang on 2017/1/3.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({MyAppcontextTest.class, EspressoMainActivityTest.class})
public class MainSuitTest {


}
