package model;

import java.util.ArrayList;
import java.util.List;

import uia.com.contabilidad.clientes.InfoUIA;

public class CompraJSF extends ClienteJSF{
	private int id;
	private String name;
	private String estado;
	protected String type;
	private ArrayList<String> cuentasNames = null;
	
	public CompraJSF() {
		
	}
	
	public CompraJSF(String name2, int id2, String estado2, List<InfoUIA> lista) {
		this.id= id2;
		this.name =name2;
		this.estado = estado2;
		
		if(cuentasNames != null)
		{
			cuentasNames.clear();
		}
		else {
			cuentasNames = new ArrayList<String>();
		
			if (lista != null) {
				lista.forEach( entry -> {
					cuentasNames.add(entry.getName());    			
				});
			}
        }
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public ArrayList<String> getCuentasNames(){
		return cuentasNames;
	}
	
	public void setCuentasNames(ArrayList<String> comprasNames) {
		this.cuentasNames = comprasNames;
	}

	
}
