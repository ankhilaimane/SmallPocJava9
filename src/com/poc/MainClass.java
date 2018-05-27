package com.poc;

import java.io.IOException;
import java.net.URISyntaxException;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class MainClass extends ImplJava9 {

  public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

    String s = new String("https://www.google.com");
    @SuppressWarnings("unused")
    HttpRequest hs = createRequestGet(s);
    String ss = getVersionHttpRequest(hs);
    System.out.println("supposed request version is : " + ss);
    HttpResponse rep = getResponse(hs);
    HttpClient.Version vers = displayversion(rep);
    System.out.println("version  resp is " + vers);

  }

}
