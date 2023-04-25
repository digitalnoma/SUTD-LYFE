package com.example.hamburgermenu.food;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;


import java.util.ArrayList;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;


public class FetchDataTask extends AsyncTask<Void, Void, ServerData> {



    protected ServerData doInBackground(Void... params) {
        try {
            // Create a URL object for the desired URL
            System.out.println("Registered");
            URL url = new URL("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app/Listing.json");

            // Open a connection to the URL
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Read the response into a string using a BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();


            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

            // Close the reader and the connection
            reader.close();
            urlConnection.disconnect();

            String jsonStr = stringBuilder.toString();

            JSONObject jsonObj = new JSONObject(jsonStr);
            Iterator<String> keys = jsonObj.keys();


            ArrayList<String> newsTitle = new ArrayList<String>();
            ArrayList<String> newsDate = new ArrayList<String>();

            while (keys.hasNext()) {
                // date becomes information
                // name becomes title



                String key = keys.next();

                newsTitle.add(jsonObj.getJSONObject(key).getString("title"));
                newsDate.add(jsonObj.getJSONObject(key).getString("information"));
            }

            String[] newsTitleArray = newsTitle.toArray(new String[0]);
            String[] newsDateArray = newsDate.toArray(new String[0]);

            // Return the JSON data as a string
            ServerData returnData = new ServerData(newsTitleArray, newsDateArray);
            return returnData;

        } catch (Exception e) {

            Log.e("Error", e.getMessage(), e);
            return null;
        }
    }


    public interface DataListener {
        void onDataFetched(ServerData data);
    }

    private DataListener mListener;

    public void setListener(DataListener listener) {
        mListener = listener;
    }



    @Override
    protected void onPostExecute(ServerData returnData) {
        if (returnData != null) {
            if (mListener != null) {
                mListener.onDataFetched(returnData);
            }
        } else {
            // Handle the case where returnData is null
            Log.e("FetchDataTask", "Failed to fetch data from server");
        }
    }
}

