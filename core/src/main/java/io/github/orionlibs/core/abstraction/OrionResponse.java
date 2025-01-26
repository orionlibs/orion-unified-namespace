package io.github.orionlibs.core.abstraction;

import java.io.Serializable;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * abstract MVC, AJAX or web service response object
 * @author dimitrios.efthymiou
 */
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class OrionResponse implements Serializable
{
    private Boolean hasErrors;
    private Boolean invalidPageNumber;
    private Error error;
    private Set<String> invalidFields;
    private Integer pageNumber;
    private Long totalNumberOfPages;
    private String authorities;


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