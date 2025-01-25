package io.github.orionlibs.utilities.tuple;

import io.github.orionlibs.utilities.abstraction.OrionInterface;
import java.util.List;

public interface Tuple extends OrionInterface
{
    Object get(int index);


    Object[] getAsArray();


    List<Object> getAsList();


    boolean isEmpty();
}