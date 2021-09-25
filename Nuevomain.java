package lab4;

import java.util.Scanner;

public class Nuevomain {
    static int i,j =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean estado = true;
        Paquete lista_paquetes[] = new Paquete[20];
        Persona_paquete lista_personas[] = new Persona_paquete[10];
        while(estado){
            System.out.println("Escriba el numero correspondiente a la opcion que guste");
            System.out.println("1) Realizar registro de personas");
            System.out.println("2) Realizar registro de paquetes");
            System.out.println("3) Registrar entrega de paquete");
            System.out.println("4) Mostrar paquetes con sierta cantidad de peso");
            System.out.println("5) Mostrar paquetes pendiente de envio");
            System.out.println("6) Mostrar datos de persona al mostrar datos del paquete");
            System.out.println("7) Salir");
            int opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    Registrar_persona(lista_personas, sc);
                    break;
                case 2:
                    Registrar_paquete(lista_paquetes, sc, lista_personas);
                    break;
                case 3:
                    Registrar_entrega(lista_paquetes, sc);
                    break;
                case 4:
                    Paquetes_min(lista_paquetes, sc);
                    break;
                case 5:
                    Paquetes_no_enviados(lista_paquetes);
                    break;
                case 6:
                    Ver_personas(lista_paquetes, sc);
                    break;
                case 7:
                    estado = false;
                    break;
            }
                    
        }
        
    }
    
    public static void Registrar_persona(Persona_paquete[] personitas, Scanner sc){
        if (i != 10) {
            System.out.println("Ingrese el nombre de la persona");
            String nombre =sc.next();
            System.out.println("Ingrese el numero telefonico de la persona");
            String numero =sc.next();
            System.out.println("Ingrese el dni de la persona");
            String dni =sc.next();
            personitas[i] = new Persona_paquete(dni, nombre, numero);
        }
        i+=1;
    }
    
    public static void Registrar_paquete(Paquete[] paquetitos, Scanner sc, Persona_paquete[] personitas){
        if (j != 20) {
            System.out.println("Ingrese la fecha en que se dejo el paquete");
            String fecha = sc.next();
            System.out.println("Ingrese el peso del paquete");
            double peso = sc.nextDouble();
            System.out.println("Ingrese la direccion de entega");
            String direccion = sc.next();
            System.out.println("Ingrese el costo de entrega");
            double costo = sc.nextDouble();
            System.out.println("Hora de ingresar los datos de la persona, ¿La persona ya existe?");
            String respuesta = sc.next();
            if (respuesta.contentEquals("Si")||respuesta.contentEquals("si")) {
                System.out.println("Ingrese el dni de la persona");
                String dni =sc.next();
                String nombre = "";
                String numero = "";
                for (int k = 0; k < personitas.length; k++) {
                    if (personitas[k] != null) {
                        if (personitas[k].getDni().equals(dni)) {
                            nombre = personitas[k].getNombre();
                            numero= personitas[k].getCelular();
                        }
                    }
                    
                }
                paquetitos[j] = new Paquete(j, fecha, peso, direccion, costo, nombre, dni, numero);
            }else if(respuesta.contentEquals("No")||respuesta.contentEquals("no")){
                System.out.println("Ingrese el nombre de la persona");
                String nombre =sc.next();
                System.out.println("Ingrese el numero telefonico de la persona");
                String numero =sc.next();
                System.out.println("Ingrese el dni de la persona");
                String dni =sc.next();
                paquetitos[j] = new Paquete(j, fecha, peso, direccion, costo, nombre, dni, numero);
                if (i != 10) {
                    personitas[i] = new Persona_paquete(dni, nombre, numero);
                }
                i+=1;
            }
            
        }
        j+=1;
    }
    
    public static void Registrar_entrega(Paquete[] paquetitos, Scanner sc){
        System.out.println("Ingrese el id del paquete que desea registrar entrega");
        int id = sc.nextInt();
        System.out.println("Ingrese la fecha de entrega");
        String fecha = sc.next();
        for (int k = 0; k < paquetitos.length; k++) {
            if (paquetitos[k] != null) {
                if (paquetitos[k].getId() == id) {
                    paquetitos[k].setFecha_ent(fecha);
                    paquetitos[k].setEstado(true);
                }
            }
        }
    }
    
    public static void Paquetes_min(Paquete[] paquetitos, Scanner sc){
        System.out.println("Ingrese el umbral minimo de pesos");
        double peso = sc.nextDouble();
        for (int k = 0; k < paquetitos.length; k++) {
            if (paquetitos[k] != null) {
                if (paquetitos[k].getPeso()>= peso) {
                    System.out.println("Id de paquete "+paquetitos[k].getId());
                    System.out.println("Fecha de recepcion "+paquetitos[k].getFecha_ent()); 
                    System.out.println("costo "+paquetitos[k].getCosto());
                    System.out.println("");
                }
            }            
        }
    }
    
    public static void Paquetes_no_enviados(Paquete[] paquetitos){
        for (int k = 0; k < paquetitos.length; k++) {
            if (paquetitos[k] != null) {
                if (paquetitos[k].isEstado() != true) {
                    System.out.println("Id de paquete: "+paquetitos[k].getId());
                    System.out.println("Fecha de recepcion: "+paquetitos[k].getFecha_ent());
                    System.out.println("costo: "+paquetitos[k].getCosto());
                    System.out.println("");
                }
            }
        }
    }
    public static void Ver_personas(Paquete[] paquetitos, Scanner sc){
        System.out.println("Ingrese el id del paquete que desea averiguar la persona");
        int id = sc.nextInt();
        for (int k = 0; k < paquetitos.length; k++) {
            if (paquetitos[k] != null) {
                if (paquetitos[k].getId() == id) {
                    System.out.println("Nombre: "+paquetitos[k].getPersona().getNombre());
                    System.out.println("Dni: "+paquetitos[k].getPersona().getDni());
                    System.out.println("Celular: "+paquetitos[k].getPersona().getCelular());
                }
            }
        }
    }
}
