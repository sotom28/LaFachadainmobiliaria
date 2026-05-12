-- Asegurar orden y consistencia
SET FOREIGN_KEY_CHECKS=0;
TRUNCATE TABLE `resenas`;
TRUNCATE TABLE `publicacion`;
ALTER TABLE `publicacion` AUTO_INCREMENT = 1;
ALTER TABLE `resenas` AUTO_INCREMENT = 1;
SET FOREIGN_KEY_CHECKS=1;

-- Inserción en 'publicacion' (Se eliminó foto_url para coincidir con la Entidad)
INSERT INTO publicacion (titulo, descripcion, precio, ubicacion, vendedor_id, propiedad_id, estado, fecha_publicacion, tipo_ventas) VALUES
('Casa moderna en Ñuñoa', 'Hermosa casa de 2 pisos, con jardín y cochera. Totalmente remodelada.', 450000000, 'Ñuñoa, Santiago', 1, 1, 'disponible', '2026-05-09 00:00:00', 'venta'),
('Departamento céntrico Santiago', 'Depto 1 dormitorio, cocina integrada, balcón con vista. Piso 8.', 180000000, 'Centro, Santiago', 2, 2, 'disponible', '2026-05-09 00:00:00', 'venta'),
('Terreno en La Florida', 'Terreno 500 m2 en zona comercial. Excelente ubicación para inversión.', 120000000, 'La Florida, Santiago', 3, 3, 'disponible', '2026-05-09 00:00:00', 'venta'),
('Casa esquina Providencia', 'Casa 4 dormitorios, 3 baños, piscina, quincho. Seguridad 24/7.', 650000000, 'Providencia, Santiago', 4, 4, 'disponible', '2026-05-09 00:00:00', 'venta'),
('Oficina comercial Alameda', 'Oficina 200 m2, piso 5, parking incluido. Ideal para empresas.', 250000000, 'Alameda, Santiago', 5, 5, 'disponible', '2026-05-09 00:00:00', 'venta');

-- Inserción en 'resenas'
-- Se mantiene 'publicacion_id' que es la FK definida en @JoinColumn de la entidad Resenas
INSERT INTO resenas (comentario, calificacion, fecha, usuario_id, publicacion_id) VALUES
('Excelente propiedad, todo como se describe. Recomendado.', 5, '2026-05-09', 1, 1),
('Muy buen trato del vendedor, proceso rápido.', 4, '2026-05-09', 2, 2),
('Ubicación perfecta, zona tranquila.', 5, '2026-05-09', 3, 3),
('La casa tiene más potencial del que se ve en fotos.', 4, '2026-05-09', 4,4),
('Excelente inversión, zona en alza.', 5, '2026-05-09', 5, 5);
