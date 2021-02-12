package omf;


import java.util.ArrayList;

public class Driver {

    public static final int TIMEOUT_20_SEC = 20;
    public static final int TIMEOUT_60_SEC = 60;


    private String lastVisitedUrl = "";

    public Driver() {
    }

    /**
     * Navigates to the specified URL directly, as though typed into the address bar.
     *
     * @param url
     *            URL to navigate to. Defaults to value specified in configuration value automation.url
     */
    public Driver open(String url) {
                 DriverManager.getCurrent().get(url);
    }

    /**
     * Close the browser.
     */
    public void close() {
        DriverManager.getCurrent().close();
    }
}
