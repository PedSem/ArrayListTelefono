package TelefonoMovil;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTelefonoMovil {
    private static TelefonoMovil telefonoMovil=new TelefonoMovil("123456789");

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean continuar=true;
        int opcion=0;
        do{
            imprimirmenu();
            try{
                System.out.print("Escoge una opcion:");
                opcion= scanner.nextInt();
                scanner.nextLine();
                if(opcion<0 || opcion>7){
                    System.out.println("Introduce una opcion valida");
                    continuar=false;
                }
            }catch (InputMismatchException e){
                System.out.println("Error.Debes introducir numeros");
                scanner.nextLine();
            }
            switch (opcion){
                case 0:
                    System.out.println("Hasta luego");
                    continuar=false;
                    break;
                case 1:
                    telefonoMovil.printContacts();
                    break;
                case 2:
                    String nombre="";
                    String numerotelefono="";
                    try{
                        System.out.print("Introduce tu nombre:");
                         nombre= scanner.next();
                    }catch (NumberFormatException e){
                        System.out.println("Error.Solo se permiten caracteres");
                        scanner.nextLine();
                        continuar=false;
                    }
                    try{
                        System.out.print("Introduce tu numero de telefono:");
                        numerotelefono= scanner.next();
                    }catch (InputMismatchException e){
                        System.out.println("Solo se permiten numeros");
                        scanner.nextLine();
                        continuar=false;
                    }
                    Contacto contacto=new Contacto(nombre,numerotelefono);
                    telefonoMovil.addNewContact(contacto);
                    System.out.println("Introducido con éxito");
                    break;
                case 6:
                    imprimirmenu();
                    break;
            }

        }while ((opcion<0 || opcion>7) || continuar);
    }
    public static void imprimirmenu(){
        System.out.println("0-Salir");
        System.out.println("1-Imprimir Contactos");
        System.out.println("2-Agregar Nuevo Contacto");
        System.out.println("3- Actualizar contacto");
        System.out.println("4- Eliminar contacto");
        System.out.println("5- Encontrar nombre del contacto");
        System.out.println("6- Imprimir menu ");
    }
    //7.Buscar por telefono
    //8.Ordenar por nombre
    //9.Borrar todo


}

