package omf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static omf.Element.loadAndGetText;

import static omf.Element.loadAndClick;

public class omfPersonalLoanPage {
    private String strLoanReplaceableAmount = ".onlineCalculator .repCalc{0}k";
    private String strLoanReplaceableTerm = ".onlineCalculator .repCalc{0}m";
    private final By minDeductionAmountBy = By.cssSelector("#calcTotalsRes #paymin");   //View Minimum Deduction  Amount
    private final By maxDeductionAmountBy = By.cssSelector("#calcTotalsRes #paymax");       //View Maximum Deduction  Amount
    private String strViewCommonBreakDown = "#breakdown{0}";    //String for Common Breakdown, replaced on the fly



    public void selectLoanAmount(String strAmount)
    {
        By loanAmountBy = By.cssSelector(strLoanReplaceableAmount.replace("{0}",strAmount));
        loadAndClick((WebElement) loanAmountBy);
    }
    public void selectLoanTerm(String strTerm)
    {
        By loanTermBy = By.cssSelector(strLoanReplaceableTerm.replace("{0}",strTerm));
        loadAndClick((WebElement) loanTermBy);
    }
    public String getMinimumDeduction()
    {
        return loadAndGetText((WebElement) minDeductionAmountBy);
    }

    public String getMaximumDeduction()
    {
        return loadAndGetText((WebElement) maxDeductionAmountBy);
    }


    public String getBreakdown(String strComponent)
    {
        By viewCommonBreakDownBy = By.cssSelector(strViewCommonBreakDown.replace("{0}",strComponent ));
        return loadAndGetText((WebElement) viewCommonBreakDownBy);
    }
    protected void verifySafely(Object actualValue, Object expectedValue, String description) {
                if (actualValue.getClass().equals(String.class)) {
                    actualValue = ((String) actualValue).trim(); // trim whitespace for Edge strings
                }
                Assert.assertEquals(actualValue, expectedValue, description);
            }

}
