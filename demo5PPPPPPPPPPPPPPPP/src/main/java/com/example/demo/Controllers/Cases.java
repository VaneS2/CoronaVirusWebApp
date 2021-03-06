package com.example.demo.Controllers;

import com.example.demo.models.Country;
import com.example.demo.models.CountryInfo;

import com.example.demo.models.GlobalCases;
import com.example.demo.services.CountryForMapService;
import com.example.demo.services.VacinePerCountryService;
import org.aspectj.bridge.AbortException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


@Controller
public class Cases {
    HttpURLConnection connection;
    private AbortException LoggerUtil;
    ArrayList<CountryInfo> list=new ArrayList<>();
    ArrayList<Country> allCountries;
    ArrayList<Country> allCountries2;

    private final VacinePerCountryService vacinePerCountryService;
    private final CountryForMapService countryForMapService;

    HttpURLConnection connection2;
    GlobalCases izlez2=null;

    public Cases(VacinePerCountryService vacinePerCountryService, CountryForMapService countryForMapService) {
        this.vacinePerCountryService = vacinePerCountryService;
        this.countryForMapService = countryForMapService;
    }


    @GetMapping("/cases")
    public String showDefault(Model model,HttpServletRequest request) throws IOException, JSONException {

        allCountries =new ArrayList<>();
        allCountries2 =new ArrayList<>();
        String line;
        StringBuffer responseContext = new StringBuffer();
        request.getSession().setAttribute("zemja","MACEDONIA");
        BufferedReader reader;
        try{
            URL url =new URL("https://api.covid19api.com/country/Macedonia" );
            connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status=connection.getResponseCode();
            if(status>299){
                reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line=reader.readLine())!=null){
                    responseContext.append(line);
                }
                reader.close();
            }
            else{
                reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line=reader.readLine())!=null){
                    responseContext.append(line);
                    break;
                }
                reader.close();

            }

            JSONArray data= new JSONArray(responseContext.toString());
            JSONObject previousDay =null;
            for(int i=0;i<data.length();i++) {

                JSONObject day = data.getJSONObject(i);
                String [] de= day.getString("Date").split("T");
                allCountries2.add(new Country(de[0],day.getInt("Confirmed"),day.getInt("Deaths")));
                if(i>0)
                {
                    previousDay =data.getJSONObject(i-1);
                    String [] s= day.getString("Date").split("T");
                    allCountries.add(new Country(s[0], day.getInt("Confirmed")- previousDay.getInt("Confirmed"), day.getInt("Deaths")- previousDay.getInt("Deaths")));
                }else{

                //System.out.println(day.getString("Country") + " " + day.getInt("Confirmed") + " " +day.getInt("Deaths"));
                    String [] s= day.getString("Date").split("T");
                allCountries.add(new Country(s[0], day.getInt("Confirmed"), day.getInt("Deaths")));}
            }


            model.addAttribute("datumm",java.time.LocalDate.now().toString());

           // System.out.println(proba("152789752"));

            model.addAttribute("vaccinePerCountry",vacinePerCountryService.getbyCountry("MACEDONIA"));



        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }


        ////////////////////////////////////////////////////////////////////////////////////////

        String line2;
        StringBuffer responseContext2 = new StringBuffer();
        BufferedReader reader2;

        try{
            URL url =new URL("https://timskiproekt-corona.azurewebsites.net/restapi?zemja=MACEDONIA");
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


            CountryInfo countryInfo=new CountryInfo(data.getString("country"),data.getString("countryImg"),proba(data.getString("cases")),
                    proba(data.getString("totalCases")),proba(data.getString("deaths")),proba(data.getString("todayDeaths")),proba(data.getString("recovered")),
                   proba(data.getString("todayRecovered")) ,data.getInt("active"),data.getInt("population"),data.getInt("tests"));

                    model.addAttribute("countryInfo",countryInfo);
                    model.addAttribute("pita",data.getInt("cases")+"."+data.getInt("recovered")+"."+data.getInt("active")+"."+data.getInt("deaths"));








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


        model.addAttribute("nastani", allCountries);
        model.addAttribute("vkupno",allCountries2);

        return "cases.html";
    }


    @GetMapping("/cases/country")
    public String showUsingSearch(Model model, HttpServletRequest request) throws IOException, JSONException {
        model.addAttribute("datumm",java.time.LocalDate.now().toString());
        String zemja = request.getParameter("search");
        request.getSession().setAttribute("zemja",zemja);

        allCountries =new ArrayList<>();
        allCountries2 =new ArrayList<>();
        String line;
        StringBuffer responseContext = new StringBuffer();
        BufferedReader reader;

        try{
            URL url =new URL("https://api.covid19api.com/country/"+zemja );
            connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status=connection.getResponseCode();
            if(status>299){
                reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line=reader.readLine())!=null){
                    responseContext.append(line);
                }
                reader.close();
            }
            else{
                reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line=reader.readLine())!=null){
                    responseContext.append(line);
                    break;
                }
                reader.close();

            }

            JSONArray data= new JSONArray(responseContext.toString());
            JSONObject previousDay =null;
            for(int i=0;i<data.length();i++) {


                JSONObject day = data.getJSONObject(i);


                String [] de= day.getString("Date").split("T");
                allCountries2.add(new Country(de[0],day.getInt("Confirmed"),day.getInt("Deaths")));
                if(i>0)
                {
                    previousDay =data.getJSONObject(i-1);
                    String [] s= day.getString("Date").split("T");
                    Country d=new Country(s[0], day.getInt("Confirmed")- previousDay.getInt("Confirmed"), day.getInt("Deaths")- previousDay.getInt("Deaths"));
                    if(previousDay.getInt("Confirmed")<= day.getInt("Confirmed") && previousDay.getInt("Deaths")<= day.getInt("Deaths") ) {
                        allCountries.add(d);
                    }
                }else{

                    //System.out.println(day.getString("Country") + " " + day.getInt("Confirmed") + " " +day.getInt("Deaths"));
                    String [] s= day.getString("Date").split("T");
                    allCountries.add(new Country(s[0], day.getInt("Confirmed"), day.getInt("Deaths")));}
            }



        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        model.addAttribute("nastani", allCountries);
        model.addAttribute("vkupno",allCountries2);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        String line2;
        StringBuffer responseContext2 = new StringBuffer();
        BufferedReader reader2;

        try{
            URL url =new URL("https://timskiproekt-corona.azurewebsites.net/restapi?zemja="+ zemja);
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

            CountryInfo countryInfo=new CountryInfo(data.getString("country"),data.getString("countryImg"),proba(data.getString("cases")),
                    proba(data.getString("totalCases")),proba(data.getString("deaths")),proba(data.getString("todayDeaths")),proba(data.getString("recovered")),
                    proba(data.getString("todayRecovered")) ,data.getInt("active"),data.getInt("population"),data.getInt("tests"));




           /* String [] zemjaNiza= zemja.split("");
            String izlezZemja=zemjaNiza[0];
            for(int i=1;i<zemjaNiza.length;i++)
            {
                izlezZemja+=zemjaNiza[i].toLowerCase();
            }*/
            model.addAttribute("vaccinePerCountry",vacinePerCountryService.getbyCountry(zemja));

            model.addAttribute("countryInfo",countryInfo);
            model.addAttribute("pita",data.getInt("cases")+"."+data.getInt("recovered")+"."+data.getInt("active")+"."+data.getInt("deaths"));











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



        return "cases.html";
    }

    @GetMapping("/global")
    public String visual(Model model){



        String line2;
        StringBuffer responseContext2 = new StringBuffer();
        BufferedReader reader2;




        try{
            URL url =new URL("https://timskiproekt-corona.azurewebsites.net/vaccines");
            connection2=(HttpURLConnection)url.openConnection();
            connection2.setRequestMethod("GET");
            connection2.setConnectTimeout(5000);
            connection2.setReadTimeout(5000);
            int status=connection2.getResponseCode();
            if(status>299){
                reader2=new BufferedReader(new InputStreamReader(connection2.getErrorStream()));
                while((line2=reader2.readLine())!=null){
                    responseContext2.append(line2);
                }
                reader2.close();
            }
            else{
                reader2=new BufferedReader(new InputStreamReader(connection2.getInputStream()));
                while((line2=reader2.readLine())!=null){
                    responseContext2.append(line2);
                    break;
                }
                reader2.close();

            }

            JSONObject global = new JSONObject(responseContext2.toString());


            izlez2= new GlobalCases(global.getString("updated"),proba(global.getString("cases")),proba(global.getString("todayCases")),proba(global.getString("deaths")),proba(global.getString("todayDeaths"))
                    ,proba(global.getString("recovered")),proba(global.getString("todayRecovered")),proba(global.getString("active")),proba(global.getString("critical")),proba(global.getString("casesPerOneMillion")),
                    proba(global.getString("deathsPerOneMillion")),proba(global.getString("tests")));

           System.out.println(proba(global.getString("cases")));


            model.addAttribute("vcGlobal",izlez2);
            model.addAttribute("zamapa",countryForMapService.giveAll());



        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            connection2.disconnect();
        }
        return "global.html";
    }

public String proba (String broj){


    String[] niza=null;
    niza=broj.split("");

        String izlez="";
        for(int i=0;i<niza.length;i++)
        {
            if(i%3==0)
            {
                izlez+=" ";
                izlez+=niza[niza.length-1-i];
            }
            else
            {
                izlez+=niza[niza.length-1-i];

            }
        }

String krajno="";
    for(int j=0;j<izlez.length();j++)
    {
        krajno+=izlez.charAt(izlez.length()-1-j);
    }

        return krajno;

}








}


