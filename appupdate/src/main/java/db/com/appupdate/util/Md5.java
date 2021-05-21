package bd.com.appupdate.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

    protected static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest messageDigest = null;

    static {
        try {
            // MD5（SHA1”SHA1”）
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(Md5.class.getName() + "，MessageDigestMD5Util.");
            e.printStackTrace();
        }
    }

     private static void appendHexPair(byte bt, StringBuffer stringbuffer) {

        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }    
  
   private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    /**
     * md5
     *
     * @param input
     * @return
     */
    public static String stringMD5(String input) {
        // 
        byte[] inputByteArray = input.getBytes();
        // inputByteArray
        messageDigest.update(inputByteArray);
        // ，，16
        byte[] resultByteArray = messageDigest.digest();
        // 
        return bufferToHex(resultByteArray);
    }

    /**
     * md5
     *
     * @param inputFile
     * @return
     * @throws IOException
     */
    public static String fileMD5(File inputFile) {
        // （）
        int bufferSize = 256 * 1024;
        FileInputStream fileInputStream = null;
        DigestInputStream digestInputStream = null;
        try {
            // DigestInputStream
            fileInputStream = new FileInputStream(inputFile);
            digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
            // readMD5，
            byte[] buffer = new byte[bufferSize];
            while (digestInputStream.read(buffer) > 0) ;
            // MessageDigest
            messageDigest = digestInputStream.getMessageDigest();
            // ，，16
            byte[] resultByteArray = messageDigest.digest();
            // ，
            return bufferToHex(resultByteArray);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                digestInputStream.close();
            } catch (Exception e) {
            }
            try {
                fileInputStream.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
}
