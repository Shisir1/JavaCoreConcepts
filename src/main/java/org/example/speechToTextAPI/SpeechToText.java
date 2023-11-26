package org.example.speechToTextAPI;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SpeechToText {

    public static void main(String[] args) {
        //set the path to your API key JSON file
        System.setProperty("GOOGLE_APPLICATION_CREDENTIALS", "path/to/your/credentials.json");

        //Instantiates a client
        try(SpeechClient speechClient = SpeechClient.create()){

            //set the path to your video file
            Path path = Paths.get("path/to/your/video/file.mp4");

            byte[] data = Files.readAllBytes(path);
            ByteString audioBytes = ByteString.copyFrom(data);

            //Build the audio content
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();

            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

            //Perform the speech reognition
            RecognizeResponse response = speechClient.recognize(config,audio);

            List<SpeechRecognitionResult> results = response.getResultsList();

            //Print the results
            for(SpeechRecognitionResult result : results){
                System.out.println("Transcript: " + result.getAlternatives(0).getTranscript());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
