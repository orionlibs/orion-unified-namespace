package io.github.orionlibs.core.web.session;

import io.github.orionlibs.core.exception.Assert;
import jakarta.servlet.http.HttpServletRequest;

class SessionAttributeModifier
{
    static void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue)
    {
        Assert.notNull(request, "The HttpServletRequest input cannot be null.");
        request.setAttribute(attributeName, attributeValue);
    }
}