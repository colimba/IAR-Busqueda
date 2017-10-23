/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iar.busqueda.gui;

import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */

/**
 * Clase para la creación de una ventana para impresi n o lectura
 * de datos
 */
public class Ventana
{
    
public Ventana()
{
	
}
    /**
     * Imprime una ventana con el icono de error
     * @param msg2 de la ventana Cuerpo de la ventana
     * @param msg1 de la ventana Un String que representa el titulo de la ventana
     */
public  <T> void imprimirError(T msg1, String msg2)
	{
	JOptionPane.showMessageDialog(null, msg1.toString(),msg2,0);
	}
	
    /**
     * Imprime un mensaje con el icono de advertencia
     * @param msg1 a Imprimir
     * @param msg2 de la Ventana String con el titulo de la ventana
     */
public  <T> void imprimirAdvertencia(T msg1, String msg2)
	{
	JOptionPane.showMessageDialog(null, msg1.toString(),msg2,2);
	}
	
    /**
     * Imprime mensaje sobre una ventana con el icono de informaci n
     * @param msg1 Cuerpo de la ventana
     * @param msg2 de la Ventana String con el titulo de la ventana
     */
public  <T> void imprimir(T msg1, String msg2)
	{
	JOptionPane.showMessageDialog(null, msg1.toString(),msg2,1);
	}
	

	
public  static  void main(String arg[])
	{
		Ventana x=new Ventana();
		int a=x.leerInt("lea entero");
		x.imprimirError("Error", "T tulo-Ventana");
		x.imprimirAdvertencia("Advertencia", "T tulo-Ventana");
		x.imprimir("Dato Digitado:"+a, "T tulo-Ventana");
		System.exit(0); 
	}
	
    /**
     * Lee un Entero a trav s de una Ventana
     * @return int le do
     */
	public   int leerInt(String msg)
	{
		
		return(Integer.parseInt(JOptionPane.showInputDialog(msg)));
	}
	
    /**
     * 
     */
	public   double leerDouble(String msg)
	{
		
		return(Double.parseDouble(JOptionPane.showInputDialog(msg)));
	}
	
	
    /**
     * Lee un dato long
     * @return un long
     */
	public   long leerLong(String msg)
	{
		
		return(Long.parseLong(JOptionPane.showInputDialog(msg)));
	}
	
    /**
     * Lee una Cadena
     * @return Un String
     */
	public   String leerCadena(String msg)
	{		
		return(JOptionPane.showInputDialog(msg));	
	}
	
	
    /**
     * Lee un Char
     * @return Un char
     */
	public   char leerChar(String msg)
	{
		String a=JOptionPane.showInputDialog(msg);
		char b[]= a.toCharArray();
		return(b[0]);
	}
    /**
     * 
     * @param msg 
     * @return 
     */
		public   byte leerByte(String msg)
	{
		return(Byte.parseByte(JOptionPane.showInputDialog(msg)));
	}
	
    /**
     * Lee un dato float
     * @return un float
     */
	public   float leerFloat(String msg)
	{	
		return(Float.parseFloat(JOptionPane.showInputDialog(msg)));
	}
	
}
