package io.github.orionlibs.orion_utilities.tuple;

import io.github.orionlibs.orion_utilities.abstraction.OrionInterface;
import java.util.List;

public interface Tuple extends OrionInterface
{
    Object get(int index);


    Object[] getAsArray();


    List<Object> getAsList();


    boolean isEmpty();
}