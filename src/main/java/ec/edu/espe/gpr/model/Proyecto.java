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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proyecto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProyecto",fetch= FetchType.LAZY)
    @JsonIgnore
    private List<Tarea> tareaList;
}
