package beans;

//import java.io.IOException;
import java.util.ArrayList;
/*
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import model.ClienteJSF;
import uia.com.contabilidad.ContabilidadUIA;

@ManagedBean(name = "clienteController")
@SessionScoped

public class ClienteController {
	private ContabilidadUIA dao = new ContabilidadUIA();
	
	
	public ArrayList<ClienteJSF> proveedores = null;
	public ArrayList<ClienteJSF> compras = null;
	public ArrayList<ClienteJSF> cuentas = null;
	public ArrayList<String> proveedoresNames = null;
	public ArrayList<String> comprasNames = null;
	public ArrayList<String> cuentasNames = null;
	public ClienteJSF proveedor = null;
	public ClienteJSF compra = null;
	
	public ClienteController() {
		
	}
	
	public ArrayList<String> getProveedoresNames(){
		if(this.proveedores != null) {
			proveedor = this.proveedores.get(0);
		}
		else {
			this.proveedores = this.dao.getListaProveedores();
			proveedor = this.proveedores.get(0);
		}
		
		proveedoresNames = this.dao.getProveedoresNames();
		return proveedoresNames;
	}
	
	public ArrayList <String> getComprasNames(){
		if(this.proveedor == null) {
			this.proveedores = this.dao.getListaCompras();
			proveedor = this.proveedores.get(0);
		}
		comprasNames = this.dao.getComprasNames(this.proveedor.getName());
		return comprasNames;
	}
	
	public ArrayList <String> getCuentasNames(){
		if(this.proveedor == null) {
			this.proveedores = this.dao.getListaCuentas();
			proveedor = this.proveedores.get(0);
		}
		cuentasNames = this.dao.getCuentasNames(this.proveedor.getName());
		return cuentasNames;
	}
	
	public void setProveedoresNames(ArrayList<String> proveedoresNames) {
		this.proveedoresNames = proveedoresNames;
	}
	
	public ClienteJSF getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(ClienteJSF proveedor) {
		this.proveedor = proveedor;
	}
	
	public void setComprasNames(ArrayList<String> comprasNames) {
		this.comprasNames = comprasNames;
	}
	
	public void setCuentasNames(ArrayList<String> cuentasNames) {
		this.cuentasNames = cuentasNames;
	}
	
	public ArrayList<ClienteJSF> getCompras(){
		return this.dao.listaCompras;
	}
	
	public ArrayList<ClienteJSF> getProveedores(){
		return this.dao.listaProveedores;
	}
	
	public ArrayList<ClienteJSF> getCuentas(){
		return this.dao.listaCuentas;
	}
	
	public void setProveedores(ArrayList<ClienteJSF> proveedores) {
		this.proveedores = proveedores;
	}

	public void setCompras(ArrayList<ClienteJSF> compras) {
		this.compras = compras;
	}
	
	public void setCuentas(ArrayList<ClienteJSF> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void onEdit(RowEditEvent<?> event) {
        MessageUtil.addInfoMessage("compra.edit", ((ClienteJSF) event.getObject()).getName());
    }
	
	public void onCancel(RowEditEvent<?> event) {
        MessageUtil.addInfoMessage("compra.edit", ((ClienteJSF) event.getObject()).getName());
    }

	public void onRowSelect(SelectEvent<?> event) {
        MessageUtil.addInfoMessage("compra.edit", ((ClienteJSF) event.getObject()).getName());
    }

}
