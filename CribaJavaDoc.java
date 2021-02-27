import java.util.Scanner;

/**
 * Este programa contiene una clase para generar todos los n�meros primos de 1
 *  hasta un n�mero m�ximo especificado  por  el  usuario.
 *  
 * El algoritmo  es simple:  Dado  un  vector  de enteros empezando  en  2, se
 * tachan  todos  los  m�ltiplos de  2.  A  continuaci�n,  se  encuentra  el  
 * siguiente entero no tachado y se tachan todos sus m�ltiplos.
 * 
 * El proceso se repite hasta que se pasa de la ra�z cuadrada del valor m�ximo.
 * Todos los n�meros que queden sin tachar son n�meros primos.
 * 
 * @author EstefaniaLeal
 * @version 1.1 25/02/2021
 * 
 */

public class CribaJavaDoc {
	/**
	 * 
	 * @param max: es el dato que introducimos desde el main para saber 
	 * hasta que n�mero queremos comprobar si es primo
	 * @return devuelve array de numeros primos desde el 2 hasta max
	 * 
	 */
	// Generar n�meros primos de 1 a max
	public static int[] generarPrimos(int max) {
		
		if (max >= 2) {
			
			int tama�o = max + 1;
			boolean[] esPrimo = new boolean[tama�o];
	
			for (int i = 0; i < tama�o; i++)
				esPrimo[i] = true;
				esPrimo[0] = esPrimo[1] = false;
		
			for (int i = 2; i < Math.sqrt(tama�o) + 1; i++) {
				if (esPrimo[i]) {
					for (int j = 2 * i; j < tama�o; j += i)
						esPrimo[j] = false;
				}
			}
			
			int cuentaDePrimos = 0;
			for (int i = 0; i < tama�o; i++) {
				if (esPrimo[i])
					cuentaDePrimos++;
			}
			
			int[] primos = new int[cuentaDePrimos];
			for (int i = 0, j = 0; i < tama�o; i++) {
				if (esPrimo[i])
					primos[j++] = i;
			}
			return primos;
		} else { 
			return new int[0];
			
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el n�mero para la criba de Erast�tenes:");
		
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		
		teclado.close();
		
		System.out.println("\nVector inicial hasta :" + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(i + 1 + "\t");
		}
		
		vector = generarPrimos(dato);
		
		System.out.println("\nVector de primos hasta:" + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(vector[i] + "\t");
		}
	}
}