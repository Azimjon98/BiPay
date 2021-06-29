package uz.bipay.data.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationRequest {
    @Expose
    @SerializedName("login")
    String login;
    @Expose
    @SerializedName("password")
    String password;
    @Expose
    @SerializedName("lang")
    String lang;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String login, String password, String lang) {
        this.login = login;
        this.password = password;
        this.lang = lang;
    }
}
