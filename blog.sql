-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-10-2015 a las 16:00:13
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `blog`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE IF NOT EXISTS `entrada` (
`id` bigint(11) NOT NULL,
  `ent_titulo` varchar(5000) NOT NULL,
  `ent_fecha` date NOT NULL,
  `ent_contenido` varchar(5000) NOT NULL,
  `ent_usu_usuario` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`id`, `ent_titulo`, `ent_fecha`, `ent_contenido`, `ent_usu_usuario`) VALUES
(3, 'tito', '2015-10-07', 'tito', 'usu1'),
(6, 'asdfafds', '2015-10-13', 'asdfasdf', 'usu1'),
(9, 'tito', '2015-10-13', 'hola', 'usu1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`usu_id` bigint(20) NOT NULL,
  `usu_password` varchar(20) NOT NULL,
  `usu_usuario` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usu_id`, `usu_password`, `usu_usuario`) VALUES
(1, 'usu1', 'usu1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`usu_id`,`usu_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
MODIFY `usu_id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
