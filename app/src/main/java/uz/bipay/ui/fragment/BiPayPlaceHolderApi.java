package uz.bipay.ui.fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import uz.bipay.data.model.LoginRequest;
import uz.bipay.data.model.RegistrationRequest;
import uz.bipay.data.model.ResetPasswordRequest;
import uz.bipay.data.model.SetPasswordRequest;
import uz.bipay.data.model.VerificationRequest;
import uz.bipay.data.model.response.LoginResponse;
import uz.bipay.data.model.response.RegistrationResponse;
import uz.bipay.data.model.response.ResetPasswordResponse;
import uz.bipay.data.model.response.SetPasswordResponse;
import uz.bipay.data.model.response.VerificationResponse;

public interface BiPayPlaceHolderApi {
    @POST("login/registration")
    Call<RegistrationResponse> registarationRequest(@Body RegistrationRequest body);
    @POST("login/send-code")
    Call<VerificationResponse>verificationRequest(@Body VerificationRequest body);
    @POST("login/password")
    Call<SetPasswordResponse>setPasswordRequest(@Body SetPasswordRequest body);
    @POST("login/registration")
    Call<LoginResponse> loginRequest(@Body LoginRequest body);
    @POST("login/reset-password")
    Call<ResetPasswordResponse>resetPasswordRequest(@Body ResetPasswordRequest body);
}
