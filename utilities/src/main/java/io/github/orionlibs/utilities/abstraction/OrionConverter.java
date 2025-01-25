package io.github.orionlibs.utilities.abstraction;

public interface OrionConverter<SOURCE, TARGET>
{
    TARGET convert(SOURCE source, TARGET target);
}