package com.cybertek.Pages;

import com.cybertek.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement OptionsBtn;

    @FindBy(xpath = "//div/button/input[@type='checkbox']")
    public WebElement checkBoxBtn;

    @FindBy(xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement perPageBtn;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement Btn100;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement nextBtn;

    @FindBy(xpath = "//td[text()='Testers meeting']")
    public WebElement testerBtn;


}
