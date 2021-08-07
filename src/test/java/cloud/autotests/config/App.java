package cloud.autotests.config;

import org.aeonbits.owner.ConfigFactory;

public class App {
    public static BrowserApp config = ConfigFactory.create(BrowserApp.class, System.getProperties());
}
