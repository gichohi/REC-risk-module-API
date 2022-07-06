package com.digitech.rec.risk.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.digitech.rec.risk.api.models.GroupCedant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupCedantData {
    public static List<GroupCedant> getGroupCedants() {
        List<GroupCedant> groupCedantList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            String json =FileUtil.getResourceFileAsString("groups_cedants.json");
            JSONArray jSONArray = new JSONArray(json);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jsonObject = jSONArray.getJSONObject(i);
                String id = jsonObject.getJSONObject("_id").getString("$oid");
                String name = jsonObject.getString("name");
                String createdAtString = jsonObject.getJSONObject("created_at").getString("$date");
                String updatedAtString = jsonObject.getJSONObject("updated_at").getString("$date");
                Date createdAt = format.parse(createdAtString);
                Date updatedAt = format.parse(updatedAtString);
                GroupCedant groupCedant = new GroupCedant();
                groupCedant.setId(id);
                groupCedant.setName(name);
                groupCedant.setCreatedAt(createdAt);
                groupCedant.setUpdatedAt(updatedAt);
                groupCedantList.add(groupCedant);
            }

        } catch (JSONException e) {
            log.error("JSON Error", e.getMessage());
        } catch (ParseException e) {
            log.error("Parse Error", e.getMessage());
        }
        return groupCedantList;
    }

    
}
