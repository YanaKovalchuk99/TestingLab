package pages;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class SuiteTest {
    @RunWith(Categories.class)
    @Categories.IncludeCategory(SmokeTest.class)
    @Suite.SuiteClasses( { CatalogPageTest.class, LoginPageTest.class, MainPageTest.class })
    public class SmokeTestSuite {}
}
