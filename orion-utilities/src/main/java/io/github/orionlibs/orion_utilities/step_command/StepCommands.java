package io.github.orionlibs.orion_utilities.step_command;

import io.github.orionlibs.orion_utilities.tuple.Pair;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StepCommands
{
    public static Map<Pattern, Pair<Method, Object>> stepPatternToStepDefinitionMapper;
    static Map<Method, Class<?>> stepMethodsFoundAndTheirClass;


    static
    {
        stepPatternToStepDefinitionMapper = new HashMap<>();
        stepMethodsFoundAndTheirClass = new HashMap<>();
    }
}