// Nombre de programa: Calculadora.java
//      Luis Carlos Ralon,13030
//		Augusto Cardenas 13136
//      Gabriela Lopez  
//      Este programa es el main.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
	@SuppressWarnings("unchecked")

public class Calculadora {
    public static int cont=0;
    static File archivo = new File("C:\\Lab2\\datos.txt"); //Almacena el archivo en donde se guardaran los datos
    java.io.File directorio = new File("C:\\Lab2");
    public static String data=new String();
    static Stack pila = new StackArrayList();
    static int result=0;// Se guarda el resultado 
    static int dat1=0; // primer dato de la pila
    static int dat2=0; // Segundo dato de la pila 
    
public static void main(String[] args) {
    data=leerDatos(); 
    int largo = data.length();
    for(int i=0;i<largo;i++){
        // Esta parte del codigo permite la ver que tipo de operacion es la que se debe realizar 
        if(Character.toString(data.charAt(i)).equals("*") && !pila.empty()){
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2*dat1;
            pila.push(result);
        }else if(Character.toString(data.charAt(i)).equals("+") && !pila.empty()){
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2+dat1;
            pila.push(result);
        }else if(Character.toString(data.charAt(i)).equals("-") && !pila.empty()){
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2-dat1;
            pila.push(result);
        }else if(Character.toString(data.charAt(i)).equals("/") && !pila.empty()){
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2/dat1;
            pila.push(result);
        }else if(!Character.toString(data.charAt(i)).equals(" ")){
            int ingresar=(int)data.charAt(i)-48; 
            pila.push(ingresar);
            
        }
    }
    System.out.println("Resultado de la operacion es: "+pila.pop());
}
		// Esta parte del programa es la que nos permite leer el texto de bloc de notas para operarlo.
    public static String leerDatos(){
            FileReader fr = null;
            BufferedReader br = null;
            String datos = new String();
            
            try{
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);
                    String linea;
                    if ((linea = br.readLine())!=null){

                        datos=linea;
                        ;
                    }
                    if(datos == null){
                        datos=" ";
                    }
                    
                    return datos;

            }
            catch(Exception e){
                    e.printStackTrace();
            }
            finally{
                    try{
                            if(null != fr ){
                                    fr.close();
                            }
                    }
                    catch(Exception e2){
                            e2.printStackTrace();
                    }

            }
            return datos;	
    }

}