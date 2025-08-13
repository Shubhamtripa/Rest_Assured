package com.backend.testing;

public class A {
	/*
	 * public static void given() { System.out.println("Execute given mtd"); }
	 * 
	 * public static void when() { System.out.println("Execute when mtd"); } public
	 * static void then() { System.out.println("Execute then mtd"); }
	 */
	
	 public A a() { 
		 System.out.println("Execute a mtd");
		return new A(); 
		 }
	 public A b() { 
		 System.out.println("Execute b mtd");
		return new A(); 
		 }
	 public B c() { 
		 System.out.println("Execute c mtd");
		return new B(); 
		 }
}
