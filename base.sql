CREATE TABLE Personnes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    date_naissance DATE NOT NULL
);

-- Table pour stocker les informations sur les emplois
CREATE TABLE Emplois (
    id INT AUTO_INCREMENT PRIMARY KEY,
    personne_id INT NOT NULL,
    nom_entreprise VARCHAR(255) NOT NULL,
    poste_occupe VARCHAR(255) NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE,
    FOREIGN KEY (personne_id) REFERENCES Personnes(id)
);