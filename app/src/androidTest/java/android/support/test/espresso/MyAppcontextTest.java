package android.support.test.espresso;

import android.test.ApplicationTestCase;

import com.czt.saisam.unittest.Base.MyAppcontext;

/**
 * Created by weichyang on 2017/1/3.
 * 构造函数初始化步骤
 */
public class MyAppcontextTest extends ApplicationTestCase<MyAppcontext> {

    public MyAppcontextTest() {
        super(MyAppcontext.class);
    }


}