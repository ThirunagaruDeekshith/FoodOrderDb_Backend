package com.spring_course.FoorOrderApp.Configurations;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Id_genarator {
    public String geneate_id(int length){
        int leftLimit=48;
        int rightLimit=90;
        Random random=new Random();
        String generatedString =random.ints(leftLimit,rightLimit+1)
                .filter(i->(i<=57||i>=65) && (i<=90||i>=97))
                .limit(length)
                .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append)
                .toString();
        return generatedString;
    }
}

