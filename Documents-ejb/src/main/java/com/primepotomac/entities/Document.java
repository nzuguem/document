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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nzuguem
 */
@Entity
@Table(name = "document", catalog = "document", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id"),
    @NamedQuery(name = "Document.findByNom", query = "SELECT d FROM Document d WHERE d.nom = :nom"),
    @NamedQuery(name = "Document.findByNature", query = "SELECT d FROM Document d WHERE d.nature = :nature"),
    @NamedQuery(name = "Document.findByType", query = "SELECT d FROM Document d WHERE d.type = :type"),
    @NamedQuery(name = "Document.findByDateDepot", query = "SELECT d FROM Document d WHERE d.dateDepot = :dateDepot"),
    @NamedQuery(name = "Document.findByChemin", query = "SELECT d FROM Document d WHERE d.chemin = :chemin"),
    @NamedQuery(name = "Document.findByDescription", query = "SELECT d FROM Document d WHERE d.description = :description"),
    @NamedQuery(name = "Document.findByDateFinalisation", query = "SELECT d FROM Document d WHERE d.dateFinalisation = :dateFinalisation")})
public class Document implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "nature", nullable = false, length = 254)
    private String nature;
    @Size(max = 254)
    @Column(name = "type", length = 254)
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDepot", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "chemin", nullable = false, length = 254)
    private String chemin;
    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;
    @Column(name = "dateFinalisation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinalisation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private List<Version> versionList;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Document(Integer id, String nom, String nature, Date dateDepot, String chemin) {
        this.id = id;
        this.nom = nom;
        this.nature = nature;
        this.dateDepot = dateDepot;
        this.chemin = chemin;
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

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFinalisation() {
        return dateFinalisation;
    }

    public void setDateFinalisation(Date dateFinalisation) {
        this.dateFinalisation = dateFinalisation;
    }

    @XmlTransient
    public List<Version> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<Version> versionList) {
        this.versionList = versionList;
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
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.primepotomac.entities.Document[ id=" + id + " ]";
    }
    
}
