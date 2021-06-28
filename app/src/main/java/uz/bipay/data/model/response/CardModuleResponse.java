package uz.bipay.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CardModuleResponse implements Serializable {
    @Expose
    @SerializedName("id")
    int id;
    @Expose
    @SerializedName("name")
    int name;
    @Expose
    @SerializedName("key")
    String key;
    @Expose
    @SerializedName("logo")
    String logo;
    @Expose
    @SerializedName("reserve")
    int reserve;
    @Expose
    @SerializedName("currency_id")
    int currency_id;
    @Expose
    @SerializedName("currencyName")
    int currencyName;
    @Expose
    @SerializedName("placeHolder")
    int placeHolder;

}
