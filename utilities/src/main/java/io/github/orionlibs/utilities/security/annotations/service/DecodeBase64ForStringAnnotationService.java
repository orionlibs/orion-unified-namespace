package io.github.orionlibs.utilities.security.annotations.service;

import io.github.orionlibs.utilities.abstraction.OrionService;
import io.github.orionlibs.utilities.cryptology.encoding.base64.Base64EncodingService;
import io.github.orionlibs.utilities.exception.InaccessibleException;
import io.github.orionlibs.utilities.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import io.github.orionlibs.utilities.security.annotations.DecodeBase64ForString;
import java.lang.reflect.Field;
import java.util.List;

public class DecodeBase64ForStringAnnotationService extends OrionService
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
                //
            }

        });
    }


    private static void processInstanceVariable(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException, InaccessibleException
    {

        if(instanceVariable.getAnnotation(DecodeBase64ForString.class) != null)
        {
            decryptData(instanceVariable, object);
        }

    }


    private static void decryptData(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException, InaccessibleException
    {
        ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);
        String data = (String)instanceVariable.get(object);
        String encryptedData = Base64EncodingService.decodeBase64ForString(data);
        ReflectionInstanceVariablesAccessService.injectStringToInstanceVariable(object, encryptedData, instanceVariable);
    }
}