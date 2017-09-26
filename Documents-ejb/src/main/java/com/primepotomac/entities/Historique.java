/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primepotomac.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nzuguem
 */
@Entity
@Table(name = "historique", catalog = "document", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historique.findAll", query = "SELECT h FROM Historique h"),
    @NamedQuery(name = "Historique.findById", query = "SELECT h FROM Historique h WHERE h.id = :id"),
    @NamedQuery(name = "Historique.findByTypeAcces", query = "SELECT h FROM Historique h WHERE h.typeAcces = :typeAcces"),
    @NamedQuery(name = "Historique.findByDateAcces", query = "SELECT h FROM Historique h WHERE h.dateAcces = :dateAcces")})
public class Historique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "typeAcces", nullable = false, length = 254)
    private String typeAcces;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateAcces", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcces;
    @JoinColumn(name = "version", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Version version;
    @JoinColumn(name = "utilisateur", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Historique() {
    }

    public Historique(Integer id) {
        this.id = id;
    }

    public Historique(Integer id, String typeAcces, Date dateAcces) {
        this.id = id;
        this.typeAcces = typeAcces;
        this.dateAcces = dateAcces;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeAcces() {
        return typeAcces;
    }

    public void setTypeAcces(String typeAcces) {
        this.typeAcces = typeAcces;
    }

    public Date getDateAcces() {
        return dateAcces;
    }

    public void setDateAcces(Date dateAcces) {
        this.dateAcces = dateAcces;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
        if (!(object instanceof Historique)) {
            return false;
        }
        Historique other = (Historique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.primepotomac.entities.Historique[ id=" + id + " ]";
    }
    
}
