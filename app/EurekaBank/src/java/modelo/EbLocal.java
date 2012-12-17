/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "eb_local", catalog = "eb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbLocal.findAll", query = "SELECT e FROM EbLocal e"),
    @NamedQuery(name = "EbLocal.findByCodigoLocal", query = "SELECT e FROM EbLocal e WHERE e.codigoLocal = :codigoLocal"),
    @NamedQuery(name = "EbLocal.findByNombreLocal", query = "SELECT e FROM EbLocal e WHERE e.nombreLocal = :nombreLocal"),
    @NamedQuery(name = "EbLocal.findByDireccionLocal", query = "SELECT e FROM EbLocal e WHERE e.direccionLocal = :direccionLocal")})
public class EbLocal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoLocal", nullable = false)
    private Integer codigoLocal;
    @Size(max = 50)
    @Column(name = "NombreLocal", length = 50)
    private String nombreLocal;
    @Size(max = 50)
    @Column(name = "DireccionLocal", length = 50)
    private String direccionLocal;
    @OneToMany(mappedBy = "codigoLocal")
    private Collection<EbMovimiento> ebMovimientoCollection;
    @OneToMany(mappedBy = "codigoLocal")
    private Collection<EbCuenta> ebCuentaCollection;

    public EbLocal() {
    }

    public EbLocal(Integer codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public Integer getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(Integer codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDireccionLocal() {
        return direccionLocal;
    }

    public void setDireccionLocal(String direccionLocal) {
        this.direccionLocal = direccionLocal;
    }

    @XmlTransient
    public Collection<EbMovimiento> getEbMovimientoCollection() {
        return ebMovimientoCollection;
    }

    public void setEbMovimientoCollection(Collection<EbMovimiento> ebMovimientoCollection) {
        this.ebMovimientoCollection = ebMovimientoCollection;
    }

    @XmlTransient
    public Collection<EbCuenta> getEbCuentaCollection() {
        return ebCuentaCollection;
    }

    public void setEbCuentaCollection(Collection<EbCuenta> ebCuentaCollection) {
        this.ebCuentaCollection = ebCuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLocal != null ? codigoLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EbLocal)) {
            return false;
        }
        EbLocal other = (EbLocal) object;
        if ((this.codigoLocal == null && other.codigoLocal != null) || (this.codigoLocal != null && !this.codigoLocal.equals(other.codigoLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreLocal;
    }
    
}
