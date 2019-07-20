package com.otus.webpages;

import com.otus.testdata.Contact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class UserProfilePage extends BasePage {
    public UserProfilePage(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = LogManager.getLogger(UserProfilePage.class);

    private By firstName = By.cssSelector("input#id_fname");
    private By firstNameLatin = By.cssSelector("input#id_fname_latin");
    private By lastName = By.cssSelector("input#id_lname");
    private By lastNameLatin = By.cssSelector("input#id_lname_latin");
    private By blogName = By.cssSelector("input#id_blog_name");
    private By birthDate = By.cssSelector("input[name='date_of_birth']");
    private By countryDropdown = By.xpath("//p[contains(text(), 'Страна')]/../following-sibling::div/div");
    private By countries = By.cssSelector("div.lk-cv-block__select-scroll_country button");
    private By cityDropdown = By.xpath("//p[contains(text(), 'Город')]/../following-sibling::div/div");
    private By cities = By.cssSelector("div.lk-cv-block__select-scroll_city button");
    private By readyForRelocationOptions = By.cssSelector("label.radio");
    private By schedule = By.xpath("//p[text()='Формат работы']/../following-sibling::div//label");
    private By emptyContactDropdown = By.xpath("//span[text()='Способ связи']/..");
    private By contacts = By.xpath("//span[text()='Способ связи' and @class='placeholder']/ancestor::div[@data-num and not(contains(@class,'hide'))]");
    private By deleteContact = By.xpath("//div[not(contains(@class, 'hide'))]/div[contains(@class, 'container__col_md-') and not(contains(@class, 'container__col_ssm-'))]/div/button[text()='Удалить']");
    private By addNewContactButton = By.xpath("//button[text()='Добавить']");
    private By genderDropdown = By.cssSelector("select#id_gender");
    private By genders = By.cssSelector("select#id_gender option");
    private By company = By.cssSelector("input#id_company");
    private By position = By.cssSelector("input#id_work");
    private By saveChangesButton = By.cssSelector("button[title='Сохранить и продолжить']");

    public UserProfilePage setFirstName(String name){
        setInputFieldValue(firstName, name);
        LOGGER.debug("First name value set: {}", name);
        return this;
    }

    public String getFirstName(){
        String result = getAttributeValue(firstName, "value");
        LOGGER.debug("First name value get: {}", result);
        return result;
    }

    public UserProfilePage setFirstNameLatin(String name){
        setInputFieldValue(firstNameLatin, name);
        LOGGER.debug("First name latin value set: {}", name);
        return this;
    }

    public String getFirstNameLatin(){
        String result = getAttributeValue(firstNameLatin, "value");
        LOGGER.debug("First name latin value get: {}", result);
        return result;
    }

    public UserProfilePage setLastName(String name){
        setInputFieldValue(lastName, name);
        LOGGER.debug("Last name value set: {}", name);
        return this;
    }

    public String getLastName(){
        String result = getAttributeValue(lastName, "value");
        LOGGER.debug("Last name value get: {}", result);
        return result;
    }

    public UserProfilePage setLastNameLatin(String name){
        setInputFieldValue(lastNameLatin, name);
        LOGGER.debug("Last name latin value set: {}", name);
        return this;
    }

    public String getLastNameLatin(){
        String result = getAttributeValue(lastNameLatin, "value");
        LOGGER.debug("Last name latin value get: {}", result);
        return result;
    }

    public UserProfilePage setBlogName(String name){
        setInputFieldValue(blogName, name);
        LOGGER.debug("Blog name value set: {}", name);
        return this;
    }

    public String getBlogName(){
        String result = getAttributeValue(blogName, "value");
        LOGGER.debug("Blog name value get: {}", result);
        return result;
    }

    public UserProfilePage setBirthDate(String date){
        setInputFieldValue(birthDate, date);
        driver.findElement(birthDate).sendKeys(Keys.chord(Keys.ENTER));
        LOGGER.debug("Birth date value set: {}", date);
        return this;
    }

    public String getBirthDate(){
        String result = getAttributeValue(birthDate, "value");
        LOGGER.debug("Birth date value get: {}", result);
        return result;
    }

    public UserProfilePage setCountry(String country){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        setDropdownFieldValue(countryDropdown, countries, "title", country);
        wait.until(ExpectedConditions.stalenessOf(driver.findElements(cities).get(0)));
        return this;
    }

    public String getCountry(){
        WebElement country = driver.findElement(countryDropdown).findElement(By.cssSelector("div"));
        String result = getAttributeValue(country, "innerText");
        LOGGER.debug("Country value get: {}", result);
        return result;
    }

    public UserProfilePage setCity(String city){
        setDropdownFieldValue(cityDropdown, cities, "title", city);
        return this;
    }

    public String getCity(){
        WebElement city = driver.findElement(cityDropdown).findElement(By.cssSelector("div"));
        String result = getAttributeValue(city, "innerText");
        LOGGER.debug("City value get: {}", result);
        return result;
    }

    public UserProfilePage setIsRelocationReady(String readiness){
        for (WebElement e: driver.findElements(readyForRelocationOptions)){
            String radioLabel = e.findElement(By.cssSelector("span.radio__label")).getAttribute("textContent");
            if(radioLabel.equals(readiness)){
                e.click();
                break;
            }
        }
        return this;
    }

    public String getIsRelocationReady() {
        for (WebElement e : driver.findElements(readyForRelocationOptions)) {
            WebElement inputRadio = e.findElement(By.cssSelector("input[type='radio']"));
            if (inputRadio.getAttribute("checked") != null) {
                WebElement radioLabel = e.findElement(By.cssSelector("span.radio__label"));
                String result = getAttributeValue(radioLabel, "textContent");
                LOGGER.debug("Relocation value get: {}", result);
                return result;
            }
        }
        return "";
    }

    public UserProfilePage setWorkSchedule(ArrayList<String> arr){
        for (WebElement e: driver.findElements(schedule)){
            WebElement checkbox = e.findElement(By.cssSelector("input[type='checkbox']"));
            if(arr.contains(checkbox.getAttribute("title"))){
                if(checkbox.getAttribute("checked") == null){
                    e.click();
                }
            }
        }
        return this;
    }

    public ArrayList<String> getWorkSchedule(){
        ArrayList<String> arr = new ArrayList<>();
        for (WebElement e: driver.findElements(schedule)){
            WebElement checkbox = e.findElement(By.cssSelector("input[type='checkbox']"));
            if(checkbox.getAttribute("checked") != null){
                arr.add(e.findElement(By.cssSelector("span.checkbox__label")).getAttribute("innerText"));
            }
        }
        LOGGER.debug("Work schedule value get: {}", arr);
        return arr;
    }

    public UserProfilePage deleteAllContactFields(){
        while (driver.findElements(deleteContact).size() > 0){
            driver.findElements(deleteContact).get(0).click();
        }
        return this;
    }

    public UserProfilePage addContactField(){
        driver.findElement(addNewContactButton).click();
        return this;
    }

    public UserProfilePage setContact(String contactType, String contactValue){
        WebElement firstEmptyField = driver.findElements(contacts).get(0);
        setDropdownFieldValue(emptyContactDropdown, firstEmptyField, "title", contactType);
        driver.findElement(By.xpath(String.format("//div[text()='%s']/ancestor::div[2]/input", contactType))).sendKeys(contactValue);
        return this;
    }

    public Contact getContact(int contactNumberOnPage){
        WebElement contactRow = driver.findElements(By.cssSelector("div.container__col_middle.container__col_12")).get(contactNumberOnPage - 1);
        String contactType = contactRow.findElement(By.cssSelector("div.input")).getAttribute("innerText");
        String contactValue = contactRow.findElement(By.cssSelector("input[type='text']")).getAttribute("value");
        Contact result = new Contact(contactType, contactValue);
        LOGGER.debug("Contact value get: {}", result);
        return result;
    }

    public UserProfilePage setGender(String genderToSet){
        setDropdownFieldValue(genderDropdown, genders,"textContent", genderToSet);
        return this;
    }

    public String getGender(){
        WebElement genderSelected = driver.findElement(genderDropdown).findElement(By.cssSelector("option[selected]"));
        String result = getAttributeValue(genderSelected, "textContent");
        LOGGER.debug("Gender value get: {}", result);
        return result;
    }

    public UserProfilePage setCompany(String companyName){
        setInputFieldValue(company, companyName);
        return this;
    }

    public String getCompany(){
        String result = getAttributeValue(company, "value");
        LOGGER.debug("Company value get: {}", result);
        return result;
    }

    public UserProfilePage setPosition(String positionTitle){
        setInputFieldValue(position, positionTitle);
        return this;
    }

    public String getPosition(){
        String result = getAttributeValue(position, "value");
        LOGGER.debug("Position value get: {}", result);
        return result;
    }

    public void saveChanges(){
        driver.findElement(saveChangesButton).click();
    }

    private void setInputFieldValue(By inputField, String value){
        driver.findElement(inputField).clear();
        driver.findElement(inputField).sendKeys(value);
    }

    private String getAttributeValue(By locator, String attribute){
        return driver.findElement(locator).getAttribute(attribute);
    }

    private String getAttributeValue(WebElement we, String attribute){
        return we.getAttribute(attribute);
    }

    private void setDropdownFieldValue(By dropdownField, By dropdownItems, String attribute, String value){
        driver.findElements(dropdownField).get(0).click();
        for (WebElement e: driver.findElements(dropdownItems)){
            if(e.getAttribute(attribute).equals(value)){
                e.click();
                break;
            }
        }
    }

    private void setDropdownFieldValue(By dropdownField, WebElement dropdownItemsContainer, String attribute, String value){
        driver.findElements(dropdownField).get(0).click();
        for (WebElement e: dropdownItemsContainer.findElements(By.cssSelector("div.lk-cv-block__select-scroll button"))){
            if(e.getAttribute(attribute).equals(value)){
                e.click();
                break;
            }
        }
    }
}
