package uz.bipay.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uz.bipay.R;
import uz.bipay.addition.MySettings;
import uz.bipay.application.MyApplication;
import uz.bipay.data.request.ResetPasswordRequest;
import uz.bipay.data.response.ResetPasswordResponse;

public class SetNewPassword extends Fragment {

    Retrofit retrofit;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_new_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText verificationCode = view.findViewById(R.id.reset_verification);
        EditText newPassword = view.findViewById(R.id.reset_new_password);
        EditText confirmNewPassword = view.findViewById(R.id.confirm_new_password);

        Button resetPassword = view.findViewById(R.id.reset_password_continue_btn);

        String finalVerificationCode = verificationCode.getText().toString();
        String finalNewPassword = newPassword.getText().toString();
        String finalConfirmNewPassword = confirmNewPassword.getText().toString();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalVerificationCode.equals("") || finalNewPassword.equals("") || finalConfirmNewPassword.equals("")){
                    Toast.makeText(getContext(),"Please fill the field",Toast.LENGTH_LONG).show();
                }else{
                    setNewPassword(finalNewPassword,finalConfirmNewPassword,finalConfirmNewPassword);
                }
            }
        });
    }
    private void setNewPassword(String verificationCode, String newPassword, String confirmNewPassword){
        retrofit.create(BiPayPlaceHolderApi.class)
                .resetPasswordRequest(new ResetPasswordRequest(verificationCode,newPassword,confirmNewPassword,"ru"))
                .enqueue(new Callback<ResetPasswordResponse>() {
                    @Override
                    public void onResponse(Call<ResetPasswordResponse> call, Response<ResetPasswordResponse> response) {
                        if (response.isSuccessful()){
                            MySettings.getInstance().setToken(newPassword);
                            Bundle bundle = new Bundle();
                            bundle.putString("New Password",newPassword);
                            Navigation.findNavController(getView()).navigate(R.id.setNewPassword_to_homeFragment,bundle);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResetPasswordResponse> call, Throwable t) {

                    }
                });
    }


}
