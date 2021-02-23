package recuperarParticiones;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String salida = null;
        String comando = "diskpart /s listdisk.txt";

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
	}
	
	

}
