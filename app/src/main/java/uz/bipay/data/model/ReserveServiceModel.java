package uz.bipay.data.model;

import java.io.Serializable;
import java.util.List;

public class ReserveServiceModel implements Serializable {
    private int tariffId;
    private String fromLogo;
    private int fromPaymentId;
    private String fromPaymentName;
    private int fromPrice;
    private int fromCurrencyId;
    private String fromCurrencyName;
    private String fromPaymentPlaceHolder;
    private String fromPaymentCode;
    private int toPaymentId;
    private String toLogo;
    private String toPaymentName;
    private int toPrice;
    private int toCurrencyId;
    private String toCurrencyName;
    private String toPaymentPlaceHolder;
    private String toPaymentCode;
    private int reserve;
    private String reserveCurrency;
    private List<String> attention;

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public String getFromLogo() {
        return fromLogo;
    }

    public void setFromLogo(String fromLogo) {
        this.fromLogo = fromLogo;
    }

    public int getFromPaymentId() {
        return fromPaymentId;
    }

    public void setFromPaymentId(int fromPaymentId) {
        this.fromPaymentId = fromPaymentId;
    }

    public String getFromPaymentName() {
        return fromPaymentName;
    }

    public void setFromPaymentName(String fromPaymentName) {
        this.fromPaymentName = fromPaymentName;
    }

    public int getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(int fromPrice) {
        this.fromPrice = fromPrice;
    }

    public int getFromCurrencyId() {
        return fromCurrencyId;
    }

    public void setFromCurrencyId(int fromCurrencyId) {
        this.fromCurrencyId = fromCurrencyId;
    }

    public String getFromCurrencyName() {
        return fromCurrencyName;
    }

    public void setFromCurrencyName(String fromCurrencyName) {
        this.fromCurrencyName = fromCurrencyName;
    }

    public String getFromPaymentPlaceHolder() {
        return fromPaymentPlaceHolder;
    }

    public void setFromPaymentPlaceHolder(String fromPaymentPlaceHolder) {
        this.fromPaymentPlaceHolder = fromPaymentPlaceHolder;
    }

    public String getFromPaymentCode() {
        return fromPaymentCode;
    }

    public void setFromPaymentCode(String fromPaymentCode) {
        this.fromPaymentCode = fromPaymentCode;
    }

    public int getToPaymentId() {
        return toPaymentId;
    }

    public void setToPaymentId(int toPaymentId) {
        this.toPaymentId = toPaymentId;
    }

    public String getToLogo() {
        return toLogo;
    }

    public void setToLogo(String toLogo) {
        this.toLogo = toLogo;
    }

    public String getToPaymentName() {
        return toPaymentName;
    }

    public void setToPaymentName(String toPaymentName) {
        this.toPaymentName = toPaymentName;
    }

    public int getToPrice() {
        return toPrice;
    }

    public void setToPrice(int toPrice) {
        this.toPrice = toPrice;
    }

    public int getToCurrencyId() {
        return toCurrencyId;
    }

    public void setToCurrencyId(int toCurrencyId) {
        this.toCurrencyId = toCurrencyId;
    }

    public String getToCurrencyName() {
        return toCurrencyName;
    }

    public void setToCurrencyName(String toCurrencyName) {
        this.toCurrencyName = toCurrencyName;
    }

    public String getToPaymentPlaceHolder() {
        return toPaymentPlaceHolder;
    }

    public void setToPaymentPlaceHolder(String toPaymentPlaceHolder) {
        this.toPaymentPlaceHolder = toPaymentPlaceHolder;
    }

    public String getToPaymentCode() {
        return toPaymentCode;
    }

    public void setToPaymentCode(String toPaymentCode) {
        this.toPaymentCode = toPaymentCode;
    }

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public String getReserveCurrency() {
        return reserveCurrency;
    }

    public void setReserveCurrency(String reserveCurrency) {
        this.reserveCurrency = reserveCurrency;
    }

    public List<String> getAttention() {
        return attention;
    }

    public void setAttention(List<String> attention) {
        this.attention = attention;
    }

    @Override
    public String toString() {
        return "ReserveServiceModel{" +
                "tariffId=" + tariffId +
                ", fromLogo='" + fromLogo + '\'' +
                ", fromPaymentId=" + fromPaymentId +
                ", fromPaymentName='" + fromPaymentName + '\'' +
                ", fromPrice=" + fromPrice +
                ", fromCurrencyId=" + fromCurrencyId +
                ", fromCurrencyName='" + fromCurrencyName + '\'' +
                ", fromPaymentPlaceHolder='" + fromPaymentPlaceHolder + '\'' +
                ", fromPaymentCode='" + fromPaymentCode + '\'' +
                ", toPaymentId=" + toPaymentId +
                ", toLogo='" + toLogo + '\'' +
                ", toPaymentName='" + toPaymentName + '\'' +
                ", toPrice=" + toPrice +
                ", toCurrencyId=" + toCurrencyId +
                ", toCurrencyName='" + toCurrencyName + '\'' +
                ", toPaymentPlaceHolder='" + toPaymentPlaceHolder + '\'' +
                ", toPaymentCode='" + toPaymentCode + '\'' +
                ", reserve=" + reserve +
                ", reserveCurrency='" + reserveCurrency + '\'' +
                ", attention=" + attention +
                '}';
    }
}
