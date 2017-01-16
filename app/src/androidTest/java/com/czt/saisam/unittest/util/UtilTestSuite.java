package com.czt.saisam.unittest.util;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author ywc
 * @since 2015-07-10 01:53
 */
public class UtilTestSuite extends TestSuite {

    public UtilTestSuite() {
        super();
        addTestSuite(MathUtilTestCase.class);
    }

    public Test suite() {

        addTestSuite(MathUtilTestCase.class);


        TestSetup wrapper = new TestSetup(this) {
            protected void setUp() {
                System.out.println("---Calling Global_setUp---");
            }

            protected void tearDown() {
                System.out.println("---Calling Global_tearDown---");
            }
        };
        return wrapper;
    }

}
