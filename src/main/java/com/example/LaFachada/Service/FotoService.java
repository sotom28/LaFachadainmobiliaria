package com.example.LaFachada.Service;

import jakarta.transaction.Transactional;

public class FotoService {
    


    @Transactional
    public  void subirFoto( String urlFoto) {
        // Lógica para subir la foto a S3
    }

    public void eliminarFoto(String urlFoto) {
        // Lógica para eliminar la foto de S3
    }

}
