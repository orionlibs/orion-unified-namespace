package io.github.orionlibs.orion_utilities.runnable.functions;

@FunctionalInterface
public interface OrionFunction3x0<T1, T2, T3> extends OrionFunction
{
    void run(T1 t1, T2 t2, T3 t3);
}