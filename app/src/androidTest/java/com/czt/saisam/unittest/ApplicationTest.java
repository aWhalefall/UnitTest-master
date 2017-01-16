package com.czt.saisam.unittest;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //每个测试方法前面都会执行
    }

    @SmallTest
    public void testPreconditions() {
        //testPreconditions 测试主要用来运行其它测试方法之前来校验Application 对象的初始化情况，
    }

    /**
     * Test basic startup/shutdown of Application
     */
    @MediumTest
    public void testSimpleCreate() {
        createApplication(); //会触发Application 的onCreate 方法
    }


}

