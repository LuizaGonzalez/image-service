package com.techCup.image_service.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "imagenes")
public class ImagenDocument {

    @Id
    private String id;
    private String name;
    private String contentType;
    private Long size;
    private byte[] data;
    private LocalDateTime uploadDate;
    private String externalReference;

    //Constructor
    public ImagenDocument() {
    }
    //Contructor with parameters
    public ImagenDocument(String name, String contentType, Long size, byte[] data, LocalDateTime uploadDate, String externalReference){
        this.name = name;
        this.contentType = contentType;
        this.size = size;
        this.data = data;
        this.uploadDate = uploadDate;
        this.externalReference = externalReference;
    }
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getContentType() { return contentType; }
    public Long getSize() { return size; }
    public byte[] getData() { return data; }
    public LocalDateTime getUploadDate() { return uploadDate; }
    public String getExternalReference() { return externalReference; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    public void setSize(Long size) { this.size = size; }
    public void setData(byte[] data) { this.data = data; }
    public void setUploadDate(LocalDateTime uploadDate) { this.uploadDate = uploadDate; }
    public void setExternalReference(String externalReference) { this.externalReference = externalReference; }
}
