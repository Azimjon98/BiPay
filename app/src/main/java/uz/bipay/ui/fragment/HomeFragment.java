package uz.bipay.ui.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import uz.bipay.Adapter.CardAdapter;
import uz.bipay.R;
import uz.bipay.recyclerView.CardItem;


public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;

    // TODO: Rename and change types of parameters


    public HomeFragment() {
        // Required empty public constructor

    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView cardRecyclerView;
    private RecyclerView.Adapter cardAdapter;
    private RecyclerView.LayoutManager cardLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<CardItem> cardList = new ArrayList<>();
        cardList.add(new CardItem(R.drawable.uzcard,"UzCard"));
        cardList.add(new CardItem(R.drawable.humo,"HUMO"));
        cardList.add(new CardItem(R.drawable.click,"Click UZS"));
        cardList.add(new CardItem(R.drawable.webmoney,"WebMoney RUB"));
        cardList.add(new CardItem(R.drawable.webmoney,"WebMoney USD"));
        cardList.add(new CardItem(R.drawable.qiwi,"Qiwi RUB"));
        cardList.add(new CardItem(R.drawable.yandex,"Yandex RUB"));
        cardList.add(new CardItem(R.drawable.beeline,"Beeline 1000 MB UZS"));
        cardList.add(new CardItem(R.drawable.paynet,"Paynet UZS"));
        cardList.add(new CardItem(R.drawable.payme,"Payme UZS"));


        cardRecyclerView = view.findViewById(R.id.recyclerview_card);
        cardLayoutManager = new LinearLayoutManager(getContext());
        cardRecyclerView.setHasFixedSize(true);
        cardAdapter = new CardAdapter(cardList);
        cardRecyclerView.setLayoutManager(cardLayoutManager);
        cardRecyclerView.setAdapter(cardAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,a
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}