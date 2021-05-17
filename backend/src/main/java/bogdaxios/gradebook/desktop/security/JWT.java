package bogdaxios.gradebook.desktop.security;

import bogdaxios.gradebook.desktop.exeptions.TokenIsBroken;

import java.io.UnsupportedEncodingException;

public class JWT {
    private final String secretKey = "SomeSecureTestUserPassword";
    private final String secretUserKey = "SomeSecretUserKey";
    private final String coder = "MD5";

    private String encodeCoder() {
        return new Crypto().coderEncrypt(coder);
    }

    private String encodeJSON(String json) {
        return new Crypto().encrypt(secretUserKey + json, secretKey);
    }

    private String encodeSecretUserKey() {
        return new Crypto().coderEncrypt(secretUserKey);
    }

    private void decodeCoder(String hash) throws TokenIsBroken {
        try {
            String decCoder = new Crypto().coderDecrypt(hash);
            if (!decCoder.equals(coder)) {
                throw new TokenIsBroken("Token is broken : coder is inappropriate, current is " + decCoder);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private String decodeJSON(String reqUserKey, String hash) throws TokenIsBroken {
        String allData = new Crypto().decrypt(hash, secretKey);
        String userKey = allData.substring(0, reqUserKey.length());
        if (!userKey.equals(reqUserKey)) {
            throw new TokenIsBroken("Token is broken : user key is inappropriate, current is " + userKey);
        }
        return allData.substring(reqUserKey.length()); //!!
    }

    private String decodeKey(String hash) throws TokenIsBroken {
        try {
            String key = new Crypto().coderDecrypt(hash);
            if (!key.equals(secretUserKey)) {
                throw new TokenIsBroken("Token is broken : secret key is inappropriate, current is " + key);
            }
            return key;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String generateJWT(String json) {
        String encCoder = encodeCoder();
        String enJSON = encodeJSON(json);
        String enKey = encodeSecretUserKey();
        return encCoder + "." + enJSON + "." + enKey;
    }

    public String decodeJWT(String jwt) throws TokenIsBroken {
        String[] splitJWT = jwt.split("\\.");
        if(splitJWT.length != 3){
            throw new TokenIsBroken("Token is broken : incorrect token signature");
        }
        decodeCoder(splitJWT[0]);
        String userKey = decodeKey(splitJWT[2]);
        return decodeJSON(userKey, splitJWT[1]);
    }

//TUQ1.T+PXhAnjr8RK7exQZyUm+fHL577yre3WmNRxsHJ4lL2w.U29tZVNlY3JldFVzZXJLZXk=
//    public static void main(final String[] args) {
//        String json = "{\"some\": \"data\"}";
//        String jwt = new JWT().generateJWT(json);
//        System.out.println(jwt);
//        try {
//            String newJson = new JWT().decodeJWT(jwt);
//            System.out.println(newJson);
//        } catch (TokenIsBroken tokenIsBroken) {
//            tokenIsBroken.printStackTrace();
//        }
//    }

}
