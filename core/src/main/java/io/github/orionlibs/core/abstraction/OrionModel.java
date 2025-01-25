package io.github.orionlibs.core.abstraction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public interface OrionModel extends Cloneable, Serializable
{
    @JsonIgnore
    OrionModel getCopy();
}