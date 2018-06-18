package com.spbstu.lab3.utilities;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources({"classpath:test.properties"})
public interface TestConfig extends Config {

    @Key("homepage.url")
    String homepage();

    @Key("webdriver.chrome.driver")
    String pathToDriver();
}
