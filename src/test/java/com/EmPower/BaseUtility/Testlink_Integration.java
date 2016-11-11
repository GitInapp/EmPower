package com.EmPower.BaseUtility;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;


public class Testlink_Integration {
	
	public static String DEVKEY="617fb9c7ea6b45e12be1e8575360303d";

	public static String URL="http://localhost:8084/testlink-1.9.15/lib/api/xmlrpc/v1/xmlrpc.php";

	public static String PROJECTNAME = "Sample Project";

	public static String TESTPLANNAME = "Test Plan1";

	public static String BUILDNAME = "Build01";

	public static String TESTCASENAME = "Test Case3";


public static void reportTestCaseResult(String projectName,String testplanName,

String testcaseName, String buildName,String msg,String result) 

throws TestLinkAPIException {

    TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEVKEY,URL);

    testlinkAPIClient.reportTestCaseResult(projectName, testplanName,

        testcaseName, buildName, msg, result);

     }

}
