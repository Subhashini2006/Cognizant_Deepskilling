package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAATest {

    private int num1;
    private int num2;

    @BeforeEach
    public void setUp() {
        num1 = 10;
        num2 = 20;
        System.out.println("Setup executed");
    }

    @Test
    public void testAddition() {


        int expected = 30;


        int actual = num1 + num2;

        assertEquals(expected, actual);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Teardown executed");
    }
}