package uz.bipay.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;

import uz.bipay.R;
import uz.bipay.ui.fragment.ExchangeFragment;
import uz.bipay.ui.fragment.SpinnerCards;

public class SpinnerCardAdapter extends ArrayAdapter<SpinnerCards> {
    public SpinnerCardAdapter(ExchangeFragment context, ArrayList<SpinnerCards> spinnerCardsList) {
        super (context,0,spinnerCardsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView,parent);
    }

    private View initView (int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_spinner_row,parent,false);
        }
        ImageView imageViewSpinnerCard = convertView.findViewById(R.id.spinner_image_view);
        TextView textViewSpinnerCardName = convertView.findViewById(R.id.spinner_cardName);

        SpinnerCards currentSpinnerCardItem = getItem(position);

        if(currentSpinnerCardItem != null) {
            imageViewSpinnerCard.setImageResource(currentSpinnerCardItem.getSpinnerCardImage());
            textViewSpinnerCardName.setText(currentSpinnerCardItem.getSpinnerCardName());
        }

        return convertView;
    }
}
