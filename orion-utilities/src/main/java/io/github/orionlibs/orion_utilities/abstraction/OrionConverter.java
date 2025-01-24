package io.github.orionlibs.orion_utilities.abstraction;

public interface OrionConverter<SOURCE, TARGET>
{
    TARGET convert(SOURCE source, TARGET target);
}