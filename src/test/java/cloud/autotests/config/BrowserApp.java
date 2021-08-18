package cloud.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/app.properties"
})
public interface BrowserApp extends Config {

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

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
