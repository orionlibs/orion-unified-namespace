package io.github.orionlibs.utilities.calendar.time;

import io.github.orionlibs.core.abstraction.OrionUncheckedException;

public class InvalidTimeException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "timeString does not have : as seperators.";


    public InvalidTimeException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidTimeException(String message)
    {
        super(message);
    }


    public InvalidTimeException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidTimeException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidTimeException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
