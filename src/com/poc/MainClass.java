package com.poc;

import java.io.IOException;
import java.net.URISyntaxException;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class MainClass {

  public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

    String url = new String("https://www.google.com");
    ImplJava9 impljava =new ImplJava9();
        
    HttpRequest request = impljava.createRequestGet(url);
    String versionRequest = impljava.getVersionHttpRequest(request);
    
    HttpResponse response = impljava.getResponse(request);
    HttpClient.Version versionResponse = impljava.displayversion(response);
    
    System.out.println("supposed request version is : " + versionRequest);
    System.out.println("version  resp is " + versionResponse);

  }

}
