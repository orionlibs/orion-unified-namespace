package io.github.orionlibs.utilities.web.filter;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.uuid.UUIDSecurityService;

public class JavaThreadIDGenerator extends Orion
{
    static void generateThreadID()
    {
        Thread.currentThread()
                        .setName(UUIDSecurityService.generate2UUIDsWithoutHyphens() + "-" + Long.toString(System.nanoTime()));
    }
}