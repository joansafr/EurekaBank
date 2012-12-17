/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.EbUsuario;

/**
 *
 * @author Antonio
 */
@Stateless
public class EbUsuarioFacade extends AbstractFacade<EbUsuario> {
    @PersistenceContext(unitName = "EurekaBankPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbUsuarioFacade() {
        super(EbUsuario.class);
    }
    
}
