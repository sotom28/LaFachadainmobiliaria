package com.example.LaFachada.Service;

import java.io.IOException;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

    private final S3Client s3Client;

    
    @Value("${AWS_S3_BUCKET:mi-bucket-local}")
    private String bucketName;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public List<String> subirFoto(Integer publicacionId, List<MultipartFile> foto) throws IOException {
        List<String> Urls = new ArrayList<>();

        for (MultipartFile nuevaFoto : foto) {

            String nombreOriginal = nuevaFoto.getOriginalFilename();
            String nombreGuardado = UUID.randomUUID().toString() + "_" + nombreOriginal;

            String rutaS3 = "publicacion/" + publicacionId + "/" + nombreGuardado;

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(rutaS3)
                    .contentType(nuevaFoto.getContentType())
                    .build();
            s3Client.putObject(putObjectRequest,
                    RequestBody.fromInputStream(nuevaFoto.getInputStream(), nuevaFoto.getSize()));

            String ruta = "https://" + bucketName + "/" + rutaS3;
            Urls.add(ruta);
        }
        return Urls;
    }

}
