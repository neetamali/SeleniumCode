package testBase;

import java.io.File;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.Logger;

public class MyLogger {
	private static  Logger logger = (Logger)LogManager.getLogger();
			
	
	public static synchronized void startTestCase(String sTestCaseName) 
	{
	sTestCaseName = sTestCaseName.replaceAll("[^a-zA-Z0-9]", "_").replaceAll("_+", "_");
	startLog(System.getProperty("user.dir"),sTestCaseName);
	info("\n\n**********************Execution started : "+sTestCaseName+"*************\n");
	
	
	}
public static void endTestCase(String sTestCaseName) {
	
}

private static void startLog(String dirpath, String testcasename) {
int noOfFiles = 0;

File dir = new File(dirpath);
if(dir.exists()) {
	int count = 0;
	for(File file : dir.listFiles()) {
		if(file.isFile()&&file.getName().endsWith(".log")&&file.getName().contains(testcasename)) {
			count++;
			
		}
	}
	noOfFiles = count;
}
	noOfFiles++;
	String logFileName = testcasename+"_"+noOfFiles;
	
	ThreadContext.put("logFileName", logFileName);
}

public static Logger getCurrentLog() {
	return logger;
	
}
public static String getcallInfo() {
	String callInfo;
	String classname = Thread.currentThread().getStackTrace()[3].getClassName();
	String methodname = Thread.currentThread().getStackTrace()[3].getMethodName();
	int linenumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
	
	callInfo = classname+":"+methodname+":"+linenumber;
	return callInfo;

}
public static void trace(Object message) {
	getCurrentLog().trace(message);
	//trace(getcallInfo()+message);
}
public static void trace(Object message, Throwable t) {
	getCurrentLog().trace(getcallInfo()+message, t);
}
public static void debug(Object message) {
	getCurrentLog().debug(getcallInfo()+message);
	//debug(getcallInfo()+message);
}
public static void debug(Object message, Throwable t) {
	getCurrentLog().debug(getcallInfo()+message, t);
	//debug(getcallInfo()+message, t);
}
public static void error(Object message) {
	getCurrentLog().error(getcallInfo()+message);
	//error(getcallInfo()+message);
}
public static void error(Object message, Throwable t) {
	getCurrentLog().error(getcallInfo()+message, t);
	//error(getcallInfo()+message,t);
}
public static void fatal(Object message) {
	getCurrentLog().fatal(getcallInfo()+message);
	//fatal(getcallInfo()+message);
}
public static void fatal(Object message, Throwable t) {
	getCurrentLog().fatal(getcallInfo()+message, t);
	//fatal(getcallInfo()+message,t);
}
public static void info(Object message) {
	getCurrentLog().info(getcallInfo()+message);
	//info(getcallInfo()+message);
}
public static void info(Object message, Throwable t) {
	getCurrentLog().info(getcallInfo()+message, t);
	//info(getcallInfo()+message,t);
}
public static void warn(Object message) {
	getCurrentLog().warn(getcallInfo()+message);
	//warn(getcallInfo()+message);
}
public static void warn(Object message, Throwable t) {
	getCurrentLog().warn(getcallInfo()+message, t);
	//warn(getcallInfo()+message,t);
}
}
