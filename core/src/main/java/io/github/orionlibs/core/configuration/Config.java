package io.github.orionlibs.core.configuration;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Config
{
    public static List<ConfigurationModel> getAllProps()
    {
        return ConfigurationService.getAllProps();
    }


    public static List<ConfigurationModel> getAllPropsByType(String type)
    {
        return ConfigurationService.getAllPropsByType(type);
    }


    public static List<String> getPropAsList(String key, String delimiter)
    {
        return ConfigurationService.getPropAsList(key, delimiter);
    }


    public static boolean doesKeyExist(String key)
    {
        return ConfigurationService.doesKeyExist(key);
    }


    public static boolean doesValueExist(String value)
    {
        return ConfigurationService.doesValueExist(value);
    }


    public static String getKeyFromValue(String value)
    {
        return ConfigurationService.getKeyFromValue(value);
    }


    public static List<String> getKeysFromValue(String value)
    {
        return ConfigurationService.getKeysFromValue(value);
    }


    public static void registerProp(String key, String value, String type)
    {
        ConfigurationService.registerProp(key, value, type);
    }


    public static void registerProp(ConfigurationModel model)
    {
        ConfigurationService.registerProp(model);
    }


    public static void updateProp(String key, String value, String type)
    {
        ConfigurationService.updateProp(key, value, type);
    }


    public static void updateProp(ConfigurationModel model)
    {
        ConfigurationService.updateProp(model);
    }


    public static void deleteProp(String key)
    {
        ConfigurationService.deleteProp(key);
    }


    public static void deleteProp(ConfigurationModel model)
    {
        ConfigurationService.deleteProp(model);
    }


    public static long getNumberOfProps()
    {
        return ConfigurationService.getNumberOfProps();
    }


    public static Map<String, String> getPropsAsMap()
    {
        return ConfigurationService.getPropsAsMap();
    }


    public static boolean containsPropKey(String key)
    {
        return ConfigurationService.containsPropKey(key);
    }


    public static boolean containsPropValue(String value)
    {
        return ConfigurationService.containsPropValue(value);
    }


    public static String getProp(String key)
    {
        return ConfigurationService.getProp(key);
    }


    public static String getProp(String key, String defaultValue)
    {
        return ConfigurationService.getProp(key, defaultValue);
    }


    public static ConfigurationModel getPropModel(String key)
    {
        return ConfigurationService.getPropModel(key);
    }


    public static ConfigurationModel getPropModel(String key, String defaultValue)
    {
        return ConfigurationService.getPropModel(key, defaultValue);
    }


    public static String getPropOrThrowException(String key) throws ConfigurationPropertyMissingException
    {
        return ConfigurationService.getPropOrThrowException(key);
    }


    public static String getPropWithPlaceholders(String key, List<String> propertyPlaceholders)
    {
        return ConfigurationService.getPropWithPlaceholders(key, propertyPlaceholders);
    }


    public static String getPropWithPlaceholders(String key, String defaultValue, List<String> propertyPlaceholders)
    {
        return ConfigurationService.getPropWithPlaceholders(key, defaultValue, propertyPlaceholders);
    }


    public static Byte getByteProp(String key)
    {
        return ConfigurationService.getByteProp(key);
    }


    public static Byte getByteProp(String key, byte defaultValue)
    {
        return ConfigurationService.getByteProp(key, defaultValue);
    }


    public static Short getShortProp(String key)
    {
        return ConfigurationService.getShortProp(key);
    }


    public static Short getShortProp(String key, short defaultValue)
    {
        return ConfigurationService.getShortProp(key, defaultValue);
    }


    public static Integer getIntegerProp(String key)
    {
        return ConfigurationService.getIntegerProp(key);
    }


    public static Integer getIntegerProp(String key, int defaultValue)
    {
        return ConfigurationService.getIntegerProp(key, defaultValue);
    }


    public static Long getLongProp(String key)
    {
        return ConfigurationService.getLongProp(key);
    }


    public static Long getLongProp(String key, long defaultValue)
    {
        return ConfigurationService.getLongProp(key, defaultValue);
    }


    public static Float getFloatProp(String key)
    {
        return ConfigurationService.getFloatProp(key);
    }


    public static Float getFloatProp(String key, float defaultValue)
    {
        return ConfigurationService.getFloatProp(key, defaultValue);
    }


    public static Double getDoubleProp(String key)
    {
        return ConfigurationService.getDoubleProp(key);
    }


    public static Double getDoubleProp(String key, double defaultValue)
    {
        return ConfigurationService.getDoubleProp(key, defaultValue);
    }


    public static BigDecimal getBigDecimalProp(String key)
    {
        return ConfigurationService.getBigDecimalProp(key);
    }


    public static BigDecimal getBigDecimalProp(String key, BigDecimal defaultValue)
    {
        return ConfigurationService.getBigDecimalProp(key, defaultValue);
    }


    public static Boolean getBooleanProp(String key)
    {
        return ConfigurationService.getBooleanProp(key);
    }


    public static Boolean getBooleanProp(String key, boolean defaultValue)
    {
        return ConfigurationService.getBooleanProp(key, defaultValue);
    }


    public static Character getCharacterProp(String key) throws InvalidConfigurationPropertyException
    {
        return ConfigurationService.getCharacterProp(key);
    }


    public static Character getCharacterProp(String key, char defaultValue) throws InvalidConfigurationPropertyException
    {
        return ConfigurationService.getCharacterProp(key, defaultValue);
    }


    public static Object getObjectProp(String key)
    {
        return ConfigurationService.getObjectProp(key);
    }


    public static void registerObjectProp(String key, Object value)
    {
        ConfigurationService.registerObjectProp(key, value);
    }


    public static void registerListProp(String key, List<?> value)
    {
        ConfigurationService.registerListProp(key, value);
    }


    public static boolean doesObjectValueExist(Object value)
    {
        return ConfigurationService.doesObjectValueExist(value);
    }


    public static String getKeyFromObjectValue(Object value)
    {
        return ConfigurationService.getKeyFromObjectValue(value);
    }


    public static List<String> getKeysFromObjectValue(Object value)
    {
        return ConfigurationService.getKeysFromObjectValue(value);
    }


    public static void updateObjectProp(String key, Object value)
    {
        ConfigurationService.updateObjectProp(key, value);
    }


    public static void updateListProp(String key, List<?> value)
    {
        ConfigurationService.updateListProp(key, value);
    }


    public static boolean containsPropObjectValue(Object value)
    {
        return ConfigurationService.containsPropObjectValue(value);
    }


    public static List<?> getListProp(String key)
    {
        return ConfigurationService.getListProp(key);
    }


    public static List<?> getListProp(String key, List<?> defaultValue)
    {
        return ConfigurationService.getListProp(key, defaultValue);
    }


    public static Object getObjectProp(String key, Object defaultValue)
    {
        return ConfigurationService.getObjectProp(key, defaultValue);
    }
}