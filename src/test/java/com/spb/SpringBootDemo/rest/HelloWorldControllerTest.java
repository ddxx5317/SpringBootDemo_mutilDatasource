package com.spb.SpringBootDemo.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloWorldControllerTest {

	@Test
	public void testHello(){
		assertEquals("hello",new HelloWorldController().hello());
		
	}
}
