-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 31-03-2015 a las 03:29:50
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `stock_maquinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alquiler`
--

CREATE TABLE IF NOT EXISTS `alquiler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_maquinaria` int(11) NOT NULL,
  `p_hora` double DEFAULT NULL,
  `p_mdia` double DEFAULT NULL,
  `p_dia` double DEFAULT NULL,
  `p_7dias` double DEFAULT NULL,
  `p_15dias` double DEFAULT NULL,
  `p_30dias` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `maquinaria` (`tipo_maquinaria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `alquiler`
--

INSERT INTO `alquiler` (`id`, `tipo_maquinaria`, `p_hora`, `p_mdia`, `p_dia`, `p_7dias`, `p_15dias`, `p_30dias`) VALUES
(1, 1, 150, 1800, 3600, 25200, 54000, 108000),
(2, 2, 180, 2160, 4320, 30240, 64800, 129600),
(3, 3, 150, 1800, 3600, 25200, 54000, 108000),
(4, 4, 120, 1440, 2880, 20160, 43200, 86400),
(5, 5, 90, 1080, 2160, 15120, 32400, 64800),
(6, 6, 80, 960, 1920, 13440, 28800, 57600),
(7, 7, 100, 1200, 2400, 16800, 36000, 72000),
(8, 8, 110, 1320, 2640, 18480, 39600, 79200),
(9, 9, 30, 360, 720, 5040, 10800, 21600),
(10, 10, 30, 360, 720, 5040, 10800, 21600);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_stockmunicipalidad`
--

CREATE TABLE IF NOT EXISTS `detalle_stockmunicipalidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_municipalidad` varchar(10) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `costoTotal` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stock_municipalidad` (`stock_municipalidad`),
  KEY `stock_municipalidad_2` (`stock_municipalidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `detalle_stockmunicipalidad`
--

INSERT INTO `detalle_stockmunicipalidad` (`id`, `stock_municipalidad`, `fechaInicio`, `fechaFin`, `costoTotal`) VALUES
(2, 'CFSR001', '2015-03-01', '2015-03-31', 5000),
(3, 'TOD6MXL001', '2015-01-01', '2015-01-15', 500),
(4, 'TOD7G001', '2015-01-01', '2015-02-10', 10000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE IF NOT EXISTS `movimiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_municipalidad` varchar(10) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `estado` varchar(3) COLLATE utf8mb4_spanish2_ci NOT NULL DEFAULT 'D',
  PRIMARY KEY (`id`),
  KEY `stock_municipalidad` (`stock_municipalidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id`, `stock_municipalidad`, `fechaInicio`, `fechaFin`, `estado`) VALUES
(1, 'TOD6MXL001', '2015-03-01', '2015-03-31', 'D'),
(2, 'TOD7G001', '2015-03-16', '2015-03-31', 'D');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipalidad`
--

CREATE TABLE IF NOT EXISTS `municipalidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `ubicacion` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `municipalidad`
--

INSERT INTO `municipalidad` (`id`, `nombre`, `ubicacion`) VALUES
(1, 'Municipalidad de Chorrillos', 'Av. Defensores del Morro (Ex Huaylas) 550 - Chorrillos'),
(2, 'Municipalidad de San Juan de Miraflores', 'Av. Belisario Suarez Nro. 1075 - Zona D - SJM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `principal`
--

CREATE TABLE IF NOT EXISTS `principal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `ciudadano` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `direccionCiudadano` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `ruc` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `empresa` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `direccionEmpresa` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `costoTotal` double DEFAULT NULL,
  `municipalidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `municipalidad` (`municipalidad`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `principal`
--

INSERT INTO `principal` (`id`, `dni`, `ciudadano`, `direccionCiudadano`, `ruc`, `empresa`, `direccionEmpresa`, `costoTotal`, `municipalidad`) VALUES
(1, '45454', 'pepito', 'avgg', '454578', 'abc sac', 'av gg', 1000, 1),
(2, '4554544', 'pepito', 'av. pepito 1234', '204878947', 'Pepito S.A.C', 'av. pepito 454', 5000, 1),
(3, '4554544', 'pepito', 'av. pepito 1234', '204878947', 'Pepito S.A.C', 'av. pepito 454', 5000, 1),
(4, '4554544', 'pepito', 'av. pepito 1234', '204878947', 'Pepito S.A.C', 'av. pepito 454', 5000, 1),
(5, 'fgfdgf', 'fdgdfg', 'dfgfdg', 'dfsdf', 'sdfsdf', 'fdsfds', 500, 1),
(6, 'fgf dgf', 'fdgdfg', 'dfgfdg', 'dfsdf', 'sdfsdf', 'fdsfds', 500, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock_municipalidad`
--

CREATE TABLE IF NOT EXISTS `stock_municipalidad` (
  `municipalidad` int(11) NOT NULL,
  `tipo_maquinaria` int(11) NOT NULL,
  `codigo` varchar(10) COLLATE utf8mb4_spanish2_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `tipo_maquinaria` (`tipo_maquinaria`),
  KEY `municipalidad` (`municipalidad`),
  KEY `codigo` (`codigo`),
  KEY `codigo_2` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `stock_municipalidad`
--

INSERT INTO `stock_municipalidad` (`municipalidad`, `tipo_maquinaria`, `codigo`) VALUES
(1, 3, 'CFSR001'),
(1, 10, 'CN001'),
(1, 8, 'M001'),
(1, 9, 'MCTT001'),
(1, 4, 'RG001'),
(1, 5, 'RLV001'),
(1, 1, 'TOD6MXL001'),
(1, 2, 'TOD7G001'),
(1, 6, 'VD6M3001'),
(1, 7, 'VV001');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_maquinaria`
--

CREATE TABLE IF NOT EXISTS `tipo_maquinaria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `tipo_maquinaria`
--

INSERT INTO `tipo_maquinaria` (`id`, `nombre`) VALUES
(1, 'Tractor de Orugas D6M-XL'),
(2, 'Tractor de Orugas D7G'),
(3, 'Cargador Frontal Sobre Ruedas'),
(4, 'Retroexcavadora Grua'),
(5, 'Rodillo Liso Vibratorio'),
(6, 'VOLQUETE DINA 6 M3'),
(7, 'Volquete Volvo'),
(8, 'Motoniveladora'),
(9, 'Mezcladora de Concreto Tipo Trompo'),
(10, 'Camioneta NISSAN');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alquiler`
--
ALTER TABLE `alquiler`
  ADD CONSTRAINT `alquiler_ibfk_1` FOREIGN KEY (`tipo_maquinaria`) REFERENCES `tipo_maquinaria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_stockmunicipalidad`
--
ALTER TABLE `detalle_stockmunicipalidad`
  ADD CONSTRAINT `detalle_stockmunicipalidad_ibfk_1` FOREIGN KEY (`stock_municipalidad`) REFERENCES `stock_municipalidad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_ibfk_1` FOREIGN KEY (`stock_municipalidad`) REFERENCES `stock_municipalidad` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `principal`
--
ALTER TABLE `principal`
  ADD CONSTRAINT `principal_ibfk_1` FOREIGN KEY (`municipalidad`) REFERENCES `municipalidad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
