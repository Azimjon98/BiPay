package uz.bipay.recyclerView;

public class SpinnerCardItem {
    private String mSpinnerCardName;
    private int mSpinnerCardImage;

    public SpinnerCardItem(String spinnerCardName, int spinnerCardImage) {
        mSpinnerCardName = spinnerCardName;
        mSpinnerCardImage = spinnerCardImage;
    }

    public String getSpinnerCardName(){
        return mSpinnerCardName;
    }

    public int getSpinnerCardImage(){
        return mSpinnerCardImage;
    }
}
