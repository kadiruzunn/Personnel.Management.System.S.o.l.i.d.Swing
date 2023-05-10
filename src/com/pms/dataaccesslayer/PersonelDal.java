package com.pms.dataaccesslayer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.pms.model.Personel;

public class PersonelDal {
	
	public List<Personel> listele(){
		
		List<Personel> liste = new ArrayList<>();
		
		Personel p1 = new Personel("Ali", "Veli", "Ankara", LocalDate.of(2000, 1, 20), 9100, true);
		Personel p2 = new Personel("Ayşe", "Karabacı", "İstanbul", LocalDate.of(2000, 1, 20), 3000, false);
		Personel p3 = new Personel("Mehmet", "Ayvacı", "İzmir", LocalDate.of(2002, 1, 10), 32000, true);
		
		
		
		liste.add(p1);
		liste.add(p2);
		liste.add(p3);
		
		
		for (int i = 0; i < 100; i++) {
			
			Personel k = new Personel("Ali", "Tunc", "Bursa", LocalDate.of(2002, 1, 8), 3000, true);
			liste.add(k);
		}
		
		return liste;
		
	}

}
