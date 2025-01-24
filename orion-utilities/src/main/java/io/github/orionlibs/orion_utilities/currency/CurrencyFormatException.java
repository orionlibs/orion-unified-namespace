package io.github.orionlibs.orion_utilities.currency;

import io.github.orionlibs.orion_utilities.abstraction.OrionCheckedException;

public class CurrencyFormatException extends OrionCheckedException
{
    public CurrencyFormatException(String message)
    {
        super(message);
    }


    public CurrencyFormatException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CurrencyFormatException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }
}