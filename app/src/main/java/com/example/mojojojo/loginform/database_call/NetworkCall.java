package com.example.mojojojo.loginform.database_call;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall {

    private SetDataResponse setDataRes;
    private static HashMap<String, String> parameters;
    private String responseString = "";

    private boolean isTaskKilled = false;

    public static String SERVER_URL_WEBSERVICE_API = "http://proglan.in/techmicra/scanandshop/scan_and_shop.php";
    private static final String TAG = "NetworkCall";


    public static NetworkCall call(HashMap<String, String> parameters) {
        NetworkCall call = new NetworkCall();
        NetworkCall.parameters = parameters;
        call.performPostCall();
        return call;
    }


    private void performPostCall() {
        Call<Object> call = RestClient.getClient().getResponse(SERVER_URL_WEBSERVICE_API,
                parameters);

        call.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
                if (response.isSuccessful()) {
                    responseString = RestClient.getGSONBuilder().toJson(response.body());
                } else {
                    responseString = "";
                }
                setDataRes.setResponse(responseString);
                Log.e(TAG, "onResponse: "+ responseString);
            }
            @Override
            public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                responseString = "";
                setDataRes.setResponse(responseString);
            }

        });
    }



    public interface SetDataResponse {
        void setResponse(String responseStr);
    }

    public void setDataResponseListener(SetDataResponse setDataRes) {
        this.setDataRes = setDataRes;
    }

}
