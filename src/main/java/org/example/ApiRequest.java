package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequest {

    public static void main(String[] args) throws IOException {

        String url = "https://thecatapi.com/";

        String bearerToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTaGlzaXIgSHVtYWdhaW4iLCJleHAiOjE2OTMzNDgxNzl9.X1wVLoxnQC34xly9uasVUGsSrUs6mjkMEH5Jeti4Hqo";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", bearerToken);

        int responseCode = connection.getResponseCode();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();

        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Body : " + response.toString());
        System.out.println(response.length());
        System.out.println(response.codePointBefore(5));

    }
}
