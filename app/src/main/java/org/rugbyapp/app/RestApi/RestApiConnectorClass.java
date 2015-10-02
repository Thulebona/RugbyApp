package org.rugbyapp.app.RestApi;

import android.util.Log;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.rugbyapp.app.domain.TeamProfile;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by codex on 2015/06/30.
 */
public class RestApiConnectorClass {

    private static URLConnection openConnection(String fetchUrl){
        URLConnection urlConnection = null;
        try {
            urlConnection =  new URL(fetchUrl).openConnection();
            urlConnection.connect();
        } catch (IOException e) {
             e.getMessage();
        }
        return urlConnection;
    }

    public static  List<TeamProfile> readAll(String fetchUrl) {

        List<TeamProfile> list = new ArrayList<TeamProfile>();
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
            ResponseEntity<TeamProfile[]> responseEntity = restTemplate.exchange(fetchUrl, HttpMethod.GET, requestEntity, TeamProfile[].class);
            TeamProfile[] results = responseEntity.getBody();

            for (TeamProfile profile : results) {
                list.add(profile);
            }

          /*  JsonReader reader = new JsonReader(new InputStreamReader(openConnection(fetchUrl).getInputStream()));
            JsonParser jsonParser = new JsonParser();
            JsonArray json = jsonParser.parse(reader).getAsJsonArray();
            Log.i("rest Json",json+"thuleb");
            Gson gson = new Gson();
            for (JsonElement element : json) {
                list.add(gson.fromJson(element, classType));
            }*/
        } catch (Exception e) {
           System.out.println(e);
        }
        Log.i("rest",list+"thule");
        System.out.println(list);
        return list;
    }

    public static <T> T read(String fetchUrl, Long ID, Class<T> classType){
        try
        {
            JsonParser jsonParser = new JsonParser();
            JsonReader reader = new JsonReader(new InputStreamReader(openConnection(fetchUrl+ID).getInputStream()));
            JsonElement element = jsonParser.parse(reader);
            Gson gson = new Gson();
          /*  Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                @Override
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsJsonPrimitive().getAsLong());
                }
            }).create();*/
            return (gson.fromJson(element,classType));
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }
    }

    public static <T> T create(String url,T classTypeObject, Class<T> classType){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> body = new HttpEntity<T>(classTypeObject,headers);
        JsonElement element = new JsonParser()
               .parse(restTemplate.postForObject(url, body, String.class))
                .getAsJsonObject();
        System.out.println(element.getAsJsonObject());
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        }).create();

        return gson.fromJson(element,classType);
    }

    public static <T> T update(String url, T classType){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> body = new HttpEntity<T>( classType,headers);
        restTemplate.put(url, body);

        return classType;
    }


}
