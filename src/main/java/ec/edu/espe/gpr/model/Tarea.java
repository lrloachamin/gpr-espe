/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author luisl
 */
@Entity
@Table(name = "tarea")
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t")})
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_TAREA")
    private Integer codigoTarea;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TAREA")
    private String nombreTarea;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACIONTAREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreaciontarea;
    @Basic(optional = false)
    @Column(name = "PRIORIDAD_TAREA")
    private String prioridadTarea;
    @Basic(optional = false)
    @Column(name = "DESCRIPICION_TAREA")
    private String descripicionTarea;
    @Basic(optional = false)
    @Column(name = "ESTADO_TAREA")
    private Character estadoTarea;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "CODIGO_PROYECTO", referencedColumnName = "CODIGO_PROYECTO")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    private Proyecto codigoProyecto;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTarea",fetch= FetchType.LAZY)
    private List<TareaDocente> tareaDocenteList;

    public Tarea() {
    }

    public Tarea(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public Tarea(Integer codigoTarea, String nombreTarea, Date fechaCreaciontarea, String prioridadTarea, String descripicionTarea, Character estadoTarea) {
        this.codigoTarea = codigoTarea;
        this.nombreTarea = nombreTarea;
        this.fechaCreaciontarea = fechaCreaciontarea;
        this.prioridadTarea = prioridadTarea;
        this.descripicionTarea = descripicionTarea;
        this.estadoTarea = estadoTarea;
    }

    public Integer getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public Date getFechaCreaciontarea() {
        return fechaCreaciontarea;
    }

    public void setFechaCreaciontarea(Date fechaCreaciontarea) {
        this.fechaCreaciontarea = fechaCreaciontarea;
    }

    public String getPrioridadTarea() {
        return prioridadTarea;
    }

    public void setPrioridadTarea(String prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }

    public String getDescripicionTarea() {
        return descripicionTarea;
    }

    public void setDescripicionTarea(String descripicionTarea) {
        this.descripicionTarea = descripicionTarea;
    }

    public Character getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(Character estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public Proyecto getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(Proyecto codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
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
        hash += (codigoTarea != null ? codigoTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.codigoTarea == null && other.codigoTarea != null) || (this.codigoTarea != null && !this.codigoTarea.equals(other.codigoTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Tarea[ codigoTarea=" + codigoTarea + " ]";
    }
    
}
