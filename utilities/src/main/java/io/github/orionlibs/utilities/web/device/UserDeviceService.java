package io.github.orionlibs.utilities.web.device;

import io.github.orionlibs.utilities.abstraction.OrionService;
import jakarta.servlet.http.HttpServletRequest;

public class UserDeviceService extends OrionService
{
    public static int resolveDevice(HttpServletRequest request)
    {
        return UserDeviceResolver.resolveDeviceType(request);
    }
}