/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.EbLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import modelo.EbCuenta;
import sesion.ReportesFacade;

/**
 *
 * @author Antonio
 */
@ManagedBean
@SessionScoped
public class Reporte {
    private EbLocal _Local;
    private EbCuenta _Cuenta;
    private Date _FechaInicio;
    private Date _FechaFin;
    //Constructor
    public Reporte() {
    }

    public Date getFechaFin() {
        return _FechaFin;
    }

    public void setFechaFin(Date _FechaFin) {
        this._FechaFin = _FechaFin;
    }

    public Date getFechaInicio() {
        return _FechaInicio;
    }

    public void setFechaInicio(Date _FechaInicio) {
        this._FechaInicio = _FechaInicio;
    }

    public EbLocal getLocal() {
        return _Local;
    }

    public void setLocal(EbLocal _Local) {
        this._Local = _Local;
    }
    public EbCuenta getCuenta() {
        return _Cuenta;
    }

    public void setCuenta(EbCuenta _Cuenta) {
        this._Cuenta = _Cuenta;
    }
    //Constructor
    //Parametros




    //Parametros
    
    //Global
    private DataModel DMReporte = null;
    @EJB
    private sesion.ReportesFacade ReportesFacade;
    
    public DataModel getDMReporte() {
        return DMReporte;
    }

    public void setDMReporte(DataModel DMReporte) {
        this.DMReporte = DMReporte;
    }
    //Global
    
    //Recuperacion
    public DataModel pa_EB_MovimientosPorCuenta() 
     {
        if (ValidarParametro() == true) {
             DMReporte = new ListDataModel(ReportesFacade.pa_EB_MovimientosPorCuenta(getCuenta().getCodigoCuenta())); 
            }
            return DMReporte;
     }
     public DataModel pa_EB_MovimientosPorLocal() 
     {
        if (ValidarParametro() == true) {
             DMReporte = new ListDataModel(ReportesFacade.pa_EB_MovimientosPorLocal(getLocal().getCodigoLocal(),getFechaInicio(),getFechaFin())); 
            }
            return DMReporte;
     }
     //Recuperacion
    //Mostrar
     public void MovimientosPorCuenta() 
     {
         DMReporte = pa_EB_MovimientosPorCuenta(); 
     }
     public void MovimientosPorLocal() 
     {
         DMReporte = pa_EB_MovimientosPorLocal(); 
     }
    //Mostrar 
    
    
    public boolean ValidarParametro(){
        boolean _EsValido = true;
        ///Validar los Parametros  
        return _EsValido;
    }
    public String ir(String URL){
        DMReporte = null;
        return URL;
    }
}
