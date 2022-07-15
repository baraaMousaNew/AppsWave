package com.services;

public interface LoginService {

    /**
     * This method is used to access the page of Login from any webpage
     */
    void navigateToLogin();

    /**
     * This method is used to fill credentials and login
     * @param username
     * @param password
     */
    void login(String username, String password);


}
