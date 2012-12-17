package controlador;

import modelo.EbMovimiento;
import controlador.util.JsfUtil;
import controlador.util.PaginationHelper;
import sesion.EbMovimientoFacade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import modelo.EbCuenta;

@ManagedBean(name = "ebMovimientoController")
@SessionScoped
public class EbMovimientoController implements Serializable {

    private EbMovimiento current;
    private DataModel items = null;
    @EJB
    private sesion.EbMovimientoFacade ejbFacade;
    @EJB
    private sesion.EbCuentaFacade ejbCuentaFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public EbMovimientoController() {
    }

    public EbMovimiento getSelected() {
        if (current == null) {
            current = new EbMovimiento();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EbMovimientoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (EbMovimiento) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new EbMovimiento();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            if(current.getTipoMovimiento().equals(-1))  
            {
                if(current.getCodigoCuenta().getSaldoCuenta().compareTo(current.getMontoMovimiento()) == -1)
                {
                    JsfUtil.addErrorMessage("El saldo en la cuenta es menor al solicitado");
                    return null;
                }
            }
            current.setCodigoMovimiento(0);
            current.setCostoMovimiento(new BigDecimal(0.0));
            current.setFechaMovimiento(new Date());
            current.setHoraMovimiento(new Date());
            current.setUsuarioNombre(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteUser());
            getFacade().create(current);
            EbCuenta _Cuenta  = current.getCodigoCuenta();
            _Cuenta.setSaldoCuenta(_Cuenta.getSaldoCuenta().add(current.getMontoMovimiento().multiply(new BigDecimal(current.getTipoMovimiento()))));
            _Cuenta.setUsuarioNombre(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteUser());
            ejbCuentaFacade.edit(_Cuenta);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EbMovimientoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (EbMovimiento) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EbMovimientoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (EbMovimiento) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EbMovimientoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = EbMovimiento.class)
    public static class EbMovimientoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EbMovimientoController controller = (EbMovimientoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ebMovimientoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EbMovimiento) {
                EbMovimiento o = (EbMovimiento) object;
                return getStringKey(o.getCodigoMovimiento());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + EbMovimientoController.class.getName());
            }
        }
    }
}
