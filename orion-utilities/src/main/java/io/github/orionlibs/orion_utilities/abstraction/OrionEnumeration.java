package io.github.orionlibs.orion_utilities.abstraction;

public interface OrionEnumeration extends OrionInterface
{
    String get();


    boolean is(OrionEnumeration other);


    boolean isNot(OrionEnumeration other);
}