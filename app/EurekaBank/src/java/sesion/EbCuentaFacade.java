/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EbCuenta;

/**
 *
 * @author Antonio
 */
@Stateless
public class EbCuentaFacade extends AbstractFacade<EbCuenta> {
    @PersistenceContext(unitName = "EurekaBankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbCuentaFacade() {
        super(EbCuenta.class);
    }
    
}
