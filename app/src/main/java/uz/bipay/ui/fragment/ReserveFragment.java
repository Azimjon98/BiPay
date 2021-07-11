package uz.bipay.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uz.bipay.Adapter.ReserveCardAdapter;
import uz.bipay.R;
import uz.bipay.application.MyApplication;
import uz.bipay.data.model.PaymentServiceModel;
import uz.bipay.data.model.ReserveServiceModel;
import uz.bipay.data.request.ReservedCardRequest;
import uz.bipay.recyclerView.ReserveCardItem;
import retrofit2.Retrofit;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReserveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReserveFragment extends Fragment {

    private RecyclerView reserveCardRecyclerView;
    private ReserveCardAdapter reserveCardAdapter;
    private RecyclerView.LayoutManager reserveCardLayoutManager;
    private BiPayPlaceHolderApi api;

    ImageView selectedCardLogo,reservedToLogo;
    TextView selectedCardName,reservedPaymentName,reservedToMoney;


    public ReserveFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ReserveFragment newInstance(String param1, String param2) {
        ReserveFragment fragment = new ReserveFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        return inflater.inflate(R.layout.fragment_reserve, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        reservedPaymentName = view.findViewById(R.id.reservedCardName);
        reservedToMoney = view.findViewById(R.id.reservedMoney);
        reservedToLogo = view.findViewById(R.id.reservedCardImage);

        ArrayList<ReserveServiceModel> reserveCardList = new ArrayList<>();

        reserveCardRecyclerView = view.findViewById(R.id.recycleview_reservedMoney);
        reserveCardLayoutManager = new LinearLayoutManager(getContext());
        reserveCardRecyclerView.setHasFixedSize(true);
        reserveCardAdapter = new ReserveCardAdapter(getContext(),new ArrayList<ReserveServiceModel>());
        reserveCardRecyclerView.setLayoutManager(reserveCardLayoutManager);
        reserveCardRecyclerView.setAdapter(reserveCardAdapter);

        selectedCardLogo = view.findViewById(R.id.selected_reservedCardImage);
        selectedCardName = view.findViewById(R.id.selected_reservedCardName);

        if (getArguments() != null && getArguments().containsKey("id")){
            Integer id =getArguments().getInt("id");

            api.getreserveService(id).enqueue(new Callback<List<ReserveServiceModel>>() {
                @Override
                public void onResponse(Call<List<ReserveServiceModel>> call, Response<List<ReserveServiceModel>> response) {
                    if(response.isSuccessful() || response.body() != null){
                        reserveCardAdapter.addItems(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<ReserveServiceModel>> call, Throwable t) {

                }
            });
        }

        if(getArguments() != null && getArguments().containsKey("name")){
            String name = getArguments().getString("name");
            selectedCardName.setText(name);
        }

        if (getArguments() != null && getArguments().containsKey("logo")){
            String logo = getArguments().getString("logo");
            Glide.with(this)
                    .load(logo)
                    .into(selectedCardLogo);
        }

    }

}