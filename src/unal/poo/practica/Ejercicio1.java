/*Ejercicio 1.4.1 de "Learning with robots*/

package unal.poo.practica;

import becker.robots.*;

public class Ejercicio1
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
    godel_e = new Robot(ciudad,1, 0, Direction.EAST,10);

    mover_n_espacios(2);
    godel_e.pickThing();
    mover_n_espacios(1);
    mover_abajo(1);
    mover_n_espacios(1);
    godel_e.putThing();
    mover_n_espacios(1);
  }
  public static void mover_n_espacios(int n){
    for(int ii=1; ii<=n; ii++){
      godel_e.move();
    }
  }
  public static void mover_abajo(int n){ //1=derecha, 2=izquierda, 3=arriba
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
}
