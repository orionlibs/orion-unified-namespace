package io.github.orionlibs.utilities.runnable.consumers;

@FunctionalInterface
public interface Consumer2<T1, T2> extends OrionConsumer
{
    void run(T1 t1, T2 t2);
}