/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primepotomac.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang;

/**
 *
 * @author nzuguem
 */
@Entity
@Table(name = "appartenancegroupe", catalog = "document", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"utilisateur", "groupe"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appartenancegroupe.findAll", query = "SELECT a FROM Appartenancegroupe a"),
    @NamedQuery(name = "Appartenancegroupe.findById", query = "SELECT a FROM Appartenancegroupe a WHERE a.id = :id")})
public class Appartenancegroupe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "groupe", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Groupe groupe;
    @JoinColumn(name = "utilisateur", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Appartenancegroupe() {
    }

    public Appartenancegroupe(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
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
        if (!(object instanceof Appartenancegroupe)) {
            return false;
        }
        Appartenancegroupe other = (Appartenancegroupe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.primepotomac.entities.Appartenancegroupe[ id=" + id + " ]";
    }
    
}
