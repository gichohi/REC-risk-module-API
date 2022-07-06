package com.digitech.rec.risk.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.digitech.rec.risk.api.models.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountryData {
    public static List<Country> getCountries() {
        List<Country> countryList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            String json =FileUtil.getResourceFileAsString("countries.json");
            JSONArray jSONArray = new JSONArray(json);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jsonObject = jSONArray.getJSONObject(i);
                String id = jsonObject.getJSONObject("_id").getString("$oid");
                String code = jsonObject.getString("code");
                String name = jsonObject.getString("name");
                String regionId = jsonObject.getJSONObject("regions_id").getString("$oid");
                String updatedAtString = jsonObject.getJSONObject("updated_at").getString("$date");
                Date updatedAt = format.parse(updatedAtString);
                Country country = new Country();
                country.setId(id);
                country.setCode(code);
                country.setName(name);
                country.setRegionId(regionId);
                country.setUpdatedAt(updatedAt);
                countryList.add(country);
            }

        } catch (JSONException e) {
            log.error("JSON Error", e.getMessage());
        } catch (ParseException e) {
            log.error("Parse Error", e.getMessage());
        }
        return countryList;
    }
    
}
