package com.digitech.rec.risk.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.digitech.rec.risk.api.models.Slip;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlipData {
    public static List<Slip> getSlips() {
        List<Slip> slipList = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            String json = FileUtil.getResourceFileAsString("slips_premium.json");
            JSONArray jSONArray = new JSONArray(json);
            for (int i = 0; i < jSONArray.length(); i++) {
                Date publicationDate = null;
                JSONObject jsonObject = jSONArray.getJSONObject(i);
                String id = jsonObject.getJSONObject("_id").getString("$oid");
                String approvalStatus = jsonObject.getString("approval_status");
                String editedPeriod = jsonObject.getString("edited_period");
                String confirmationStatus = jsonObject.getString("confirmation_status");
                String reference = jsonObject.getString("reference");
                String cedantId = jsonObject.getJSONObject("cedants_id").getString("$oid");
                String publicationDateString = jsonObject.getString("published_date");
                String validationStatus = jsonObject.getString("validation_status");
                if (!publicationDateString.equals("")) {
                    publicationDate = dateFormat.parse(publicationDateString);
                }
                String createdAtString = jsonObject.getJSONObject("created_at").getString("$date");
                String updatedAtString = jsonObject.getJSONObject("updated_at").getString("$date");
                Date createdAt = format.parse(createdAtString);
                Date updatedAt = format.parse(updatedAtString);
                Slip slip = new Slip();
                slip.setId(id);
                slip.setApprovalStatus(approvalStatus);
                slip.setEditedPeriod(editedPeriod);
                slip.setReference(reference);
                slip.setCedantId(cedantId);
                slip.setConfirmationStatus(confirmationStatus);
                slip.setValidationStatus(validationStatus);
                if (publicationDate != null) {
                    slip.setPublicationDate(publicationDate);
                }
                slip.setCreatedAt(createdAt);
                slip.setUpdatedAt(updatedAt);
                slipList.add(slip);
            }

        } catch (JSONException e) {
            log.error("JSON Error", e.getMessage());
        } catch (ParseException e) {
            log.error("Parse Error", e.getMessage());
        }
        return slipList;
    }

}
