package UploadFile.model;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan("model")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "resources/static/upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}