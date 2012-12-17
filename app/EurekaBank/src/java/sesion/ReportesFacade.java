/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.EbMovimiento;

/**
 *
 * @author Antonio
 */
@Stateless
public class ReportesFacade extends AbstractFacade<EbMovimiento> {
    @PersistenceContext(unitName = "EurekaBankPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ReportesFacade() {
        super(EbMovimiento.class);
    }


     public List<Object> pa_EB_MovimientosPorCuenta(Integer Cuenta) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_EB_MovimientosPorCuenta(?) }"); 
            query.setParameter(1, Cuenta); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
     public List<Object> pa_EB_MovimientosPorLocal(Integer Local, Date FechaInicio, Date FechaFin) 
     {
        try{
            Query query = em.createNativeQuery("{ CALL pa_EB_MovimientosPorLocal(?,?,?) }"); 
            query.setParameter(1, Local); 
            query.setParameter(2, FechaInicio); 
            query.setParameter(3, FechaFin); 
            return query.getResultList();
        }catch(Exception e){
            return null;
        }
     }
    
}
