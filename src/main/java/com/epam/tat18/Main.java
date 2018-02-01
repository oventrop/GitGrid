package com.epam.tat18;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Main {

	public static void main(String[] args) {

		TestNG testng = new TestNG();
		List<String> suitesList = new ArrayList<String>();
		suitesList.add("testng.xml");
		testng.setTestSuites(suitesList);
		testng.run();
	}

}
