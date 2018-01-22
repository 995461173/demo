//package com.example.dome.entity.response;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
///**
// * Created by lenovo on 2018/1/20.
// */
//public class ReadByGet extends Thread{
//
//    @Override
//    public void run(){
//        URL url = null;//如果有参数，在网址中携带参数
//        try {
//            url = new URL("网址");
//            URLConnection conn = null;
//            InputStream is = null;
//            conn = url.openConnection();
//            is = conn.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            String line;
//            StringBuilder builder = new StringBuilder();
//            while((line=br.readLine())!=null){
//                builder.append(line);
//            }
//
//            br.close();
//           // isr.cloae();
//            is.close();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(builder.toString);
//    }
//
//    public static void main(String[] args){
//        new ReadByGet().start();
//    }
//
//}
