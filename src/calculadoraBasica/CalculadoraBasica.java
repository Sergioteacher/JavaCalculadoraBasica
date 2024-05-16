package calculadoraBasica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 * Clase CalculadoraBasica principal del proyecto 
 * @author Sergio Teacher
 * @version 0.2
 *
 */
public class CalculadoraBasica {

	private JFrame frmCalcuBasic;
	private JLabel lblSize;
	private JPanel panel_Central;
	private JPanel panel_nivel1;
	private JPanel panel_nivel2;
	private JPanel panel_nivel3;
	private JPanel panel_nivel4;
	private JPanel panel_nivel5;
	private JTextField textField;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_0;
	private JButton btnNewButton_Minus;
	private JButton btnNewButton_Coma;
	private JPanel panel_Izq;
	private JButton btnNewButton_AC;
	private JButton btnNewButton_Add;
	private JButton btnNewButton_Sus;
	private JButton btnNewButton_Res;
	private JLabel lblNewLabel;
	private Double Num=0.0;
	private Boolean Coma = false, OpPulsada = false;
	private String operador = "";
	private String anteriorOp = "";

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
	 * Método que unifica las operaciones de la Calculadora
	 * @param Numero tipo Double 
	 */
	public void Calculo(Double Numero) {

		if( anteriorOp != operador ) {
			if (Num != 0) {
				switch (anteriorOp){
				case "+":
					Num += Numero;
					break;
				case "-":
					Num -= Numero;
					break;
				}
			}else {
				Num = Numero;
			}
			Numero = 0.0;
		}
		switch (operador){
			case "+":
				Num += Numero;
				break;
			case "-":
				Num -= Numero;
				break;
		}
		anteriorOp = operador;
	}

