package uz.bipay.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResetPasswordResponse implements Serializable {
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
}
