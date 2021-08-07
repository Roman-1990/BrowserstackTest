package cloud.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/app.properties"
})
public interface BrowserApp extends Config {
    @Key("mobilePlatform")
    String mobilePlatform();

    @Key("androidDevice")
    String androidDevice();

    @Key("androidVersion")
    String androidVersion();

    @Key("webUrl")
    String webUrl();


    @Key("apiUrl")
    String apiUrl();

    @Key("androidAppUrl")
    String androidAppUrl();

    @Key("userLogin")
    String userLogin();

    @Key("userKey")
    String userKey();
}
