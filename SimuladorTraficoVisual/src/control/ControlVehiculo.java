package control;

import visual.Simulador;

public class ControlVehiculo {
	private static boolean execute;
	public static void start1(String[] param,String paramPeaton[],String paramSemaforo) {
		Thread executer = new Thread() {
			@Override
			public void run() {
				execute = true;
				String params="";
				String paramsPeaton="";
				String paramSemaforos="";
				String semaforo="green";
				int i = 0;
				synchronized (param) {
					
				
				 do{

					//Geocoder.clear();
				if(param[i] != null){
					params = param[i];
				}
				
				if(paramPeaton[i] != null){
					
					paramsPeaton = paramPeaton[i];
				}
				
				if(paramSemaforo != null){
					paramSemaforos = paramSemaforo;
					
				}
				
				if(!colorSemaforo(i,semaforo).equals("")){
					semaforo=colorSemaforo(i,semaforo);
				}else{
					semaforo = "green";
				}
				
				if(paramPeaton[i] == param[i]){
					System.out.println("Son iguales");
				}
						
					
					try {
						Simulador.refreshMap1(params,paramsPeaton,paramSemaforos,semaforo);
					} catch (Exception e) {
						e.printStackTrace();
					}
					i=i+1;
				}while (param[i] != null);
			}}
		};
		executer.start();
	}
	static String colorNuevo="";
	static int count=0;
	private static String colorSemaforo(int control,String colorAnterior){
		
		if(count == 8 && colorAnterior.equals("green")){
			colorNuevo="yellow";
			count=0;
		}
		
		if(count == 6 && colorAnterior.equals("yellow")){
			colorNuevo="red";
			count=0;
		}
		
		if(count == 10 && colorAnterior.equals("red")){
			colorNuevo="green";
			count=0;
		}
		
		count=count+1;
		return colorNuevo;
	}

	
	
}
