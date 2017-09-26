/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primepotomac.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nzuguem
 */
@Entity
@Table(name = "employee", catalog = "document", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"matricule"}),
    @UniqueConstraint(columnNames = {"nom", "prenom", "dateNaissance"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByNom", query = "SELECT e FROM Employee e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employee.findByPrenom", query = "SELECT e FROM Employee e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employee.findBySexe", query = "SELECT e FROM Employee e WHERE e.sexe = :sexe"),
    @NamedQuery(name = "Employee.findByDateNaissance", query = "SELECT e FROM Employee e WHERE e.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Employee.findByMatricule", query = "SELECT e FROM Employee e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Employee.findByPoste", query = "SELECT e FROM Employee e WHERE e.poste = :poste"),
    @NamedQuery(name = "Employee.findByMail", query = "SELECT e FROM Employee e WHERE e.mail = :mail"),
    @NamedQuery(name = "Employee.findByTelephone", query = "SELECT e FROM Employee e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Employee.findByDateEmbauche", query = "SELECT e FROM Employee e WHERE e.dateEmbauche = :dateEmbauche"),
    @NamedQuery(name = "Employee.findByDateFinService", query = "SELECT e FROM Employee e WHERE e.dateFinService = :dateFinService")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "nom", nullable = false, length = 254)
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom", length = 254)
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexe", nullable = false)
    private Character sexe;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "matricule", nullable = false, length = 254)
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "poste", nullable = false, length = 254)
    private String poste;
    @Size(max = 254)
    @Column(name = "mail", length = 254)
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "telephone", nullable = false, length = 254)
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateEmbauche", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmbauche;
    @Column(name = "dateFinService")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinService;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Utilisateur> utilisateurList;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String nom, Character sexe, String matricule, String poste, String telephone, Date dateEmbauche) {
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        this.matricule = matricule;
        this.poste = poste;
        this.telephone = telephone;
        this.dateEmbauche = dateEmbauche;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Date getDateFinService() {
        return dateFinService;
    }

    public void setDateFinService(Date dateFinService) {
        this.dateFinService = dateFinService;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.primepotomac.entities.Employee[ id=" + id + " ]";
    }
    
}
