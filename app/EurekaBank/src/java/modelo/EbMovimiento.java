/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "eb_movimiento", catalog = "eb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbMovimiento.findAll", query = "SELECT e FROM EbMovimiento e"),
    @NamedQuery(name = "EbMovimiento.findByCodigoMovimiento", query = "SELECT e FROM EbMovimiento e WHERE e.codigoMovimiento = :codigoMovimiento"),
    @NamedQuery(name = "EbMovimiento.findByCostoMovimiento", query = "SELECT e FROM EbMovimiento e WHERE e.costoMovimiento = :costoMovimiento"),
    @NamedQuery(name = "EbMovimiento.findByFechaMovimiento", query = "SELECT e FROM EbMovimiento e WHERE e.fechaMovimiento = :fechaMovimiento"),
    @NamedQuery(name = "EbMovimiento.findByHoraMovimiento", query = "SELECT e FROM EbMovimiento e WHERE e.horaMovimiento = :horaMovimiento"),
    @NamedQuery(name = "EbMovimiento.findByTipoMovimiento", query = "SELECT e FROM EbMovimiento e WHERE e.tipoMovimiento = :tipoMovimiento"),
    @NamedQuery(name = "EbMovimiento.findByMontoMovimiento", query = "SELECT e FROM EbMovimiento e WHERE e.montoMovimiento = :montoMovimiento")})
public class EbMovimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoMovimiento", nullable = false)
    private Integer codigoMovimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CostoMovimiento", precision = 14, scale = 3)
    private BigDecimal costoMovimiento;
    @Column(name = "FechaMovimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;
    @Column(name = "HoraMovimiento")
    @Temporal(TemporalType.TIME)
    private Date horaMovimiento;
    @Column(name = "TipoMovimiento")
    private Integer tipoMovimiento;
    @Column(name = "MontoMovimiento", precision = 14, scale = 3)
    private BigDecimal montoMovimiento;
    @JoinColumn(name = "CodigoUsuario", referencedColumnName = "CodigoUsuario")
    @ManyToOne
    private EbUsuario codigoUsuario;
    @JoinColumn(name = "CodigoLocal", referencedColumnName = "CodigoLocal")
    @ManyToOne
    private EbLocal codigoLocal;
    @JoinColumn(name = "CodigoCuenta", referencedColumnName = "CodigoCuenta")
    @ManyToOne
    private EbCuenta codigoCuenta;
    @Size(max = 50)
    @Column(name = "UsuarioNombre", length = 50)
    private String usuarioNombre;

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public EbMovimiento() {
    }

    public EbMovimiento(Integer codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public Integer getCodigoMovimiento() {
        return codigoMovimiento;
    }

    public void setCodigoMovimiento(Integer codigoMovimiento) {
        this.codigoMovimiento = codigoMovimiento;
    }

    public BigDecimal getCostoMovimiento() {
        return costoMovimiento;
    }

    public void setCostoMovimiento(BigDecimal costoMovimiento) {
        this.costoMovimiento = costoMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Date getHoraMovimiento() {
        return horaMovimiento;
    }

    public void setHoraMovimiento(Date horaMovimiento) {
        this.horaMovimiento = horaMovimiento;
    }

    public Integer getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Integer tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(BigDecimal montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
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

    public EbCuenta getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(EbCuenta codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoMovimiento != null ? codigoMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EbMovimiento)) {
            return false;
        }
        EbMovimiento other = (EbMovimiento) object;
        if ((this.codigoMovimiento == null && other.codigoMovimiento != null) || (this.codigoMovimiento != null && !this.codigoMovimiento.equals(other.codigoMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.EbMovimiento[ codigoMovimiento=" + codigoMovimiento + " ]";
    }
    
}
