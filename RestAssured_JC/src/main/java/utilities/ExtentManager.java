package utilities;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    public static ExtentHtmlReporter createExtentHtmlReporter(String filePath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
        // Optionally, you can customize the HTML report settings here
        return htmlReporter;
    }
}
