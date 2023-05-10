package com.pms.presentationlayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class MainWindow {

	private JFrame frame;
	private JTextField txtEposta;
	private JTextField txtSifre;
	private JLabel lblifre;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainWindow() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-Posta");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setBounds(78, 65, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		txtEposta = new JTextField();
		txtEposta.setText("ali@gmail.com");
		txtEposta.setBounds(151, 60, 189, 26);
		frame.getContentPane().add(txtEposta);
		txtEposta.setColumns(10);
		
		txtSifre = new JTextField();
		txtSifre.setText("123");
		txtSifre.setColumns(10);
		txtSifre.setBounds(151, 108, 189, 26);
		frame.getContentPane().add(txtSifre);
		
		lblifre = new JLabel("Şifre");
		lblifre.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblifre.setBounds(78, 113, 61, 16);
		frame.getContentPane().add(lblifre);
		
		JButton btnOturumAc = new JButton("Oturum Aç");
		btnOturumAc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String eposta = txtEposta.getText();
				String sifre = txtSifre.getText();
				
				if("ali@gmail.com".equals(eposta) && "123".equals(sifre)) {
					
					JOptionPane.showMessageDialog(btnOturumAc, "Oturum Açıldı");
					
					PersonelYonetimEkrani personelYonetimEkrani = new PersonelYonetimEkrani();
					personelYonetimEkrani.setVisible(true);
					frame.setVisible(false);
					
										
				}else {
					
					JOptionPane.showMessageDialog(btnOturumAc, "Kullanıcı adı veya şifre hatalı !");

				}
				
			}
		});
		btnOturumAc.setBounds(226, 146, 117, 29);
		frame.getContentPane().add(btnOturumAc);
	}
}
