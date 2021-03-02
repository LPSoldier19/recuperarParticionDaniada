package recuperarParticiones;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String salida = null;
        String comando = "diskpart /s listdisk.txt";
        String salidaRecuperacion = null;
        int R;
        Scanner leer = new Scanner(System.in);
        
        do{
        	System.out.println("Que desea realizar:");
            System.out.println("1-Analizar Partición");
            System.out.println("0-Salir");
            R=leer.nextInt();
            switch (R) {
			case 1:
				try{

	                // Ejecucion Basica del Comando
	                Process proceso = Runtime.getRuntime().exec(comando);

	                InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
	                BufferedReader stdInput = new BufferedReader(entrada);

	                //Si el comando tiene una salida la mostramos
	                if((salida=stdInput.readLine()) != null){
	                	while ((salida=stdInput.readLine()) != null){
	                    	System.out.println(salida);
	                    }
	                }else{
	                	System.out.println("No se a producido ninguna salida");
	                }
	            }catch (IOException e) {
	                    System.out.println("Excepción: ");
	                    e.printStackTrace();
	            }
	            

	        	Scanner scanner = new Scanner(System.in);
	        	System.out.print("Elija la particion que desea analizar/recuperar: ");
	        	String diskName = scanner.nextLine();
	        	
	        	if(diskName != "") {
	        		try {
	        			String[] command = {"chkdsk", diskName+":", "/f", "/r"  };
	        			Process recuperarParticion = Runtime.getRuntime().exec(command);

	                    InputStreamReader entradaRecuperacion = new InputStreamReader(recuperarParticion.getInputStream());
	                    BufferedReader stdInputRecuperacion = new BufferedReader(entradaRecuperacion);

	                    if((salidaRecuperacion=stdInputRecuperacion.readLine()) != null){
	                    	while ((salidaRecuperacion=stdInputRecuperacion.readLine()) != null){
	                        	System.out.println(salidaRecuperacion);
	                        }
	                    }else{
	                    	System.out.println("No se a producido ninguna salida");
	                    }
	    			} catch (Exception e) {
	    				System.out.println("Excepción: ");
	                    e.printStackTrace();
	    			}
	        	}
				break;

			case 0:
				System.exit(0);
				break;
				
			default:
				break;
			}
        	
        }while(R==1);

        
	}
	
	

}
