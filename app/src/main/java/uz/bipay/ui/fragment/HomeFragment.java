package uz.bipay.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

import uz.bipay.Adapter.CardAdapter;
import uz.bipay.Adapter.ReserveCardAdapter;
import uz.bipay.R;
import uz.bipay.recyclerView.CardItem;
import uz.bipay.recyclerView.ReserveCardItem;


public class HomeFragment<onViewCreated> extends Fragment {

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

    private final int ID_HOME = 1;
    private final int ID_HISTORY = 2;
    private final int ID_CARDS = 3;
    private final int ID_NOTIFICATIONS = 4;

    SNavigationDrawer sNavigationDrawer;
    Class aClass;

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
        cardLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        cardRecyclerView.setHasFixedSize(true);
        cardAdapter = new CardAdapter(cardList);
        cardRecyclerView.setLayoutManager(cardLayoutManager);
        cardRecyclerView.setAdapter(cardAdapter);

        reserveCardRecyclerView = view.findViewById(R.id.recyclerview_reserve);
        reserveCardLayoutManager = new LinearLayoutManager(getContext());
        reserveCardRecyclerView.setHasFixedSize(true);
        reserveCardAdapter = new ReserveCardAdapter(reserveCardList);
        reserveCardRecyclerView.setLayoutManager(reserveCardLayoutManager);
        reserveCardRecyclerView.setAdapter(reserveCardAdapter);

        MeowBottomNavigation bottomNavigation = view.findViewById(R.id.bottomNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.home_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HISTORY,R.drawable.history_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_CARDS,R.drawable.cards_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATIONS,R.drawable.notifications_icon));

        bottomNavigation.setOnClickMenuListener(model -> {
            return null;
        });

        bottomNavigation.setOnShowListener(model -> {
            String name;

                switch (model.getId()){
                    case ID_HOME: name = "Home";
                    break;

                    case ID_HISTORY: name = "History";
                    break;

                    case ID_CARDS: name = "Cards";
                    break;

                    case ID_NOTIFICATIONS: name = "Notifications";
                    break;

                    default: name = "";
                }
                return null;
        });

        bottomNavigation.setCount(ID_NOTIFICATIONS,"4");
        bottomNavigation.show(ID_HOME,true);

        //Assign vaariable of drawer menu
        sNavigationDrawer = view.findViewById(R.id.headline_icon);

        //Initialize menu item list
        List<MenuItem> itemList = new ArrayList<>();
        //Add menu item in list
        itemList.add(new MenuItem("Exchange",R.drawable.cards_icon));
        itemList.add(new MenuItem("Tariffs",R.drawable.tariffs_icon));
        itemList.add(new MenuItem("News",R.drawable.speaker_icon));
        itemList.add(new MenuItem("Chat",R.drawable.chat_icon));
        itemList.add(new MenuItem("Info",R.drawable.info_icon));
        //set menu item list
        sNavigationDrawer.setMenuItemList(itemList);

        //set default title
        sNavigationDrawer.setAppbarTitleTV("Exchange");

        //set default fragment
        aClass = ExchangeFragment.class;

        //open fragment
        openFragment();

        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                switch (position){
                    case 0:
                        aClass = ExchangeFragment.class;
                        break;
                    case 1:


                }
            }
        });

        sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {
                openFragment();
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void openFragment() {
        try {
            //Initialize fragment
            Fragment fragment  = (Fragment) aClass.newInstance();
            //open fragment
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .replace(R.id.exchange_fragment,fragment) //check fragment
                    .commit();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void getSupportFragmentManager() {
    }


}