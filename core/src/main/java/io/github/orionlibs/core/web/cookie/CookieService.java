package io.github.orionlibs.core.web.cookie;

import org.springframework.http.ResponseCookie;

public class CookieService
{
    public static ResponseCookie createCookie(String cookieName, String cookieValue)
    {
        return createCookie(cookieName, cookieValue, 86400);
    }


    public static ResponseCookie createCookie(String cookieName, String cookieValue, int expirationInSeconds)
    {
        return CookieBuilder.createCookie(cookieName, cookieValue, expirationInSeconds);
    }


    public static ResponseCookie updateCookieValue(ResponseCookie cookie, String cookieValue)
    {
        return updateCookieValue(cookie, cookieValue, 86400);
    }


    public static ResponseCookie updateCookieValue(ResponseCookie cookie, String cookieValue, int expirationInSeconds)
    {
        return CookieModifier.updateCookieValue(cookie, cookieValue, expirationInSeconds);
    }


    public static ResponseCookie invalidateCookie(ResponseCookie cookie)
    {
        return CookieModifier.invalidateCookie(cookie);
    }
}