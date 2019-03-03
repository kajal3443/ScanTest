package com.example.mojojojo.loginform.database_call;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.mojojojo.loginform.MyParam;
import com.example.mojojojo.loginform.R;
import com.payumoney.core.PayUmoneyConstants;
import com.payumoney.core.PayUmoneySdkInitializer;
import com.payumoney.core.entity.TransactionResponse;
import com.payumoney.sdkui.ui.utils.PayUmoneyFlowManager;
import com.payumoney.sdkui.ui.utils.ResultModel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;

public class PayUMoneyMain {

    MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
    PayUmoneySdkInitializer.PaymentParam paymentParam;
    PayUmoneySdkInitializer.PaymentParam.Builder builder;
//    Context context;

    public void startPaymentFlow(ParamPayUMoney paramPayUMoney, Activity activity) {
        Initializer(paramPayUMoney);
        calculateServerSideHashAndInitiatePayment1(paramPayUMoney);

        PayUmoneyFlowManager.startPayUMoneyFlow(paymentParam,
                activity, R.style.AppTheme_default, false);

//        this.context = activity;
    }

    public MutableLiveData<Boolean> onResult() {
        return mutableLiveData;
    }

    private static final String TAG = "PayUMoneyMain";

    public void onResultActivity(int requestCode, int resultCode, Intent data) {
        if (requestCode == PayUmoneyFlowManager.REQUEST_CODE_PAYMENT && resultCode == RESULT_OK && data != null) {
            TransactionResponse transactionResponse = data.getParcelableExtra(PayUmoneyFlowManager.INTENT_EXTRA_TRANSACTION_RESPONSE);
            ResultModel resultModel = data.getParcelableExtra(PayUmoneyFlowManager.ARG_RESULT);
            if (transactionResponse != null && transactionResponse.getPayuResponse() != null) {

                if (transactionResponse.getTransactionStatus().equals(TransactionResponse.TransactionStatus.SUCCESSFUL)) {
                    mutableLiveData.postValue(true);

                } else {
                    mutableLiveData.postValue(false);

                }

                // Response from Payumoney
                String payuResponse = transactionResponse.getPayuResponse();

                // Response from SURl and FURL
                String merchantResponse = transactionResponse.getTransactionDetails();
            } else if (resultModel != null && resultModel.getError() != null) {
                Log.d(TAG, "Error response : " + resultModel.getError().getTransactionResponse());
            } else {
                Log.d(TAG, "Both objects are null!");
            }
        }
    }


    public void Initializer(ParamPayUMoney paramPayUMoney) {
        builder = new PayUmoneySdkInitializer.PaymentParam.Builder();
        builder.setAmount(paramPayUMoney.getAmount())              // Payment amount
                .setTxnId(paramPayUMoney.getTransactionId())       // Transaction ID
                .setPhone(paramPayUMoney.getPhone())              // User Phone number
                .setProductName(paramPayUMoney.getProductName())  // Product Name or description
                .setFirstName(paramPayUMoney.getFirstName())         // User First name
                .setEmail(paramPayUMoney.getEmail())                     // User Email ID
                .setsUrl(paramPayUMoney.getSurl())                    // Success URL (surl)
                .setfUrl(paramPayUMoney.getFurl())                     //Failure URL (furl)
                .setUdf1(paramPayUMoney.getUdf1())
                .setIsDebug(paramPayUMoney.isDebug())               // Integration environment - true (Debug)/ false(Production)
                .setKey(paramPayUMoney.getMerchantKey())             // Merchant key
                .setMerchantId(paramPayUMoney.getMerchantId());      // Merchant ID
    }

    private void calculateServerSideHashAndInitiatePayment1(ParamPayUMoney paramPayUMoney) {

        try {
            paymentParam = builder.build();
            StringBuilder stringBuilder = new StringBuilder();
            HashMap<String, String> params = paymentParam.getParams();
            stringBuilder.append(params.get(PayUmoneyConstants.KEY) + "|");
            stringBuilder.append(params.get(PayUmoneyConstants.TXNID) + "|");
            stringBuilder.append(params.get(PayUmoneyConstants.AMOUNT) + "|");
            stringBuilder.append(params.get(PayUmoneyConstants.PRODUCT_INFO) + "|");
            stringBuilder.append(params.get(PayUmoneyConstants.FIRSTNAME) + "|");
            stringBuilder.append(params.get(PayUmoneyConstants.EMAIL) + "|");
            stringBuilder.append(params.get(PayUmoneyConstants.UDF1) + "||||||||||");


            stringBuilder.append(ParamPayUMoney.salt);

            String hash = hashCal("SHA-512", stringBuilder.toString());
            paymentParam.setMerchantHash(hash);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void generateHashFromServer() {
        //nextButton.setEnabled(false); // lets not allow the user to click the button again and again.

        HashMap<String, String> params = paymentParam.getParams();

        // lets create the post params
        StringBuffer postParamsBuffer = new StringBuffer();
        postParamsBuffer.append(concatParams(PayUmoneyConstants.KEY, params.get(PayUmoneyConstants.KEY)));
        postParamsBuffer.append(concatParams(PayUmoneyConstants.AMOUNT, params.get(PayUmoneyConstants.AMOUNT)));
        postParamsBuffer.append(concatParams(PayUmoneyConstants.TXNID, params.get(PayUmoneyConstants.TXNID)));
        postParamsBuffer.append(concatParams(PayUmoneyConstants.EMAIL, params.get(PayUmoneyConstants.EMAIL)));
        postParamsBuffer.append(concatParams("productinfo", params.get(PayUmoneyConstants.PRODUCT_INFO)));
        postParamsBuffer.append(concatParams("firstname", params.get(PayUmoneyConstants.FIRSTNAME)));
        postParamsBuffer.append(concatParams(PayUmoneyConstants.UDF1, params.get(PayUmoneyConstants.UDF1)));

        String postParams = postParamsBuffer.charAt(postParamsBuffer.length() - 1) == '&' ? postParamsBuffer.substring(0, postParamsBuffer.length() - 1).toString() : postParamsBuffer.toString();

        // lets make an api call
//        GetHashesFromServerTask getHashesFromServerTask = new GetHashesFromServerTask();
//        getHashesFromServerTask.execute(postParams);
    }

    protected String concatParams(String key, String value) {
        return key + "=" + value + "&";
    }


    public void setHashMapKey(String hashMapKey) {
        if (builder != null) {
            try {
                paymentParam = builder.build();
                paymentParam.setMerchantHash(hashMapKey);
            } catch (Exception e) {
                paymentParam = null;
                e.printStackTrace();
            }
        }
    }

    public String hashCal(String type, String hashString) {
        StringBuilder hash = new StringBuilder();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(type);
            messageDigest.update(hashString.getBytes());
            byte[] mdbytes = messageDigest.digest();
            for (byte hashByte : mdbytes) {
                hash.append(Integer.toString((hashByte & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash.toString();
    }
}
