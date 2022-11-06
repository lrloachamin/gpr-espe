/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "CODIGO_PROYECTO")
    private Integer codigoProyecto;
    
    @Column(name = "NOMBRE_PROYECTO")
    private String nombreProyecto;
    
    @Column(name = "FECHA_CREACIONPROYECTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionproyecto;
    
    @Column(name = "DESCRIPCION_PROYECTO")
    private String descripcionProyecto;
    
    @Column(name = "ESTADO_PROYECTO")
    private String estadoProyecto;
    
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProyecto",fetch= FetchType.LAZY)
    private List<Tarea> tareaList;

    public Proyecto() {
    }

    public Proyecto(Integer codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public Proyecto(Integer codigoProyecto, String nombreProyecto, Date fechaCreacionproyecto, String descripcionProyecto, String estadoProyecto) {
        this.codigoProyecto = codigoProyecto;
        this.nombreProyecto = nombreProyecto;
        this.fechaCreacionproyecto = fechaCreacionproyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.estadoProyecto = estadoProyecto;
    }

    public Integer getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaCreacionproyecto() {
        return fechaCreacionproyecto;
    }

    public void setFechaCreacionproyecto(Date fechaCreacionproyecto) {
        this.fechaCreacionproyecto = fechaCreacionproyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProyecto != null ? codigoProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.codigoProyecto == null && other.codigoProyecto != null) || (this.codigoProyecto != null && !this.codigoProyecto.equals(other.codigoProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Proyecto[ codigoProyecto=" + codigoProyecto + " ]";
    }
    
}
