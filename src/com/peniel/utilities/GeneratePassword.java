package com.peniel.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyStore;
import java.security.spec.KeySpec;
import java.util.Properties;


public class GeneratePassword {
	protected static final String PROP_FILENAME = "/com/peniel/utilities/config.properties";
	protected Properties prop = null;

	private static final String UNICODE_FORMAT = "UTF8";
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private KeySpec ks;
	private SecretKeyFactory skf;
	private Cipher cipher;
	byte[] arrayBytes;
	private String encryptionKey;
	private String encryptionScheme;
	SecretKey key,key1;
	String keyPhrase,keyFilePath,keyStPass;

	public GeneratePassword(String appProperty) throws Exception {
		// Read environment variables from configuration file
		prop = new Properties();
		InputStream in = null;
	//	java.io.FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			//in = GeneratePassword.class.getResourceAsStream(PROP_FILENAME);
			in = new FileInputStream(appProperty);
			// load a properties file from class path
			prop.load(in);
			keyFilePath = prop.getProperty("keyFilePath");
			keyStPass = prop.getProperty("keyStPass");
			keyPhrase = prop.getProperty("keyPhrase");
			fis = new FileInputStream(keyFilePath);
			char[] password = keyStPass.toCharArray();

			KeyStore ks = KeyStore.getInstance("JCEKS");
			ks.load(fis, password);

			// Replace key value with customized string

			SecretKey mySecretKey = new SecretKeySpec(keyPhrase.getBytes(UNICODE_FORMAT), 0,
					keyPhrase.getBytes(UNICODE_FORMAT).length, "DES");
			KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(mySecretKey);

			ks.setEntry("imagingkey", skEntry, new KeyStore.PasswordProtection(password));
			//fos = new java.io.FileOutputStream(keyFilePath);
			//ks.store(fos, password);

			key1 = (javax.crypto.SecretKey) ks.getKey("imagingkey", password);
			// key1 = (javax.crypto.SecretKey) ks.getKey("alias","keystorepass".toCharArray());

			String keyString = Base64.encodeBase64String(key1.getEncoded());
			encryptionKey = keyString;

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				fis.close();
			}
//			if (fos != null) {
//				fos.close();
//			}

		}
		encryptionScheme = DESEDE_ENCRYPTION_SCHEME;
		arrayBytes = encryptionKey.getBytes(UNICODE_FORMAT);
		ks = new DESedeKeySpec(arrayBytes);
		skf = SecretKeyFactory.getInstance(encryptionScheme);
		cipher = Cipher.getInstance(encryptionScheme);
		key = skf.generateSecret(ks);
	}

	public String encrypt(String unencryptedString) throws Exception {
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = new String(Base64.encodeBase64(encryptedText));
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return encryptedString;
	}

	public String decrypt(String encryptedString) throws Exception {
		String decryptedPass = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptedPass = Base64.decodeBase64(encryptedString);
			byte[] plainText = cipher.doFinal(encryptedPass);
			decryptedPass = new String(plainText);
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		return decryptedPass;
	}
	public Boolean validateKey(String userKey) {			
		try {
			if(userKey.equalsIgnoreCase(keyPhrase)){
				return true;
			}else
			{
				return false;
			}			
		} catch (Exception e) {
			return false;
		}		
	}

	public static void main(String args[]) throws Exception {
		String appProperty = args[0];
		GeneratePassword generatePassphrase = new GeneratePassword(appProperty);

		String passPhrase = "Peniel$123";
		String encrypted = generatePassphrase.encrypt(passPhrase);
		String decrypted = generatePassphrase.decrypt(encrypted);

		System.out.println("Pass Phrase: " + passPhrase);
		System.out.println("Encrypted Password:" + encrypted);
		System.out.println("Decrypted Password:" + decrypted);

	}

}