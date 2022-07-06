package com.degitech.rec.risk.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.degitech.rec.risk.api.models.Cedant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CedantData {
    public static List<Cedant> getCedants() {
        List<Cedant> cedantList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            String json =FileUtil.getResourceFileAsString("cedants.json");
            JSONArray jSONArray = new JSONArray(json);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jsonObject = jSONArray.getJSONObject(i);
                String id = jsonObject.getJSONObject("_id").getString("$oid");
                String name = jsonObject.getString("name");
                String code = jsonObject.getString("code");
                String color1 = jsonObject.getString("color1");
                String color2 = jsonObject.getString("color2");
                String contact = jsonObject.getString("contact");
                String email = jsonObject.getString("email");
                String logo = jsonObject.getString("logo");
                String countryId = jsonObject.getJSONObject("countries_id").getString("$oid");
                String currencyId = jsonObject.getJSONObject("currencies_id").getString("$oid");
                String groupCedantId = jsonObject.getJSONObject("groups_cedants_id").getString("$oid");
                String regionId = jsonObject.getJSONObject("region_id").getString("$oid");
                String reinsuranceId = jsonObject.getJSONObject("reinsurances_id").getString("$oid");
                String typeCedantId = jsonObject.getJSONObject("types_cedants_id").getString("$oid");
                String createdAtString = jsonObject.getJSONObject("created_at").getString("$date");
                String updatedAtString = jsonObject.getJSONObject("updated_at").getString("$date");
                Date createdAt = format.parse(createdAtString);
                Date updatedAt = format.parse(updatedAtString);
                Cedant cedant = new Cedant();
                cedant.setId(id);
                cedant.setCode(code);
                cedant.setName(name);
                cedant.setColor1(color1);
                cedant.setColor2(color2);
                cedant.setContact(contact);
                cedant.setCountryId(countryId);
                cedant.setCurrencyId(currencyId);
                cedant.setEmail(email);
                cedant.setLogo(logo);
                cedant.setGroupCedantId(groupCedantId);
                cedant.setRegionId(regionId);
                cedant.setReinsuranceId(reinsuranceId);
                cedant.setTypeCedantId(typeCedantId);
                cedant.setCreatedAt(createdAt);
                cedant.setUpdatedAt(updatedAt);
                cedantList.add(cedant);
            }

        } catch (JSONException e) {
            log.error("JSON Error", e.getMessage());
        } catch (ParseException e) {
            log.error("Parse Error", e.getMessage());
        }
        return cedantList;
    }

    
}
