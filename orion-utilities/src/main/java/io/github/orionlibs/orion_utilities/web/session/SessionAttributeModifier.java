package io.github.orionlibs.orion_utilities.web.session;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import jakarta.servlet.http.HttpServletRequest;

class SessionAttributeModifier extends Orion
{
    static void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue)
    {
        Assert.notNull(request, "The HttpServletRequest input cannot be null.");
        request.setAttribute(attributeName, attributeValue);
    }
}