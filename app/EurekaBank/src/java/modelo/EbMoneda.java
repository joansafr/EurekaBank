/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "eb_moneda", catalog = "eb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EbMoneda.findAll", query = "SELECT e FROM EbMoneda e"),
    @NamedQuery(name = "EbMoneda.findByCodigoMoneda", query = "SELECT e FROM EbMoneda e WHERE e.codigoMoneda = :codigoMoneda"),
    @NamedQuery(name = "EbMoneda.findByCostoMantenimiento", query = "SELECT e FROM EbMoneda e WHERE e.costoMantenimiento = :costoMantenimiento")})
public class EbMoneda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "CodigoMoneda", nullable = false)
    private Integer codigoMoneda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CostoMantenimiento", precision = 14, scale = 3)
    private BigDecimal costoMantenimiento;
    @Size(max = 50)
    @Column(name = "NombreMoneda", length = 50)
    private String nombreMoneda;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMoneda")
    private Collection<EbCuenta> ebCuentaCollection;

    public EbMoneda() {
    }

    public EbMoneda(Integer codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public Integer getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(Integer codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public BigDecimal getCostoMantenimiento() {
        return costoMantenimiento;
    }
    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public void setCostoMantenimiento(BigDecimal costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
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
        hash += (codigoMoneda != null ? codigoMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EbMoneda)) {
            return false;
        }
        EbMoneda other = (EbMoneda) object;
        if ((this.codigoMoneda == null && other.codigoMoneda != null) || (this.codigoMoneda != null && !this.codigoMoneda.equals(other.codigoMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMoneda;
    }
    
}
