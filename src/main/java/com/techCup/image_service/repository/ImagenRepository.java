package com.techCup.image_service.repository;

import com.techCup.image_service.model.document.ImagenDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ImagenRepository extends MongoRepository<ImagenDocument, String> {

    // Find all images by external reference
    List<ImagenDocument> findByExternalReference(String externalReference);
}
