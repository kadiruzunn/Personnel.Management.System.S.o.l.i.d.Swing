package com.pms.model;

import java.time.LocalDate;

public class Personel {
	
	private int id;
	private String ad;
	private String soyad;
	private String dogumYeri;
	private LocalDate dogumTarihi;
	private double maas;
	private boolean engelliMi;
	

	public Personel() {
		
	}

	public Personel(String ad, String soyad, String dogumYeri, LocalDate dogumTarihi, double maas, boolean engelliMi) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.dogumYeri = dogumYeri;
		this.dogumTarihi = dogumTarihi;
		this.maas = maas;
		this.engelliMi = engelliMi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getDogumYeri() {
		return dogumYeri;
	}

	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}

	public LocalDate getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(LocalDate dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public double getMaas() {
		return maas;
	}

	public void setMaas(double maas) {
		this.maas = maas;
	}
	

	public boolean isEngelliMi() {
		return engelliMi;
	}

	public void setEngelliMi(boolean engelliMi) {
		this.engelliMi = engelliMi;
	}
	
	
}
