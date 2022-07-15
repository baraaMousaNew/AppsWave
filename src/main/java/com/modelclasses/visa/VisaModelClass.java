package com.modelclasses.visa;

import org.json.simple.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class VisaModelClass {

    private String organizationName;

    private String telephone;

    private String countryOfResidence;

    private String visitPurpose;

    private String purposeDetails;

    private String visitDate;

    private String visitTime;

    private String visitDuration;

    private String totalNumberOfVisitors;

    private String requestRemarks;

    public VisaModelClass(JSONObject object) throws InvocationTargetException, IllegalAccessException {

        Set<String> keys = object.keySet();
        for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();){
            String value = iterator.next();
            try {
                Method method = this.getClass().getMethod(value, String.class);
                method.invoke(this, object.get(value).toString());
            }catch (NoSuchMethodException e){

            }
        }
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void organizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void telephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void countryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getVisitPurpose() {
        return visitPurpose;
    }

    public void visitPurpose(String visitPurpose) {
        this.visitPurpose = visitPurpose;
    }

    public String getPurposeDetails() {
        return purposeDetails;
    }

    public void purposeDetails(String purposeDetails) {
        this.purposeDetails = purposeDetails;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void visitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void visitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitDuration() {
        return visitDuration;
    }

    public void visitDuration(String visitDuration) {
        this.visitDuration = visitDuration;
    }

    public String getTotalNumberOfVisitors() {
        return totalNumberOfVisitors;
    }

    public void totalNumberOfVisitors(String totalNumberOfVisitors) {
        this.totalNumberOfVisitors = totalNumberOfVisitors;
    }

    public String getRequestRemarks() {
        return requestRemarks;
    }

    public void requestRemarks(String requestRemarks) {
        this.requestRemarks = requestRemarks;
    }

}
