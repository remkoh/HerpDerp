/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Temp
 */
@Entity
@Table(name = "taxrate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxrate.findAll", query = "SELECT t FROM Taxrate t"),
    @NamedQuery(name = "Taxrate.findById", query = "SELECT t FROM Taxrate t WHERE t.id = :id"),
    @NamedQuery(name = "Taxrate.findByTaxrate", query = "SELECT t FROM Taxrate t WHERE t.taxrate = :taxrate")})
public class Taxrate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAXRATE")
    private Double taxrate;
    @OneToMany(mappedBy = "taxrateidId")
    private Collection<Productcategory> productcategoryCollection;

    public Taxrate() {
    }

    public Taxrate(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Double taxrate) {
        this.taxrate = taxrate;
    }

    @XmlTransient
    public Collection<Productcategory> getProductcategoryCollection() {
        return productcategoryCollection;
    }

    public void setProductcategoryCollection(Collection<Productcategory> productcategoryCollection) {
        this.productcategoryCollection = productcategoryCollection;
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
        if (!(object instanceof Taxrate)) {
            return false;
        }
        Taxrate other = (Taxrate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BTW: " + this.getTaxrate().toString();
    }
    
}
