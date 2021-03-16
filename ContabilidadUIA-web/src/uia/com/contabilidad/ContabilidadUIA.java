package uia.com.contabilidad;

import java.util.ArrayList;

import model.ClienteJSF;
//import uia.com.contabilidad.clientes.InfoUIA;
import uia.com.contabilidad.gestor.DecoradorProveedores;
import uia.com.contabilidad.gestor.Gestor;
import uia.com.contabilidad.proveedores.Proveedor;

import uia.com.contabilidad.gestor.DecoradorCompras;
import uia.com.contabilidad.gestor.DecoradorCuentas;

public class ContabilidadUIA {
	
	public Gestor contabilidad = null;
	private DecoradorProveedores gestorProveedores = null;
	private DecoradorCompras gestorCompras = null;
	private DecoradorCuentas gestorCuentas = null;
	public ArrayList<ClienteJSF> listaProveedores = null;
	public ArrayList<ClienteJSF> listaCuentas = null;
	public ArrayList<ClienteJSF> listaCompras = null;
	public ArrayList<String> listaCuentasNames = null;
	public ArrayList<String> listaComprasNames = null;
	public ArrayList<String> listaProveedoresNames = null;
	public Proveedor proveedor = null;
	public String clienteId = "";
		
	public ContabilidadUIA()
	{
	contabilidad = new Gestor("/Users/vogel/git/ContabilidadUIA-web/ContabilidadUIA-web/ListaProveedores.json");		
	gestorProveedores = new DecoradorProveedores(contabilidad, "proveedor");
	gestorCompras = new DecoradorCompras(gestorProveedores, "compra");
	gestorCuentas = new DecoradorCuentas(gestorCompras, "cuenta");
	gestorProveedores.Print();
	listaProveedores = gestorProveedores.getLista();
	}
	
	public ArrayList<ClienteJSF> getListaProveedores() {
		return listaProveedores;
	}
	
	public ArrayList<ClienteJSF> getListaCompras(){
		return listaCompras;
	}
	
	public ArrayList<ClienteJSF> getListaCuentas(){
		return listaCuentas;
	}

	public void setListaProveedores(ArrayList<ClienteJSF> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
				
	public DecoradorProveedores getGestorProveedores() {
		return gestorProveedores;
	}

	public void setGestorProveedores(DecoradorProveedores gestorProveedores) {
		this.gestorProveedores = gestorProveedores;
	}
	
	public ClienteJSF getClienteById(String clienteId) {
		return null;
	}
	
	public void borraCliente(String clienteId) {
		
	}
	
	public ArrayList<ClienteJSF> getAllClientes(){
		return null;
	}
	
	public void checkCliente(ClienteJSF cliente) {
		
	}
	
	public ArrayList<ClienteJSF> getCuentas(String clienteId){
		this.clienteId = clienteId;
		proveedor = (Proveedor) this.gestorCompras.busca(clienteId);
		this.listaCuentas = proveedor.getListaItems();
		return this.listaCuentas;
	}
	
	public ArrayList<ClienteJSF> getCompras(String clienteId){
		this.clienteId = clienteId;
		proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
		this.listaCompras = proveedor.getListaItems();
		return listaCompras;
	}
	
	public ArrayList<ClienteJSF> getListaCompras(String clienteId){
		this.clienteId = clienteId;
		getCompras(this.clienteId);
		return listaCompras;
	}
	
	public ArrayList<ClienteJSF> getListaCuentas(String clienteId){
		this.clienteId = clienteId;
		getCuentas(this.clienteId);
		return listaCuentas;
	}
	
	public ArrayList<ClienteJSF> getCheques(String clienteId){
		return null;
	}
	
	public ArrayList<String> getProveedoresNames() {			
		return gestorProveedores.getListaNames();
	}


	public ArrayList<String> getComprasNames(String clienteId) 
	{
			this.clienteId = clienteId;
			proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
			listaComprasNames = proveedor.getListaNames();
			return listaComprasNames;
	}
	
	public ArrayList<String> getCuentasNames(String clienteId)
	{
		this.clienteId = clienteId;
		proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
		listaCuentasNames = proveedor.getListaNames();
		return listaCuentasNames;
	}

}
