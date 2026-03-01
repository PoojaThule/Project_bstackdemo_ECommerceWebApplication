package com.bstackdemo.utilis;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	private static ExtentReports extent;

	public static ExtentReports getReportObj() {

		if (extent == null) {

			String timestamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
			String Reportpath = System.getProperty("user.dir") + "/reports/BstackDemo_ExtentReport" + timestamp + ".html";

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Reportpath);

			sparkReporter.config().setReportName("BstackDemo Automation Report"); // Report Name
			sparkReporter.config().setDocumentTitle("Test Execution Report"); // Web page title

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Tester", "Pooja Thule");
			extent.setSystemInfo("Operating System", "Window 11");
			extent.setSystemInfo("Project Name", "Bstackdemo ecommerce Application");
			extent.setSystemInfo("Domain", "E-commerce");

		}

		return extent;

	}
}
