import java.util.Scanner;

public class CribaRefactorizado {
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