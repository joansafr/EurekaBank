/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EbMovimiento;

/**
 *
 * @author Antonio
 */
@Stateless
public class EbMovimientoFacade extends AbstractFacade<EbMovimiento> {
    @PersistenceContext(unitName = "EurekaBankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbMovimientoFacade() {
        super(EbMovimiento.class);
    }
    
}
