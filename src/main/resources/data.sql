-- Asegurar orden y consistencia: truncar tablas y reiniciar AUTO_INCREMENT
SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE `reseñas`;
TRUNCATE TABLE `publicacion`;
ALTER TABLE `publicacion` AUTO_INCREMENT = 1;
ALTER TABLE `reseñas` AUTO_INCREMENT = 1;
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO publicacion (idpublicacion, titulo, descripcion, precio, ubicacion, region, comuna, contacto, estado, fecha_publicacion, tipoventas, fotos_url, tipo_propiedad, cantidadhabitaciones, cantidadbaños) VALUES
(1, 'Casa moderna en Ñuñoa', 'Hermosa casa de 2 pisos, con jardín y cochera. Totalmente remodelada.', 450000000, 'Ñuñoa, Santiago', 'Región Metropolitana', 'Ñuñoa', '+56912345678', 'disponible', '2026-05-05', 'venta', 'https://ejemplo.com/foto1.jpg', 'Casa', 3, 2),
(2, 'Departamento céntrico Santiago', 'Depto 1 dormitorio, cocina integrada, balcón con vista. Piso 8.', 180000000, 'Centro, Santiago', 'Región Metropolitana', 'Santiago', '+56987654321', 'disponible', '2026-05-04', 'venta', 'https://ejemplo.com/foto2.jpg', 'Departamento', 1, 1),
(3, 'Terreno en La Florida', 'Terreno 500 m2 en zona comercial. Excelente ubicación para inversión.', 120000000, 'La Florida, Santiago', 'Región Metropolitana', 'La Florida', '+56998765432', 'disponible', '2026-05-03', 'venta', 'https://ejemplo.com/foto3.jpg', 'Terreno', 0, 0),
(4, 'Casa esquina Providencia', 'Casa 4 dormitorios, 3 baños, piscina, quincho. Seguridad 24/7.', 650000000, 'Providencia, Santiago', 'Región Metropolitana', 'Providencia', '+56912349876', 'disponible', '2026-05-02', 'venta', 'https://ejemplo.com/foto4.jpg', 'Casa', 4, 3),
(5, 'Oficina comercial Alameda', 'Oficina 200 m2, piso 5, parking incluido. Ideal para empresas.', 250000000, 'Alameda, Santiago', 'Región Metropolitana', 'Santiago', '+56911223344', 'disponible', '2026-05-01', 'venta', 'https://ejemplo.com/foto5.jpg', 'Oficina', 0, 2);

-- Datos de prueba para Reseñas
INSERT INTO reseñas (idreseñas, comentario, calificacion, fecha, usuario_id, idpropiedad, idpublicacion) VALUES
(1, 'Excelente propiedad, todo como se describe. Recomendado.', 5, '2026-05-05', 1, 1, 1),
(2, 'Muy buen trato del vendedor, proceso rápido.', 4, '2026-05-04', 2, 2, 2),
(3, 'Ubicación perfecta, zona tranquila.', 5, '2026-05-03', 3, 3, 3),
(4, 'La casa tiene más potencial del que se ve en fotos.', 4, '2026-05-02', 4, 4, 4),
(5, 'Excelente inversión, zona en alza.', 5, '2026-05-01', 5, 5, 5);
