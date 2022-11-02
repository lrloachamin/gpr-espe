/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author luisl
 */
@Entity
@Table(name = "opcion")
@NamedQueries({
    @NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")})
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_OPCION")
    private String codigoOpcion;
    @Basic(optional = false)
    @Column(name = "DESC_OPCION")
    private String descOpcion;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY, mappedBy = "codigoOpcion")
    private List<OpcPer> opcPerList;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "COD_SISTEMA", referencedColumnName = "COD_SISTEMA")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Sistema codSistema;

    public Opcion() {
    }

    public Opcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public Opcion(String codigoOpcion, String descOpcion) {
        this.codigoOpcion = codigoOpcion;
        this.descOpcion = descOpcion;
    }

    public String getCodigoOpcion() {
        return codigoOpcion;
    }

    public void setCodigoOpcion(String codigoOpcion) {
        this.codigoOpcion = codigoOpcion;
    }

    public String getDescOpcion() {
        return descOpcion;
    }

    public void setDescOpcion(String descOpcion) {
        this.descOpcion = descOpcion;
    }

    public List<OpcPer> getOpcPerList() {
        return opcPerList;
    }

    public void setOpcPerList(List<OpcPer> opcPerList) {
        this.opcPerList = opcPerList;
    }

    public Sistema getCodSistema() {
        return codSistema;
    }

    public void setCodSistema(Sistema codSistema) {
        this.codSistema = codSistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOpcion != null ? codigoOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.codigoOpcion == null && other.codigoOpcion != null) || (this.codigoOpcion != null && !this.codigoOpcion.equals(other.codigoOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Opcion[ codigoOpcion=" + codigoOpcion + " ]";
    }
    
}
