package io.github.orionlibs.utilities.abstraction;

public interface OrionEnumeration extends OrionInterface
{
    String get();


    boolean is(OrionEnumeration other);


    boolean isNot(OrionEnumeration other);
}