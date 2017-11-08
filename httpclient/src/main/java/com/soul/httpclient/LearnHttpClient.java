package com.soul.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class LearnHttpClient {

    public static void main(String[] args) {
        try {
//            testHttpClientGet();
            testHttpClientPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testHttpClientGet() throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse closeableHttpResponse = null;

        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com");
        uriBuilder.addParameter("user","goudan");
        URI uri = uriBuilder.build();
        System.out.println(uri.toString());
        HttpGet httpGet = new HttpGet(uri);

        closeableHttpResponse = httpClient.execute(httpGet);
        if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
            String result = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println(result);
        }
        System.out.println(closeableHttpResponse);

    } private static void testHttpClientPost() throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse closeableHttpResponse = null;

        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com");
        URI uri = uriBuilder.build();
        System.out.println(uri.toString());

        HttpPost httpPost = new HttpPost(uri);
        List<NameValuePair> paramList = new ArrayList();
        paramList.add(new BasicNameValuePair("user","goudan"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
        httpPost.setEntity(entity);

        closeableHttpResponse = httpClient.execute(httpPost);
        System.out.println(closeableHttpResponse);
            String s = EntityUtils.toString(closeableHttpResponse.getEntity(), "utf-8");
            System.out.println(s);


    }


}
