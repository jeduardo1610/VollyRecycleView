package com.example.m14x.vollyrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.m14x.vollyrecycleview.Adapter.MyAdapter;
import com.example.m14x.vollyrecycleview.Model.ObjectDescription;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String mssg;

    private List<ObjectDescription> data = new ArrayList<ObjectDescription>();
    public List<ObjectDescription> pojo = new ArrayList<ObjectDescription>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayoutManager = new LinearLayoutManager(this);

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView = (RecyclerView) findViewById(R.id.RV);
        mRecyclerView.setHasFixedSize(true);
        //using the layout manager

        data = sendRequest();
        mAdapter = new MyAdapter(data);
        mRecyclerView.setAdapter(mAdapter);




    }

    public List<ObjectDescription> sendRequest(){
        String url = "http://itunes.apple.com/search?term=rock";

// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        //System.out.println(response.toString());
                        mssg = response.toString();


                        try {
                            JSONObject mObject = new JSONObject(response);
                            JSONArray jsonArray = mObject.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                ObjectDescription od = new ObjectDescription();
                                JSONObject row = jsonArray.getJSONObject(i);
                                Log.d("JEPB", row.toString());
                                od.setArtistId(row.getInt("artistId"));
                                od.setArtistName(row.getString("artistName"));
                                od.setCollectionId(row.getInt("collectionId"));
                                od.setCollectionName(row.getString("collectionName"));
                                od.setKind(row.getString("kind"));
                                od.setTrackId(row.getInt("trackId"));
                                od.setWrapperType(row.getString("wrapperType"));
                                pojo.add(od);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //aqui se pierden los datos



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
        return pojo;
    }

}
