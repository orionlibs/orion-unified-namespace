package io.github.orionlibs.core.runnable.functions;

@FunctionalInterface
public interface OrionFunctionNx1<T, R> extends OrionFunction
{
    R run(T[] args);
}