package uz.bipay.data.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class    ResetPasswordRequest {
    @Expose
    @SerializedName("login")
    String login;
    @Expose
    @SerializedName("password")
    String password;
    @Expose
    @SerializedName("code")
    String code;
    @Expose
    @SerializedName("check_password")
    String check_password;
    public ResetPasswordRequest() {
    }

    public ResetPasswordRequest(String login,String password, String code,String check_password) {
        this.login = login;
        this.password = password;
        this.code = code;
        this.check_password = check_password;
    }
}
