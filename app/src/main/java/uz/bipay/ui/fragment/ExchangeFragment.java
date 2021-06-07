package uz.bipay.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import uz.bipay.Adapter.CardAdapter;
import uz.bipay.Adapter.SpinnerCardAdapter;
import uz.bipay.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExchangeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExchangeFragment extends Fragment {

    private ArrayList<SpinnerCards> mSpinnerCardList;
    private SpinnerCardAdapter mSpinnerAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExchangeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExchangeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExchangeFragment newInstance(String param1, String param2) {
        ExchangeFragment fragment = new ExchangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exchange, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList();

        Spinner spinnerCards = (Spinner) view.findViewById(R.id.spinner);

        mSpinnerAdapter = new SpinnerCardAdapter(this,mSpinnerCardList);
        spinnerCards.setAdapter(mSpinnerAdapter);

        spinnerCards.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerCards clickedSpinnerItem = (SpinnerCards) parent.getItemAtPosition(position);
                String clickedSpinnerCardName = clickedSpinnerItem.getSpinnerCardName();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initList(){
        mSpinnerCardList = new ArrayList<>();
        mSpinnerCardList.add(new SpinnerCards("Uzcard",R.drawable.uzcard));
        mSpinnerCardList.add(new SpinnerCards("HUMO",R.drawable.humo));
        mSpinnerCardList.add(new SpinnerCards("Click UZS",R.drawable.click));
        mSpinnerCardList.add(new SpinnerCards("WebMoney RUB",R.drawable.webmoney));
        mSpinnerCardList.add(new SpinnerCards("WebMoney USD",R.drawable.webmoney));
        mSpinnerCardList.add(new SpinnerCards("Qiwi RUB",R.drawable.qiwi));
        mSpinnerCardList.add(new SpinnerCards("Yandex RUB",R.drawable.yandex));
        mSpinnerCardList.add(new SpinnerCards("Beeline 1000 MB UZS",R.drawable.beeline));
        mSpinnerCardList.add(new SpinnerCards("Paynet UZS",R.drawable.paynet));
        mSpinnerCardList.add(new SpinnerCards("Payme UZS",R.drawable.payme));
    }
}