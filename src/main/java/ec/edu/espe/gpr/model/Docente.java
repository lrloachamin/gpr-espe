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
@Table(name = "docente")
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_DOCENTE")
    private Integer codigoDocente;
    @Basic(optional = false)
    @Column(name = "ID_DOCENTE")
    private String idDocente;
    @Basic(optional = false)
    @Column(name = "NOMBRE_DOCENTE")
    private String nombreDocente;
    @Basic(optional = false)
    @Column(name = "APELLIDO_DOCENTE")
    private String apellidoDocente;
    @Basic(optional = false)
    @Column(name = "CEDULA_DOCENTE")
    private String cedulaDocente;
    @Basic(optional = false)
    @Column(name = "TELEFONO_DOCENTE")
    private String telefonoDocente;
    @Basic(optional = false)
    @Column(name = "CORREO_DOCENTE")
    private String correoDocente;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "COD_CARGO", referencedColumnName = "COD_CARGO")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Cargo codCargo;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne(fetch= FetchType.LAZY)
    private Usuario codigoUsuario;
    
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDocente",fetch= FetchType.LAZY)
    private List<TareaDocente> tareaDocenteList;

    public Docente() {
    }

    public Docente(Integer codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public Docente(Integer codigoDocente, String idDocente, String nombreDocente, String apellidoDocente, String cedulaDocente, String telefonoDocente, String correoDocente) {
        this.codigoDocente = codigoDocente;
        this.idDocente = idDocente;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.cedulaDocente = cedulaDocente;
        this.telefonoDocente = telefonoDocente;
        this.correoDocente = correoDocente;
    }

    public Integer getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(Integer codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public String getCedulaDocente() {
        return cedulaDocente;
    }

    public void setCedulaDocente(String cedulaDocente) {
        this.cedulaDocente = cedulaDocente;
    }

    public String getTelefonoDocente() {
        return telefonoDocente;
    }

    public void setTelefonoDocente(String telefonoDocente) {
        this.telefonoDocente = telefonoDocente;
    }

    public String getCorreoDocente() {
        return correoDocente;
    }

    public void setCorreoDocente(String correoDocente) {
        this.correoDocente = correoDocente;
    }

    public Cargo getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Cargo codCargo) {
        this.codCargo = codCargo;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public List<TareaDocente> getTareaDocenteList() {
        return tareaDocenteList;
    }

    public void setTareaDocenteList(List<TareaDocente> tareaDocenteList) {
        this.tareaDocenteList = tareaDocenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDocente != null ? codigoDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.codigoDocente == null && other.codigoDocente != null) || (this.codigoDocente != null && !this.codigoDocente.equals(other.codigoDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Docente[ codigoDocente=" + codigoDocente + " ]";
    }
    
}