package uz.bipay.data.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReservedCardRequest {
    @Expose
    @SerializedName("id")
    Integer id;

    public ReservedCardRequest(){

    }

    public ReservedCardRequest(Integer id) {
        this.id = id;
    }
}
