package uz.bipay.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PaymentResponseServices implements Serializable {
    @Expose
    @SerializedName("status")
    String payment;
    @Expose
    @SerializedName("status")
    String paymentSumma;
}
