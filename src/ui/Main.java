package ui; 

import java.util.Scanner;

import model.VideoGame;

public class Main{

	private Scanner reader; 
	private VideoGame videoGame;

	public Main(){
		reader = new Scanner(System.in);
		videoGame = new VideoGame(); 
	}

	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		// creación del objeto. 
		Main main = new Main(); 
		// llamdo a uno de los metodos de la clase. 
		String msj = main.toString(); 
		System.out.println(msj); 
		int option = 0; 

		do{
			option = main.getOptionShowMenu(); 
			main.executeOption(option);
		}while(option != 0);

		main.getReader().close();
	}
	
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Bienvenido al Video Juego >>>>>");
		System.out.println(
				"1. Agregar un jugador\n" +
				"2. Agregar un tesoro a un nivel\n" +
				"3. Agregar un enemigo a un nivel\n" +
                "4. Modificar el puntaje de un jugador\n" +
                "5. Incrementar el nivel de un jugador\n" +
                "6. Mostrar los tesoros y enemigos de un nivel\n" +
                "7. Buscar un tesoro en todos los niveles\n" +
                "8. Buscar un tipo de enemigo en todos los niveles\n" +
                "9. Mostrar el tesoro mas repetido en todos los niveles\n" +
                "10. Mostrar el enemigo con el mayor puntaje y donde se encuentra\n" +
                "11. Mostar la cantidad de consonantes en los nombres de los enemigos del juego\n" +
                "12. Mostrar el top 5 de jugadores del juego\n" +
				"0. Salir del Programa. ");
		option = reader.nextInt(); 

		return option; 
	}

	public void executeOption(int option){
		switch(option){
			videoGame.initVideoGame();
			String msj="";
			case 1:
				System.out.println("Escribe el nickname del jugador");
				String nickName= reader.next();
				System.out.println("Escribe el nombre");
				String name=reader.next();
				msj=videoGame.addPlayer(nickName, name);
				System.out.println(msj);
				break; 

			case 2:
				
				break; 

			case 3:

				break;
            
            case 4:

				break; 
            
            case 5:

				break;
                
            case 6:

				break; 

            case 7:

                break;

            case 8:

				break; 

            case 9:

				break; 

            case 10:

				break; 

            case 11:

				break; 

            case 12:

				break; 

			case 0: 
				System.out.println("Programa Finalizado.");
				break; 

			default: 
				System.out.println("Opcion Invalida");
				break; 
		}
	}



}
