package com.mangopay.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File token storage strategy implementation.
 */
public class FileStorageStrategy implements IStorageStrategy {

    private String _tempDir = null;
    
    /**
     * Instantiates FileStorageStrategy object.
     * @param tempDir Temporary directory path.
     */
    public FileStorageStrategy(String tempDir) {
        _tempDir = tempDir;
    }
    
    /**
     * Gets the currently stored token.
     * @return Currently stored token instance or null.
     */
    @Override
    public OAuthToken get() {
        try
        {
           FileInputStream fileIn = new FileInputStream(getFilePath());
           ObjectInputStream in = new ObjectInputStream(fileIn);
           OAuthToken token = (OAuthToken) in.readObject();
           in.close();
           fileIn.close();
           return token;
        } catch (Exception ex)
        {
            return null; // it's not an error: e.g. file not found cause not stored yet
        }
    }

    /**
     * Stores authorization token passed as an argument.
     * @param token Token instance to be stored.
     */
    @Override
    public void store(OAuthToken token) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(getFilePath());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(token);
            out.close();
            fileOut.close();
        } catch (Exception ex) {
            Logger.getLogger(FileStorageStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getFilePath() { return _tempDir + getClass().getName() + ".tmp"; }
}
