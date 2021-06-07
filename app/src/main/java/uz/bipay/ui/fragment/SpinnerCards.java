package uz.bipay.ui.fragment;

public class SpinnerCards {
    private String mSpinnerCardName;
    private int mSpinnerCardImage;

    public SpinnerCards(String spinnerCardName, int spinnerCardImage){
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
