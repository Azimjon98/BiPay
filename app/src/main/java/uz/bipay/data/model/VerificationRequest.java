package uz.bipay.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerificationRequest {
    @Expose
    @SerializedName("login")
    String login;
    @Expose
    @SerializedName("code")
    String code;
    @Expose
    @SerializedName("lang")
    String lang;

    public VerificationRequest() {
    }

    public VerificationRequest(String login,String code, String lang) {
        this.login = login;
        this.code = code;
        this.lang = lang;
    }
}
