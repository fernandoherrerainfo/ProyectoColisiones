package mx.fca.aviones;

import java.util.ArrayList;

public class Aerolineas {
    //Ningun cambio

    //Escenario 1: One collision BIEN
    public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();
        aviones.add(new Avion(Direccion.SOUTH, 0, 0));
        aviones.add(new Avion(Direccion.EAST, 1, 2));
        aviones.add(new Avion(Direccion.SOUTH, 2, 1));
        aviones.add(new Avion(Direccion.SOUTH, 5, 5));
        aviones.add(new Avion(Direccion.SOUTH, 4, 4));

        return aviones;
    }

    //Escenario 2: Close encounter
    /*public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();
        aviones.add(new Avion(Direccion.EAST, 2, 3));
        aviones.add(new Avion(Direccion.SOUTH, 3, 1));
        return aviones;
    }*/

    //Escenario 3: Catastrophy Bien
    /*public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();

        aviones.add(new Avion(Direccion.EAST, 0, 1));
        aviones.add(new Avion(Direccion.SOUTH, 1, 0));

        aviones.add(new Avion(Direccion.EAST, 0, 3));
        aviones.add(new Avion(Direccion.SOUTH, 1, 2));

        aviones.add(new Avion(Direccion.EAST, 0, 5));
        aviones.add(new Avion(Direccion.SOUTH, 1, 4));

        aviones.add(new Avion(Direccion.EAST, 2, 1));
        aviones.add(new Avion(Direccion.SOUTH, 3, 0));

        aviones.add(new Avion(Direccion.EAST, 2, 3));
        aviones.add(new Avion(Direccion.SOUTH, 3, 2));

        aviones.add(new Avion(Direccion.EAST, 2, 5));
        aviones.add(new Avion(Direccion.SOUTH, 3, 4));

        aviones.add(new Avion(Direccion.EAST, 4, 1));
        aviones.add(new Avion(Direccion.SOUTH, 5, 0));

        aviones.add(new Avion(Direccion.EAST, 4, 3));
        aviones.add(new Avion(Direccion.SOUTH, 5, 2));

        aviones.add(new Avion(Direccion.EAST, 4, 5));
        aviones.add(new Avion(Direccion.SOUTH, 5, 4));
        return aviones;
    }*/

    //Escenario 4: Chained reaction FALLO
   /*public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();

        aviones.add(new Avion(Direccion.EAST, 3, 4));
        aviones.add(new Avion(Direccion.SOUTH, 4, 3));

        aviones.add(new Avion(Direccion.EAST, 2, 4));
        aviones.add(new Avion(Direccion.SOUTH, 4, 2));

        aviones.add(new Avion(Direccion.EAST, 1, 4));
        aviones.add(new Avion(Direccion.SOUTH, 4, 1));

        aviones.add(new Avion(Direccion.EAST, 0, 4));
        aviones.add(new Avion(Direccion.SOUTH, 1, 3));

        aviones.add(new Avion(Direccion.SOUTH, 4, 0));
        return aviones;
    }*/

    //Escenario 5: Left and Up PARCIAL
    /*public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();

        aviones.add(new Avion(Direccion.NORTH, 7, 3));
        aviones.add(new Avion(Direccion.WEST, 8, 2));

        aviones.add(new Avion(Direccion.NORTH, 3, 5));
        aviones.add(new Avion(Direccion.WEST, 4, 4));

        aviones.add(new Avion(Direccion.NORTH, 6, 9));
        aviones.add(new Avion(Direccion.WEST, 7, 8));

        aviones.add(new Avion(Direccion.NORTH, 7, 5));
        aviones.add(new Avion(Direccion.NORTH, 1, 7));

        aviones.add(new Avion(Direccion.WEST, 2, 8));
        aviones.add(new Avion(Direccion.WEST, 4, 5));
        aviones.add(new Avion(Direccion.WEST, 8, 3));

        return aviones;
    }*/

    //Escenario 6: All directions FALLO
    /*public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();
        aviones.add(new Avion(Direccion.EAST, 2, 2));
        aviones.add(new Avion(Direccion.SOUTH, 4, 1));
        aviones.add(new Avion(Direccion.NORTH, 4, 3));
        aviones.add(new Avion(Direccion.WEST, 6, 2));
        return aviones;
    }*/

    //Escenario 8: 4-in-one FALLO
    /*public static ArrayList<Avion> AEROMEXICO(){
        ArrayList<Avion> aviones = new ArrayList<>();
        aviones.add(new Avion(Direccion.EAST, 1, 2));
        aviones.add(new Avion(Direccion.SOUTH, 2, 1));
        aviones.add(new Avion(Direccion.NORTH, 2, 3));
        aviones.add(new Avion(Direccion.WEST, 3, 2));
        return aviones;
    }*/


}
