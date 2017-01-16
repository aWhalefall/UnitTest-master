package com.czt.saisam.unittest.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by weichyang on 2016/12/27.
 */
public class DataUtilsTest {

    @Test
    public void isSameDayOfMillis() throws Exception {
        Assert.assertEquals(true, DataUtils.isSameDayOfMillis(1010000, 1000000));
    }

}