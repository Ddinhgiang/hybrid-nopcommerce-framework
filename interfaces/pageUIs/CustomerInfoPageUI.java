package pageUIs;

<<<<<<< Updated upstream:interfaces/pageUIs/CustomerInfoPageUI.java
public class CustomerInfoPageUI extends SidebarPageUI{
    public static final String GENDER_MALE_RADIO = "//input[@id='gender-male']";
    public static final String FIRST_NAME_TEXTBOX= "//input[@id='FirstName']";
    public static final String LAST_NAME_TEXTBOX= "//input[@id='LastName']";
=======
public class UserCustomerInfoPageUI extends UserSidebarPageUI {
    public static final String GENDER_MALE_RADIO = "xpath=//input[@id='gender-male']";
    public static final String FIRST_NAME_TEXTBOX= "xpath=//input[@id='FirstName']";
    public static final String LAST_NAME_TEXTBOX= "xpath=//input[@id='LastName']";
>>>>>>> Stashed changes:interfaces/pageUIs/user/UserCustomerInfoPageUI.java
//    public static final String DAY_DROPDOWN="";
//    public static final String MONTH_DROPDOWN="";
//    public static final String YEAR_DROPDOWN="";
    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";
    public static final String COMPANY_TEXTBOX = "xpath=//input[@id='Company']";
}
