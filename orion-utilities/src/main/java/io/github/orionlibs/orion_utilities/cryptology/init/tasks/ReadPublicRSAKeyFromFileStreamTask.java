package io.github.orionlibs.orion_utilities.cryptology.init.tasks;

import io.github.orionlibs.orion_utilities.abstraction.Orion;
import io.github.orionlibs.orion_utilities.cryptology.encryption.EncryptionAlgorithm;
import io.github.orionlibs.orion_utilities.exception.Assert;
import io.github.orionlibs.orion_utilities.utility.OrionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

public class ReadPublicRSAKeyFromFileStreamTask extends Orion
{
    public static PublicKey run(InputStream publicRSAKeyStream) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        Assert.notNull(publicRSAKeyStream, "input publicRSAKeyStream cannot be null.");
        ObjectInputStream ois = null;

        try
        {
            ois = new ObjectInputStream(publicRSAKeyStream);
            BigInteger modulus = (BigInteger)ois.readObject();
            BigInteger exponent = (BigInteger)ois.readObject();
            RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
            KeyFactory fact = KeyFactory.getInstance(EncryptionAlgorithm.RSA.get());
            return fact.generatePublic(rsaPublicKeySpec);
        }
        finally
        {
            OrionUtils.closeResource(ois);
            OrionUtils.closeResource(publicRSAKeyStream);
        }

    }
}