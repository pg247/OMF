package omf;


public class omfLandingPage {
    /**
     * Method to navigate to Page
     * @returns - Returns the current object instance
     */
    public omfLandingPage navigateToPage(String url) {
        new Driver().open(url);
        return this;
    }


}

