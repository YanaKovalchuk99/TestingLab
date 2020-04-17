import io.appium.java_client.android.AndroidDriver;
import org.junit.*;

import java.util.concurrent.TimeUnit;

public class AppTests {

    private static AndroidDriverManager driverManager;
    static AndroidDriver driver;
    private LoginLayout loginLayout;
    private RegistretionLayout registrationLayout;
    private ExpensesLayout expensesLayout;

    @BeforeClass
    public static void prepareTest(){
        driverManager = new AndroidDriverManager();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Before
    public void initPageObject(){
        driver.launchApp();
        loginLayout = new LoginLayout(driver);
        registrationLayout = new RegistretionLayout(driver);
        expensesLayout = new ExpensesLayout(driver);
    }

    @Test
    public void registrationTest(){
       registretionAll();
       Assert.assertEquals(".activities.LoginActivity",driver.currentActivity());
    }

    @Test
    public void loginTest(){
        registretionAll();
        loginLayout.enterEmailAndPassword("kovalyana@mail.ru","99999999");
        Assert.assertEquals(".activities.BudgetActivity",driver.currentActivity());
    }

    @Test
    public void expensesTest(){
        registretionAll();
        loginLayout.enterEmailAndPassword("kovalyana@mail.ru","99999999");
        expensesLayout.addExpenses();
        expensesLayout.addNewExpenses("Ticket","200","15/04/2020","Cinema");
        Assert.assertTrue(expensesLayout.expensesList("Ticket"));
    }

    @After
    public void tearDown(){
        driver.closeApp();
    }

    @AfterClass
    public static void tearDownDriver(){
        driverManager.quitDriver();

    }

    public void registretionAll(){
        registrationLayout.registerClick();
        registrationLayout.registrationNewAccount("kovalyana@mail.ru","Yana","99999999","99999999");
    }

}
