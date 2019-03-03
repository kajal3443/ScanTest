package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.mojojojo.loginform.database_call.NetworkCall;
import com.example.mojojojo.loginform.database_call.jsn;
import com.example.mojojojo.loginform.model.OrderDetails;
import com.example.mojojojo.loginform.model.Product;

import org.json.JSONObject;

import java.util.HashMap;

import static com.example.mojojojo.loginform.MyParam.userEmail;

public class CashConfirm extends AppCompatActivity {

    TextView cashid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_confirm);

        cashid=(TextView)findViewById(R.id.cashid);
    }
}
//        public void saveOrder() {
//
//            for (Object o : MyParam.listCart) {
//                Product product = (Product) o;
//
//                OrderDetails orderDetails = new OrderDetails();
//                orderDetails.setOrder_amount(product.getProduct_price());
//                orderDetails.setProduct_id(product.getProduct_id());
//                orderDetails.setUser_id(MyParam.userEmail);
//
//                HashMap<String, String> map = new HashMap<>();
//                map = jsn.getMapForModel(orderDetails, "save");
//                map.put("table", "order_details");
//                Log.e("Order", "saveOrder: "+map.toString());
//
//                NetworkCall.call(map).setDataResponseListener(new NetworkCall.SetDataResponse() {
//                    @Override
//                    public void setResponse(String responseStr) {
//                        if (jsn.checkResponseStr(responseStr)) {
//                            JSONObject jsonObjectAt0 = jsn.getJSONObjectAt0(responseStr);
//                            String orderId=jsn.getJSONString(jsonObjectAt0,"id");
//                            sendMail(MyParam.userEmail,orderId);
//                        }
//                    }
//                });
//
//
//            }
//
//        }
//
//
//
//
//    private void sendMail(String userEmail, String orderId) {
//        HashMap<String, String> param=new HashMap<>();
//        param.put("type","saveOrderMail");
//        param.put("Order_id",orderId);
//        param.put("email",userEmail);
//
//        //Log.e(TAG, "sendMail: "+ param.toString());
//        NetworkCall.call(param).setDataResponseListener(new NetworkCall.SetDataResponse() {
//            @Override
//            public void setResponse(String responseStr) {
//                //Log.e(TAG, "setResponse: "+responseStr );
//            }
//        });
//    }
//}