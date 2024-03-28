package model;

import java.awt.print.Printable;
import java.io.Serializable;
import java.util.ArrayList;

public class Set <D> implements Serializable{
	
	private ArrayList<D> d = new ArrayList<>();

	public Set() {
		
	};
	
	public void remove(D itemD) {
		this.d.remove(itemD);
	
	}
	public void remove(int index) {
		this.d.remove(index);
	
	}

	public boolean add(D itemD) {
		if (d.contains(itemD)) {
			return false;
		}
		else {
			d.add(itemD);
			return true;
		}
	}
	public D get(int index) {
		return d.get(index);
	}
	
	public ArrayList<D> items() {
		return new ArrayList<D>(this.d);
	}
	public int size() {
		return this.d.size();
	}
	
}