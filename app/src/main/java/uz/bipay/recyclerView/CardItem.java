package uz.bipay.recyclerView;

public class CardItem {

    private int cardImage;
    private String cardName;

    public CardItem(int cardImage, String cardName) {
        cardImage = cardImage;
        cardName = cardName;
    }

    public int getCardImage() {
        return cardImage;
    }

    public String getCardName(){
        return cardName;
    }
}
