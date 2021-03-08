package uia.com.contabilidad;

import java.util.ArrayList;

//import uia.com.contabilidad.clientes.InfoUIA;
import uia.com.contabilidad.gestor.DecoradorProveedores;
import uia.com.contabilidad.gestor.DecoradorCompras;
import uia.com.contabilidad.gestor.DecoradorCuentas;
import uia.com.contabilidad.gestor.Gestor;
import uia.com.presentacion.ClienteJSP;

public class ContabilidadUIA {
		
		private DecoradorProveedores gestorProveedores = null;
		
		private DecoradorCuentas gestorCuentas = null;
		
		private ArrayList<ClienteJSP> listaProveedores = null;
		
		private ArrayList<ClienteJSP> listaCuentas = null;

		public ContabilidadUIA()
		{
		 Gestor contabilidad = new Gestor("/Users/vogel/eclipse-workspace/ContabilidadUIA-web/ListaProveedores.json");		
		 DecoradorProveedores gestorProveedores = new DecoradorProveedores(contabilidad, "proveedor");
		 DecoradorCompras gestorCompras = new DecoradorCompras(gestorProveedores, "Compra");
		 DecoradorCuentas gestorCuentas = new DecoradorCuentas(gestorCompras, "Cuenta");
		 gestorProveedores.Print();
		 gestorCuentas.Print();
		 listaProveedores = gestorProveedores.getLista();
		 listaCuentas = gestorCuentas.getLista();
		}
		
		
		public ArrayList<ClienteJSP> getListaProveedores() {
			return listaProveedores;
		}


		public void setListaProveedores(ArrayList<ClienteJSP> listaProveedores) {
			this.listaProveedores = listaProveedores;
		}
		
		public DecoradorCuentas getGestorCuentas() {
			return gestorCuentas;
		}
		
		
		
		public ArrayList<ClienteJSP> getListaCuentas(){
			return listaCuentas;
		}
		
		
		public DecoradorProveedores getGestorProveedores() {
			return gestorProveedores;
		}

		public void setGestorProveedores(DecoradorProveedores gestorProveedores) {
			this.gestorProveedores = gestorProveedores;
		}


}
