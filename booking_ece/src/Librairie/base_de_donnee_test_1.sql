-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 17 avr. 2025 à 07:26
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `base_de_donnee_test_1`
--

-- --------------------------------------------------------

--
-- Structure de la table `client_table`
--

DROP TABLE IF EXISTS `client_table`;
CREATE TABLE IF NOT EXISTS `client_table` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_identifiant` varchar(30) NOT NULL,
  `client_motdepasse` varchar(40) NOT NULL,
  `client_dateinscription` varchar(30) NOT NULL,
  `client_categorie` varchar(30) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client_table`
--

INSERT INTO `client_table` (`client_id`, `client_identifiant`, `client_motdepasse`, `client_dateinscription`, `client_categorie`) VALUES
(4, 'AntoinePOIRIER', 'MOTDEPAPASSE', 'Thu Mar 27 18:54:49 CET 2025', 'normal'),
(5, 'Liollyna', 'motdepasse2', 'Wed Mar 26 09:40:37 CET 2025', 'Administrateur'),
(6, 'AntoinePOIRIER', 'asasasasasasa', 'Wed Mar 26 09:46:05 CET 2025', 'Client');

-- --------------------------------------------------------

--
-- Structure de la table `hebergement_table`
--

DROP TABLE IF EXISTS `hebergement_table`;
CREATE TABLE IF NOT EXISTS `hebergement_table` (
  `hebergement_id` int(11) NOT NULL AUTO_INCREMENT,
  `hebergement_titre` varchar(50) NOT NULL,
  `hebergement_description` varchar(200) NOT NULL,
  `hebergement_categorie` varchar(20) NOT NULL,
  `hebergement_rang` int(11) NOT NULL,
  `hebergement_prix` int(11) NOT NULL,
  `hebergement_debut_location` varchar(40) NOT NULL,
  `hebergement_fin_location` varchar(40) NOT NULL,
  `hebergement_nombre_personne` int(11) NOT NULL,
  `hebergement_detail_wifi` tinyint(1) NOT NULL,
  `hebergement_detail_petit_dejeuner` tinyint(1) NOT NULL,
  `hebergement_detail_piscine_interieure` tinyint(1) NOT NULL,
  `hebergement_detail_centre_sportif` tinyint(1) NOT NULL,
  `hebergement_id_locataire` int(11) NOT NULL,
  PRIMARY KEY (`hebergement_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hebergement_table`
--

INSERT INTO `hebergement_table` (`hebergement_id`, `hebergement_titre`, `hebergement_description`, `hebergement_categorie`, `hebergement_rang`, `hebergement_prix`, `hebergement_debut_location`, `hebergement_fin_location`, `hebergement_nombre_personne`, `hebergement_detail_wifi`, `hebergement_detail_petit_dejeuner`, `hebergement_detail_piscine_interieure`, `hebergement_detail_centre_sportif`, `hebergement_id_locataire`) VALUES
(1, 'Hebergement vide', 'Description vide', 'Sans catégorie', 1, 1000, 'Tue Apr 01 15:07:55 CEST 2025', 'Tue Apr 01 15:07:55 CEST 2025', 1, 0, 0, 0, 0, -1),
(2, 'Hebergement vide', 'Description vide', 'Sans catégorie', 1, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, -1),
(3, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(4, 'Hebergement vide', 'Description vide', 'Sans catégorie', 1, 1000, 'Tue Apr 01 15:12:24 CEST 2025', 'Tue Apr 01 15:12:24 CEST 2025', 1, 0, 0, 0, 0, -1),
(6, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(7, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(8, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(9, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(10, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(11, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(12, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(13, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(14, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(15, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(16, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2),
(17, 'Appartement luxueux', 'Ceci est un appartement', 'appartement', 3, 1000, 'Tue Apr 01 15:11:10 CEST 2025', 'Tue Apr 01 15:11:10 CEST 2025', 1, 0, 0, 0, 0, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
