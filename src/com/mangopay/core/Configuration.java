package com.mangopay.core;

/**
 * Configuration settings.
 */
public class Configuration {

    /**
     * Client identifier.
     */
    public String ClientId = "";
    
    /**
     * Client password.
     */
    public String ClientPassword = "";
    
    /**
     * Base URL to MangoPay API.
     */
    public String BaseUrl = "https://api.sandbox.mangopay.com";
    
    /**
     * [INTERNAL USAGE ONLY] Switch debug mode: log all request and response data.
     */
    public boolean DebugMode = false;

}
