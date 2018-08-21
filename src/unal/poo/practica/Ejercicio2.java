/*Ejercicio 1, clase de Agosto 19*/

package unal.poo.practica;

import becker.robots.*;

public class Ejercicio2
{
  //Declaracion de Variables -- Forma temporal - No es buena practica tener
  //variables estaticas
  public static City ciudad;
  public static Robot godel_e;

	public static void main (String[] args){
    //Declarar la creacion de la ciudad
    ciudad = new City("Field.txt");
    ciudad.showThingCounts(true);

    //Direction.NORTH, EAST, SOUTH, WEST
    //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
    godel_e = new Robot(ciudad,0, 2, Direction.WEST,10);

    mov_principal();
  }
  public static void mover_n_espacios(int n){
    for(int ii=1; ii<=n; ii++){
      godel_e.move();
    }
  }
  public static void mov_principal(){
    girar_derecha(2);
    mover_n_espacios(1);
    girar_abajo(1);
    mover_n_espacios(3);
    girar_izquierda(4);
    mover_n_espacios(3);
    girar_arriba(2);
    mover_n_espacios(3);
    girar_derecha(3);
    mover_n_espacios(2);
    girar_izquierda(1);
  }
  public static void girar_abajo(int n){ //1=derecha, 2=izquierda, 3=arriba
    if(n == 1){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 2){
      godel_e.turnLeft();
    }
    else if(n == 3){
      for(int ii=0; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
  }
  public static void girar_derecha(int n){ //2=izquierda, 3=arriba, 4=abajo
    if(n == 2){
      for(int ii=1; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 3){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 4){
      godel_e.turnLeft();
    }
  }
  public static void girar_arriba(int n){ //1=derecha, 2=izquierda, 4=abajo
    if(n == 1){
        godel_e.turnLeft();
    }
    else if(n == 2){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 4){
      for(int ii=1; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
  }
  public static void girar_izquierda(int n){ //1=derecha, 3=abajo, 4=izquierda
    if(n == 1){
      for(int ii=1; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 3){
        godel_e.turnLeft();
    }
    else if(n == 4){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
  }
}
