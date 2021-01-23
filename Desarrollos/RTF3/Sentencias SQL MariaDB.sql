#Nombre base de datos saetel-db

#CIUDADES
CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `codigo_ciudad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `codigo_region` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `ciudades_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_region` int(11) NOT NULL,
  `id_ciudad` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ciudades_region_fk` (`id_ciudad`),
  KEY `ciudades_region_fk_1` (`id_region`),
  CONSTRAINT `ciudades_region_fk` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id`),
  CONSTRAINT `ciudades_region_fk_1` FOREIGN KEY (`id_region`) REFERENCES `region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#EMPRESAS
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nit` varchar(20) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `empresas_ciudad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(11) NOT NULL,
  `id_ciudad` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empresas_ciudad_fk` (`id_ciudad`),
  KEY `empresas_ciudad_fk_1` (`id_empresa`),
  CONSTRAINT `empresas_ciudad_fk` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id`),
  CONSTRAINT `empresas_ciudad_fk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `inscripcion_empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `inscripcion_empresa_fk` (`id_empresa`),
  CONSTRAINT `inscripcion_empresa_fk` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#CLIENTES
CREATE TABLE `tipo_documento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_documento` int(11) NOT NULL,
  `numero_documento` varchar(100) NOT NULL,
  `primer_nombre` varchar(100) NOT NULL,
  `segundo_nombre` varchar(100) DEFAULT NULL,
  `primer_apellido` varchar(100) NOT NULL,
  `segundo_apellido` varchar(100) DEFAULT NULL,
  `direccion_residencia` varchar(100) DEFAULT NULL,
  `telefono_fijo` varchar(100) DEFAULT NULL,
  `celular_principal` varchar(100) DEFAULT NULL,
  `celular_secundario` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_fk` (`id_tipo_documento`),
  CONSTRAINT `cliente_fk` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#CONTRATOS
CREATE TABLE `estrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `contrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_contrato` varchar(100) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `id_estrato` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contrato_fk` (`id_empresa`),
  KEY `contrato_fk_1` (`id_cliente`),
  KEY `contrato_fk_2` (`id_estrato`),
  CONSTRAINT `contrato_fk` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`),
  CONSTRAINT `contrato_fk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `contrato_fk_2` FOREIGN KEY (`id_estrato`) REFERENCES `estrato` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#SERVICIOS
CREATE TABLE `servicio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `television` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `cantidad_canales` int(11) DEFAULT NULL,
  `calidad` varchar(100) DEFAULT NULL,
  `cantidad_decodificadores` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `television_fk` (`id_servicio`),
  CONSTRAINT `television_fk` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `internet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `velocidad` varchar(100) DEFAULT NULL,
  `tecnologia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `internet_fk` (`id_servicio`),
  CONSTRAINT `internet_fk` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `linea_fija` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `alcance` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `linea_fija_fk` (`id_servicio`),
  CONSTRAINT `linea_fija_fk` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `linea_movil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(11) NOT NULL,
  `tipo_plan` varchar(100) DEFAULT NULL,
  `datos_megas` varchar(50) DEFAULT NULL,
  `mensajes_textos` varchar(50) DEFAULT NULL,
  `minutos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `linea_movil_fk` (`id_servicio`),
  CONSTRAINT `linea_movil_fk` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `servicio_contrato` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_contrato` int(11) NOT NULL,
  `id_servicio` int(11) NOT NULL,
  `precio` double NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `servicio_contrato_fk` (`id_contrato`),
  KEY `servicio_contrato_fk_1` (`id_servicio`),
  CONSTRAINT `servicio_contrato_fk` FOREIGN KEY (`id_contrato`) REFERENCES `contrato` (`id`),
  CONSTRAINT `servicio_contrato_fk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#USUARIOS
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `clave` varchar(100) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `id_empresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuarios_fk` (`id_rol`),
  KEY `usuarios_fk_1` (`id_empresa`),
  CONSTRAINT `usuarios_fk` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`),
  CONSTRAINT `usuarios_fk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#ARCHIVOS
CREATE TABLE `archivos_empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_empresa` int(11) NOT NULL,
  `fecha_carga` datetime NOT NULL,
  `enlace` varchar(500) DEFAULT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `archivos_empresa_fk` (`id_empresa`),
  CONSTRAINT `archivos_empresa_fk` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `plantilla_archivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enlace` varchar(500) NOT NULL,
  `estado` varchar(20) NOT NULL,
  `peso_maximo_megas` int(11) NOT NULL,
  `tipo_archivo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `periodo_carga_archivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#INSERCIONES DEFAULT

#REGIONES
INSERT INTO `saetel-db`.region (id, nombre, codigo_region) VALUES(1, 'Amazonia', NULL);
INSERT INTO `saetel-db`.region (id, nombre, codigo_region) VALUES(2, 'Andina', NULL);
INSERT INTO `saetel-db`.region (id, nombre, codigo_region) VALUES(3, 'Caribe', NULL);
INSERT INTO `saetel-db`.region (id, nombre, codigo_region) VALUES(4, 'Insular', NULL);
INSERT INTO `saetel-db`.region (id, nombre, codigo_region) VALUES(5, 'Orinoquia', NULL);
INSERT INTO `saetel-db`.region (id, nombre, codigo_region) VALUES(6, 'Pacifico', NULL);

#ALGUNAS CIUDADES
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(1, 'BOGOTA', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(2, 'MEDELLIN', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(3, 'CALI', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(4, 'BARRANQUILLA', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(5, 'CARTAGENA', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(6, 'SOLEDAD', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(7, 'CUCUTA', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(8, 'IBAGUE', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(9, 'SOACHA', NULL);
INSERT INTO `saetel-db`.ciudad (id, nombre, codigo_ciudad) VALUES(10, 'BUCARAMANGA', NULL);

INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(1, 2, 1);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(2, 2, 2);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(3, 6, 3);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(4, 3, 4);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(5, 3, 5);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(6, 3, 6);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(7, 2, 7);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(8, 2, 8);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(9, 2, 9);
INSERT INTO `saetel-db`.ciudades_region (id, id_region, id_ciudad) VALUES(10, 2, 10);

#TIPOS DE DOCUMENTOS
INSERT INTO `saetel-db`.tipo_documento (id, descripcion) VALUES(1, 'CEDULA DE CIUDADANIA');
INSERT INTO `saetel-db`.tipo_documento (id, descripcion) VALUES(2, 'TARJETA DE EXTRANJERIA');
INSERT INTO `saetel-db`.tipo_documento (id, descripcion) VALUES(3, 'CEDULA DE EXTRANJERIA');
INSERT INTO `saetel-db`.tipo_documento (id, descripcion) VALUES(4, 'NIT');

#ESTRATOS
INSERT INTO `saetel-db`.estrato (id, descripcion) VALUES(1, 'BAJO-BAJO');
INSERT INTO `saetel-db`.estrato (id, descripcion) VALUES(2, 'BAJO');
INSERT INTO `saetel-db`.estrato (id, descripcion) VALUES(3, 'MEDIO-BAJO');
INSERT INTO `saetel-db`.estrato (id, descripcion) VALUES(4, 'MEDIO');
INSERT INTO `saetel-db`.estrato (id, descripcion) VALUES(5, 'MEDIO-ALTO');
INSERT INTO `saetel-db`.estrato (id, descripcion) VALUES(6, 'ALTO');

#USUARIOS
INSERT INTO `saetel-db`.rol (id, descripcion) VALUES(1, 'ADMINISTRADOR');
INSERT INTO `saetel-db`.rol (id, descripcion) VALUES(2, 'USUARIO-EMPRESA');



