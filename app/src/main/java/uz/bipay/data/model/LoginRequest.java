package uz.bipay.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @Expose
    @SerializedName("login")
    String login;
    @Expose
    @SerializedName("password")
    String password;
    @Expose
    @SerializedName("lang")
    String lang;
    public LoginRequest(){

    }

    public LoginRequest(String login, String password, String lang) {
        this.login = login;
        this.password = password;
        this.lang = lang;
    }
}
