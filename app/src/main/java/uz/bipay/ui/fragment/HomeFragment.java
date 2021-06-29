package uz.bipay.ui.fragment;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uz.bipay.Adapter.CardAdapter;
import uz.bipay.Adapter.ReserveCardAdapter;
import uz.bipay.MainActivity;
import uz.bipay.R;
import uz.bipay.application.MyApplication;
import uz.bipay.data.model.PaymentServiceModel;
import uz.bipay.module.CardModule;
import uz.bipay.recyclerView.CardItem;
import uz.bipay.recyclerView.ReserveCardItem;

public class HomeFragment extends Fragment {

    private RecyclerView cardRecyclerView;
    //adapterni aniq etda
    private CardAdapter cardAdapter;
    private RecyclerView.LayoutManager cardLayoutManager;
    private RecyclerView reserveCardRecyclerView;
    private ReserveCardAdapter reserveCardAdapter;
    private RecyclerView.LayoutManager reserveCardLayoutManager;

    private BiPayPlaceHolderApi api;
    private PaymentServiceModel paymentServiceModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            api =  MyApplication.getInstance()
                    .getMyApplicationComponent()
                    .getRetrofitApp()
                    .create(BiPayPlaceHolderApi.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        cardLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        cardRecyclerView.setHasFixedSize(true);
        cardAdapter = new CardAdapter(getContext(),new ArrayList<PaymentServiceModel>());
        cardRecyclerView.setLayoutManager(cardLayoutManager);
        cardRecyclerView.setAdapter(cardAdapter);
        

        reserveCardRecyclerView = view.findViewById(R.id.recyclerview_reserve);
        reserveCardLayoutManager = new LinearLayoutManager(getContext());
        reserveCardRecyclerView.setHasFixedSize(true);
        reserveCardAdapter = new ReserveCardAdapter(reserveCardList);
        reserveCardRecyclerView.setLayoutManager(reserveCardLayoutManager);
        reserveCardRecyclerView.setAdapter(reserveCardAdapter);

        //bulldi api ni ishlatasan

        api.getpaymentServices().enqueue(new Callback<List<PaymentServiceModel>>() {
            @Override
            public void onResponse(Call<List<PaymentServiceModel>> call, Response<List<PaymentServiceModel>> response) {
                //bu yerda agar response kesa nimadr yozasan adapterga qiymat berasan masalan
                //sanga service model emas service model listi kelobtiku
                // shularni hammasini san yozgandin)))
                //buldi davom ettir man kettim endi nmasini qilish kere hozr id bilan recyclerviewdagi har bitta cardni tanidimi?
                //ha id si bilan ishlatasan birinchi shularni listga chiqarchi qani ??? qaysi listga chiqaraman postmandagini run qilganda chiqishi keremi

                if (response.isSuccessful() || response.body() != null ){
                  cardAdapter.addItems(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<PaymentServiceModel>> call, Throwable t) {

            }
        });



    }

}
