package io.github.orionlibs.orion_utilities.web.filter;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.uuid.UUIDSecurityService;

public class JavaThreadIDGenerator extends Orion
{
    static void generateThreadID()
    {
        Thread.currentThread()
                        .setName(UUIDSecurityService.generate2UUIDsWithoutHyphens() + "-" + Long.toString(System.nanoTime()));
    }
}