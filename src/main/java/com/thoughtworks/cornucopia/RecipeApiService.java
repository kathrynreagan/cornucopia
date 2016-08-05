package com.thoughtworks.cornucopia;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class RecipeApiService {

    public URL createUrlFromIngredients(String ingredients) {
        String baseUrlText = "http://food2fork.com/api/search?key=d58c01859288708b43b44fb004c81c45&q=";




        return null;
    }

    public String sendRequest(String ingredients) {
        String result = "";

        try{
            URL url = new URL("http://food2fork.com/api/search?key=d58c01859288708b43b44fb004c81c45&q=chicken,zucchini");
            // this is what we want to mock!
            InputStream is = url.openStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            is.close();
            result = response.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}
