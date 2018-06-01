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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "membresia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membresia.findAll", query = "SELECT m FROM Membresia m")
    , @NamedQuery(name = "Membresia.findByIdMembresia", query = "SELECT m FROM Membresia m WHERE m.idMembresia = :idMembresia")
    , @NamedQuery(name = "Membresia.findByValor", query = "SELECT m FROM Membresia m WHERE m.valor = :valor")
    , @NamedQuery(name = "Membresia.findByFechaIn", query = "SELECT m FROM Membresia m WHERE m.fechaIn = :fechaIn")
    , @NamedQuery(name = "Membresia.findByFechaO", query = "SELECT m FROM Membresia m WHERE m.fechaO = :fechaO")})
public class Membresia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMembresia")
    private Integer idMembresia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIn")
    @Temporal(TemporalType.DATE)
    private Date fechaIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaO")
    @Temporal(TemporalType.DATE)
    private Date fechaO;
    @JoinColumn(name = "TipoMembresia", referencedColumnName = "idTipoMembresia")
    @ManyToOne(optional = false)
    private Tipomembresia tipoMembresia;
    @OneToMany(mappedBy = "membresia")
    private List<Usuario> usuarioList;

    public Membresia() {
    }

    public Membresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Membresia(Integer idMembresia, double valor, Date fechaIn, Date fechaO) {
        this.idMembresia = idMembresia;
        this.valor = valor;
        this.fechaIn = fechaIn;
        this.fechaO = fechaO;
    }

    public Integer getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(Integer idMembresia) {
        this.idMembresia = idMembresia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(Date fechaIn) {
        this.fechaIn = fechaIn;
    }

    public Date getFechaO() {
        return fechaO;
    }

    public void setFechaO(Date fechaO) {
        this.fechaO = fechaO;
    }

    public Tipomembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(Tipomembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMembresia != null ? idMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membresia)) {
            return false;
        }
        Membresia other = (Membresia) object;
        if ((this.idMembresia == null && other.idMembresia != null) || (this.idMembresia != null && !this.idMembresia.equals(other.idMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alexandria.entidades.Membresia[ idMembresia=" + idMembresia + " ]";
    }
    
}
