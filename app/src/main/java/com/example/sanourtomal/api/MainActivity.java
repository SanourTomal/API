package com.example.sanourtomal.api;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model>models;
    ListView listView;
    CustomAdapter adapter;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();


        new GetCourses().execute();
    }


    private void initialize() {
       models= new ArrayList<Model>();
       listView=(ListView)findViewById(R.id.list);

    }

    private class GetCourses extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            models = new ArrayList<Model>();
            JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, "https://api.teachflex.inov.io/explore" , null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                JSONArray courses = response.getJSONArray("courses");
                                for(int i =0 ;i<courses.length();i++){
                                    JSONObject rs = courses.getJSONObject(i);
                                    String _id = rs.getString("_id");
                                    String title = rs.getString("title");
                                    String createdAt = rs.getString("createdAt");
                                    String updatedAt = rs.getString("updatedAt");
                                    String subject = rs.getString("subject");
                                    String board = rs.getString("board");

                                    Model model = new Model(subject,_id,updatedAt,createdAt,title,board);                                    Log.d("single",courses.get(i).toString());
                                    models.add(model);
                                }
                                adapter=new CustomAdapter(getApplicationContext(),models);
                                listView.setAdapter(adapter);
                                mProgressDialog.dismiss();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            Controller.getInstance().addToRequestQueue(request);
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {

        }
    }
}
