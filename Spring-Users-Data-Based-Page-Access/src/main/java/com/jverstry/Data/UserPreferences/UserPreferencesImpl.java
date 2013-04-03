package com.jverstry.Data.UserPreferences;

public class UserPreferencesImpl implements UserPreferences {
    
    private long userId;
    private String preferedColor;
    
    public UserPreferencesImpl() { }

    @Override
    public long getUserId() {
        return this.userId;
    }

    @Override
    public String getPreferedColor() {
        return this.preferedColor;
    }

    @Override
    public void setPreferedColor(String color) {
        if ( color == null ) return;
        this.preferedColor = color;
    }
    
}
