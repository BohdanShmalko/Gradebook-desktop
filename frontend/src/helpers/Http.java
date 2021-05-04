package helpers;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Http {
    private String base;
    private HttpURLConnection connection = null;

    public Http() {
        this.base = "http://localhost:3001/";
    }
    public Http(String baseUrl) {
        this.base = baseUrl;
    }

    public String get(String url) {
        return request(url, "GET", "");
    }

    public String post(String url, String json) {
        return request(url, "POST", json);
    }


    private String request(String url, String method, String json) {
        StringBuffer sb = new StringBuffer();
        try {
            this.connection = (HttpURLConnection) new URL(this.base + url).openConnection();
            byte[] postDataBytes = json.getBytes(StandardCharsets.UTF_8);

            this.connection.setRequestMethod(method);
            this.connection.setUseCaches(false);
            this.connection.setDoOutput(true);
            this.connection.setConnectTimeout(5000);
            this.connection.setReadTimeout(5000);
            JSONObject obj = JSON.parse(JsonDb.get());
            this.connection.setRequestProperty("Set-Cookie", "token="+obj.get("token"));
            if (postDataBytes.length != 0){
                this.connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                this.connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                this.connection.getOutputStream().write(postDataBytes);
            }

            this.connection.connect();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null){
                    sb.append(line);
                }
            }

        }catch (Throwable cause) {
            cause.printStackTrace();
        }finally {
            if (connection != null){
                connection.disconnect();
            }
            return sb.toString();
        }
    }
}
