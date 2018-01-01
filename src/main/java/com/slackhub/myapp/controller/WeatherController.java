//package com.slackhub.myapp.controller;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping("/weather")
//@CrossOrigin(origins = "http://localhost:4200" )
//public class WeatherController {
//
//    @RequestMapping(value="{zip}")
//    public ResponseEntity<Weather> getWeather(@RequestParam ("{zip}") String zip) {
//
//        Weather weather = new Weather();
//        RestTemplate restTemplate = new RestTemplate();
//        String jsonStr = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=ab6fe4ad66123fde420e4cbeca20f461" , String.class);
//        JSONObject json = null;
//        try {
//            json = new JSONObject(jsonStr);
//            JSONArray main = null;
//            main = json.getJSONObject("contents").getJSONArray("quotes");
//            JSONObject json1 = null;
//
//            for (int i = 0; i < main.length(); i++) {
//                String val = main.getString(i);
//                json1 = new JSONObject(val);
//                weather.setTemp( json1.getString("temp"));
//                weather.setPressure(json1.getString("pressure"));
//                weather.setCloud(json1.getString("cloud"));
//                weather.setHumidity(json1.getString("humidity"));
//
//
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return  new ResponseEntity<Weather>(weather, HttpStatus.OK);
//    }
//    }
