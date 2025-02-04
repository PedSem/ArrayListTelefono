package TelefonoMovil;

import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto>myContacts=new ArrayList<>();
    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        myContacts=new ArrayList<>();
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
             myContacts.add(contacto);
             return true;
        }else{
            System.out.println("El contacto ya existe");
            return false;
        }

    }
    public boolean updateContact(Contacto contactoantiguo,Contacto contactonuevo){
        int index=findContact(contactoantiguo);
        if(index>=0){
             myContacts.set(index,contactonuevo);
             return true;

        }else{
            return false;
        }
    }
    public boolean removeContact(Contacto contacto){
        int index=findContact(contacto);
        if(index>=0){
            myContacts.remove(index);
            return true;
        }else{
            return false;
        }
    }
    public int findContact(Contacto contacto){
        for(int i=0;i<myContacts.size();i++){
            if(myContacts.get(i).getName().equals(contacto.getName())){
                return i;
            }
        }
        return -1;

    }
    public int findContact(String nombre) {

        int index = myContacts.indexOf(nombre);
        if (index >= 0) {
            return index;
        } else {
            return -1;
        }
    }
    public Contacto queryContact(String nombre){
        int index=findContact(nombre);
        if(index>=0){
            return myContacts.get(index);
        }else{
            return null;
        }




    }
    public void printContacts(){
        System.out.println("Lista de contactos:");
        System.out.println("Tenemos " + myContacts.size() + " elementos en el arrayList");
        for(int i=0;i<myContacts.size();i++){
            System.out.print((i+1) + ". ");
            System.out.println(myContacts.get(i));
        }
    }
}
