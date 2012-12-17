/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EbMoneda;

/**
 *
 * @author Antonio
 */
@Stateless
public class EbMonedaFacade extends AbstractFacade<EbMoneda> {
    @PersistenceContext(unitName = "EurekaBankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbMonedaFacade() {
        super(EbMoneda.class);
    }
    
}
