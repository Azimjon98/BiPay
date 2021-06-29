package uz.bipay.ui.fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import uz.bipay.data.model.PaymentServiceModel;
import uz.bipay.data.request.LoginRequest;
import uz.bipay.data.request.RegistrationRequest;
import uz.bipay.data.request.ResetPasswordRequest;
import uz.bipay.data.request.SetPasswordRequest;
import uz.bipay.data.request.VerificationRequest;
import uz.bipay.data.response.LoginResponse;
import uz.bipay.data.response.RegistrationResponse;
import uz.bipay.data.response.ResetPasswordResponse;
import uz.bipay.data.response.SetPasswordResponse;
import uz.bipay.data.response.VerificationResponse;
import uz.bipay.module.CardModule;

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
    //@POST("app/create-applications")
   // Call<PaymentResponseServices> paymentRequest(@Body PaymentRequest body);

    @GET("/additional/payment-service")
    public Call<List<PaymentServiceModel>> getpaymentServices ();


    //request da hech narsa bumidi degani metod ichida hech narsa bumid
//buldi shunaqa qib ishlatasan
    //response keladimi endib boldimi? shu respose


    Call<CardModule> services();
}
