package com.poc;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpClient.Version;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class ImplJava9 {

  @SuppressWarnings("exports")
  public static HttpRequest createRequestGet(String str) throws URISyntaxException {
    /*
     * @SuppressWarnings("unused") HttpClient client = HttpClient.newHttpClient();
     */
    @SuppressWarnings("unused")
    HttpClient client = HttpClient.newBuilder().proxy(ProxySelector.getDefault()).build();
    HttpRequest request = HttpRequest.newBuilder().uri(new URI(str)).version(HttpClient.Version.HTTP_2).GET().build();
    return request;
  }

  public static String getVersionHttpRequest(HttpRequest hr) throws URISyntaxException {

    Optional<Version> vers = hr.version();
    String v = vers.toString();
    return v;

  }

  @SuppressWarnings({ "exports", "rawtypes" })
  public static HttpResponse getResponse(HttpRequest request) throws IOException, InterruptedException {
    HttpResponse response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandler.asString());
    System.out.println(response.statusCode());
    return response;
  }

  @SuppressWarnings("exports")
  public static HttpClient.Version displayversion(@SuppressWarnings("rawtypes") HttpResponse response) {
    HttpClient.Version s = null;
    if (response.statusCode() == 200) {
      s = response.version();
    }
    return s;
  }

}
