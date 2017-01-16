package com.czt.saisam.unittest.util.junit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by weichyang on 2017/1/16.
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class order {

    @Test
    public void a() {
        System.out.print("RUN A \n");
    }


    @Test
    public void b() {
        System.out.print("RUN b \n");
    }


    @Test
    public void c() {
        System.out.print("RUN c \n");
    }


    @Test
    public void d() {
        System.out.print("RUN d \n");
    }


    @Test
    public void e() {
        System.out.print("RUN e \n");
    }
}
