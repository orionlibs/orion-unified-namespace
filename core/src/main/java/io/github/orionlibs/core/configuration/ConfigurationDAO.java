package io.github.orionlibs.core.configuration;

import java.util.List;

public interface ConfigurationDAO
{
    long getNumberOfConfigurationProperties();


    boolean doesConfigurationKeyExist(String configurationKey);


    boolean doesConfigurationValueExist(String configurationValue);


    ConfigurationModel getConfigurationByKey(String configurationKey);


    String getConfigurationKeyByValue(String configurationValue);


    List<ConfigurationModel> getConfigurations();


    List<String> getConfigurationKeysByValue(String configurationValue);


    String getConfigurationValueByKey(String configurationKey);


    List<ConfigurationModel> getConfigurationsByType(String configurationType);


    int save(ConfigurationModel model);


    int save(String configurationKey, String configurationValue, String configurationType);


    int update(ConfigurationModel model);


    int update(String configurationKey, String configurationValue, String configurationType);


    int delete(String configurationKey);


    int delete(ConfigurationModel model);
}
