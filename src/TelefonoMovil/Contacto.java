package TelefonoMovil;

import java.util.Comparator;
import java.util.Objects;

public class Contacto implements Comparable<Contacto> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(name, contacto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
    @Override
    public int compareTo(Contacto c1){
        return this.name.compareTo(c1.name);



    }

    @Override
    public String toString() {
        return "Contacto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
