/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexandria.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findByIdDocumento", query = "SELECT d FROM Documento d WHERE d.idDocumento = :idDocumento")
    , @NamedQuery(name = "Documento.findByTitulo", query = "SELECT d FROM Documento d WHERE d.titulo = :titulo")
    , @NamedQuery(name = "Documento.findByCodigoPublicacion", query = "SELECT d FROM Documento d WHERE d.codigoPublicacion = :codigoPublicacion")
    , @NamedQuery(name = "Documento.findByFechaPublicacion", query = "SELECT d FROM Documento d WHERE d.fechaPublicacion = :fechaPublicacion")
    , @NamedQuery(name = "Documento.findByAbstract1", query = "SELECT d FROM Documento d WHERE d.abstract1 = :abstract1")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDocumento")
    private Integer idDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 45)
    @Column(name = "codigoPublicacion")
    private String codigoPublicacion;
    @Column(name = "fechaPublicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Size(max = 300)
    @Column(name = "Abstract")
    private String abstract1;
    @ManyToMany(mappedBy = "documentoList")
    private List<Categoria> categoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocumento")
    private List<Calificacion> calificacionList;
    @JoinColumn(name = "idtipoDocumento", referencedColumnName = "idtipoDocumento")
    @ManyToOne(optional = false)
    private Tipodocumento idtipoDocumento;

    public Documento() {
    }

    public Documento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Documento(Integer idDocumento, String titulo) {
        this.idDocumento = idDocumento;
        this.titulo = titulo;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigoPublicacion() {
        return codigoPublicacion;
    }

    public void setCodigoPublicacion(String codigoPublicacion) {
        this.codigoPublicacion = codigoPublicacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAbstract1() {
        return abstract1;
    }

    public void setAbstract1(String abstract1) {
        this.abstract1 = abstract1;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    public Tipodocumento getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(Tipodocumento idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alexandria.entidades.Documento[ idDocumento=" + idDocumento + " ]";
    }
    
}
