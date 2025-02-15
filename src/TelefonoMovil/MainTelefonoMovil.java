package TelefonoMovil;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTelefonoMovil {
    private static Scanner scanner=new Scanner(System.in);
    private static TelefonoMovil telefonoMovil=new TelefonoMovil("123456789");

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean continuar=true;
        int opcion=0;
        boolean entradavalida;
        do{
            imprimirmenu();
            do{
                 entradavalida=false;
                try{
                    System.out.print("Escoge una opcion:");
                    opcion= scanner.nextInt();
                    scanner.nextLine();
                    entradavalida=true;
                    if(opcion<0 || opcion>12){
                        entradavalida=false;
                        System.out.println("Introduce una opcion valida");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Error.Debes introducir numeros");
                    scanner.nextLine();
                }
            }while (!entradavalida);

            switch (opcion){
                case 0:
                    System.out.println("Has salido con exito");
                    continuar=false;
                    break;
                case 1:
                    telefonoMovil.printContacts();
                    break;
                case 2:
                    AnyadirConacto();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removecontact();
                    break;
                case 5:
                    EncontrarContacto();
                    break;
                case 6:
                    imprimirmenu();
                    break;
                case 7:
                    EncontrarContactoTelefono();
                    break;
                case 8:
                    telefonoMovil.OrdenarNombre();
                    break;
                case 9:
                    telefonoMovil.Eliminartodo();
                    break;
                case 10:
                    telefonoMovil.numerocontactos();
                    break;
                case 11:
                    EncontrarClave();
                    break;
            }

        }while (continuar);
    }
    public static void imprimirmenu(){
        System.out.println("0-Salir");
        System.out.println("1-Imprimir Contactos");
        System.out.println("2-Agregar Nuevo Contacto");
        System.out.println("3- Actualizar contacto");
        System.out.println("4- Eliminar contacto");
        System.out.println("5- Encontrar nombre del contacto");
        System.out.println("6- Imprimir menu");
        System.out.println("7-Encontrar numero de telefono del contacto");
        System.out.println("8-Ordenar Nombre");
        System.out.println("9-Eliminar todos los contactos");
        System.out.println("10-Contar contactos");
        System.out.println("11-Buscar por clave");
    }
    public static void AnyadirConacto(){
        String nombre="";
        String numerotelefono="";
        boolean continuar=false;
        do{
            try{
                System.out.print("Introduce el nombre que quieres añadir:");
                nombre= scanner.next();
                boolean esvalido=true;
                for(int i=0;i<nombre.length();i++){
                    if(!Character.isLetter(nombre.charAt(i))){
                        esvalido=false;
                    }
                }
                if(esvalido){
                    continuar=true;
                }else{
                    System.out.println("Error.Solo se permiten caracteres");
                }
            }catch (NumberFormatException e){
                System.out.println("Error.Solo se permiten caracteres");
            }
        }while (!continuar);

        continuar=false;
        do{
            try{
                System.out.print("Introduce el numero de telefono que quieres añadir:");
                numerotelefono= String.valueOf(scanner.nextInt());
                if (numerotelefono.length()==9){
                    continuar=true;
                }else{
                    System.out.println("Error.Introduce una longitud de 9 numeros");
                }
            }catch (InputMismatchException e){
                System.out.println("Solo se permiten numeros");
                scanner.nextLine();
            }
        }while (!continuar);
        Contacto contacto=Contacto.createContact(nombre,numerotelefono);
        boolean resultado=telefonoMovil.addNewContact(contacto);
        if(resultado){
            System.out.println("Contacto añadido con éxito");
        }else{
            System.out.println("No se pudo añadir el contacto");
        }

    }
    public static void updateContact(){
        String nombre="";
        String nuevonombre="";
        String nuevonumerotelefono="";
        boolean continuar=false;
        do{
            try{
                System.out.print("Introduce el nombre que deseas actualizar:");
                nombre= scanner.next();
                boolean esvalido=true;
                for(int i=0;i<nombre.length();i++){
                    if(!Character.isLetter(nombre.charAt(i))){
                        esvalido=false;
                    }
                }
                if(esvalido){
                    continuar=true;
                }else{
                    System.out.println("Error.Solo se permiten caracteres");
                }
            }catch (NumberFormatException e){
                System.out.println("Error.Solo se permiten caracteres");
            }
        }while (!continuar);
        Contacto contactoviejo=telefonoMovil.queryContact(nombre);
        if(contactoviejo!=null){
            continuar=false;
            do{
                try{
                    System.out.print("Introduce el nuevo nombre:");
                    nuevonombre= scanner.next();
                    boolean esvalido=true;
                    for(int i=0;i<nuevonombre.length();i++){
                        if(!Character.isLetter(nuevonombre.charAt(i))){
                            esvalido=false;
                        }
                    }
                    if(esvalido){
                        continuar=true;
                    }else{
                        System.out.println("Error.Solo se permiten caracteres");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Error.Solo se permiten caracteres");
                }
            }while (!continuar);
            continuar=false;
            do{
                try{
                    System.out.print("Introduce el nuevo numero de telefono:");
                    nuevonumerotelefono= String.valueOf(scanner.nextInt());
                    if (nuevonumerotelefono.length()==9){
                        continuar=true;
                    }else{
                        System.out.println("Error.Introduce un numero valido");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Solo se permiten numeros");
                    scanner.nextLine();
                }
            }while (!continuar);
            Contacto contactonuevo=Contacto.createContact(nuevonombre,nuevonumerotelefono);
            boolean resultadonuevo= telefonoMovil.updateContact(contactoviejo,contactonuevo);
            if(resultadonuevo){
                System.out.println("El Contacto se ha modificado correctamente");
            }else{
                System.out.println("El contacto ya existe");

            }
        }else{
            System.out.println("No se encontro el contacto");
        }

    }
    public static void removecontact(){
        String nombre="";
        boolean continuar=false;
        do{
            try{
                System.out.print("Introduce el nombre del contacto que quieres eliminar:");
                nombre= scanner.next();
                boolean esvalido=true;
                for(int i=0;i<nombre.length();i++){
                    if(!Character.isLetter(nombre.charAt(i))){
                        esvalido=false;
                    }
                }
                if(esvalido){
                    continuar=true;
                }else{
                    System.out.println("Error.Solo se permiten caracteres");
                }
            }catch (NumberFormatException e){
                System.out.println("Error.Solo se permiten caracteres");
            }
        }while (!continuar);
        Contacto removercontacto=telefonoMovil.queryContact(nombre);
        if(removercontacto!=null){
            boolean resultadoremover=telefonoMovil.removeContact(removercontacto);
            if(resultadoremover){
                System.out.println("Se ha eliminado correctamente");
            }else{
                System.out.println("El contacto no existe");
            }
        }else{
            System.out.println("El contacto no existe");
        }

    }
    public static void EncontrarContacto(){
        String nombre="";
        boolean continuar=false;
        do{
            try{
                System.out.print("Introduce el nombre del contacto que deseas buscar:");
                nombre= scanner.next();
                boolean esvalido=true;
                for(int i=0;i<nombre.length();i++){
                    if(!Character.isLetter(nombre.charAt(i))){
                        esvalido=false;
                    }
                }
                if(esvalido){
                    continuar=true;
                }else{
                    System.out.println("Error.Solo se permiten caracteres");
                }
            }catch (NumberFormatException e){
                System.out.println("Error.Solo se permiten caracteres");
            }
        }while (!continuar);
        Contacto contactoencontrar=telefonoMovil.queryContact(nombre);
        if(contactoencontrar!=null){
            System.out.println("Contacto encontrado " + contactoencontrar.getName() + " -> " + contactoencontrar.getPhoneNumber());
        }else{
            System.out.println("No se encontro el contacto");
        }

    }
    public static void EncontrarContactoTelefono(){
        String numerotelefono="";
        boolean continuar=false;
        do{
            try{
                System.out.print("Introduce el nuevo numero de telefono:");
                numerotelefono= String.valueOf(scanner.nextInt());
                if (numerotelefono.length()==9){
                    continuar=true;
                }else{
                    System.out.println("Error.Introduce un numero valido");
                }
            }catch (InputMismatchException e){
                System.out.println("Solo se permiten numeros");
                scanner.nextLine();
            }
        }while (!continuar);
        Contacto contactoencontrar=telefonoMovil.queryContactTelefono(numerotelefono);
        if(contactoencontrar!=null){
            System.out.println("Contacto encontrado " + contactoencontrar.getName() + " -> " + contactoencontrar.getPhoneNumber());
        }else{
            System.out.println("No se encontro el contacto");
        }
    }
    public static void EncontrarClave(){
        boolean continuar=false;
        String clave="";
        do{
            try{
                System.out.println("Introduce la clave que quieres obtener");
                clave= scanner.next();
                boolean esvalido=true;
                for(int i=0;i<clave.length();i++){
                    if(!Character.isLetter(clave.charAt(i))){
                        esvalido=false;
                    }
                }
                if(esvalido){
                    continuar=true;
                }else{
                    System.out.println("Error.Solo se permiten caracteres");
                }

            }catch (NumberFormatException e){
                System.out.println("Error.Pon solo caracteres");
            }
        }while (!continuar);
        Contacto clavecontacto=telefonoMovil.queryContact(clave);
        if(clavecontacto!=null){
            System.out.println("Telefono encontrado -> "  + clavecontacto.getPhoneNumber());
        }else{
            System.out.println("No se encontro el contacto");
        }

    }
}

