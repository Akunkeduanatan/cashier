package com.smk.cashier.model;

import java.util.Date;

public abstract class Model {
    protected Date dacreated;
    protected Date lastModified;

    protected String createdBy;
    protected String updatedBy;

    public Date getDacreated() {
        return dacreated;
    }

    public void setDacreated(Date dacreated) {
        this.dacreated = dacreated;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
