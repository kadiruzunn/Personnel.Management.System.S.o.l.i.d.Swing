package com.pms.businesslogiclayer;

import java.util.List;

import com.pms.dataaccesslayer.PersonelDal;
import com.pms.model.Personel;

public class PersonelBll {
	
	public List<Personel> listele(){
		
		PersonelDal dal = new PersonelDal(); 
		
		List<Personel> liste = dal.listele(); 
		
		return liste;
		
	}

}
