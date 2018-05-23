package com.vonkazo.proyecto3trimestre.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class JFramePrincipal extends JFrame {

	private JPanel contentPane;
	private JPanelArchivo archivo;
	private JPanelCreacion creacion;
	private JPanelConsulta consulta;
	private JMenu mnArchivo;
	private JMenuItem mntmExportar;
	private JToolBar toolBar;
	private JButton btnBuscar;
	private JPanel panel;
	private JMenuItem mntmSalir;
	private JToolBar toolBar_1;
	private JButton btnBuscar_1;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnExportar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePrincipal frame = new JFramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFramePrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 434);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmExportar = new JMenuItem("Exportar");
		mntmExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel("archivo");
			}
		});
		mnArchivo.add(mntmExportar);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnModelos = new JMenu("Modelos");
		menuBar.add(mnModelos);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPanel("creacion");
			}
		});
		mnModelos.add(mntmCrear);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel("consulta");
			}
		});
		mnModelos.add(mntmConsultar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		archivo = new JPanelArchivo();
		creacion = new JPanelCreacion();
		consulta = new JPanelConsulta();
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(archivo, "archivo");
		archivo.setLayout(new BorderLayout(0, 0));
		
		toolBar_1 = new JToolBar();
		archivo.add(toolBar_1, BorderLayout.NORTH);
		
		btnBuscar_1 = new JButton("Buscar");
		toolBar_1.add(btnBuscar_1);
		
		btnEditar = new JButton("Editar");
		toolBar_1.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		toolBar_1.add(btnEliminar);
		
		btnExportar = new JButton("Exportar");
		toolBar_1.add(btnExportar);
		contentPane.add(creacion, "creacion");
		contentPane.add(consulta, "consulta");
		consulta.setLayout(new BorderLayout(0, 0));
		
		toolBar = new JToolBar();
		consulta.add(toolBar, BorderLayout.NORTH);
		
		btnBuscar = new JButton("Buscar");
		toolBar.add(btnBuscar);
		
		panel = new JPanel();
		consulta.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
	}

	private void cambiarPanel(String nombre) {
		((CardLayout)(contentPane.getLayout())).show(contentPane, nombre);
	}
}
