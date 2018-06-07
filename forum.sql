-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 07 Juin 2018 à 13:41
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `forum`
--

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `categorie_id` int(11) DEFAULT NULL,
  `utilisateur_id` varchar(50) DEFAULT NULL,
  `date_creation` datetime NOT NULL,
  `date_update` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id`, `nom`, `categorie_id`, `utilisateur_id`, `date_creation`, `date_update`) VALUES
(1, 'Film', NULL, NULL, '2018-06-06 12:08:49', '2018-06-06 12:08:49'),
(2, 'action', 1, NULL, '2018-06-06 12:20:09', '2018-06-07 11:29:57'),
(3, 'Informatique', NULL, NULL, '2018-06-06 12:21:00', '2018-06-06 12:21:00'),
(4, 'Linux', 3, NULL, '2018-06-06 12:21:05', '2018-06-06 14:42:11'),
(5, 'Livre', NULL, NULL, '2018-06-06 14:32:38', '2018-06-06 14:32:38'),
(6, 'Science Fiction', 5, NULL, '2018-06-06 14:32:50', '2018-06-06 14:32:50'),
(7, 'Fantasy', 5, NULL, '2018-06-06 14:32:59', '2018-06-06 14:33:17');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `texte` varchar(255) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_update` datetime NOT NULL,
  `sujet_id` int(11) NOT NULL,
  `utilisateur_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `message`
--

INSERT INTO `message` (`id`, `texte`, `date_creation`, `date_update`, `sujet_id`, `utilisateur_id`) VALUES
(1, 'c\'est une belle histoire', '2018-06-07 07:58:00', '2018-06-07 07:58:00', 1, NULL),
(2, 'c \'est une autre histoire', '2018-06-07 08:57:19', '2018-06-07 08:57:19', 2, NULL),
(3, 'm2i et romy c\'est un romand ', '2018-06-07 08:57:19', '2018-06-07 08:57:19', 2, NULL),
(4, 'lkdsjflksdlkfjsjdlkdjfkl', '2018-06-07 07:58:00', '2018-06-07 07:58:00', 1, NULL),
(5, '544665', '2018-06-07 07:58:00', '2018-06-07 07:58:00', 1, NULL),
(6, 'gare aux gars roux', '2018-06-07 13:35:49', '2018-06-07 13:35:49', 3, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `sujet`
--

CREATE TABLE `sujet` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_update` datetime NOT NULL,
  `categorie_id` int(11) NOT NULL,
  `utilisateur_id` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `sujet`
--

INSERT INTO `sujet` (`id`, `titre`, `date_creation`, `date_update`, `categorie_id`, `utilisateur_id`) VALUES
(1, 'une histoire', '2018-06-07 07:58:00', '2018-06-07 07:58:00', 2, NULL),
(2, 'M2i', '2018-06-07 08:57:19', '2018-06-07 08:57:19', 2, NULL),
(3, 'Le loup garoux', '2018-06-07 13:35:49', '2018-06-07 13:35:49', 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `email` varchar(50) NOT NULL,
  `pseudo` varchar(50) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `role` tinyint(4) NOT NULL,
  `birthday` date NOT NULL,
  `ban` tinyint(4) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_update` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`email`, `pseudo`, `mdp`, `role`, `birthday`, `ban`, `date_creation`, `date_update`) VALUES
('admin@free.fr', 'zzz', '484908208d2959e7ad7b6b92f7919304a31e50f5cfd642d84319e12bf54560a27c076a4fe31bf3ed44eb44b2dea4f3905c5e15d48a07b569e86aecb05d52631c', 1, '2018-06-03', 0, '2018-06-06 09:56:01', '2018-06-06 09:56:01');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cat_id` (`categorie_id`),
  ADD KEY `user_id` (`utilisateur_id`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id_message` (`utilisateur_id`),
  ADD KEY `sujet_id` (`sujet_id`);

--
-- Index pour la table `sujet`
--
ALTER TABLE `sujet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cat_id_sujet` (`categorie_id`),
  ADD KEY `user_id_sujet` (`utilisateur_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `sujet`
--
ALTER TABLE `sujet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
