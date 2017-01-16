package com.czt.saisam.unittest.android;

/**
 * Created by Tom on 2016/12/14.
 */

public class VersionCompareUtil {

    /**
     * 版本号对比  按照  原理：十分割，十进制对比
     *
     * @param oldVersion
     * @param newVersion
     * @return oldVersion > newVersion  return -1
     * oldVersion = newVersion  return 0
     * oldVersion < newVersion  return 1
     */
    public static int compareVersions(String oldVersion, String newVersion) {
        int result = 0;
        String[] oldVs = oldVersion.split("\\.");
        String[] newVs = newVersion.split("\\.");
        int oldLen = oldVs.length;
        int newLen = newVs.length;
        int len = oldLen > newLen ? oldLen : newLen;
        for (int i = 0; i < len; i++) {
            if (i < oldLen && i < newLen) {
                int o = Integer.parseInt(oldVs[i]);
                int n = Integer.parseInt(newVs[i]);
                if (o > n) {
                    result = -1;
                    break;
                } else if (o < n) {
                    result = 1;
                    break;
                }
            } else {  //
                if (oldLen > newLen) {
                    for (int j = i; j < oldLen; j++) {
                        if (Integer.parseInt(oldVs[j]) > 0) {
                            result = -1;
                        }
                    }
                    break;
                } else if (oldLen < newLen) {
                    for (int j = i; j < newLen; j++) {
                        if (Integer.parseInt(newVs[j]) > 0) {
                            result = 1;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
}
