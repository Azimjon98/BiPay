package uz.bipay.recyclerView;

public class ReserveCardItem {

    private int reserveCardImage;
    private String reserveCardName;
    private String reserveMoney;

    public ReserveCardItem(int reserveCardImage, String reserveCardName, String reserveMoney) {
        this.reserveCardImage = reserveCardImage;
        this.reserveCardName = reserveCardName;
        this.reserveMoney = reserveMoney;
    }

    public int getReserveCardImage() {
        return reserveCardImage;
    }

    public String getReserveCardName(){
        return reserveCardName;
    }

    public String getReserveMoney(){
        return reserveMoney;
    }
}
