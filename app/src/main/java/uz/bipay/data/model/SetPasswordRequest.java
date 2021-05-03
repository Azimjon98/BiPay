package uz.bipay.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetPasswordRequest {
    @Expose
    @SerializedName("password")
    String password;
    @Expose
    @SerializedName("confirmpassword")
    String confirmpassword;
    @Expose
    @SerializedName("lang")
    String lang;

    public SetPasswordRequest() {
    }

    public SetPasswordRequest(String password,String confirmpassword, String lang) {
        this.password = password;
        this.confirmpassword = confirmpassword;
        this.lang = lang;
    }
}
