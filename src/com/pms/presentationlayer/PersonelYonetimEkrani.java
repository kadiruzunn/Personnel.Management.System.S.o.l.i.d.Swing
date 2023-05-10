package com.pms.presentationlayer;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.pms.businesslogiclayer.PersonelBll;
import com.pms.model.Personel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;

public class PersonelYonetimEkrani extends JFrame {

	private JPanel contentPane;
	private List<Personel> personelListesi;
	private PersonelBll bll;
	private JTable table;
	private JTextField txtAd;
	private JLabel lblNewLabel_1;
	private JTextField txtSoyad;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtDogumTarihi;
	private JLabel lblNewLabel_4;
	private JTextField txtMaas;
	private JComboBox cmbDogumYeri;
	private JButton btnSil;
	private JCheckBox chckEngelliMi;

	
	public PersonelYonetimEkrani() {
		
		bll = new PersonelBll();

		personelListesi = bll.listele();

		
		setTitle("Personel Yönetim Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 259, 762, 330);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		JLabel lblNewLabel = new JLabel("Ad");
		lblNewLabel.setBounds(41, 42, 44, 16);
		contentPane.add(lblNewLabel);
		
		txtAd = new JTextField();
		txtAd.setBounds(132, 37, 188, 26);
		contentPane.add(txtAd);
		txtAd.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Soyad");
		lblNewLabel_1.setBounds(41, 75, 44, 16);
		contentPane.add(lblNewLabel_1);
		
		txtSoyad = new JTextField();
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(132, 70, 188, 26);
		contentPane.add(txtSoyad);
		
		lblNewLabel_2 = new JLabel("Doğum Yeri");
		lblNewLabel_2.setBounds(41, 108, 79, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Doğum Tarihi");
		lblNewLabel_3.setBounds(41, 141, 93, 16);
		contentPane.add(lblNewLabel_3);
		
		txtDogumTarihi = new JTextField();
		txtDogumTarihi.setColumns(10);
		txtDogumTarihi.setBounds(132, 136, 188, 26);
		contentPane.add(txtDogumTarihi);
		
		lblNewLabel_4 = new JLabel("Maaş");
		lblNewLabel_4.setBounds(41, 174, 44, 16);
		contentPane.add(lblNewLabel_4);
		
		txtMaas = new JTextField();
		txtMaas.setColumns(10);
		txtMaas.setBounds(132, 169, 188, 26);
		contentPane.add(txtMaas);
		
		cmbDogumYeri = new JComboBox();
		cmbDogumYeri.setModel(new DefaultComboBoxModel(new String[] {"Ankara", "İzmir", "İstanbul", "Bursa"}));
		cmbDogumYeri.setBounds(132, 104, 188, 27);
		contentPane.add(cmbDogumYeri);
		
		JButton btnNewButton = new JButton("Kaydet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personelEkle();
			}
		});
		btnNewButton.setBounds(132, 203, 188, 29);
		contentPane.add(btnNewButton);
		
		btnSil = new JButton("Sil");
		btnSil.setBackground(new Color(255, 255, 255));
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int secilenIndex = table.getSelectedRow();
				
				if(secilenIndex == -1) {
					JOptionPane.showMessageDialog(btnNewButton, "Önce silinecek kaydı seçiniz!");
					return;
				}
				
				personelSil(secilenIndex);
			}
		});
		btnSil.setBounds(710, 203, 93, 29);
		contentPane.add(btnSil);
		
		chckEngelliMi = new JCheckBox("Engelli Mi?");
		chckEngelliMi.setBounds(367, 38, 128, 23);
		contentPane.add(chckEngelliMi);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int selectedIndex = table.getSelectedRow();
				
				if(selectedIndex != -1) {
					
					
					verileriGetir(selectedIndex);
					
				}
				
			}

		
		});
		
		
		personelListesiGoster();
	}
	
	private void personelEkle() {

		Personel personel = new Personel();
		personel.setAd(txtAd.getText());
		personel.setSoyad(txtSoyad.getText());
		personel.setDogumYeri(cmbDogumYeri.getSelectedItem().toString());
		personel.setDogumTarihi(LocalDate.parse(txtDogumTarihi.getText()));
		personel.setMaas(Double.parseDouble(txtMaas.getText()));
		personel.setEngelliMi(chckEngelliMi.isSelected());
		
		personelListesi.add(personel);
		
		personelListesiGoster();
		
		
	}
	
	private void personelListesiGoster() {
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Ad");
		model.addColumn("Soyad");
		model.addColumn("Doğum Yeri");
		model.addColumn("Doğum Tarihi");
		model.addColumn("Maaş");
		model.addColumn("Engelli Mi?");
		
		Object[] row = new Object[6];
		
		int rowCount = personelListesi.size();
		
		for (Personel p : personelListesi) {
			
			row[0] = p.getAd();
			row[1] = p.getSoyad();
			row[2] = p.getDogumYeri();
			row[3] = p.getDogumTarihi();
			row[4] = p.getMaas();
			row[5] = p.isEngelliMi() ? "Evet" : "Hayır";
			
			model.addRow(row);
			
		}
		
		table.setModel(model);
			
		
	}
	
	private void personelSil(int secilenIndex) {
		
		personelListesi.remove(secilenIndex);
		personelListesiGoster();

		
	}
	
private void verileriGetir(int kayitIndex) {
		
		Personel secilenPersonel = personelListesi.get(kayitIndex);
		
		txtAd.setText(secilenPersonel.getAd());
		txtSoyad.setText(secilenPersonel.getSoyad());
		cmbDogumYeri.setSelectedItem(secilenPersonel.getDogumYeri());
		txtDogumTarihi.setText(secilenPersonel.getDogumTarihi().toString());
		txtMaas.setText(String.valueOf(secilenPersonel.getMaas()));
		chckEngelliMi.setSelected(secilenPersonel.isEngelliMi());
		
	}
}
