package com.czt.saisam.unittest.util.junit4;

import com.czt.saisam.unittest.util.AsyncTask;

import junit.framework.Assert;

import org.junit.Test;

/**
 * by weichayang
 */

public class AsyncTaskJunit4TestCase {

    @Test(timeout = 500)
    public void sync_getOnlineConfig() {
        Assert.assertEquals("value1", new AsyncTask().sync_getOnlineConfig("key1"));
    }


}
