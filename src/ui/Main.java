package ui; 

import java.util.Scanner;

import model.VideoGame;

public class Main{

	private Scanner reader; 
	private VideoGame videoGame;

	public Main(){
		reader = new Scanner(System.in);
		videoGame= new VideoGame();
	}

	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		Main main = new Main(); 
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
		option = validateIntegerOption();
		return option; 
	}

	public void executeOption(int option){
		switch(option){
			case 1:
				System.out.println("Escribe el nickname del jugador");
				String nickName= reader.next();
				System.out.println("Escribe el nombre");
				String name=reader.next();
				String msj=videoGame.addPlayer(nickName, name);
				System.out.println(msj);
				break; 

			case 2:
				System.out.println("Escribe el nombre del tesoro");
				String nameTreasure= reader.next();
				System.out.println("Escribe su url");
				String url= reader.next();
				System.out.println("Escribe su puntaje");
				int scoreTreasure= validateIntegerOption();
				System.out.println("Escribe el nivel donde vas a agregar el tesoro");
				int level= validateIntegerOption();
				while(level>10 || level<1){
					System.out.println("Escribe un nivel entre 1-10");
					level= validateIntegerOption();
				}
				System.out.println("Escribe la cantidad de tesoros a agregar");
				int quantityOfTreasure=validateIntegerOption();
				while(quantityOfTreasure<1){
					System.out.println("Escribe una cantidad mayor o igual a 1");
					quantityOfTreasure=validateIntegerOption();
				}
				msj=videoGame.addTreasure(nameTreasure, url, scoreTreasure, level, quantityOfTreasure);
				System.out.println(msj);
				break; 

			case 3:
				System.out.println("Escribe el nombre del enemigo");
				String nameEnemy= reader.next();
				System.out.println("Escribe el daño");
				int damageEnemy= validateIntegerOption();
				System.out.println("Escribe el puntaje");
				int scoreEnemy=validateIntegerOption();
				System.out.println(videoGame.showTypeEnemyList());
				System.out.println("Escribe el tipo de enemigo");
				int optionEnemy=validateIntegerOption();
				while(optionEnemy>4 || optionEnemy<1){
					System.out.println("Escribe un tipo entre 1-4");
					optionEnemy= validateIntegerOption();
				}
				System.out.println("Escribe el nivel");
				level= validateIntegerOption();
				while(level>10 || level<1){
					System.out.println("Escribe un nivel entre 1-10");
					level= validateIntegerOption();
				}
				optionEnemy--;
				msj=videoGame.addEnemy(nameEnemy, damageEnemy, scoreEnemy, optionEnemy , level);
				System.out.println(msj);
				break;
            
            case 4:
				System.out.println("Escribe el nickName del jugador");
				nickName=reader.next();
				System.out.println("Escribe su nuevo puntaje");
				int scorePlayer=validateIntegerOption();
				msj=videoGame.modifyPlayerScore(nickName, scorePlayer);
				System.out.println(msj);
				break; 
            
            case 5:
				System.out.println("Escribe el nickName del jugador");
				nickName=reader.next();
				System.out.println("Escribe el nivel");
				level= validateIntegerOption();
				while(level>10 || level<2){
					System.out.println("Escribe un nivel entre 2-10");
					level= validateIntegerOption();
				}
				msj=videoGame.increasePlayerLevel(nickName,level);
				System.out.println(msj);
				break;
                
            case 6:
				System.out.println("Escribe el nivel");
				level= validateIntegerOption();
				while(level>10 && level<1){
					System.out.println("Escribe un nivel entre 1-10");
					level= validateIntegerOption();
				}
				msj=videoGame.getLevels()[level-1].listEnemiesAndTreasures();
				System.out.println(msj);
				break; 

            case 7:
				System.out.println("Escribe el nombre del tesoro");
				nameTreasure=reader.next();
				msj=videoGame.countATreasure(nameTreasure);
				System.out.println(msj);
                break;

            case 8:
				System.out.println(videoGame.showTypeEnemyList());
				System.out.println("Escribe el tipo de enemigo");
				optionEnemy=validateIntegerOption();
				while(optionEnemy>4 || optionEnemy<1){
					System.out.println("Escribe un tipo entre 1-4");
					optionEnemy= validateIntegerOption();
				}
				msj=videoGame.countATypeEnemy(optionEnemy-1);
				System.out.println(msj);
				break; 

            case 9:
				msj=videoGame.showMostRepeatedTreasure();
				System.out.println(msj);
				break; 

            case 10:
				msj=videoGame.showHigerScoreEnemy();
				System.out.println(msj);
				break; 

            case 11:
				msj=videoGame.showEnemiesConsonants();
				System.out.println(msj);
				break; 

            case 12:
				msj=videoGame.showTop5Players();
				System.out.println(msj);
				break; 

			case 0: 
				System.out.println("Programa Finalizado.");
				break; 

			default: 
				System.out.println("Opcion Invalida");
				break; 
		}
	}

	/**validateIntegerOption= Validates if the user input is a integer number
	 * @return option: int = The integer number that the user input
	 */
	public int validateIntegerOption(){
		int option = 0; 
		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}
		while(option==-1){
			if(reader.hasNextInt()){
				option = reader.nextInt(); 
			}
			else{
				// clear reader. 
				reader.nextLine(); 
				option = -1; 
			}
		}
		return option; 
	}
}