package io.github.orionlibs.orion_utilities.runnable.functions;

@FunctionalInterface
public interface OrionFunctionNx0<T> extends OrionFunction
{
    @SuppressWarnings("unchecked")
    void run(T... args);
}