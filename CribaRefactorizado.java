import java.util.Scanner;

public class CribaRefactorizado {
	// Generar números primos de 1 a max
	public static int[] generarPrimos(int max) {
		
		if (max >= 2) {
			
			int tamaño = max + 1;
			boolean[] esPrimo = new boolean[tamaño];
	
			for (int i = 0; i < tamaño; i++)
				esPrimo[i] = true;
				esPrimo[0] = esPrimo[1] = false;
		
			for (int i = 2; i < Math.sqrt(tamaño) + 1; i++) {
				if (esPrimo[i]) {
					for (int j = 2 * i; j < tamaño; j += i)
						esPrimo[j] = false;
				}
			}
			
			int cuentaDePrimos = 0;
			for (int i = 0; i < tamaño; i++) {
				if (esPrimo[i])
					cuentaDePrimos++;
			}
			
			int[] primos = new int[cuentaDePrimos];
			for (int i = 0, j = 0; i < tamaño; i++) {
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
		System.out.println("Introduce el número para la criba de Erastótenes:");
		
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