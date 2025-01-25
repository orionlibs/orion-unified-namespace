package io.github.orionlibs.core.configuration;

import io.github.orionlibs.core.registry.ServiceRegistry;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationService
{
    public static List<ConfigurationModel> getAllProps()
    {
        Map<String, String> allProps = InMemoryConfigurationService.getPropsAsMap();
        List<ConfigurationModel> allProperties = new ArrayList<>();
        for(Map.Entry<String, String> prop : allProps.entrySet())
        {
            allProperties.add(ConfigurationModel.builder()
                            .configurationKey(prop.getKey())
                            .configurationValue(prop.getValue())
                            .configurationType("")
                            .build());
        }
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            allProperties.addAll(customDAO.getConfigurations());
        }
        return allProperties;
    }


    public static List<ConfigurationModel> getAllPropsByType(String type)
    {
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            return customDAO.getConfigurationsByType(type);
        }
        else
        {
            return new ArrayList<>();
        }
    }


    public static List<String> getPropAsList(String key, String delimiter)
    {
        String value = InMemoryConfigurationService.getProp(key);
        if(value == null)
        {
            value = getProp(key);
        }
        if(value != null && !value.isEmpty())
        {
            return Arrays.asList(value.split(delimiter));
        }
        else
        {
            return null;
        }
    }


    public static boolean doesKeyExist(String key)
    {
        boolean doesKeyExist = InMemoryConfigurationService.containsPropKey(key);
        if(!doesKeyExist)
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                doesKeyExist = customDAO.doesConfigurationKeyExist(key);
            }
        }
        return doesKeyExist;
    }


    public static boolean doesValueExist(String value)
    {
        boolean doesValueExist = InMemoryConfigurationService.doesValueExist(value);
        if(!doesValueExist)
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                doesValueExist = customDAO.doesConfigurationValueExist(value);
            }
        }
        return doesValueExist;
    }


    public static String getKeyFromValue(String value)
    {
        String key = InMemoryConfigurationService.getKeyFromValue(value);
        if(key == null)
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                key = customDAO.getConfigurationKeyByValue(value);
            }
        }
        return key;
    }


    public static List<String> getKeysFromValue(String value)
    {
        List<String> keys = InMemoryConfigurationService.getKeysFromValue(value);
        if(keys == null || keys.isEmpty())
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                keys = customDAO.getConfigurationKeysByValue(value);
            }
        }
        return keys;
    }


    public static void registerProp(String key, String value, String type)
    {
        InMemoryConfigurationService.registerProp(key, value);
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            customDAO.save(key, value, type);
        }
    }


    public static void registerProp(ConfigurationModel model)
    {
        InMemoryConfigurationService.registerProp(model.getConfigurationKey(), model.getConfigurationValue());
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            customDAO.save(model);
        }
    }


    public static void updateProp(String key, String value, String type)
    {
        InMemoryConfigurationService.updateProp(key, value);
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            customDAO.update(key, value, type);
        }
    }


    public static void updateProp(ConfigurationModel model)
    {
        InMemoryConfigurationService.updateProp(model.getConfigurationKey(), model.getConfigurationValue());
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            customDAO.update(model);
        }
    }


    public static void deleteProp(String key)
    {
        InMemoryConfigurationService.deleteProp(key);
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            customDAO.delete(key);
        }
    }


    public static void deleteProp(ConfigurationModel model)
    {
        InMemoryConfigurationService.deleteProp(model.getConfigurationKey());
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            customDAO.delete(model);
        }
    }


    public static long getNumberOfProps()
    {
        int x = InMemoryConfigurationService.getNumberOfConfigurationProperties();
        if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
        {
            x += customDAO.getNumberOfConfigurationProperties();
        }
        return x;
    }


    public static Map<String, String> getPropsAsMap()
    {
        Map<String, String> entries = new HashMap<>();
        getAllProps().forEach(prop -> entries.put(prop.getConfigurationKey(), prop.getConfigurationValue()));
        return entries;
    }


    public static boolean containsPropKey(String key)
    {
        return doesKeyExist(key);
    }


    public static boolean containsPropValue(String value)
    {
        return doesValueExist(value);
    }


    public static String getProp(String key)
    {
        String value = InMemoryConfigurationService.getProp(key);
        if(value == null)
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                value = customDAO.getConfigurationValueByKey(key);
            }
        }
        return value;
    }


    public static String getProp(String key, String defaultValue)
    {
        String value = InMemoryConfigurationService.getProp(key);
        if(value == null)
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                value = customDAO.getConfigurationValueByKey(key);
            }
        }
        return (value != null) ? value : defaultValue;
    }


    public static ConfigurationModel getPropModel(String key)
    {
        String value = InMemoryConfigurationService.getProp(key);
        if(value == null)
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                return customDAO.getConfigurationByKey(key);
            }
        }
        return ConfigurationModel.builder()
                        .configurationKey(key)
                        .configurationValue(value)
                        .configurationType("")
                        .build();
    }


    public static ConfigurationModel getPropModel(String key, String defaultValue)
    {
        String value = InMemoryConfigurationService.getProp(key);
        if(value == null)
        {
            if(ServiceRegistry.getService(ConfigurationDAO.class) instanceof ConfigurationDAO customDAO)
            {
                ConfigurationModel model = customDAO.getConfigurationByKey(key);
                if(model == null)
                {
                    return ConfigurationModel.builder()
                                    .configurationKey(key)
                                    .configurationValue(defaultValue)
                                    .configurationType("")
                                    .build();
                }
                else
                {
                    return model;
                }
            }
        }
        return ConfigurationModel.builder()
                        .configurationKey(key)
                        .configurationValue(value)
                        .configurationType("")
                        .build();
    }


    public static String getPropOrThrowException(String key) throws ConfigurationPropertyMissingException
    {
        String value = getProp(key);
        if(value == null)
        {
            throw new ConfigurationPropertyMissingException("Configuration property {} is missing.", key);
        }
        else
        {
            return value;
        }
    }


    public static String getPropWithPlaceholders(String key, List<String> propertyPlaceholders)
    {
        return getPropWithPlaceholders(key, null, propertyPlaceholders);
    }


    public static String getPropWithPlaceholders(String key, String defaultValue, List<String> propertyPlaceholders)
    {
        return applyPlaceholders(getProp(key, defaultValue), propertyPlaceholders);
    }


    private static String applyPlaceholders(String aString, List<String> placeholders)
    {
        if(aString != null && !aString.isEmpty() && placeholders != null && !placeholders.isEmpty())
        {
            Object[] placeholders1 = placeholders.toArray(new Object[0]);
            return MessageFormat.format(aString, placeholders1);
        }
        else
        {
            return aString;
        }
    }


    private static boolean keyIsNotEmpty(String key)
    {
        return key != null && !key.isEmpty();
    }


    public static Byte getByteProp(String key)
    {
        return getByteProp(key, Byte.MIN_VALUE);
    }


    public static Byte getByteProp(String key, byte defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Byte.parseByte(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }
        }
        return defaultValue;
    }


    public static Short getShortProp(String key)
    {
        return getShortProp(key, Short.MIN_VALUE);
    }


    public static Short getShortProp(String key, short defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Short.parseShort(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }
        }
        return defaultValue;
    }


    public static Integer getIntegerProp(String key)
    {
        return getIntegerProp(key, Integer.MIN_VALUE);
    }


    public static Integer getIntegerProp(String key, int defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Integer.parseInt(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }
        }
        return defaultValue;
    }


    public static Long getLongProp(String key)
    {
        return getLongProp(key, Long.MIN_VALUE);
    }


    public static Long getLongProp(String key, long defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Long.parseLong(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }
        }
        return defaultValue;
    }


    public static Float getFloatProp(String key)
    {
        return getFloatProp(key, Float.MIN_VALUE);
    }


    public static Float getFloatProp(String key, float defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Float.parseFloat(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }
        }
        return defaultValue;
    }


    public static Double getDoubleProp(String key)
    {
        return getDoubleProp(key, Double.MIN_VALUE);
    }


    public static Double getDoubleProp(String key, double defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return Double.parseDouble(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }
        }
        return defaultValue;
    }


    public static BigDecimal getBigDecimalProp(String key)
    {
        return getBigDecimalProp(key, BigDecimal.ZERO);
    }


    public static BigDecimal getBigDecimalProp(String key, BigDecimal defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            try
            {
                return new BigDecimal(getProp(key));
            }
            catch(NumberFormatException e)
            {
                return defaultValue;
            }
        }
        return defaultValue;
    }


    public static Boolean getBooleanProp(String key)
    {
        return getBooleanProp(key, Boolean.FALSE);
    }


    public static Boolean getBooleanProp(String key, boolean defaultValue)
    {
        if(keyIsNotEmpty(key))
        {
            return Boolean.parseBoolean(getProp(key));
        }
        return defaultValue;
    }


    public static Character getCharacterProp(String key) throws InvalidConfigurationPropertyException
    {
        return getCharacterProp(key, Character.MIN_VALUE);
    }


    public static Character getCharacterProp(String key, char defaultValue) throws InvalidConfigurationPropertyException
    {
        if(keyIsNotEmpty(key))
        {
            String value = getProp(key);
            if(value.length() == 1)
            {
                return Character.valueOf(value.toCharArray()[0]);
            }
            else
            {
                throw new InvalidConfigurationPropertyException(String.format("The property value '{}', cannot be converted to a character object.", value));
            }
        }
        return defaultValue;
    }


    public static Object getObjectProp(String key)
    {
        return InMemoryConfigurationService.getObjectProp(key);
    }


    public static void registerObjectProp(String key, Object value)
    {
        InMemoryConfigurationService.registerObjectProp(key, value);
    }


    public static void registerListProp(String key, List<?> value)
    {
        InMemoryConfigurationService.registerListProp(key, value);
    }


    public static boolean doesObjectValueExist(Object value)
    {
        return InMemoryConfigurationService.doesObjectValueExist(value);
    }


    public static String getKeyFromObjectValue(Object value)
    {
        return InMemoryConfigurationService.getKeyFromObjectValue(value);
    }


    public static List<String> getKeysFromObjectValue(Object value)
    {
        return InMemoryConfigurationService.getKeysFromObjectValue(value);
    }


    public static void updateObjectProp(String key, Object value)
    {
        InMemoryConfigurationService.updateObjectProp(key, value);
    }


    public static void updateListProp(String key, List<?> value)
    {
        InMemoryConfigurationService.updateListProp(key, value);
    }


    public static boolean containsPropObjectValue(Object value)
    {
        return InMemoryConfigurationService.containsPropObjectValue(value);
    }


    public static List<?> getListProp(String key)
    {
        return InMemoryConfigurationService.getListProp(key);
    }


    public static List<?> getListProp(String key, List<?> defaultValue)
    {
        return InMemoryConfigurationService.getListProp(key, defaultValue);
    }


    public static Object getObjectProp(String key, Object defaultValue)
    {
        return InMemoryConfigurationService.getObjectProp(key, defaultValue);
    }
}