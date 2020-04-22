package pe.com.claro.postventa.dinamico.canonical.bean;

import java.util.Comparator;

import pe.com.claro.postventa.dinamico.canonical.types.ItemsResponseOrdenTrabajoType;

public class SortbyPotitionRoute implements Comparator<ItemsResponseOrdenTrabajoType>  {
	
	  // Used for sorting in ascending order of 
    // roll number 
    public int compare(ItemsResponseOrdenTrabajoType a, ItemsResponseOrdenTrabajoType b) 
    { 
        return a.getPosicionRuta() - b.getPosicionRuta();
    } 

}
