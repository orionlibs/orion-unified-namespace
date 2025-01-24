package io.github.orionlibs.orion_utilities.runnable.functions;

@FunctionalInterface
public interface OrionFunctionNxN<T, R> extends OrionFunction
{
    @SuppressWarnings("unchecked")
    R[] run(T... args);
}