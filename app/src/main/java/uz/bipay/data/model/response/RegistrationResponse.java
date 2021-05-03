package uz.bipay.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class RegistrationResponse implements Serializable {
    @Expose
    @SerializedName("status")
    String login;
    @Expose
    @SerializedName("message")
    String password;
}
