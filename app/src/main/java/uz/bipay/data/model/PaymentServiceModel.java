package uz.bipay.data.model;

import java.io.Serializable;

public class PaymentServiceModel implements Serializable {
    //hammasini private qib chiq metneodga orqali bulishi kerak xop qara boya id berdinku currentimagega oshanga logo bumidimi?
    private int id;
    private String name;
    private String key;
    private String logo;
    private int reserve;
    private int currency_id;
    private String currencyName;
    private String placeHolder;


    //set get lar ni generatsiya qil xop hozr

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }
}
