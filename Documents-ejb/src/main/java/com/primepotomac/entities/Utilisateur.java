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
@Table(name = "utilisateur", catalog = "document", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"login", "pass"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateur.findByPass", query = "SELECT u FROM Utilisateur u WHERE u.pass = :pass")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "login", nullable = false, length = 254)
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "pass", nullable = false, length = 254)
    private String pass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private List<Appartenancegroupe> appartenancegroupeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private List<Historique> historiqueList;
    @JoinColumn(name = "employee", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private List<Version> versionList;

    public Utilisateur() {
    }

    public Utilisateur(Integer id) {
        this.id = id;
    }

    public Utilisateur(Integer id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public List<Appartenancegroupe> getAppartenancegroupeList() {
        return appartenancegroupeList;
    }

    public void setAppartenancegroupeList(List<Appartenancegroupe> appartenancegroupeList) {
        this.appartenancegroupeList = appartenancegroupeList;
    }

    @XmlTransient
    public List<Historique> getHistoriqueList() {
        return historiqueList;
    }

    public void setHistoriqueList(List<Historique> historiqueList) {
        this.historiqueList = historiqueList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.primepotomac.entities.Utilisateur[ id=" + id + " ]";
    }
    
}
