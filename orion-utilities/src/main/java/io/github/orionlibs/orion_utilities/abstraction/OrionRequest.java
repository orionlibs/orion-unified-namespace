package io.github.orionlibs.orion_utilities.abstraction;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * abstract MVC, AJAX or web service request object
 * @author dimitrios.efthymiou
 */
@NoArgsConstructor
//@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class OrionRequest implements Serializable
{
    private String internalUse;
}