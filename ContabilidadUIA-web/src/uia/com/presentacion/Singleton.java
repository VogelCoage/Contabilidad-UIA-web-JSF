package uia.com.presentacion;

import uia.com.contabilidad.ContabilidadUIA;

public class Singleton {
	private static ContabilidadUIA singleton = new ContabilidadUIA();
	
	public Singleton() {
		
	}
	
	public static ContabilidadUIA getInstance() {
		return singleton;
	}
	
	public static ContabilidadUIA getSingleton() {
		return singleton;
	}
	
	public static void setSingleton(ContabilidadUIA singleton) {
		Singleton.singleton = singleton;
	}
}
