package com.thoughtworks.cornucopia;



import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class RecipeApiConnection {

    String retrieveResponse(URL url) {
        String result = "";
        try {
            InputStream inputStream = url.openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            inputStream.close();
            result = response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}