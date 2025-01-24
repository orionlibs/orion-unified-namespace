package io.github.orionlibs.orion_utilities.web.cookie;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import org.springframework.http.ResponseCookie;

class CookieModifier extends Orion
{
    private static final String ErrorMessage = "The cookie input cannot be null.";


    static ResponseCookie updateCookieValue(ResponseCookie cookie, String cookieValue, int expirationInSeconds)
    {
        Assert.notNull(cookie, ErrorMessage);
        ResponseCookie cookie1 = ResponseCookie.from(cookie.getName(), cookieValue)
                        .domain(cookie.getDomain())
                        .httpOnly(cookie.isHttpOnly())
                        .maxAge(expirationInSeconds)
                        .path(cookie.getPath())
                        .sameSite(cookie.getSameSite())
                        .secure(true)
                        .build();
        return cookie1;
    }


    static ResponseCookie invalidateCookie(ResponseCookie cookie)
    {
        Assert.notNull(cookie, ErrorMessage);
        ResponseCookie cookie1 = ResponseCookie.from(cookie.getName(), null)
                        .domain(cookie.getDomain())
                        .httpOnly(cookie.isHttpOnly())
                        .maxAge(0L)
                        .path(cookie.getPath())
                        .sameSite(cookie.getSameSite())
                        .secure(true)
                        .build();
        return cookie1;
    }
}