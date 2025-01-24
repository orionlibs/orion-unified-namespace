package io.github.orionlibs.orion_utilities.web.service.socket;

import io.github.orionlibs.orion_utilities.abstraction.OrionUncheckedException;

public class SocketException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "Problem with the socket.";


    public SocketException()
    {
        super(DefaultErrorMessage);
    }


    public SocketException(String message)
    {
        super(message);
    }


    public SocketException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public SocketException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public SocketException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}