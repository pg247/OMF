package omf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.reflect.Method;

import static omf.Element.loadAndClick;

public class validatePersonalLoanCalculator {
    String url = "https://www.oldmutualfinance.co.za)";
    private final By personalLoanViewButtonBy = By.cssSelector("[href='personal-loans']");
    private omfLandingPage omfLandingPage = new omfLandingPage();
    private omfPersonalLoanPage omfPersonalLoanPage = new omfPersonalLoanPage();
    private String strAmount = "";
    private String strTerm = "";
    private final String strMinimumDeductionAmount = "R1,463.04";
    private final String strMaximumDeductionAmount = "R1,642.59";
    private final String strViewBreakDownCapital = "Capital";
    private final String strViewBreakDownTerm = "Term";

    @BeforeMethod
    public void setup(Method method) {
        System.out.println("START TEST: " + method.getName());
    }

    @AfterMethod
    public void postResults(ITestResult result) throws Exception {
        System.out.println("END TEST: " + result.getMethod().getMethodName());
    }

    @Test
    public void verifyCalculation()  {
        strAmount="50";
        String strFullAmount = "R" +strAmount+",000.00";
        strTerm="84";
        String strFullTerm = strTerm + "months";

        omfLandingPage = omfLandingPage.navigateToPage(url);
        loadAndClick((WebElement) personalLoanViewButtonBy);
        omfPersonalLoanPage.selectLoanAmount(strAmount);
        omfPersonalLoanPage.selectLoanTerm(strTerm);
        omfPersonalLoanPage.verifySafely(strMinimumDeductionAmount, omfPersonalLoanPage.getMinimumDeduction()," The Minimum Deduction Amount matched: ");
        omfPersonalLoanPage.verifySafely(strMaximumDeductionAmount, omfPersonalLoanPage.getMaximumDeduction()," The Maximum Deduction Amount matched: ");
        omfPersonalLoanPage.verifySafely(strFullAmount,omfPersonalLoanPage.getBreakdown(strViewBreakDownCapital)," The View Breakdown Amount text is matched: ");
        omfPersonalLoanPage.verifySafely(strFullTerm,omfPersonalLoanPage.getBreakdown(strViewBreakDownTerm)," The View Breakdown Term text is matched: ");
    }
}
