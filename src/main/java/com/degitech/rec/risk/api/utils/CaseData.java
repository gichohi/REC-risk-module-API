package com.degitech.rec.risk.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.degitech.rec.risk.api.models.CaseNotLife;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CaseData {
    public static List<CaseNotLife> getcases() {
        List<CaseNotLife> caseList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            String json = FileUtil.getResourceFileAsString("case_not_life_premium.json");
            JSONArray jSONArray = new JSONArray(json);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jsonObject = jSONArray.getJSONObject(i);
                String id = jsonObject.getJSONObject("_id").getString("$oid");
                String branch = jsonObject.getString("branch");
                String branchId = null;
                if (!(jsonObject.get("branches_id") instanceof String)) {
                    branchId = jsonObject.getJSONObject("branches_id").getString("$oid");
                }
                String cedantId = jsonObject.getJSONObject("cedants_id").getString("$oid");
                double premiumHt = jsonObject.getDouble("premium_ht");
                String policyNumber = jsonObject.getString("policy_number");

                String updatedAtString = jsonObject.getJSONObject("updated_at").getString("$date");
                Date updatedAt = format.parse(updatedAtString);

                if (branchId != null) {
                    CaseNotLife c = new CaseNotLife();
                    c.setId(id);
                    c.setUpdatedAt(updatedAt);
                    c.setBranch(branch);
                    c.setBranchId(branchId);
                    c.setCedantId(cedantId);
                    c.setPremiumHt(premiumHt);
                    c.setPolicyNumber(policyNumber);
                    caseList.add(c);
                }
            }

        } catch(JSONException e){
            log.error("Parse Error", e.getMessage());
        } 
        catch (ParseException e) {
            log.error("Parse Error", e.getMessage());
        }
        return caseList;
    }

}
