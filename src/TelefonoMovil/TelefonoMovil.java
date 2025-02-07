package TelefonoMovil;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto>myContacts=new ArrayList<>();
    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts=new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }

    public boolean addNewContact(Contacto contacto){
        int index=findContact(contacto);
        if(index==-1){
            this.myContacts.add(contacto);
            return true;
        }else{
            return false;
        }

    }
    public boolean updateContact(Contacto contactoantiguo,Contacto contactonuevo){
        int index=findContact(contactoantiguo);
        if(index==-1){
            return false;
        }else{
            this.myContacts.set(index,contactonuevo);
            return true;
        }



    }
    public boolean removeContact(Contacto contacto){
        int index=findContact(contacto);
        if(index==-1){
            return false;
        }else{
            this.myContacts.remove(index);
            return true;
        }
    }
    private int findContact(Contacto contacto){
        int index=this.myContacts.indexOf(contacto);
        return index;

    }
    private int findContact(String nombre) {
        for(int i=0;i<this.myContacts.size();i++){
            if(this.myContacts.get(i).getName().equals(nombre)){
                return i;
            }
        }
        return -1;
    }
    public Contacto queryContact(String nombre){
        int index=findContact(nombre);
        if(index>=0){
            return this.myContacts.get(index);
        }else{
            return null;
        }





    }
    private int findContactTelefono(String numerotelefono){
        for(int i=0;i<this.myContacts.size();i++){
            if(this.myContacts.get(i).getPhoneNumber().equals(numerotelefono)){
                return i;
            }
        }
        return -1;


    }
    public Contacto queryContactTelefono(String numerotelefono){
        int index=findContactTelefono(numerotelefono);
        if(index>=0){
            return this.myContacts.get(index);

        }else{
            return null;
        }

    }
    public void printContacts(){
        System.out.println("Lista de contactos:");
        System.out.println("Tenemos " + myContacts.size() + " elementos en el arrayList");
        for(int i=0;i<myContacts.size();i++){
            System.out.print((i+1) + ". ");
            System.out.println(myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
    public  void OrdenarNombre(){
        Collections.sort(myContacts);
        System.out.println("Nombres Ordenados");
        for(Contacto contacto:myContacts){
            System.out.println(contacto.getName());
        }
    }
    public void Eliminartodo(){
        myContacts.clear();
        System.out.println("Eliminado con éxito");
    }
    public void numerocontactos(){
        int contarcontactos=0;
        for(int i=0;i<myContacts.size();i++){
            while (contarcontactos<myContacts.size()){
                contarcontactos++;
            }

        }
        System.out.println("Hay " + contarcontactos + " contactos");
    }
    public void Encontrarclave(){
        Scanner scanner=new Scanner(System.in);
        boolean continuar=false;
        do{
            try{
                System.out.println("Introduce la clave que quieres obtener");
                String clave= scanner.nextLine().toLowerCase();
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
                for(Contacto contacto:myContacts){
                    if(contacto.getName().equalsIgnoreCase(clave)){
                        System.out.println(contacto);
                        continuar=true;
                    }
                    if(!continuar){
                        System.out.println("Introduce una clave valida");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Error.Pon solo caracteres");
            }
        }while (!continuar);


    }
}
