package com.digitech.rec.risk.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.digitech.rec.risk.api.models.Region;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegionData {
    public static List<Region> getRegions() {
        List<Region> regionList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            String json =FileUtil.getResourceFileAsString("region.json");
            JSONArray jSONArray = new JSONArray(json);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jsonObject = jSONArray.getJSONObject(i);
                String id = jsonObject.getJSONObject("_id").getString("$oid");
                String code = jsonObject.getString("code");
                String name = jsonObject.getString("name");
                String updatedAtString = jsonObject.getJSONObject("updated_at").getString("$date");
                Date updatedAt = format.parse(updatedAtString);
                Region region = new Region();
                region.setId(id);
                region.setCode(code);
                region.setName(name);
                region.setUpdatedAt(updatedAt);
                regionList.add(region);
            }

        } catch (JSONException e) {
            log.error("JSON Error", e.getMessage());
        } catch (ParseException e) {
            log.error("Parse Error", e.getMessage());
        }
        return regionList;
    }
    
}
