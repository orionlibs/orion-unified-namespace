package io.github.orionlibs.core.utility;

import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.reflection.object.ReflectionObjectsService;
import io.github.orionlibs.core.utility.tasks.CloseResourceTask;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionUtils
{
    public static void closeResource(Closeable closeable)
    {
        CloseResourceTask.run(closeable);
    }


    public static int getBooleanAsInteger(boolean x)
    {
        return (x) ? 1 : 0;
    }


    public static int getBooleanAsInteger(Boolean x)
    {
        Assert.notNull(x, "The given Boolean object cannot be null.");
        return (x) ? 1 : 0;
    }


    public static <T> T copyFields(Object source, T target)
    {
        return ReflectionObjectsService.copyFields(source, target);
    }


    public static <T> List<T> getIntersection(List<T>... lists)
    {
        if((lists != null))
        {
            if(lists.length == 1)
            {
                return new ArrayList<T>(lists[0]);
            }
            else if(lists.length > 1)
            {
                List<T> result = new ArrayList<>();
                lists[0].stream()
                                .filter(element -> doesElementExistInAllLists(element, lists))
                                .forEach(element -> result.add(element));
                return result;
            }
        }
        return null;
    }


    public static <T> boolean doesElementExistInAllLists(T element, List<T>... lists)
    {
        if((lists != null && lists.length > 0))
        {
            return doesElementExistInAllLists(element, Arrays.asList(lists));
        }
        return true;
    }


    public static <T> boolean doesElementExistInAllLists(T element, List<List<T>> lists)
    {
        int numberOfListsThatIncludeElement = 1;
        for(int j = 1; j < lists.size(); j++)
        {
            for(int k = 0; k < lists.get(j).size(); k++)
            {
                if(element.equals(lists.get(j).get(k)))
                {
                    ++numberOfListsThatIncludeElement;
                    break;
                }
            }
        }
        return numberOfListsThatIncludeElement == lists.size();
    }
}