package io.github.orionlibs.orion_utilities.security.annotations.service;

import io.github.orionlibs.orion_utilities.abstraction.OrionEnumeration;
import io.github.orionlibs.orion_utilities.cryptology.encryption.rsa.RSAEncryptionException;
import io.github.orionlibs.orion_utilities.cryptology.hashing.md5.MD5HashingException;
import io.github.orionlibs.orion_utilities.exception.InaccessibleException;
import io.github.orionlibs.orion_utilities.security.annotations.DecryptAsData;
import java.lang.reflect.Field;
import java.util.List;

public class DecryptAsDataAnnotationService extends EncryptionDecryptionAnnotationService
{
    public void decryptObject(Object objectToDecrypt, List<Field> instanceVariablesOfObject, List<OrionEnumeration> decodingAndDecryptionAlgorithmsForDataToBeUsedInOrder)
    {
        processInputs(objectToDecrypt, decodingAndDecryptionAlgorithmsForDataToBeUsedInOrder);
        instanceVariablesOfObject.parallelStream().forEach(field ->
        {

            try
            {
                processInstanceVariableForDecryption(field);
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
            catch(MD5HashingException e)
            {
                //
            }
            catch(RSAEncryptionException e)
            {
                //
            }

        });
    }


    private void processInstanceVariableForDecryption(Field instanceVariable) throws IllegalArgumentException, IllegalAccessException, InaccessibleException, MD5HashingException, RSAEncryptionException
    {

        if(instanceVariable.getAnnotation(DecryptAsData.class) != null)
        {
            decryptData(instanceVariable);
        }

    }
}