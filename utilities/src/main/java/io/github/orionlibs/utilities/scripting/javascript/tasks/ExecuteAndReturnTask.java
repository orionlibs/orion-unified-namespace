package io.github.orionlibs.utilities.scripting.javascript.tasks;

import io.github.orionlibs.utilities.abstraction.Orion;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExecuteAndReturnTask extends Orion
{
    public static Object run(String JavaScriptCodeToExecute, String resultName, Object objectToCastResultTo)
    {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("javascript");

        try
        {
            engine.eval(JavaScriptCodeToExecute);
            return engine.get(resultName).getClass().cast(objectToCastResultTo);
        }
        catch(ScriptException e)
        {
        }

        return null;
    }
}