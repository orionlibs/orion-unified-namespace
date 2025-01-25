package io.github.orionlibs.utilities.web.app.exception;

import io.github.orionlibs.utilities.abstraction.Orion;
import io.github.orionlibs.utilities.logger.LoggingService;
import io.github.orionlibs.utilities.web.session.SessionService;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrionGlobalExceptionService extends Orion
{
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiCallError<String>> handleAccessDeniedException(HttpServletRequest request, AccessDeniedException exception)
    {
        String userID = SessionService.getUserID(request);
        LoggingService.logErrorToConsole(request.getRemoteAddr(),
                        userID,
                        "HTTP.403",
                        "access denied for request URL = " + request.getRequestURL().toString(),
                        exception);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiCallError<>("Access denied!", List.of("")));
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiCallError<String>> handleInternalServerError(HttpServletRequest request, Throwable exception)
    {
        String userID = SessionService.getUserID(request);
        LoggingService.logErrorToConsole(request.getRemoteAddr(),
                        userID,
                        "HTTP.500",
                        "error for request URL = " + request.getRequestURL().toString(),
                        exception);
        return ResponseEntity.badRequest().build();
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ApiCallError<T>
    {
        private String message;
        private List<T> details;
    }
}