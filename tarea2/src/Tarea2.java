package tarea2.tarea2.src;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarea2{
    public static void main(String[] args) {
    
            Scanner input = new Scanner(System.in);
            int option;
            int option2;
            String marca, modelo, propietario;
            Boolean salir = true;
            Auto auto;
            ArrayList<Auto> autos = new ArrayList<Auto>();
            Persona persona;
            ArrayList<Persona> personas = new ArrayList<Persona>();
            String cliente;
            int seleccion;

            Estacionamiento estacionamiento = new Estacionamiento(8, 60, 180);

            do {
                
                System.out.println("---------------------------------------");
                System.out.println("- 1)- Agregar nuevo vehiculo          -");
                System.out.println("- 2)- Agregar nuevo cliente           -");
                System.out.println("- 3)- Crear nuevo estacionamiento     -");
                System.out.println("- 4)- Mostrar todas las cuentas       -");
                System.out.println("- 5)- Ingreso de auto                 -");
                System.out.println("- 6)- Salida de auto                  -");
                System.out.println("- 7)- Cerrar estacionamiento          -");
                System.out.println("- 0)- Salir                           -");
                System.out.println("---------------------------------------");
                
                option = input.nextInt();
                
                switch (option) {
                    case 1:
                    System.out.println("Elija la marca del vehiculo: ");
                    
                    System.out.println("----------------------------");
                    System.out.println("- 1)- Volkswagen           -");
                    System.out.println("- 2)- Fiat                 -");
                    System.out.println("- 3)- Ferrari              -");
                    System.out.println("- 4)- Mercedes             -");
                    System.out.println("- 5)- Lamborghini          -");
                    System.out.println("- 6)- Nissan               -");
                    System.out.println("- 0)- Salir                -");
                    System.out.println("----------------------------");
                    
                    option2 = input.nextInt();
                    switch (option2) {
                        case 1:
                            marca = "Volkswagen";
                            System.out.println("Ingrese el modelo del auto");
                            modelo = input.next();
                            System.out.println("Ingrese el propietario del vehiculo");
                            propietario = input.next();
                            auto = new Auto(marca, modelo, propietario);
                            autos.add(auto);
                          break;
                        case 2:
                            marca = "Fiat";
                            System.out.println("Ingrese el modelo del auto");
                            modelo = input.next();
                            System.out.println("Ingrese el propietario del vehiculo");
                            propietario = input.next();
                            auto = new Auto(marca, modelo, propietario);
                            autos.add(auto);
                          break;
                        case 3:
                            marca = "Ferrari";
                            System.out.println("Ingrese el modelo del auto");
                            modelo = input.next();
                            System.out.println("Ingrese el propietario del vehiculo");
                            propietario = input.next();
                            auto = new Auto(marca, modelo, propietario);
                            autos.add(auto);
                          break;
                        case 4:
                            marca = "Mercedes";
                            System.out.println("Ingrese el modelo del auto");
                            modelo = input.next();
                            System.out.println("Ingrese el propietario del vehiculo");
                            propietario = input.next();
                            auto = new Auto(marca, modelo, propietario);
                            autos.add(auto);
                          break;
                        case 5:
                            marca = "Lamborghini";
                            System.out.println("Ingrese el modelo del auto");
                            modelo = input.next();
                            System.out.println("Ingrese el propietario del vehiculo");
                            propietario = input.next();
                            auto = new Auto(marca, modelo, propietario);
                            autos.add(auto);
                          break;
                        case 6:
                            marca = "Nissan";
                            System.out.println("Ingrese el modelo del auto");
                            modelo = input.next();
                            System.out.println("Ingrese el propietario del vehiculo");
                            propietario = input.next();
                            auto = new Auto(marca, modelo, propietario);
                            autos.add(auto);
                          break;
                        case 0:
                          break;
                        default:
                            System.out.println("Opcion invalida");
                          break;
                    }
                      break;
                    case 2:
                        System.out.println("Ingrese el nombre del nuevo cliente");
                        cliente = input.next();
                        persona = new Persona(cliente, estacionamiento.getPrecioIngreso());
                        personas.add(persona);
                      break;
                    case 3:
                    
                      break;
                    case 4:
                        for (int i = 0; i < personas.size(); i++) {
                            Persona per = personas.get(i);
                            System.out.println(per.getNombre() + " debe $" + per.getCuenta());
                        }
                    
                      break;
                    case 5:
                        System.out.println("Cual de los siguientes usuarios ingreso");
                        for (int i = 0; i < personas.size(); i++) {
                            Persona per = personas.get(i);
                            int j = i + 1;
                            if(!per.getUsa()) {
                              System.out.println(j + "- " + per.getNombre());
                            }
                        }
                        seleccion = input.nextInt();
                        Persona per = personas.get(seleccion - 1);
                        per.ingreso(estacionamiento.getPrecioNoche());
                        System.out.println(per.getCuenta());
                        
                      break;
                    case 6:
                    System.out.println("Cual de los siguientes usuarios salio del estacionamiento");
                        for (int i = 0; i < personas.size(); i++) {
                            Persona perso = personas.get(i);
                            int j = i + 1;
                            if(perso.getUsa()) {
                              System.out.println(j + "- " + perso.getNombre());
                            }
                        }
                        seleccion = input.nextInt();
                        Persona perso2 = personas.get(seleccion - 1);
                        perso2.sale();
                        System.out.println("Debe: " + perso2.getCuenta());
                      break;
                    case 7:
                    System.out.println("El estacionamiento a cerrado, las cuentas actuales son:");
                        for (int i = 0; i < personas.size(); i++) {
                            Persona perso = personas.get(i);
                            int j = i + 1;
                            if(perso.getUsa()) {
                              perso.cierre(estacionamiento.getPrecioNoche());
                              System.out.println(perso.getNombre() + " debe $" + perso.getCuenta());
                            }
                        }
                      break;
                    case 0:
                        salir = false;
                      break;
                    default:
                        System.out.println("Opcion invalida");
                      break;
                }
            } while (salir);

        }
    }


class Persona{
    private String nombre;
    private int cuenta;
    private boolean usa;
    
    public Persona(String nombre, int precioIngreso){
        this.nombre = nombre;   
        cuenta = precioIngreso;
        usa = true;
    }

    public int ingreso(int precioIngreso) {
        cuenta = cuenta + precioIngreso;
        usa = true;
        return cuenta;
    }

    public boolean sale() {
        usa = false;
        return usa;
    }

    public int cierre(int precioNoche) {
        if(usa) {
            cuenta = cuenta + precioNoche;
        }
        return cuenta;
    }

    

    public int getCuenta() {
        return cuenta;
    }

    public String getNombre() {
        return nombre;
    }
     public boolean getUsa(){
         return usa;
     }
}

class Auto{
    private String marca;
    private String modelo;
    private String dueño;

    public  Auto(String marca, String modelo, String dueño){
        this.marca = marca;
        this.modelo = modelo;
        this.dueño = dueño;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDueño() {
        return dueño;
    }

}

class Estacionamiento{
    private int lugares;
    private int precioIngreso;
    private int precioNoche;

    public Estacionamiento(int lugares, int precioIngreso, int precioNoche){
        this.lugares = lugares;
        this.precioIngreso = precioIngreso;
        this.precioNoche = precioNoche;

    }

    public int getLugares() {
        return lugares;
    }

    public int getPrecioIngreso() {
        return precioIngreso;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }
}