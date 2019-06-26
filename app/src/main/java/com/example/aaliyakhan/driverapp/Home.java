package com.example.aaliyakhan.driverapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ListView listView;
    String url = "http://100.126.225.143:8888/location.php";
    ArrayList <OrderData>list=new ArrayList<OrderData>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Orders");
        listView = findViewById(R.id.listview);
        listView.setAdapter(new ListAdapter(Home.this, ConstantsData.list));
        retrieveData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                startActivity(new Intent(Home.this,Profile.class));
                break;
            case R.id.help:
                startActivity(new Intent(Home.this,Help.class));
                break;
            default:
                break;
        }
        return true;
    }

    private void retrieveData() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url,new JSONArray(),
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonobject = response.getJSONObject(i);
                                String code = jsonobject.getString("code");
                                //String from_address = jsonobject.getString("from_address");
                                String to_address = jsonobject.getString("to_address");
                                ConstantsData.list.add(new OrderData(code,to_address));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        });
        queue.add(jsonObjectRequest);
    }


}

