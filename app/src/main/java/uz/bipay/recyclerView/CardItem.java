package uz.bipay.recyclerView;

public class CardItem {

    private int cardImage;
    private String cardName;

    public CardItem(int cardImage, String cardName) {
        this.cardImage = cardImage;
        this.cardName = cardName;
    }

    public int getCardImage() {
        return cardImage;
    }

    public String getCardName(){
        return cardName;
    }
}
