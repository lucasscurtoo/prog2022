import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    private String nombre,telefono,email;
    private static ArrayList <Contact> contacts = new ArrayList<Contact>();

    public Contact(String nombre, String email, String telefono){
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static void SearchContact(String busqueda){
        for (Contact contacto: contacts) {  
            if (contacto.getNombre().equals(busqueda)) {
                System.out.println("- Nombre: " + contacto.getNombre());
                System.out.println("- Telefono: " + contacto.getTelefono());
                System.out.println("- Email: " + contacto.getEmail());
                
            }else{
                System.out.println("No se encontro el contacto");
            }
            }
        }
        public static void Register(String nombre,String email,String telefono) {
        
        if (contacts.size() >= 256) {
            System.out.println("El contacto no puede ser creado, ya hay muchos en el sistema");
        }else{
            contacts.add(new Contact(nombre, email,telefono));
        }
    }
        
}