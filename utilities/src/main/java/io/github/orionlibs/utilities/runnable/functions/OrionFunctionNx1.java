package io.github.orionlibs.utilities.runnable.functions;

@FunctionalInterface
public interface OrionFunctionNx1<T, R> extends OrionFunction
{
    R run(T[] args);
}