package com.services;

import com.modelclasses.visa.VisaModelClass;

import java.awt.*;

public interface VisaService {

    /**
     * This method is used to start the visa service
     */
    void startService();

    /**
     * This method is used to navigate to the visa service using direct URL
     */
    void navigateServiceURL();

    /**
     * This method is used to fill the application info step of the visa service
     */
    void fillApplicationInfo(VisaModelClass visaModelClass);

    /**
     * This method is used to navigate to the next step
     */
    void navigateNext();

    /**
     * This method is used to quit from the visa service
     */
    void exitVisaService();

    /**
     * This method is used to save the visa request as a draft
     */
    void saveVisaDraft();

    /**
     * This method is used to navigate back
     */
    void navigateBack();

    /**
     * This method is used to upload the mandatory attachments
     */
    void uploadMandatoryAttachments() throws InterruptedException, AWTException;

    /**
     * This method is used to assert the visa request was submitted successfully
     */
    void assertVisaSubmitted();

}
