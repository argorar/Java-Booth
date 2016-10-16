package co.edu.uniquindio.booth.app;

import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 * Clase que realiza el algoritmo de Booth para la multiplicación de números binarios.
 *  @author Jonh Sebastián Adudelo O
 *	@author Universidad del Quíndio
 *	@since 03-03-2016
 */
public class App {

	/**
	 * Variables
	 */
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		byte w;
		int a,x,y;
		long z;
		x =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número 1."));
		y =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número 2."));
		System.out.println("El resultado de multiplicar "+x+"*"+y+" es:");
		a=0;                                                  
		w=0;
		z=0;
		for (int i = 0; i < 32; i++) {
			if((((x&0x01)<<1)|w)==1)
				a=a+y;
			if((((x&0x01)<<1)|w)==2)
				a=a-y;
			
			z=((((long)a)<<32)|((((long)x)&0xffffffffL)));
			w=(byte)(z&0x01);
			z=z>>1;
			
			a=(int) ((z>>32)&0xffffffff);
			x=(int)((z)&0xffffffff);
		}		
		System.out.println(z);
	}
}
