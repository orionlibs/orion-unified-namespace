package io.github.orionlibs.orion_utilities.abstraction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public interface OrionModel extends Cloneable, Serializable
{
    @JsonIgnore
    public abstract OrionModel getCopy();
}