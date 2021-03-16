package uia.com.contabilidad.compras;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import model.ClienteJSF;
import uia.com.contabilidad.clientes.InfoUIA;

public class Compra extends InfoUIA{
	private ArrayList<ClienteJSF> listaJSF = null;
	private ArrayList<String> listaNames = null;
	
	@JsonCreator
    public Compra(@JsonProperty("id")int id, @JsonProperty("name")String name) 
	{
        super(id, name);
        super.type =  this. getClass(). getSimpleName();        
    }
	
	public ArrayList<ClienteJSF> getLista()
	{
		//return super.getItems();
		
		//modificado
		//ClienteJSF cliente = null;
		if(listaJSF != null) {
			((List<ClienteJSF>) listaJSF).clear();
		}
		else {
			listaJSF = new ArrayList<ClienteJSF>();
		}
		if(this.items != null) {
			System.out.println("----- Lista -----");
			items.forEach(t ->{
				if(t.getClienteJSP() != null) {
					((List<ClienteJSF>) listaJSF).add(t.getClienteJSP());
				}
			});
		}
		return listaJSF;
	}
	
	public ArrayList<ClienteJSF> getListaCuentas(){
		//ClienteJSF cliente = null;
		if(listaJSF != null) {
			listaJSF = new ArrayList<ClienteJSF>();
		}
		
		if(this.items != null) {
			System.out.println("----- Lista -----");
			items.forEach(t ->{
				if(t.getItems() != null) {
					t.getItems().forEach(p ->{
						((List<ClienteJSF>) listaJSF).add(p.getClienteJSP());
					});
				}
			});
		}
		return listaJSF;
	}
	
	public ArrayList<String> getListaNames() 
	{
		//ClienteJSF cliente = null;		
		if(listaNames == null)
		{		
			listaNames = new ArrayList<String>();
		}
		else
			listaNames.clear();
		
		if (this.items != null) 
		{        
			System.out.println("----- Lista -----");
			
            items.forEach(t->{
    			if(t.getItems() != null)
    			{
    				t.getItems().forEach(p->
    				{
    					((List<String>) listaNames).add(p.getClienteJSP().getName());
    				});
    			}
    		});
		}
		return listaNames;
	}
}
