package uz.bipay.data.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import uz.bipay.module.CardModule;

public class CardModuleResponse implements Serializable {

    public int id;
    public CardModule cardModule;
    public String name;
    public String key;
    public String logo;
    public int reserve;
    public int currency_id;
    public String currencyName;
    public String  placeHolder;
}
