package io.github.orionlibs.core.content;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XPath
{
    public static final String xpathRegex = "^(/([^/]+)(\\[.*?\\])?)+$";
    private String xPath;


    public XPath(String xPath) throws Exception
    {
        this.xPath = xPath;
        if(!isValid(xPath))
        {
            throw new Exception("Invalid XPath");
        }
    }


    public XPath(String customRegex, String xPath) throws Exception
    {
        this.xPath = xPath;
        if(!isValid(customRegex, xPath))
        {
            throw new Exception("Invalid XPath");
        }
    }


    public static boolean isValid(String xpath)
    {
        Pattern pattern = Pattern.compile(xpathRegex);
        Matcher matcher = pattern.matcher(xpath);
        return matcher.matches();
    }


    public static boolean isValid(String customRegex, String xpath)
    {
        Pattern pattern = Pattern.compile(customRegex);
        Matcher matcher = pattern.matcher(xpath);
        return matcher.matches();
    }


    public String getxPath()
    {
        return xPath;
    }
}
