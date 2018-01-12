package tw.com.shiaoshia.ex2018011201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click01(View v) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new StringRequest("http://data.ntpc.gov.tw/od/data/api/BF90FA7E-C358-4CDA-B579-B6C84ADC96A1?$format=json",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NET",response);

                        try {
                            JSONArray array = new JSONArray(response);
                            JSONObject obj = array.getJSONObject(0);
                            String str = obj.getString("district");
                            Log.d("NET",response);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);
        requestQueue.start();
    }
}
