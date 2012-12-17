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
@Table(name = "eb_usuario", catalog = "eb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbUsuario.findAll", query = "SELECT e FROM EbUsuario e"),
    @NamedQuery(name = "EbUsuario.findByCodigoUsuario", query = "SELECT e FROM EbUsuario e WHERE e.codigoUsuario = :codigoUsuario"),
    @NamedQuery(name = "EbUsuario.findByNombreUsuario", query = "SELECT e FROM EbUsuario e WHERE e.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "EbUsuario.findByIdentificadorUsuario", query = "SELECT e FROM EbUsuario e WHERE e.identificadorUsuario = :identificadorUsuario"),
    @NamedQuery(name = "EbUsuario.findByContrasenaUsuario", query = "SELECT e FROM EbUsuario e WHERE e.contrasenaUsuario = :contrasenaUsuario")})
public class EbUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoUsuario", nullable = false)
    private Integer codigoUsuario;
    @Size(max = 50)
    @Column(name = "NombreUsuario", length = 50)
    private String nombreUsuario;
    @Size(max = 20)
    @Column(name = "IdentificadorUsuario", length = 20)
    private String identificadorUsuario;
    @Size(max = 64)
    @Column(name = "ContrasenaUsuario", length = 64)
    private String contrasenaUsuario;
    @OneToMany(mappedBy = "codigoUsuario")
    private Collection<EbMovimiento> ebMovimientoCollection;
    @OneToMany(mappedBy = "codigoUsuario")
    private Collection<EbCuenta> ebCuentaCollection;

    public EbUsuario() {
    }

    public EbUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdentificadorUsuario() {
        return identificadorUsuario;
    }

    public void setIdentificadorUsuario(String identificadorUsuario) {
        this.identificadorUsuario = identificadorUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
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
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EbUsuario)) {
            return false;
        }
        EbUsuario other = (EbUsuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EbUsuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
