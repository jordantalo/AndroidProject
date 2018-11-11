package com.example.jordan.projectapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewDebug;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DestinationActivity extends AppCompatActivity {

    // Will show the string "data" that holds the results
    ListView results;
    // URL of object to be parsed
    String JsonURL = "http://voyage2.corellis.eu/api/v2/homev2?lat=43.14554197717751&lon=6.00246207789145&offset=0";
    // This string will hold the results
    String data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;
    //creation Library of destinations
    List<ClassDestination> bibliothequedestination = new ArrayList<ClassDestination>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination);


        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        // Casts results into the TextView found within the main layout XML with id jsonData
        results = (ListView) findViewById(R.id.listviewid);
        JSONObject jsonObj = new JSONObject();

        // Creating the JsonArrayRequest class called arrayreq, passing the required parameters
        //JsonURL is the URL to be fetched from
        JsonObjectRequest arrayobj = new JsonObjectRequest(JsonURL,jsonObj,
                // The second parameter Listener overrides the method onResponse() and passes
                //JSONArray as a parameter
                new Response.Listener<JSONObject>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Retrieves first JSON object in outer array
                            // Retrieves "colorArray" from the JSON object
                            JSONArray tab = response.getJSONArray("data");
                            // Iterates through the JSON Array getting objects and adding them
                            //to the list view until there are no more objects in colorArray
                            for (int i = 0; i < tab.length(); i++) {
                                //gets each JSON object within the JSON array
                                JSONObject jsonObject = tab.getJSONObject(i);

                                // Retrieves the string labeled "colorName" and "hexValue",
                                // and converts them into javascript objects
                                String type = !jsonObject.isNull("type") ? jsonObject.getString("type"): "";

                                if (type.equals("RESTAURANT") || type.equals("POI")  || type.equals("CITY")  || type.equals("GOELOC")) {
                                    Log.d("TEST1", Integer.toString(i));
                                    String display = !jsonObject.isNull("display") ? jsonObject.getString("display") : "";
                                    String media = !jsonObject.isNull("media") ? jsonObject.getString("media") : "";

                                    if ( !jsonObject.isNull("location")){
                                        JSONObject loc = jsonObject.getJSONObject("location");
                                        JSONObject coords = loc.getJSONObject("coords");
                                        Double lat = Double.parseDouble(coords.getString("lat"));
                                        Double longi =Double.parseDouble(coords.getString("lon"));
                                    }
                                    else {
                                        double lat = 0;
                                        double longi = 0;
                                    }

                                    Double lat = !jsonObject.isNull("lat") ? Double.parseDouble(jsonObject.getString("lat")) : 0;
                                    Double longi = !jsonObject.isNull("lon") ? Double.parseDouble(jsonObject.getString("lon")) : 0;

                                    ClassDestination dest = new ClassDestination(type,display,media,lat,longi);

                                    Log.d("LAT", Double.toString(lat));
                                    Log.d("LONG", Double.toString(longi));
                                    bibliothequedestination.add(dest);
                                }
                            }
                            // Adds the data string to the  ListView "results"
                            DestinationAdapter adapter = new DestinationAdapter(getApplicationContext(), bibliothequedestination);
                            results.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            // If an error occurs, this prints the error to the log

                            Log.d("TEST :", "aaaa"+e.toString());
                            e.printStackTrace();
                        }
                    }
                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        // Adds the JSON array request "arrayreq" to the request queue
        requestQueue.add(arrayobj);
    }
}

