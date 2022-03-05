package com.example.demo.Controllers;

import com.example.demo.models.CountryInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

@Controller
public class testi {

    HttpURLConnection connection;
    @GetMapping("/testi")
    public String lala()
    {
        String line2;
        StringBuffer responseContext2 = new StringBuffer();
        BufferedReader reader2;

        try{


            URL url =new URL("https://corona-app-timskiproekt.azurewebsites.net/restapi?zemja=ALBANIA");
            connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status=connection.getResponseCode();
            if(status>299){
                reader2=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line2=reader2.readLine())!=null){
                    responseContext2.append(line2);
                }
                reader2.close();
            }
            else{
                reader2=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line2=reader2.readLine())!=null){
                    responseContext2.append(line2);
                    break;
                }
                reader2.close();

            }

            JSONObject data= new JSONObject(responseContext2.toString());

            System.out.println(data.getString("countryImg"));





        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        // model.addAttribute("nastani", list);
return "global.html";
    }

}
