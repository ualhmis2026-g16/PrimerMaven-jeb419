package org.eda2.practica01;

public class TorneoTenis2{

	public static boolean EsPar(int x) {
		if(x%2==0) return true;
		return false;
	}
	
	public static void torneoRecursivoCaso2(int [][]tabla, int n) {
		if(n == 2) {
			tabla[1][1] = 2;
			tabla[2][1] = 1;
		}else if(!EsPar(n)) {
			torneoRecursivoCaso2(tabla, n+1);
			
			for(int jug = 1; jug<=n; jug++) {
				for(int dia = 1; dia<=n; dia++) {
					if(tabla[jug][dia] == n+1) {
						tabla[jug][dia] = 0;
					}
				}
			}
		}else {
			int m = n/2;
			torneoRecursivoCaso2(tabla, m);
			if(EsPar(m)) {
				//Inferior izquierdo
				for(int jug = m+1; jug<=n ; jug++) {
					for(int dia = 1; dia<m ; dia++) {
						tabla[jug][dia] = tabla[jug-m][dia] + m;
					}
				}
				
				//Superior derecho
				for(int jug = 1; jug <= m ; jug++) {
					for(int dia = m; dia < n ; dia++) {
						if((jug + dia) <= n) {
							tabla[jug][dia] = jug + dia;
						}else
							tabla[jug][dia] = jug + dia - m;
					}
				}
				
				//Inferior derecha
				for(int jug = m+1; jug<=n ; jug ++) {
					for(int dia = m ; dia<n ; dia++ ) {
						if(jug > dia) {
							tabla[jug][dia] = jug - dia;
						}else {
							tabla [jug][dia] = jug - dia + m;
						}
					}
				}
			}
			else {
				//Inferior izquierdo
				for(int jug = m+1; jug<= n; jug ++) {
					for(int dia = 1; dia<=m; dia++) {
						if(tabla[jug-m][dia] == 0)
							tabla[jug][dia] = 0;
						else
							tabla[jug][dia] = tabla [jug-m][dia] + m;
					}
				}

				//Ceros
				for(int jug = 1; jug<=m;jug++) {
					for(int dia = 1; dia<=m; dia++) {
						if(tabla[jug][dia] == 0) {
							tabla[jug][dia] = jug + m;
							tabla [jug+m][dia] = jug;
						}
					}
				}

				//Superior derecho
				for(int jug = 1; jug<= m ;jug++) {
					for(int dia = m+1; dia< n;dia++) {
						if((jug+ dia) <= n) {
							tabla[jug][dia] = jug + dia;
						} else {
							tabla[jug][dia] = jug + dia - m;
						}
					}
				}

				//Inferior derecho
				for(int jug = m+1; jug <= n ; jug++) {
					for(int dia= m +1; dia < n; dia++) {
						if(jug > dia) {
							tabla[jug][dia] = jug - dia;
						} else {
							tabla[jug][dia] = (jug + m) - dia;
						}
					}
				}

			}
		}
	}
	
	public static void main(String[] args) {
		int n=5;
		int nd = (n+"   ").length();
		if(n>1) {
			if(EsPar(n)) {
				int[][] tabla2 = new int [n+1][n];

				for (int i = 0; i < n+1; i++) {
					for (int j = 0; j < n; j++) {
						tabla2[i][j] =0;
					}
				}

				torneoRecursivoCaso2(tabla2,n);
				for(int x=0; x<n ; x++) {
					if (x==0) {
						for (int i = 0; i < nd; i++) {
							System.out.print(" ");
						}
						System.out.print("|");
					}else {
						System.out.printf("%"+nd+"s","d" +(x));
					}
				}
				System.out.println();
				for (int i = 0; i < n; i++) {
					for(int x=0; x<nd ; x++) {
						System.out.print("-");
					}
				}
				System.out.println("-");
				for (int i = 1; i < tabla2.length; i++) {
					System.out.printf("%"+nd+"s","j"+(i) );
					System.out.print("|");
					for (int j = 1; j < n; j++) {
						System.out.printf("%"+nd+"d",tabla2[i][j]);
					}
					System.out.println("");
				}
				System.out.println();

			}else {
				int[][] tabla2 = new int [n+2][n+1];
				for (int i = 0; i < n+2; i++) {
					for (int j = 0; j < n+1; j++) {
						tabla2[i][j] =0;
					}
				}
				torneoRecursivoCaso2(tabla2,n);
				for(int x=0; x<n+1 ; x++) {
					if (x==0) {
						for (int i = 0; i < nd; i++) {
							System.out.print(" ");
						}
						System.out.print("|");
					}else {
						System.out.printf("%"+nd+"s","d" +(x));
					}
				}
				System.out.println();
				for (int i = 0; i < n+1; i++) {
					for(int x=0; x<nd ; x++) {
						System.out.print("-");
					}
				}
				System.out.println("-");
				for (int i = 1; i < tabla2.length-1; i++) {
					System.out.printf("%"+nd+"s","j"+(i) );
					System.out.print("|");
					for (int j = 1; j < n+1; j++) {

						System.out.printf("%"+nd+"d",+tabla2[i][j]);
					}
					System.out.println("");
				}
				System.out.println();

			}
		}else 
			System.out.println("Error: el valor introducido debe ser >1 y no potencia de 2");
	}
}