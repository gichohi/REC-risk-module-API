package com.digitech.rec.risk.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.digitech.rec.risk.api.models.Branch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BranchData {
        public static List<Branch> getbranches() {
            List<Branch> branchList = new ArrayList<>();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            try {
                String json =FileUtil.getResourceFileAsString("branches.json");
                JSONArray jSONArray = new JSONArray(json);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jsonObject = jSONArray.getJSONObject(i);
                    String id = jsonObject.getJSONObject("_id").getString("$oid");
                    String name = jsonObject.getString("name");
                    String code = jsonObject.getString("code");
                    String createdAtString = jsonObject.getJSONObject("created_at").getString("$date");
                    String updatedAtString = jsonObject.getJSONObject("updated_at").getString("$date");
                    Date createdAt = format.parse(createdAtString);
                    Date updatedAt = format.parse(updatedAtString);
                    Branch branch = new Branch();
                    branch.setId(id);
                    branch.setCode(code);
                    branch.setName(name);
                    branch.setCreatedAt(createdAt);
                    branch.setUpdatedAt(updatedAt);
                    branchList.add(branch);
                }
    
            } catch (JSONException e) {
                log.error("JSON Error", e.getMessage());
            } catch (ParseException e) {
                log.error("Parse Error", e.getMessage());
            }
            return branchList;
        }
    
}
