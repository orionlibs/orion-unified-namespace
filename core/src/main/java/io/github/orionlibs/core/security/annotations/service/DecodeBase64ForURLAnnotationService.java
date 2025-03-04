package io.github.orionlibs.core.security.annotations.service;

import io.github.orionlibs.core.cryptology.encoding.base64.Base64EncodingService;
import io.github.orionlibs.core.exception.InaccessibleException;
import io.github.orionlibs.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import io.github.orionlibs.core.security.annotations.DecodeBase64ForURL;
import java.lang.reflect.Field;
import java.util.List;

public class DecodeBase64ForURLAnnotationService
{
    public static void decryptObject(Object objectToDecrypt, List<Field> instanceVariablesOfObject)
    {
        instanceVariablesOfObject.forEach(field ->
        {
            try
            {
                processInstanceVariable(field, objectToDecrypt);
            }
            catch(IllegalArgumentException e)
            {
                throw e;
            }
            catch(IllegalAccessException e)
            {
                //throw new InaccessibleException("The instance variable is inaccessible.");
            }
            catch(InaccessibleException e)
            {
                e.printStackTrace();
            }
        });
    }


    private static void processInstanceVariable(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException, InaccessibleException
    {
        if(instanceVariable.getAnnotation(DecodeBase64ForURL.class) != null)
        {
            decryptData(instanceVariable, object);
        }
    }


    private static void decryptData(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException, InaccessibleException
    {
        ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);
        String data = (String)instanceVariable.get(object);
        String encryptedData = Base64EncodingService.decodeBase64ForURL(data);
        ReflectionInstanceVariablesAccessService.injectStringToInstanceVariable(object, encryptedData, instanceVariable);
    }
}