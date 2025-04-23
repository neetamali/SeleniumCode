package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableComponents.PropertiesOperationClass;

public class ExtentReportNGClass {
	public static ExtentReports extent;
	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat dtformate = new SimpleDateFormat("dd-mm-yyy HH-mm-ss");
		Date date = new Date();
		String actualdt = dtformate.format(date);
		
		String reportPath = System.getProperty("user.dir")+"Reports/ExecutionReport_"+actualdt+".html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		extent = new  ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");
		
		extent.setSystemInfo("Executed on environment: ", PropertiesOperationClass.getPropertyValueKey("url"));
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperationClass.getPropertyValueKey("browser"));
		extent.setSystemInfo("Executed on Operating System: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
		
		
		return extent;
		
	}
}
