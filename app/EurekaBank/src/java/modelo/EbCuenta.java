/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "eb_cuenta", catalog = "eb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbCuenta.findAll", query = "SELECT e FROM EbCuenta e"),
    @NamedQuery(name = "EbCuenta.findByCodigoCuenta", query = "SELECT e FROM EbCuenta e WHERE e.codigoCuenta = :codigoCuenta"),
    @NamedQuery(name = "EbCuenta.findByActivo", query = "SELECT e FROM EbCuenta e WHERE e.activo = :activo"),
    @NamedQuery(name = "EbCuenta.findByFechaCreacionCuenta", query = "SELECT e FROM EbCuenta e WHERE e.fechaCreacionCuenta = :fechaCreacionCuenta"),
    @NamedQuery(name = "EbCuenta.findBySaldoCuenta", query = "SELECT e FROM EbCuenta e WHERE e.saldoCuenta = :saldoCuenta")})
public class EbCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoCuenta", nullable = false)
    private Integer codigoCuenta;
    @Column(name = "Activo")
    private Boolean activo;
    @Column(name = "FechaCreacionCuenta")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SaldoCuenta", precision = 14, scale = 3)
    private BigDecimal saldoCuenta;
    @OneToMany(mappedBy = "codigoCuenta")
    private Collection<EbMovimiento> ebMovimientoCollection;
    @JoinColumn(name = "CodigoUsuario", referencedColumnName = "CodigoUsuario")
    @ManyToOne
    private EbUsuario codigoUsuario;
    @JoinColumn(name = "CodigoLocal", referencedColumnName = "CodigoLocal")
    @ManyToOne
    private EbLocal codigoLocal;
    @JoinColumn(name = "CodigoMoneda", referencedColumnName = "CodigoMoneda", nullable = false)
    @ManyToOne(optional = false)
    private EbMoneda codigoMoneda;
    @JoinColumn(name = "CodigoCliente", referencedColumnName = "CodigoCliente", nullable = false)
    @ManyToOne(optional = false)
    private EbCliente codigoCliente;
    @Size(max = 50)
    @Column(name = "UsuarioNombre", length = 50)
    private String usuarioNombre;

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public EbCuenta() {
    }

    public EbCuenta(Integer codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public Integer getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(Integer codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacionCuenta() {
        return fechaCreacionCuenta;
    }

    public void setFechaCreacionCuenta(Date fechaCreacionCuenta) {
        this.fechaCreacionCuenta = fechaCreacionCuenta;
    }

    public BigDecimal getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(BigDecimal saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    @XmlTransient
    public Collection<EbMovimiento> getEbMovimientoCollection() {
        return ebMovimientoCollection;
    }

    public void setEbMovimientoCollection(Collection<EbMovimiento> ebMovimientoCollection) {
        this.ebMovimientoCollection = ebMovimientoCollection;
    }

    public EbUsuario getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(EbUsuario codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public EbLocal getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(EbLocal codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public EbMoneda getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(EbMoneda codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public EbCliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(EbCliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCuenta != null ? codigoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EbCuenta)) {
            return false;
        }
        EbCuenta other = (EbCuenta) object;
        if ((this.codigoCuenta == null && other.codigoCuenta != null) || (this.codigoCuenta != null && !this.codigoCuenta.equals(other.codigoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + codigoCuenta + "] "+ codigoCliente.getNombreCliente() + " " + codigoCliente.getApellidoCliente();
    }
    
}
