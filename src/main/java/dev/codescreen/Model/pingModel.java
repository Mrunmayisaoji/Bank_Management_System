package dev.codescreen.Model;

import java.util.Date;

public class pingModel {
    private Date serverDateTime;

    public pingModel(Date serverDateTime) {
        this.serverDateTime = serverDateTime;
    }

    public Date getServerDateTime() {
        return serverDateTime;
    }

    public void setServerDateTime(Date serverDateTime) {
        this.serverDateTime = serverDateTime;
    }

    @Override
    public String toString() {
        return "pingModel [serverDateTime=" + serverDateTime + "]";
    }
    
    
}
