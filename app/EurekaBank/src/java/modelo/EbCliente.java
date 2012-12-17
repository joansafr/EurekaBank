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
@Table(name = "eb_cliente", catalog = "eb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbCliente.findAll", query = "SELECT e FROM EbCliente e"),
    @NamedQuery(name = "EbCliente.findByCodigoCliente", query = "SELECT e FROM EbCliente e WHERE e.codigoCliente = :codigoCliente"),
    @NamedQuery(name = "EbCliente.findByNombreCliente", query = "SELECT e FROM EbCliente e WHERE e.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "EbCliente.findByApellidoCliente", query = "SELECT e FROM EbCliente e WHERE e.apellidoCliente = :apellidoCliente"),
    @NamedQuery(name = "EbCliente.findByDniCliente", query = "SELECT e FROM EbCliente e WHERE e.dniCliente = :dniCliente")})
public class EbCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoCliente", nullable = false)
    private Integer codigoCliente;
    @Size(max = 50)
    @Column(name = "NombreCliente", length = 50)
    private String nombreCliente;
    @Size(max = 50)
    @Column(name = "ApellidoCliente", length = 50)
    private String apellidoCliente;
    @Size(max = 8)
    @Column(name = "DniCliente", length = 8)
    private String dniCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCliente")
    private Collection<EbCuenta> ebCuentaCollection;

    public EbCliente() {
    }

    public EbCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
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
        hash += (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EbCliente)) {
            return false;
        }
        EbCliente other = (EbCliente) object;
        if ((this.codigoCliente == null && other.codigoCliente != null) || (this.codigoCliente != null && !this.codigoCliente.equals(other.codigoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCliente+" "+apellidoCliente;
    }
    
}
