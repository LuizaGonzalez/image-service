package com.techCup.image_service.repository;

import com.techCup.image_service.document.ImagenDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ImagenRepository extends MongoRepository<ImagenRepository, String> {

    // Find all images by external reference
    List<ImagenDocument> findByExternalReference(String externalReference);
}
