package io.github.orionlibs.orion_utilities.object;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.exception.Assert;
import io.github.orionlibs.orion_utilities.runnable.functions.OrionFunction2x1;

public class EqualityFunction extends Orion
{
    private static OrionFunction2x1<Object, Object, Integer> formula;
    static
    {
        formula = (Object x, Object y) -> ((x.equals(y)) ? 0 : 1);
    }


    public static Integer run(Object x, Object y)
    {
        Assert.notNull(x, "x input cannot be null.");
        Assert.notNull(y, "y input cannot be null.");
        return formula.run(x, y);
    }


    public static boolean runAndGetBoolean(Object x, Object y)
    {
        Assert.notNull(x, "x input cannot be null.");
        Assert.notNull(y, "y input cannot be null.");
        return (formula.run(x, y) == 0) ? true : false;
    }


    public static OrionFunction2x1<Object, Object, Integer> getFormula()
    {
        return formula;
    }
}