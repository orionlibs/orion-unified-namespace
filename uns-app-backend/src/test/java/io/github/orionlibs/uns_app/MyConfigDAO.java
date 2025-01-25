package io.github.orionlibs.uns_app;

import io.github.orionlibs.core.configuration.ConfigurationDAO;
import io.github.orionlibs.core.configuration.ConfigurationModel;
import java.util.List;

public class MyConfigDAO implements ConfigurationDAO
{
    @Override public long getNumberOfConfigurationProperties()
    {
        return 0;
    }


    @Override public boolean doesConfigurationKeyExist(String configurationKey)
    {
        return false;
    }


    @Override public boolean doesConfigurationValueExist(String configurationValue)
    {
        return false;
    }


    @Override public ConfigurationModel getConfigurationByKey(String configurationKey)
    {
        return null;
    }


    @Override public String getConfigurationKeyByValue(String configurationValue)
    {
        return "";
    }


    @Override public List<ConfigurationModel> getConfigurations()
    {
        return List.of();
    }


    @Override public List<String> getConfigurationKeysByValue(String configurationValue)
    {
        return List.of();
    }


    @Override public String getConfigurationValueByKey(String configurationKey)
    {
        return "test name";
    }


    @Override public List<ConfigurationModel> getConfigurationsByType(String configurationType)
    {
        return List.of();
    }


    @Override public int save(ConfigurationModel model)
    {
        return 0;
    }


    @Override public int save(String configurationKey, String configurationValue, String configurationType)
    {
        return 0;
    }


    @Override public int update(ConfigurationModel model)
    {
        return 0;
    }


    @Override public int update(String configurationKey, String configurationValue, String configurationType)
    {
        return 0;
    }


    @Override public int delete(String configurationKey)
    {
        return 0;
    }


    @Override public int delete(ConfigurationModel model)
    {
        return 0;
    }
}
