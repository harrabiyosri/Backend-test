package com.enexse.testjava.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class MyGenerator implements IdentifierGenerator {

    private static char rndChar () {
        int rnd = (int) (Math.random() * 52); // or use Random or whatever
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);

    }

    public static final String generatorName = "myGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        String id = "";
        char ch1 = rndChar();
        id+=ch1;
        char ch2 = rndChar();
        id+=ch2;
        Random rand = new Random(); //instance of random class
        int upperbound = 10;



        Integer int1 = rand.nextInt(upperbound);
        String ch3 = int1.toString();
        id+=ch3;
        Integer int2 = rand.nextInt(upperbound);
        String ch4 = int2.toString();
        id+=ch4;
        Integer int3 = rand.nextInt(upperbound);
        String ch5 = int3.toString();
        id+=ch5;
        Integer int4 = rand.nextInt(upperbound);
        String ch6 = int4.toString();
        id+=ch6;
        Integer int5 = rand.nextInt(upperbound);
        String ch7 = int5.toString();
        id+=ch7;
        return id;
    }
}
