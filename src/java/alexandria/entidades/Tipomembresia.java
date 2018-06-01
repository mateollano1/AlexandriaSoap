/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alexandria.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "tipomembresia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomembresia.findAll", query = "SELECT t FROM Tipomembresia t")
    , @NamedQuery(name = "Tipomembresia.findByIdTipoMembresia", query = "SELECT t FROM Tipomembresia t WHERE t.idTipoMembresia = :idTipoMembresia")
    , @NamedQuery(name = "Tipomembresia.findByValor", query = "SELECT t FROM Tipomembresia t WHERE t.valor = :valor")
    , @NamedQuery(name = "Tipomembresia.findByDescripcion", query = "SELECT t FROM Tipomembresia t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tipomembresia.findByNombre", query = "SELECT t FROM Tipomembresia t WHERE t.nombre = :nombre")})
public class Tipomembresia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoMembresia")
    private Integer idTipoMembresia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMembresia")
    private List<Membresia> membresiaList;

    public Tipomembresia() {
    }

    public Tipomembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public Tipomembresia(Integer idTipoMembresia, double valor, String nombre) {
        this.idTipoMembresia = idTipoMembresia;
        this.valor = valor;
        this.nombre = nombre;
    }

    public Integer getIdTipoMembresia() {
        return idTipoMembresia;
    }

    public void setIdTipoMembresia(Integer idTipoMembresia) {
        this.idTipoMembresia = idTipoMembresia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Membresia> getMembresiaList() {
        return membresiaList;
    }

    public void setMembresiaList(List<Membresia> membresiaList) {
        this.membresiaList = membresiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMembresia != null ? idTipoMembresia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomembresia)) {
            return false;
        }
        Tipomembresia other = (Tipomembresia) object;
        if ((this.idTipoMembresia == null && other.idTipoMembresia != null) || (this.idTipoMembresia != null && !this.idTipoMembresia.equals(other.idTipoMembresia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alexandria.entidades.Tipomembresia[ idTipoMembresia=" + idTipoMembresia + " ]";
    }
    
}
