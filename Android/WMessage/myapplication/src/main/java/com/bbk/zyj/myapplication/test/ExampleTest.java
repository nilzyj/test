package com.bbk.zyj.myapplication.test;

import android.test.InstrumentationTestCase;

/**
 * Created by Administrator on 2016/7/22.
 */
public class ExampleTest extends InstrumentationTestCase {
    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }
}
