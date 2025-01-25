package io.github.orionlibs.core.abstraction;

import java.io.Serializable;

public interface OrionEnumeration extends Serializable
{
    String get();


    boolean is(OrionEnumeration other);


    boolean isNot(OrionEnumeration other);
}