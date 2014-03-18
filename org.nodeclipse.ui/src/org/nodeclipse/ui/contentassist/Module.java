package org.nodeclipse.ui.contentassist;

/**
 * @author Paul Verest
 */
public class Module {
	
	private String name;

	public Module(String name){
		this.name=name;
	}

	@Override
	public String toString(){
		return name;
	}
}
