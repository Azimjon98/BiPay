package uz.bipay.ui.fragment;

import android.content.Context;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.readystatesoftware.chuck.internal.ui.MainActivity;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uz.bipay.R;
import uz.bipay.addition.MySettings;
import uz.bipay.application.MyApplication;
import uz.bipay.data.model.RegistrationRequest;
import uz.bipay.data.model.VerificationRequest;
import uz.bipay.data.model.response.RegistrationResponse;
import uz.bipay.data.model.response.VerificationResponse;

public class VerificationFragment extends Fragment {
    TextView timer;
    Retrofit retrofit;
    String phone = "";
    String code = "";


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            retrofit = MyApplication.getInstance().getMyApplicationComponent().getRetrofitApp();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey("phone")) {
            phone = getArguments().getString("phone");
        }else{
            Navigation.findNavController(requireView()).popBackStack();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_verification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText inputCode1 = view.findViewById(R.id.ver_code1);
        EditText inputCode2 = view.findViewById(R.id.ver_code2);
        EditText inputCode3 = view.findViewById(R.id.ver_code3);
        EditText inputCode4 = view.findViewById(R.id.ver_code4);
        EditText inputCode5 = view.findViewById(R.id.ver_code5);

        NavController navController = Navigation.findNavController(view);

        Button verification = view.findViewById(R.id.ver_continue_btn);

        TextView verResend = view.findViewById(R.id.ver_resend_btn);
        String verText = "Resend";
        SpannableString spannableString = new SpannableString(verText);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getContext(), "Please enter Phone number correctly", Toast.LENGTH_LONG).show();
                requestCode(phone);
            }
        };
        spannableString.setSpan(clickableSpan, 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        verResend.setText(spannableString);
        verResend.setMovementMethod(LinkMovementMethod.getInstance());
        TextView timer = view.findViewById(R.id.timer_view);

        long duration = TimeUnit.MINUTES.toMillis(2);

        new CountDownTimer(duration,2000){

            @Override
            public void onTick(long millisUntilFinished) {
                String sDuration = String.format(Locale.ENGLISH,"%02d : %02d"
                        ,TimeUnit.MILLISECONDS.toMinutes(2)
                        ,TimeUnit.MILLISECONDS.toSeconds(2)
                        , TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(2)));
                timer.setText(sDuration);
            }

            @Override
            public void onFinish() {
                        timer.setVisibility(View.INVISIBLE);
                        verResend.setVisibility(View.VISIBLE);
            }
        };

        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String finalInputCode1 = inputCode1.getText().toString();
                String finalInputCode2 = inputCode2.getText().toString();
                String finalInputCode3 = inputCode3.getText().toString();
                String finalInputCode4 = inputCode4.getText().toString();
                String finalInputCode5 = inputCode5.getText().toString();

                String allVerificationCode = finalInputCode1 + finalInputCode2 + finalInputCode3 + finalInputCode4 + finalInputCode5;

                if (finalInputCode1.equals("") || finalInputCode2.equals("") || finalInputCode3.equals("") || finalInputCode4.equals("")) {
                    Toast.makeText(getContext(), "Verification Code is Blank", Toast.LENGTH_LONG).show();
                } else {
                    verificationCode(allVerificationCode);
                }
            }
        });
    }

    private void verificationCode(String verificationCode) {
        retrofit.create(BiPayPlaceHolderApi.class)
                .verificationRequest(new VerificationRequest(phone, verificationCode, "ru"))
                .enqueue(new Callback<VerificationResponse>() {
                    @Override
                    public void onResponse(Call<VerificationResponse> call, Response<VerificationResponse> response) {
                        if (response.isSuccessful()) {
                            MySettings.getInstance().setToken(verificationCode);
                            Bundle bundle = new Bundle();
                            bundle.putString("Verification Code", verificationCode);
                            Navigation.findNavController(requireView()).navigate(R.id.verificationFragment_to_setPasswordFragment, bundle);
                        }

                    }

                    @Override
                    public void onFailure(Call<VerificationResponse> call, Throwable t) {

                    }
                });
    }

    private void requestCode(String phone) {
        retrofit.create(BiPayPlaceHolderApi.class)
                .registarationRequest(new RegistrationRequest(phone, "123456", "ru"))
                .enqueue(new Callback<RegistrationResponse>() {
                    @Override
                    public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                        if (response.isSuccessful()) {
                            MySettings.getInstance().setPhone(phone);
                            Bundle bundle = new Bundle();
                            bundle.putString("phone", phone);

                        }
                    }

                    @Override
                    public void onFailure(Call<RegistrationResponse> call, Throwable t) {

                    }
                });
    }
}
