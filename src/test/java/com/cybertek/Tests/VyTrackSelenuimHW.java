package com.cybertek.Tests;

import com.cybertek.Pages.CalendarEventsPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.Pages.TestBase;
import com.cybertek.Utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class VyTrackSelenuimHW extends TestBase {

    @Test
    public void test1(){

        extentLogger = report.createTest("Options is displayed");

        extentLogger.info("Login as a Store Manager");

        extentLogger.info("Navigate to --> Activities > Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']")).isDisplayed();

        Assert.assertTrue(calendarEventsPage.OptionsBtn.isDisplayed());

        extentLogger.info("Verify \"Options\" is displayed");

        extentLogger.pass("Passed");
    }
    @Test
    public void test2(){

        extentLogger = report.createTest("Verify that page number");

        extentLogger.info("Login as a Store Manager");

        extentLogger.info("Navigate to --> Activities > Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value").equals("1"));

        extentLogger.info("Verify that page number is equals to \"1\"");

        extentLogger.pass("Passed");
    }
    @Test
    public void test3() throws InterruptedException {

        extentLogger = report.createTest("Verify that view per page number");

        extentLogger.info("Login as a Store Manager");

        extentLogger.info("Navigate to --> Activities > Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Thread.sleep(2000);

        String actualNum=driver.findElement(By.xpath("(//button[@data-toggle='dropdown'])[1]")).getText();

        Assert.assertEquals(actualNum,"25");

        extentLogger.info("Verify that view per page number is equals to 25");

        extentLogger.pass("Passed");
    }
    @Test
    public void test4() throws InterruptedException {

        extentLogger = report.createTest("Verify that number of calendar events ");

        extentLogger.info("Login as a Store Manager");

        extentLogger.info("Navigate to --> Activities > Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        Thread.sleep(2000);

        calendarEventsPage.perPageBtn.click();

        calendarEventsPage.Btn100.click();
        extentLogger.info("View per page 100 rows");

        Thread.sleep(3000);

        extentLogger.info("Calculate the number of records in one page and add to the total number of records");

        int count = 0;

        String str = driver.findElement(By.xpath("(//label[@class='dib'])[2]")).getText();

        int num = Integer.parseInt(str.substring(3, 5));

        for (int i = 0; i < num; i++) {
            Thread.sleep(3000);

            List<WebElement> tableRow = driver.findElements(By.cssSelector("tbody>tr"));

            count = count + tableRow.size();

            calendarEventsPage.nextBtn.click();
        }

        String strCounter = Integer.toString(count);

        extentLogger.info("Verify that the number of calendar events equals to number of records");

        Assert.assertEquals(driver.findElement(By.xpath("(//label[@class='dib'])[3]")).getText(),"Total Of "+strCounter+" Records");

        extentLogger.pass("Test passed");

    }
    @Test
    public void test5() throws InterruptedException {

        extentLogger = report.createTest("Calendar events were selected");

        extentLogger.info("Login as a Store Manager");

        extentLogger.info("Navigate to --> Activities > Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        Thread.sleep(2000);

        calendarEventsPage.perPageBtn.click();

        calendarEventsPage.Btn100.click();
        extentLogger.info("View per page 100 rows");

        calendarEventsPage.checkBoxBtn.click();
        extentLogger.info("click checkbox button to select all events");

        String str = driver.findElement(By.xpath("(//label[@class='dib'])[2]")).getText();

        int num = Integer.parseInt(str.substring(3, 5));

        for (int i = 0; i < num; i++) {
            Thread.sleep(2000);

            List<WebElement> tableRow = driver.findElements(By.cssSelector("tbody>tr"));

            for(int j=1;j<=tableRow.size();j++ ){

                Assert.assertTrue(driver.findElement(By.xpath("(//tbody/tr/td/input)[" + j + "]")).isSelected());
            }
            calendarEventsPage.nextBtn.click();
        }
        extentLogger.info("Verify that all calendar events were selected");
        extentLogger.pass("Passed");
    }
    @Test
    public void test6() throws InterruptedException {
        extentLogger = report.createTest("Verify given data");
        extentLogger.info("Login as a Store Manager");
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.testerBtn.click();

        Thread.sleep(1000);

        String [][] data = {
                {"Title","Testers meeting"},
                {"Description","This is a a weekly testers meeting"},
                {"Start","Nov 27, 2019, 9:30"},
                {"End","Nov 27, 2019, 10:30"},
                {"All-Day Event","No"},
                {"Organizer","Stephan Haley"},
                {"Guests","Tom Smith"},
                {"Recurrence","Weekly every 1 week on Wednesday"},
                {"Call Via Hangout","No"}
        };
        for (int i = 1; i <= data.length ; i++) {
           Assert.assertEquals(driver.findElement(By.xpath("(//label[@class='control-label'])["+i+"]")).getText(),data[i-1][0]);
           Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='controls']/div)["+i+"]")).getText().contains(data[i-1][1]));
        }
        extentLogger.info("Verify the given data is displayed:");
        extentLogger.pass("Passed");

    }

    @Ignore
    @Test //zuhal solution
    public void test6_3() throws InterruptedException {
        extentLogger = report.createTest("Veriy that the table data is displayed:");
        Thread.sleep(3000);
        extentLogger.info("Click on the Testers Meeting");
        driver.findElement(By.xpath("//td[.='Testers meeting']")).click();
        Thread.sleep(3000);
        String[] tableData ={
                "Title Testers meeting",
                "Description This is a a weekly testers meeting",
                "Start Nov 27, 2019, 9:30 PM",
                "End Nov 27, 2019, 10:30 PM",
                "All-Day Event No",
                "Organizer Stephan Haley",
                "Guests Tom Smith - Required",
                "Recurrence Weekly every 1 week on Wednesday",
                "Call Via Hangout No"
        };
        for (int i = 1; i <= tableData.length; i++) {
            String key = driver.findElement(By.xpath("(//label[@class='control-label'])[" + i + "]")).getText();
            String value = driver.findElement(By.xpath("(//div[@class='controls']/div)[" + i + "]")).getText();
            extentLogger.info("Verifying if each of the data in the table is equal to the data we get from the website");
            Assert.assertEquals(key + " " + value, tableData[i-1]);
        }
        extentLogger.pass("Test passed");
    }
}
