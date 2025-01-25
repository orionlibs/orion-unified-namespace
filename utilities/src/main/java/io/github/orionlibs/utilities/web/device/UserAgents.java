package io.github.orionlibs.utilities.web.device;

import io.github.orionlibs.utilities.abstraction.OrionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserAgents extends OrionConstants
{
    public static final List<String> mobileUserAgentPrefixes = new ArrayList<String>();
    public static final List<String> mobileUserAgentKeywords = new ArrayList<String>();
    public static final List<String> tabletUserAgentKeywords = new ArrayList<String>();
    public static final String[] knownMobileUserAgentPrefixes = new String[]
    {"w3c ", "w3c-", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "htc_", "inno", "ipaq", "ipod", "jigs", "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "lg/u", "maui", "maxo", "midp", "mits",
                    "mmef", "mobi", "mot-", "moto", "mwbp", "nec-", "newt", "noki", "palm", "pana", "pant", "phil", "play", "port", "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-",
                    "tosh", "tsm-", "upg1", "upsi", "vk-v", "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda ", "xda-"};
    public static final String[] knownMobileUserAgentKeywords = new String[]
    {"blackberry", "webos", "ipod", "lge vx", "midp", "maemo", "mmp", "mobile", "netfront", "hiptop", "nintendo DS", "novarra", "openweb", "opera mobi", "opera mini", "palm", "psp", "phone", "smartphone", "symbian", "up.browser", "up.link", "wap", "windows ce"};
    public static final String[] knownTabletUserAgentKeywords = new String[]
    {"ipad", "playbook", "hp-tablet", "kindle"};
    static
    {
        mobileUserAgentPrefixes.addAll(Arrays.asList(knownMobileUserAgentPrefixes));
        mobileUserAgentKeywords.addAll(Arrays.asList(knownMobileUserAgentKeywords));
        tabletUserAgentKeywords.addAll(Arrays.asList(knownTabletUserAgentKeywords));
    }
}