package models;
import etu1789.dao.Generic2;
import etu1789.dao.annotation.Column;
import etu1789.dao.annotation.Table;
import etu1789.dao.annotation.ForeignKey;

@Table(libelle = "utilisateurs", base = "postgresql")

public class Utilisateurs extends Generic2{
    @Column(libelle = "id_utilisateur", primaryKey = true)
private Integer idUtilisateur;
public Integer getIdUtilisateur(){ return idUtilisateur; }
public void setIdUtilisateur(Integer o){ idUtilisateur=o; }
@Column(libelle = "nom")
private String nom;
public String getNom(){ return nom; }
public void setNom(String o){ nom=o; }
@Column(libelle = "prenom")
private String prenom;
public String getPrenom(){ return prenom; }
public void setPrenom(String o){ prenom=o; }
@Column(libelle = "email")
private String email;
public String getEmail(){ return email; }
public void setEmail(String o){ email=o; }

    public Utilisateurs(){}
public Utilisateurs(Integer o){ idUtilisateur=o; }

}

