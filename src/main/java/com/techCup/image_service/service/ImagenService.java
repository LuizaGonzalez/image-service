package com.techCup.image_service.service;

import com.techCup.image_service.model.document.ImagenDocument;
import com.techCup.image_service.repository.ImagenRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;

    // Constructor injection
    public ImagenService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    // Save image
    public ImagenDocument save(MultipartFile file, String externalReference) throws IOException {
        ImagenDocument image = new ImagenDocument(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getSize(),
                file.getBytes(),
                LocalDateTime.now(),
                externalReference
        );
        return imagenRepository.save(image);
    }

    // Find image by id
    public ImagenDocument findById(String id) {
        return imagenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
    }

    // List all images
    public List<ImagenDocument> findAll() {
        return imagenRepository.findAll();
    }

    // List images by external reference
    public List<ImagenDocument> findByExternalReference(String externalReference) {
        return imagenRepository.findByExternalReference(externalReference);
    }

    // Delete image by id
    public void delete(String id) {
        imagenRepository.deleteById(id);
    }
}