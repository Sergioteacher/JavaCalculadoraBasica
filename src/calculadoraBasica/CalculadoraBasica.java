package calculadoraBasica;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Font;
import java.awt.Color;


/**
 * Clase CalculadoraBasica principal del proyecto 
 * @author Sergio Teacher
 * @version 0.1
 *
 */
public class CalculadoraBasica {

	private JFrame frmCalcuBasic;
	private JLabel lblSize;
	

	/**
	 * Este metodo estático se encarga de iniciar la ejecucion del programar
	 * @param args es una matriz de tipo String con los parametros
	 * que el reciba por consola el programa
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraBasica window = new CalculadoraBasica();
					window.frmCalcuBasic.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * El constructor de la clase.
	 */
	public CalculadoraBasica() {
		initialize();
	}

	/**
	 * Initializa los contenidos del frame.
	 */
	private void initialize() {

		Dimension ini = new Dimension(209,209);
		frmCalcuBasic = new JFrame();
		frmCalcuBasic.setTitle("Calcu Basic");
		frmCalcuBasic.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				lblSize.setText(frmCalcuBasic.getSize().width + " " + frmCalcuBasic.getSize().height  );
			}
		});
		
		frmCalcuBasic.setBounds(100, 100, 224, 240);
		frmCalcuBasic.setMinimumSize(ini);
		frmCalcuBasic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalcuBasic.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblCabecera = new JLabel("Calculadora B\u00E1sica");
		lblCabecera.setForeground(Color.RED);
		lblCabecera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		frmCalcuBasic.getContentPane().add(lblCabecera, BorderLayout.NORTH);
		
		lblSize = new JLabel(" ");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		frmCalcuBasic.getContentPane().add(lblSize, BorderLayout.SOUTH);
		lblSize.setText(" ");
	}

}
