package io.github.orionlibs.orion_utilities.web.device;

import io.github.orionlibs.orion_utilities.abstraction.OrionService;
import jakarta.servlet.http.HttpServletRequest;

public class UserDeviceService extends OrionService
{
    public static int resolveDevice(HttpServletRequest request)
    {
        return UserDeviceResolver.resolveDeviceType(request);
    }
}