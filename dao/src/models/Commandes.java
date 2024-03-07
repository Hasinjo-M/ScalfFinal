package models;
import etu1789.dao.Generic2;
import etu1789.dao.annotation.Column;
import etu1789.dao.annotation.Table;
import etu1789.dao.annotation.ForeignKey;

@Table(libelle = "commandes", base = "postgresql")

public class Commandes extends Generic2{
    @Column(libelle = "id_commande", primaryKey = true)
private Integer idCommande;
public Integer getIdCommande(){ return idCommande; }
public void setIdCommande(Integer o){ idCommande=o; }
@ForeignKey(libelle = "idUtilisateur", type = Integer.class)
@Column(libelle = "utilisateur_id")
private Utilisateurs utilisateurs;
public Utilisateurs getUtilisateurs(){ return utilisateurs; }
public void setUtilisateurs(Utilisateurs o){ utilisateurs=o; }
@Column(libelle = "montant")
private Double montant;
public Double getMontant(){ return montant; }
public void setMontant(Double o){ montant=o; }
@Column(libelle = "date_commande")
private java.sql.Date dateCommande;
public java.sql.Date getDateCommande(){ return dateCommande; }
public void setDateCommande(java.sql.Date o){ dateCommande=o; }

    public Commandes(){}
public Commandes(Integer o){ idCommande=o; }

}

