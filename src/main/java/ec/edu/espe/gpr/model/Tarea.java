/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tarea")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_TAREA")
    private Integer codigoTarea;

    @Column(name = "NOMBRE_TAREA")
    private String nombreTarea;
    
    @Column(name = "FECHA_CREACIONTAREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreaciontarea;
    
    @Column(name = "PRIORIDAD_TAREA")
    private String prioridadTarea;
    
    @Column(name = "DESCRIPICION_TAREA")
    private String descripicionTarea;
    
    @Column(name = "ESTADO_TAREA")
    private Character estadoTarea;
    
    @Column(name = "FECHA_ENTREGA_TAREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntregaTarea;

    @JoinColumn(name = "CODIGO_PROYECTO", referencedColumnName = "CODIGO_PROYECTO")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proyecto codigoProyecto;
    
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoTarea",fetch= FetchType.LAZY)
    @JsonBackReference
    private List<TareaDocente> tareaDocenteList;
    */
}
