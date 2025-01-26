package io.github.orionlibs.core.abstraction;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * abstract RESTful web service response object
 * @author dimitrios.efthymiou
 */
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class OrionAPIResponse implements Serializable
{
    private OrionResponse.Error error;


    @NoArgsConstructor
    @SuperBuilder
    @Getter
    @Setter
    static class Error implements Serializable
    {
        private Boolean hasErrors;
        private String errorCode;
        private String errorMessage;
    }
}