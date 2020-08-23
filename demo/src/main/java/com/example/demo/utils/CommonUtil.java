package com.example.demo.utils;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;

public class CommonUtil {

    public static int getRandom(){
        Random r = new Random(1);

        return r.nextInt();
    }

    public static void main(String[] args) {
        System.out.println(getRandom());
    }
}
