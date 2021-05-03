package uz.bipay.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SetPasswordResponse implements Serializable {
    @Expose
    @SerializedName("status")
    String password;
    @Expose
    @SerializedName("message")
    String confirmpassword;
}
