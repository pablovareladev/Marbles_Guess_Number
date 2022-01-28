import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		//declaramos variable
		int seleccion = 0;

		do {

			try {
				System.out.println("¿A que juego quieres jugar? (1) Juego de las canicas || (2) Juego del numero oculto" );
				seleccion = teclado.nextInt();
			}catch(Exception e) {
				System.out.println("no has introducido un numero");
				teclado.next();
			}


		}while(seleccion != 1 && seleccion != 2);

		if(seleccion == 1) {
			System.out.println("Bienvenido al juego de las canicas");
			//Declaración de variables 

			int eleccion = 0;

			int canicasJUno = 10;
			int canicasJDos = 10;

			int guardarJUno = 0;
			int apuestaJUno = 0;

			String parimparUsuario =  "";
			int parImparCPU = 0;


			int guardarJDos = 0;
			int apuestaJDos = 0;



			boolean finPartida = false;

			//----------IA------------------

			int canicasCPU = 10;
			int guardarCPU = 0;
			int apuestaCPU = 0;



			do {
				//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
				try {
					System.out.println("Seleccione modo de juego (1) Contra la CPU || (2) 2 Jugadores");
					eleccion = teclado.nextInt();

				}catch(Exception e) {
					System.out.println("No has introducido un numero");
					teclado.next();	
				}

				//Hacemos control de errores para que no pueda meter numeros fuera del rango
			}while(eleccion >= 3 || eleccion <= 0);

			if(eleccion == 2) {
				//PRIMER TURNO---------------------------------------------

				//le decimos que ejecute las instrucciones
				do {

					do {
						//Entrara en el if si la booleana sigue dando false, si no, será fin de partida en la funcion
						if(finPartida == false) {

							do {
								//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
								try {
									System.out.println("Jugador1: ¿Cuántas canicas quieres guardar?");
									guardarJUno = teclado.nextInt();

								}catch(Exception e) {
									System.out.println("No has introducido un numero");
									teclado.next();	
								}

								//Hacemos control de errores para que no pueda meter numeros fuera del rango
							}while(guardarJUno > canicasJUno || guardarJUno <= 0);

							do {
								//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
								try {
									System.out.println("Jugador2: ¿Apuesta el número de canicas?");
									apuestaJDos = teclado.nextInt();

								}catch(Exception e) {
									System.out.println("No has introducido un numero");
									teclado.next();	
								}

								//Hacemos control de errores para que no pueda meter numeros fuera del rango
							}while(apuestaJDos > canicasJDos || apuestaJDos <= 0);

							do {

								//pedimos al usuario que nos diga si es un numero par o impar
								System.out.println("Jugador2: ¿El número de canicas que ha apostado el jugador1 es par o impar?");
								parimparUsuario = teclado.next();

								//miramos que el usuario lo introduzca en minusculas
								parimparUsuario = parimparUsuario.toLowerCase();


								//se repetira hasta que se cumpla una de las condiciones
							}while(parimparUsuario.equals("impar") && parimparUsuario.equals("par"));

							//si acierta que es par
							if (guardarJUno % 2 == 0 && parimparUsuario.equals("par")) {

								canicasJUno = canicasJUno - guardarJUno;
								canicasJDos = canicasJDos + guardarJUno;

								//si acierta que es impar
							}else if (guardarJUno % 2 != 0 && parimparUsuario.equals("impar")) {

								canicasJUno = canicasJUno - guardarJUno;
								canicasJDos = canicasJDos + guardarJUno;

							}
							//si se equivoca y falla
							else {
								canicasJUno = canicasJUno + apuestaJDos;
								canicasJDos = canicasJDos - apuestaJDos;
							}


							//mostramos cuantas canicas le quedan a cada uno
							System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
							System.out.println("Jugador2 tienes " + canicasJDos + " canicas.");


							finPartida = finDePrograma (canicasJUno, canicasJDos);
						}

					}while(finPartida == true);

					//---------------------------------------------------------------------------------------------------------		

					//SEGUNDO TURNO----------------------------------------------


					do {
						//mientras no gane ninguno de los dos, entraará en este if
						if(finPartida == false) {


							do {
								//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
								try {
									System.out.println("Jugador2: ¿Cuántas canicas quieres guardar?");
									guardarJDos = teclado.nextInt();

								}catch(Exception e) {
									System.out.println("No has introducido un numero");
									teclado.next();	
								}

								//Hacemos control de errores para que no pueda meter numeros fuera del rango
							}while(guardarJDos > canicasJDos || guardarJDos <= 0);

							do {
								//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
								try {
									System.out.println("Jugador1: ¿Apuesta el número de canicas?");
									apuestaJUno = teclado.nextInt();

								}catch(Exception e) {
									System.out.println("No has introducido un numero");
									teclado.next();	
								}

								//Hacemos control de errores para que no pueda meter numeros fuera del rango
							}while(apuestaJUno > canicasJUno || apuestaJUno <= 0);

							do {

								//pedimos al usuario que nos diga si es un numero par o impar
								System.out.println("Jugador1: ¿El número de canicas que ha apostado el jugador2 es par o impar?");
								parimparUsuario = teclado.next();

								parimparUsuario = parimparUsuario.toLowerCase();


								//se repetira hasta que se cumpla una de las condiciones
							}while(parimparUsuario.equals("impar") && parimparUsuario.equals("par"));


							//si acierta que es par
							if (guardarJDos % 2 == 0 && parimparUsuario.equals("par")) {

								canicasJUno = canicasJUno + guardarJDos;
								canicasJDos = canicasJDos - guardarJDos;

								//si acierta que es impar
							}else if (guardarJDos % 2 != 0 && parimparUsuario.equals("impar")) {

								canicasJUno = canicasJUno + guardarJDos;
								canicasJDos = canicasJDos - guardarJDos;

							}
							//si se equivoca y falla
							else {
								canicasJUno = canicasJUno + apuestaJUno;
								canicasJDos = canicasJDos - apuestaJUno;
							}


							//mostramos cuantas canicas le quedan a cada uno
							System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
							System.out.println("Jugador2 tienes " + canicasJDos + " canicas.");

							finPartida = finDePrograma (canicasJUno, canicasJDos);

						}

					}while(finPartida == true);

					//mientras que la instruccion sea distinto de true, va a buclear


				}while(finPartida != true);

			}


			if(eleccion == 1) {
				//PRIMER TURNO---------------------------------------------

				//le decimos que ejecute las instrucciones
				do {

					//Entrara en el if si la booleana sigue dando false, si no, será fin de partida en la funcion
					if(finPartida == false) {
						do {
							//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
							try {
								System.out.println("Jugador1: ¿Cuántas canicas quieres guardar?");
								guardarJUno = teclado.nextInt();

							}catch(Exception e) {
								System.out.println("No has introducido un numero");
								teclado.next();	
							}

							//Hacemos control de errores para que no pueda meter numeros fuera del rango
						}while(guardarJUno > canicasJUno || guardarJUno <= 0);

						//apuesta de la CPU
						apuestaCPU = (int)(Math.random()*(canicasCPU-1+1)+1); 

						//le decimos al usuario lo que ha apostado la CPU
						System.out.println("La CPU ha apostado " + apuestaCPU + " canicas");


						parImparCPU = (int)(Math.random()*(2-1+1)+1);

						if(parImparCPU == 1) {
							System.out.println("La CPU ha escogido IMPAR");

						}

						if(parImparCPU == 2) {
							System.out.println("La CPU ha escogido PAR");

						}


						//si acierta que es par
						if (guardarJUno % 2 == 0 && parImparCPU == 2) {

							canicasJUno = canicasJUno - guardarJUno;
							canicasCPU = canicasCPU + guardarJUno;

							//si acierta que es impar
						}else if (guardarJUno % 2 != 0 && parImparCPU == 1) {

							canicasJUno = canicasJUno - guardarJUno;
							canicasCPU = canicasCPU + guardarJUno;

						}
						//si se equivoca y falla
						else {
							canicasJUno = canicasJUno + apuestaCPU;
							canicasCPU = canicasCPU - apuestaCPU;
						}


						//mostramos cuantas canicas le quedan a cada uno
						System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
						System.out.println("CPU tiene " + canicasCPU + " canicas.");


						finPartida = finDeProgramaCPU (canicasJUno, canicasCPU);
					}


					//---------------------------------------------------------------------------------------------------------		

					//SEGUNDO TURNO----------------------------------------------



					//mientras no gane ninguno de los dos, entraará en este if
					if(finPartida == false) {


						guardarCPU = (int)(Math.random()*(canicasCPU-1+1)+1); 
						System.out.println("La CPU ha guardado canicas");


						do {
							//Pedimos al usuario que introduzca los datos y controlamos que nos de un numero
							try {
								System.out.println("Jugador1: ¿Apuesta el número de canicas?");
								apuestaJUno = teclado.nextInt();

							}catch(Exception e) {
								System.out.println("No has introducido un numero");
								teclado.next();	
							}

							//Hacemos control de errores para que no pueda meter numeros fuera del rango
						}while(apuestaJUno > canicasJUno || apuestaJUno <= 0);

						do {

							//pedimos al usuario que nos diga si es un numero par o impar
							System.out.println("Jugador1: ¿El número de canicas que ha apostado la CPU es par o impar?");
							parimparUsuario = teclado.next();

							parimparUsuario = parimparUsuario.toLowerCase();


							//se repetira hasta que se cumpla una de las condiciones
						}while(parimparUsuario.equals("impar") && parimparUsuario.equals("par"));



						//si acierta que es par
						if (guardarCPU % 2 == 0 && parimparUsuario.equals("par")) {

							canicasJUno = canicasJUno + guardarCPU;
							canicasCPU = canicasCPU - guardarCPU;

							//si acierta que es impar
						}else if (guardarCPU % 2 != 0 && parimparUsuario.equals("impar")) {

							canicasJUno = canicasJUno + guardarCPU;
							canicasCPU = canicasCPU - guardarCPU;

						}
						//si se equivoca y falla
						else {
							canicasJUno = canicasJUno - apuestaJUno;
							canicasCPU = canicasCPU + apuestaJUno;
						}


						//mostramos cuantas canicas le quedan a cada uno
						System.out.println("Jugador1 tienes " + canicasJUno + " canicas.");
						System.out.println("La CPU tiene " + canicasCPU + " canicas.");

						finPartida = finDeProgramaCPU (canicasJUno, canicasCPU);

					}



					//mientras que la instruccion sea distinto de true, va a buclear
				}while(finPartida != true);
			}
		}


		else if(seleccion == 2) {
			System.out.println("Bienvenido al Juego 2 Numero Oculto");

			System.out.println("¿Que desea hacer?");

			//Variables
			int escogerOpcion = 0;
			int numIntUsuario = 0;
			int numMaxUsuario = 0;
			int numInt = 5;
			int numMax = 10;

			//Menu
			do {
				//Con el try catch comprobamos que no sea una letra
				try {
					System.out.println("1-Configuracion");	
					System.out.println("2-Jugar");
					System.out.println("3-Salir");
					escogerOpcion = teclado.nextInt();
				}catch(Exception e) {
					System.out.println("No has introducido un numero");
					teclado.next();
				}

				//No aseguramos que los numeros introducidos sean entre 1 y 3
			}while(escogerOpcion != 1 && escogerOpcion !=2 && escogerOpcion !=3);


			//Elegir la primera opcion
			if(escogerOpcion==1) {
				System.out.println("Has entrado en menu Configuracion: ");

				//Pedimos el numero de intentos para adivinar el numero miramos que no se pueda introducir un caracter
				do {
					try {
						System.out.println("Introduzca el numero de intentos para jugar a adivinar el numero: ");
						numIntUsuario = teclado.nextInt();
					}catch(Exception e) {
						System.out.println("No has introducido un numero");
						teclado.next();

					}
				}while(numIntUsuario==0 || numIntUsuario<0);

				//Pedimos el numero max para adivinar y comprobamos que no sea un caracter
				do {
					try {
						System.out.println("Introduzca el numero maximo para jugar: ");
						numMaxUsuario = teclado.nextInt();
					}catch(Exception e) {
						System.out.println("No has introducido un numero");
						teclado.next();
					}
				}while(numMaxUsuario==0 || numMaxUsuario<0);

				//Le pedimos al usuario que escoja si quiere jugar o salir
				do {
					//Comprobamos que no introduciomos un caracter
					try {
						System.out.println("Que quieres hacer");
						System.out.println("2-Jugar");
						System.out.println("3-Salir");
						escogerOpcion = teclado.nextInt();
					}catch(Exception e) {
						System.out.println("No has introducido un numero");
						teclado.next();
					}

				}while(escogerOpcion !=2 && escogerOpcion !=3);
			}

			//Elegir segunda opcion
			if(escogerOpcion==2) {
				System.out.println("Has entrado en la opcion de Jugar");
				int aleatorio = (int) Math.floor(Math.random()*(numMax-0+1)+0);
				//System.out.println(aleatorio);

				//Llamamos a la funcion
				intentarAdivinar (numInt, numMax, aleatorio);
			}

			//Elegir tercera opcion
			if(escogerOpcion == 3) {

				System.out.println("Has salido del juego");
			}

		}

	}


	//funcion para el primer juego VS
	private static boolean finDePrograma (int canicasJUno, int canicasJDos) {

		boolean partida = false;

		//condicion para si gana el jugador1
		if(canicasJUno == 20) {

			partida = true;	

			System.out.print("El Jugador2 ha perdido.\r\n"
					+ "¡¡¡Felicidades jugador1!!!\r\n");


		}
		//condicion para si gana el jugador2
		else if(canicasJDos == 20) {

			partida = true;	

			System.out.print("El Jugador1 ha perdido.\r\n"
					+ "¡¡¡Felicidades jugador2!!!\r\n");

			//si no, se devulve false
		}else {
			partida = false;
		}

		return partida;

	}

	//funcion para el primer juego contra la CPU
	private static boolean finDeProgramaCPU (int canicasJUno, int canicasCPU) {

		boolean partida = false;

		//condicion para si gana el jugador1
		if(canicasJUno == 20) {

			partida = true;	

			System.out.print("La CPU ha perdido\r\n"
					+ "¡¡¡Felicidades jugador1!!!\r\n");


		}
		//condicion para si gana la CPU
		else if(canicasCPU == 20) {

			partida = true;	

			System.out.print("El Jugador1 ha perdido.\r\n"
					+ "¡¡¡TE HA GANADO LA CPU!!!\r\n");

			//si no, se devulve false
		}else {
			partida = false;
		}

		return partida;

	}


	//funcion del segundo juego
	private static void intentarAdivinar (int numInt, int numMax, int aleatorio ) {
		Scanner teclado = new Scanner (System.in);

		//Declaramos Variables
		int numOculto = 0;
		int contadorIntentos = 0;


		//Con el bucle for hacemos que se pida numero hasta que el numero de intentos se agote
		for(int i=0; i<numInt; i++) {

			do {

				try {
					System.out.println("Introduzca numero para adivinar el numero oculto");
					numOculto = teclado.nextInt();
				}catch(Exception e) {
					System.out.println("No has introducido un numero");
					teclado.next();
				}

			}while(numOculto==0);

			contadorIntentos ++;

			//Aqui miramos las condiciones
			if(numOculto == aleatorio) {
				//Si acertamos el numero
				System.out.println("HAS ACERTADO :) " + "has necesitado " + contadorIntentos + " intentos para adivinar");
				break;
			}else if(contadorIntentos == numInt) {
				//Si nos quedamos sin intentos
				System.out.println("Perdiste!. Intentos consumidos :/");
			}else if(numOculto>aleatorio) {
				//Pista si ponemos un numero mayor que el aleatorio
				System.out.println("El numero oculto es menor ");
			}else if(numOculto<aleatorio) {
				//Pista si ponemos un numero menor que el aleatorio
				System.out.println("El numero oculto es mayor ");
			}
		}

	}

}



