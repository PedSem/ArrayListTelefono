package TelefonoMovil;

public class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public static Contacto createContact(String nombre,String numerotelefono){
        return new Contacto(nombre,numerotelefono);
    }
}
