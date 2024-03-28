-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-03-2024 a las 19:27:59
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `turnosjsp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudadano`
--

CREATE TABLE `ciudadano` (
  `ID` bigint(20) NOT NULL,
  `APELLIDO` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ciudadano`
--

INSERT INTO `ciudadano` (`ID`, `APELLIDO`, `NOMBRE`) VALUES
(1, 'de la Rica', 'Daniel'),
(2, 'Alcaraz', 'Alfonso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPCION` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `ESTADO` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `ciudadano_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`ID`, `DESCRIPCION`, `ESTADO`, `FECHA`, `ciudadano_id`) VALUES
(3, 'fff', 'YA_ATENDIDO', '2024-03-15 23:00:00', 1),
(5, 'bb', 'EN_ESPERA', '2024-06-11 22:00:00', 2),
(6, 'nnn', 'YA_ATENDIDO', '2024-03-30 23:00:00', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_TURNO_ciudadano_id` (`ciudadano_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudadano`
--
ALTER TABLE `ciudadano`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `turno`
--
ALTER TABLE `turno`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turno`
--
ALTER TABLE `turno`
  ADD CONSTRAINT `FK_TURNO_ciudadano_id` FOREIGN KEY (`ciudadano_id`) REFERENCES `ciudadano` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
