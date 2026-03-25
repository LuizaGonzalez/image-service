package com.techCup.image_service.controller;

import com.techCup.image_service.model.document.ImagenDocument;
import com.techCup.image_service.service.ImagenService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagenController {

    private final ImagenService imagenService;

    // Constructor injection
    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;

    }
    @PostMapping(consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
    public ImagenDocument uploandImagen(@RequestParam("file") MultipartFile file, @RequestParam("externalReference") String externalReference) throws IOException{
        return imagenService.save(file, externalReference);
    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id){
        ImagenDocument image = imagenService.findById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + image.getName() + "\"")
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .body(image.getData());
    }
    // List images by external reference
    @GetMapping("/reference/{externalReference}")
    public List<ImagenDocument> listByReference(@PathVariable String externalReference) {
        return imagenService.findByExternalReference(externalReference);
    }
    // List ALL images
    @GetMapping
    public List<ImagenDocument> listAll() {
        return imagenService.findAll();
    }
    // Delete image by id
    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable String id) {
        imagenService.delete(id);
    }
}
