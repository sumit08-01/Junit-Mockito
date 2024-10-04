package com.luv2code.springmvc.controller;

import java.util.StringTokenizer;

public class StringToken {

    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("This@is@sumit", "@",true);
        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.countTokens());
        }
    }
}
