/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primepotomac.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nzuguem
 */
@Entity
@Table(name = "version", catalog = "document", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v"),
    @NamedQuery(name = "Version.findById", query = "SELECT v FROM Version v WHERE v.id = :id"),
    @NamedQuery(name = "Version.findByNumero", query = "SELECT v FROM Version v WHERE v.numero = :numero"),
    @NamedQuery(name = "Version.findByValide", query = "SELECT v FROM Version v WHERE v.valide = :valide")})
public class Version implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "numero", nullable = false, length = 254)
    private String numero;
    @Column(name = "valide")
    private Boolean valide;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "version")
    private List<Historique> historiqueList;
    @JoinColumn(name = "document", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Document document;
    @JoinColumn(name = "utilisateur", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Version() {
    }

    public Version(Integer id) {
        this.id = id;
    }

    public Version(Integer id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    @XmlTransient
    public List<Historique> getHistoriqueList() {
        return historiqueList;
    }

    public void setHistoriqueList(List<Historique> historiqueList) {
        this.historiqueList = historiqueList;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.primepotomac.entities.Version[ id=" + id + " ]";
    }
    
}
