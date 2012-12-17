/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EbLocal;

/**
 *
 * @author Antonio
 */
@Stateless
public class EbLocalFacade extends AbstractFacade<EbLocal> {
    @PersistenceContext(unitName = "EurekaBankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbLocalFacade() {
        super(EbLocal.class);
    }
    
}
