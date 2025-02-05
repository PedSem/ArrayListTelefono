package TelefonoMovil;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTelefonoMovil {
    private static TelefonoMovil telefonoMovil=new TelefonoMovil("123456789");

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean continuar=true;
        String nombre="";
        String numerotelefono="";
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
                    System.out.println("Has salido con exito");
                    continuar=false;
                    break;
                case 1:
                    telefonoMovil.printContacts();
                    break;
                case 2:
                        try{
                            System.out.print("Introduce tu nombre:");
                            nombre= scanner.nextLine();
                        }catch (NumberFormatException e){
                            System.out.println("Error.Solo se permiten caracteres");
                            scanner.nextLine();
                            continuar=false;
                        }
                        try{
                            System.out.print("Introduce tu numero de telefono:");
                            numerotelefono= scanner.nextLine();
                            while (numerotelefono.length()!=9){
                                System.out.println("Error.Introduce un numero valido");
                                continuar=true;
                                numerotelefono=scanner.nextLine();
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Solo se permiten numeros");
                            scanner.nextLine();
                        }
                        if(continuar){
                            Contacto contacto=Contacto.createContact(nombre,numerotelefono);
                            boolean resultado=telefonoMovil.addNewContact(contacto);
                            if(resultado){
                                System.out.println("Contacto añadido con éxito");
                            }else{
                                System.out.println("No se pudo añadir el contacto");
                            }
                        }
                    break;
                case 3:
                    System.out.print("Introduce el nombre");
                    nombre= scanner.next();
                    Contacto contactoviejo=telefonoMovil.queryContact(nombre);
                    if(contactoviejo!=null){
                        System.out.print("Introduce el nuevo nombre:");
                        String nuevonombre= scanner.next();
                        System.out.println("Introduce el nuevo numero de telefono");
                        String nuevonumerotelefono= scanner.next();
                        Contacto contactonuevo=Contacto.createContact(nuevonombre,nuevonumerotelefono);
                        boolean resultado= telefonoMovil.updateContact(contactoviejo,contactonuevo);
                        if(resultado){
                            System.out.println("El Contacto se ha modificado correctamente");
                        }else{
                            System.out.println("El contacto ya existe");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nombre");
                    nombre= scanner.next();
                    Contacto contacto=telefonoMovil.queryContact(nombre);
                    if(contacto!=null){
                        boolean resultadoremover=telefonoMovil.removeContact(contacto);
                        if(resultadoremover){
                            System.out.println("Se ha eliminado correctamente");
                        }else{
                            System.out.println("El contacto no existe");
                        }
                    }
                    break;
                case 5:
                    System.out.print("Introduce el nombre:");
                    nombre= scanner.next();
                    Contacto contactoencontrar=telefonoMovil.queryContact(nombre);
                    if(contactoencontrar!=null){
                        System.out.println(contactoencontrar.getName() + " -> " + contactoencontrar.getPhoneNumber());
                    }else{
                        System.out.println("No se encontro el contacto");
                    }
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

