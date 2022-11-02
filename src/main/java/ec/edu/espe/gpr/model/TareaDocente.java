/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author luisl
 */
@Entity
@Table(name = "tarea_docente")
@NamedQueries({
    @NamedQuery(name = "TareaDocente.findAll", query = "SELECT t FROM TareaDocente t")})
public class TareaDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_TAREA_DOCENTE")
    private Integer codigoTareaDocente;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "ARCHIVO_TAREA_DOCENTE")
    private String archivoTareaDocente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "INDICADOR_TAREADOCENTE")
    private BigDecimal indicadorTareadocente;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_TAREADOCENTE")
    private String descripcionTareadocente;
    @Basic(optional = false)
    @Column(name = "ESTADO_TAREA_DOCENTE")
    private String estadoTareaDocente;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "CODIGO_DOCENTE", referencedColumnName = "CODIGO_DOCENTE")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Docente codigoDocente;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "CODIGO_TAREA", referencedColumnName = "CODIGO_TAREA")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Tarea codigoTarea;

    public TareaDocente() {
    }

    public TareaDocente(Integer codigoTareaDocente) {
        this.codigoTareaDocente = codigoTareaDocente;
    }

    public TareaDocente(Integer codigoTareaDocente, Date fechaEntrega, String archivoTareaDocente, BigDecimal indicadorTareadocente, String descripcionTareadocente, String estadoTareaDocente) {
        this.codigoTareaDocente = codigoTareaDocente;
        this.fechaEntrega = fechaEntrega;
        this.archivoTareaDocente = archivoTareaDocente;
        this.indicadorTareadocente = indicadorTareadocente;
        this.descripcionTareadocente = descripcionTareadocente;
        this.estadoTareaDocente = estadoTareaDocente;
    }

    public Integer getCodigoTareaDocente() {
        return codigoTareaDocente;
    }

    public void setCodigoTareaDocente(Integer codigoTareaDocente) {
        this.codigoTareaDocente = codigoTareaDocente;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getArchivoTareaDocente() {
        return archivoTareaDocente;
    }

    public void setArchivoTareaDocente(String archivoTareaDocente) {
        this.archivoTareaDocente = archivoTareaDocente;
    }

    public BigDecimal getIndicadorTareadocente() {
        return indicadorTareadocente;
    }

    public void setIndicadorTareadocente(BigDecimal indicadorTareadocente) {
        this.indicadorTareadocente = indicadorTareadocente;
    }

    public String getDescripcionTareadocente() {
        return descripcionTareadocente;
    }

    public void setDescripcionTareadocente(String descripcionTareadocente) {
        this.descripcionTareadocente = descripcionTareadocente;
    }

    public String getEstadoTareaDocente() {
        return estadoTareaDocente;
    }

    public void setEstadoTareaDocente(String estadoTareaDocente) {
        this.estadoTareaDocente = estadoTareaDocente;
    }

    public Docente getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(Docente codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public Tarea getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(Tarea codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTareaDocente != null ? codigoTareaDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaDocente)) {
            return false;
        }
        TareaDocente other = (TareaDocente) object;
        if ((this.codigoTareaDocente == null && other.codigoTareaDocente != null) || (this.codigoTareaDocente != null && !this.codigoTareaDocente.equals(other.codigoTareaDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.TareaDocente[ codigoTareaDocente=" + codigoTareaDocente + " ]";
    }
    
}
