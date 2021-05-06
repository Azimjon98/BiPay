package uz.bipay.ui.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import uz.bipay.recyclerView.ReserveCardItem;


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
    private RecyclerView reserveCardRecyclerView;
    private RecyclerView.Adapter reserveCardAdapter;
    private RecyclerView.LayoutManager reserveCardLayoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


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

        ArrayList<ReserveCardItem> reserveCardList = new ArrayList<>();
        reserveCardList.add(new ReserveCardItem(R.drawable.uzcard,"UzCard","3000"));
        reserveCardList.add(new ReserveCardItem(R.drawable.humo,"HUMO","5000"));
        reserveCardList.add(new ReserveCardItem(R.drawable.click,"Click UZS","3000"));
        reserveCardList.add(new ReserveCardItem(R.drawable.webmoney,"WebMoney RUB","5000"));
        reserveCardList.add(new ReserveCardItem(R.drawable.webmoney,"WebMoney USD","4000"));
        reserveCardList.add(new ReserveCardItem(R.drawable.qiwi,"Qiwi RUB","2500"));
        reserveCardList.add(new ReserveCardItem(R.drawable.yandex,"Yandex RUB","3500"));
        reserveCardList.add(new ReserveCardItem(R.drawable.beeline,"Beeline 1000 MB UZS","4500"));
        reserveCardList.add(new ReserveCardItem(R.drawable.paynet,"Paynet UZS","4300"));
        reserveCardList.add(new ReserveCardItem(R.drawable.payme,"Payme UZS","5000"));



        cardRecyclerView = view.findViewById(R.id.recyclerview_card);
        cardLayoutManager = new LinearLayoutManager(getContext());
        cardRecyclerView.setHasFixedSize(true);
        cardAdapter = new CardAdapter(cardList);
        cardRecyclerView.setLayoutManager(cardLayoutManager);
        cardRecyclerView.setAdapter(cardAdapter);

        reserveCardRecyclerView = view.findViewById(R.id.recyclerview_reserve);
        reserveCardLayoutManager = new LinearLayoutManager(getContext());
        reserveCardRecyclerView.setHasFixedSize(true);
        reserveCardAdapter = new CardAdapter(cardList);
        reserveCardRecyclerView.setLayoutManager(reserveCardLayoutManager);
        reserveCardRecyclerView.setAdapter(reserveCardAdapter);



    }
}