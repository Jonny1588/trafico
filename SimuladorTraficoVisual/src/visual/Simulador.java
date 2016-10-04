package visual;
import javax.swing.*;
import javax.swing.JApplet;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.ItemSelectable;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import control.ControlVehiculo;
import control.Geocoder;

import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class Simulador extends JApplet {

	/**
	 * Create the applet.
	 */
	
	static String pathArchivoVehiculo = "C:/Users/jonny/workspace/Simulador/data/DatosVehiculo.txt";
	static String[] coordenadasVehiculo=new String[99];	
	static String[] coordenadaVehiculo=new String[3];
	static String[] idCoordVehiculo=new String[99];
	
	static String pathArchivoPeaton = "C:/Users/jonny/workspace/Simulador/data/DatosPeaton.txt";
	static String[] coordenadasPeaton=new String[99];	
	static String[] coordenadaPeaton=new String[3];
	static String[] idCoordPeaton=new String[99];
	
	static String pathArchivoSemaforo = "C:/Users/jonny/workspace/Simulador/data/DatosSemaforo.txt";
	static String[] coordenadasSemaforo=new String[99];	
	static String[] coordenadaSemaforo=new String[3];
	static String[] idCoordSemaforo=new String[99];
	
	static String pathArchivoCalles = "C:/Users/jonny/workspace/Simulador/data/DatosCalles.txt";
	
	static JLabel jLabel1 = new JLabel("");
	static JComboBox cb_calle = new JComboBox();
	JLabel lblNewLabel = new JLabel("Peaton:");
	JComboBox comboBox_1 = new JComboBox();
	JLabel lblSemaforo = new JLabel("Semaforo:");
	static JComboBox cb_semaforo = new JComboBox();
	static JComboBox cb_calleFin = new JComboBox();
	public Simulador() {
		
		setName("Simulador de Trafico Con Agentes");
				setSize(1200, 700);
		
		JLabel lblCallePrincipal = new JLabel("Calle:");
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
					refreshMap1(muestraCoordenadasVehiculo(pathArchivoVehiculo),muestraCoordenadasPeaton(pathArchivoPeaton));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				try {
					ControlVehiculo.start1(muestraCoordenadasVehiculo(pathArchivoVehiculo),muestraCoordenadasPeaton(pathArchivoPeaton),muestraCoordenadasSemaforo(pathArchivoSemaforo));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		cb_semaforo.addItem("Seleccione");
		cb_semaforo.addItem("Chimborazo y Av. Vicente Rocafuerte");
		cb_semaforo.addItem("Chimborazo y Av. Simon Bolivar");
		
	
		cb_calle.addItem("Seleccione");
		cb_calle.addItem("Chimborazo y Av. Hermano Miguel");
		cb_calle.addItem("Chimborazo y Av. Vicente Rocafuerte");
		cb_calle.addItem("Chimborazo y Av. Simon Bolivar");
		
		cb_calleFin.addItem("Seleccione");
		cb_calleFin.addItem("Chimborazo y Av. Vicente Rocafuerte");
		cb_calleFin.addItem("Chimborazo y Av. Simon Bolivar");
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnIniciar)
									.addGap(3))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblSemaforo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cb_semaforo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(jLabel1)
							.addPreferredGap(ComponentPlacement.RELATED, 774, Short.MAX_VALUE)
							.addComponent(lblCallePrincipal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(cb_calleFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cb_calle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(159))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCallePrincipal)
								.addComponent(cb_calle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(jLabel1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cb_calleFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSemaforo)
						.addComponent(cb_semaforo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(btnIniciar)
					.addContainerGap(448, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public static void refreshMap1(String paramsVehiculo,String paramsPeaton,String paramSemaforo,String semaforo) throws Exception {
		jLabel1.setIcon(new ImageIcon(Geocoder.createImageMap1(paramsVehiculo,paramsPeaton,paramSemaforo,semaforo)));
	}
	
	public static String[] muestraCoordenadasVehiculo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        int count=0;
        int controlIni=1,numData=1,controlFin=1;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        String params=(String) cb_calle.getSelectedItem();			
        while((cadena = b.readLine())!=null) {
        	coordenadaVehiculo = cadena.split(";");
        	numData=Integer.parseInt(coordenadaVehiculo[1]);
        	controlIni = Integer.parseInt(muestraNumControlCalles(pathArchivoCalles));
        	if(numData >= controlFin && numData <= controlIni){
        	coordenadasVehiculo[count] = coordenadaVehiculo[0];
        	count=count+1;
        	}
        }
        b.close();
        return coordenadasVehiculo;
    }
	
	 public static String[] muestraCoordenadasPeaton(String archivo) throws FileNotFoundException, IOException {
	        String cadena;
	        int count=0;
	        FileReader f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        String params="";
	        while((cadena = b.readLine())!=null) {
	        	coordenadaPeaton = cadena.split(";");
	        	coordenadasPeaton[count] = coordenadaPeaton[0];
	        	idCoordPeaton[count]= coordenadaPeaton[1];
	        	params=params+"|" + coordenadaPeaton[0];
	            count=count+1;
	        }
	        b.close();
	        return coordenadasPeaton;
	    }
	 
	 public static String muestraCoordenadasSemaforo(String archivo) throws FileNotFoundException, IOException {
	        String cadena;
	        int count=0;
	        FileReader f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        String params="";
	        while((cadena = b.readLine())!=null) {
	        	coordenadaSemaforo = cadena.split(";");
	        	coordenadasSemaforo[count] = coordenadaSemaforo[0];
	        	idCoordSemaforo[count]= coordenadaSemaforo[1];
	        	
	        	if(coordenadaSemaforo[1].equals(cb_semaforo.getSelectedItem())){
	        		params=coordenadaSemaforo[0];
	        	}
	        	
	            count=count+1;
	        }
	        b.close();
	        return params;
	    }
	 
	 public static String muestraNumControlCalles(String archivo) throws FileNotFoundException, IOException {
	        String cadena;
	        int count=0;
	        String[] CallesControl=new String[9];
	        FileReader f = new FileReader(archivo);
	        BufferedReader b = new BufferedReader(f);
	        String params="";
	        while((cadena = b.readLine())!=null) {
	        	CallesControl = cadena.split(";");
	        
	        	if(CallesControl[0].equals(cb_calle.getSelectedItem())){
	        		params=CallesControl[1];
	        	}
	        	
	            count=count+1;
	        }
	        b.close();
	        return params;
	    }
}
