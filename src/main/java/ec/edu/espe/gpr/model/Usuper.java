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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuper")
public class Usuper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @Column(name = "COD_USUPER")
    private String codUsuper;
    
    @Column(name = "FECHA_ASG_USUPER")
    @Temporal(TemporalType.DATE)
    private Date fechaAsgUsuper;
    @Column(name = "FECH_RETIRO_USUPER_OPCPER")
    @Temporal(TemporalType.DATE)
    private Date fechRetiroUsuperOpcper;
    
    @JoinColumn(name = "CODIGO_PERFIL", referencedColumnName = "CODIGO_PERFIL")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Perfil codigoPerfil;
    
    @JoinColumn(name = "CODIGO_USUARIO", referencedColumnName = "CODIGO_USUARIO")
    @ManyToOne(optional = false,fetch= FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario codigoUsuario;

    public Usuper() {
    }

    public Usuper(String codUsuper) {
        this.codUsuper = codUsuper;
    }

    public Usuper(String codUsuper, Date fechaAsgUsuper) {
        this.codUsuper = codUsuper;
        this.fechaAsgUsuper = fechaAsgUsuper;
    }

    public String getCodUsuper() {
        return codUsuper;
    }

    public void setCodUsuper(String codUsuper) {
        this.codUsuper = codUsuper;
    }

    public Date getFechaAsgUsuper() {
        return fechaAsgUsuper;
    }

    public void setFechaAsgUsuper(Date fechaAsgUsuper) {
        this.fechaAsgUsuper = fechaAsgUsuper;
    }

    public Date getFechRetiroUsuperOpcper() {
        return fechRetiroUsuperOpcper;
    }

    public void setFechRetiroUsuperOpcper(Date fechRetiroUsuperOpcper) {
        this.fechRetiroUsuperOpcper = fechRetiroUsuperOpcper;
    }

    public Perfil getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Perfil codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    public Usuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuper != null ? codUsuper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuper)) {
            return false;
        }
        Usuper other = (Usuper) object;
        if ((this.codUsuper == null && other.codUsuper != null) || (this.codUsuper != null && !this.codUsuper.equals(other.codUsuper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.gpr.model.Usuper[ codUsuper=" + codUsuper + " ]";
    }
    
}
