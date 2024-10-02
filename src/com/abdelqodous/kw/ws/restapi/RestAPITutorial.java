package com.abdelqodous.kw.ws.restapi;

import com.abdelqodous.kw.ws.restapi.dto.Transcript;
import com.abdelqodous.kw.ws.restapi.utils.RestConstants;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestAPITutorial {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("------------------ Start of Post request --------------");
        Transcript transcript = new Transcript();
        transcript.setAudio_url(RestConstants.AUDIO_URL);

        Gson gson = new Gson();
        String requestTranscript = gson.toJson(transcript);
        System.out.println("Json Request: " +requestTranscript);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(RestConstants.API_URL))
                .header("Authorization", RestConstants.API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString( requestTranscript))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("PostResponse: " +postResponse.body());

        System.out.println("------------------ End of Post request --------------");
        System.out.println("----------------------------><-----------------------");
        System.out.println("------------------ Start of Get request -------------");
        Transcript responseTranscript = gson.fromJson(postResponse.body(), Transcript.class);

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(RestConstants.API_URL + "/" + responseTranscript.getId()))
                .header("Authorization", RestConstants.API_KEY)
                .GET()
                .build();

        while (true){
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            responseTranscript = gson.fromJson(getResponse.body(), Transcript.class);
            System.out.println("Response status: " +responseTranscript.getStatus());
            if("completed".equals( responseTranscript.getStatus()) ||
                    "error".equals( responseTranscript.getStatus()))
                break;

            Thread.sleep(1000);
        }
        System.out.println("Transcript completed");
        System.out.println("Transcript: " +responseTranscript.getText());
        System.out.println("------------------ End of Get request --------------");
    }
}