	/**
	 * Initializa los contenidos del frame.
	 * Con un pesado despliegue de aciones complejas
	 * entrelazadas con los objetos visuales.
	 */
	private void initialize() {

		Dimension ini = new Dimension(224,209);
		frmCalcuBasic = new JFrame();
		frmCalcuBasic.setTitle("Calcu Basic");
		frmCalcuBasic.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				lblSize.setText(frmCalcuBasic.getSize().width + " " + frmCalcuBasic.getSize().height  );
			}
		});
		
		frmCalcuBasic.setBounds(100, 100, 400, 350);
		frmCalcuBasic.setMinimumSize(ini);
		frmCalcuBasic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalcuBasic.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblCabecera = new JLabel("Calculadora B\u00E1sica");
		lblCabecera.setForeground(Color.RED);
		lblCabecera.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		frmCalcuBasic.getContentPane().add(lblCabecera, BorderLayout.NORTH);
		
		lblSize = new JLabel(" ");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		frmCalcuBasic.getContentPane().add(lblSize, BorderLayout.SOUTH);
		lblSize.setText(" ");
		
		panel_Central = new JPanel();
		frmCalcuBasic.getContentPane().add(panel_Central, BorderLayout.CENTER);
		panel_Central.setLayout(new GridLayout(5, 1, 0, 0));
		
		panel_nivel1 = new JPanel();
		panel_Central.add(panel_nivel1);
		FlowLayout fl_panel_nivel1 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_nivel1.setLayout(fl_panel_nivel1);
		
		textField = new JTextField();
		textField.setBackground(Color.PINK);
		textField.setEditable(false);
		panel_nivel1.add(textField);
		textField.setColumns(15);
		
		panel_nivel2 = new JPanel();
		panel_Central.add(panel_nivel2);
		panel_nivel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("1");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "1");
				}
			}
		});
		panel_nivel2.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("2");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "2");
				}
			}
		});
		panel_nivel2.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("3");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("3");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "3");
				}
			}
		});
		panel_nivel2.add(btnNewButton_3);
		
		panel_nivel3 = new JPanel();
		panel_Central.add(panel_nivel3);
		panel_nivel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_4 = new JButton("4");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("4");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "4");
				}
			}
		});
		panel_nivel3.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("5");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("5");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "5");
				}
			}
		});
		panel_nivel3.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("6");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "6");
				}
			}
		});
		panel_nivel3.add(btnNewButton_6);
		
		panel_nivel4 = new JPanel();
		panel_Central.add(panel_nivel4);
		panel_nivel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_7 = new JButton("7");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("7");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "7");
				}
			}
		});
		panel_nivel4.add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("8");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("8");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "8");
				}
			}
		});
		panel_nivel4.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("9");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("9");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "9");
				}
			}
		});
		panel_nivel4.add(btnNewButton_9);
		
		panel_nivel5 = new JPanel();
		panel_Central.add(panel_nivel5);
		panel_nivel5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton_0 = new JButton(" 0 ");
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("0");
					OpPulsada = false;
				}else {
					textField.setText( textField.getText() + "0");
				}
			}
		});
		panel_nivel5.add(btnNewButton_0);
		
		btnNewButton_Minus = new JButton("-");
		btnNewButton_Minus.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton_Minus.setForeground(Color.RED);
		btnNewButton_Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(OpPulsada) {
					textField.setText("-");
					OpPulsada = false;
				}
				if("".equals(textField.getText())) {
					textField.setText("-");
				}
			}
		});
		panel_nivel5.add(btnNewButton_Minus);
		
		btnNewButton_Coma = new JButton(",");
		btnNewButton_Coma.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_Coma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( Coma == false )  {
					Coma = true;
				textField.setText( textField.getText() + ".");
				}
			}
		});
		panel_nivel5.add(btnNewButton_Coma);
		
		panel_Izq = new JPanel();
		frmCalcuBasic.getContentPane().add(panel_Izq, BorderLayout.EAST);
		panel_Izq.setLayout(new BoxLayout(panel_Izq,BoxLayout.Y_AXIS));
		
		lblNewLabel = new JLabel(" ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(CalculadoraBasica.class.getResource("/imag/fun2.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_Izq.add(lblNewLabel);
		
		btnNewButton_AC = new JButton("AC");
		btnNewButton_AC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				Coma = false;
				OpPulsada = false;
				Num=0.0;
				operador = "";
				anteriorOp = "";
			}
		});
		panel_Izq.add(btnNewButton_AC);
		
		btnNewButton_Add = new JButton("+");
		btnNewButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!"".equals(textField.getText())) {
					try {
							operador = "+";
							OpPulsada = true;
							Calculo(Double.parseDouble(textField.getText()));
							
					}catch(NumberFormatException ee) {
						JOptionPane.showMessageDialog(
								btnNewButton_Add,
								   "Error:" + ee.toString());
					}
				}
				textField.setText(Num.toString());
				Coma = false;
				
			}
		});
		btnNewButton_Add.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_Izq.add(btnNewButton_Add);
		
		btnNewButton_Sus = new JButton("-");
		btnNewButton_Sus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!"".equals(textField.getText())) {
					try {
						operador = "-";
						OpPulsada = true;
						Calculo(Double.parseDouble(textField.getText()));
						
					}catch(NumberFormatException ee) {
						JOptionPane.showMessageDialog(
								btnNewButton_Add,
								   "Error:" + ee.toString());
					}
				}
				textField.setText(Num.toString());
				Coma = false;
				
			}
		});
		btnNewButton_Sus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_Izq.add(btnNewButton_Sus);
		
		btnNewButton_Res = new JButton("=");
		btnNewButton_Res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(!"".equals(textField.getText())) {
					try {
						if(!"".equals(operador)) {
							Calculo(Double.parseDouble(textField.getText()));
						}
						
					}catch(NumberFormatException ee) {
						JOptionPane.showMessageDialog(
								btnNewButton_Add,
								   "Error:" + ee.toString());
					}
				}
				
				textField.setText(Num.toString());
				Num=0.0;
				//anteriorOp = "";
				OpPulsada = true;
				
			}
		});
		btnNewButton_Res.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_Izq.add(btnNewButton_Res);
		
		frmCalcuBasic.pack();
	}

}
