package com.chairul.sidwonggahu.adapter;

public class URLAdapter {
    private String URL = "https://sid-wonggahu.com/webservices/";
    private String URL_PHOTO = "https://sid-wonggahu.com/admin-control/assets/images/photo/";
    private String URL_WEB = "https://sid-wonggahu.com/";
    private String URL_ANDROID = "https://sid-wonggahu.com/android/";

    /*private String URL = "https://sid-sidomulyo.com/webservices/";
    private String URL_PHOTO = "https://sid-sidomulyo.com/admin-control/assets/images/photo/";
    private String URL_WEB = "https://sid-sidomulyo.com/";
    private String URL_ANDROID = "https://sid-sidomulyo.com/android/";*/

    public String getLogin(){
        return URL = URL+"ws-get-login.php";
    }

    public String getMain(){
        return URL_WEB = URL_WEB+"index.php";
    }

    public String getAndroidProfile(String nik){
        return URL_WEB = URL_ANDROID+"profile.php?nik="+nik;
    }

    public String getAndroidRequest(){
        return URL_WEB = URL_ANDROID+"request.php";
    }
}
