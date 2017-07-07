package main.segundoParcialAliciaMarcosKhabie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Marcos Khabie
 * @version 1.0
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println(percentgeOfProducts("testParcial")+ " %");
    }

    public static double percentgeOfProducts(String nameOfFile){
        double counter = 0;//variable que me va a contar la cantidad total de productos.
        double amountOfProductsThatPassed = 0;//variable que va contando los productos que pasaron la prueba.
        try {
            FileReader fileReader = new FileReader(nameOfFile);
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();

            while (line != null) {

                int controlResult= (int)line.charAt(8);//el controlResult representa el resultado del control, va a buscar el char en 8 ya que aqui siempre tendremos el resultado del producto, o 1 o 2.
                if (controlResult==49){//Aca me fijo si el resultado del control es 1. ACLARO ESTA IGUALADO A 49 PORQUE AL CASTEAR A INT EL CHAR ME DEVUELVE EL ASCII DE 1 ES DECIR, 49.
                    amountOfProductsThatPassed++;
                }
                counter++;
                line = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("File do not exist!");
        }
        return (amountOfProductsThatPassed/counter)*100;
    }
}
