package com.demo.test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.app.CounterDemo;



@TestInstance(Lifecycle.PER_CLASS)
public class CounterTest {

   CounterDemo c=null;

   CounterDemo counterDemo = new CounterDemo();

   

   @Test
    public void shouldReturn_a_value_2() {
        counterDemo.increment();
        counterDemo.increment();
        Assertions.assertEquals(2, counterDemo.getCount());//assertions are static



   }
    
    @Test
    public void shouldReturn_a_value_minus2() {
        counterDemo.decrement();
        counterDemo.decrement();
        Assertions.assertEquals(-2, counterDemo.getCount());



   }
}