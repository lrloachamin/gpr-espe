/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gpr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tarea_docente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TareaDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CODIGO_TAREA_DOCENTE")
    private Integer codigoTareaDocente;

    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;

    @Column(name = "ARCHIVO_TAREA_DOCENTE")
    private String archivoTareaDocente;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation

    @Column(name = "INDICADOR_TAREADOCENTE")
    private BigDecimal indicadorTareadocente;

    @Column(name = "DESCRIPCION_TAREADOCENTE")
    private String descripcionTareadocente;

    @Column(name = "ESTADO_TAREA_DOCENTE")
    private String estadoTareaDocente;

    @JoinColumn(name = "CODIGO_DOCENTE", referencedColumnName = "CODIGO_DOCENTE")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Docente codigoDocente;

    @JoinColumn(name = "CODIGO_TAREA", referencedColumnName = "CODIGO_TAREA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tarea codigoTarea;
}
