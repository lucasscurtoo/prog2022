import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

// Atento a la indentacion, q vi algunos problemas.
public class Agenda {
  // no es neceasario contaminar la clase con variables que pueden ser locales.
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String regx = "^(.+)@(.+)$"; 
    Pattern pattern = Pattern.compile(regx);
    boolean quit = false;

    // tiene mas sentiodo hacerlo en la Agenda y no en Contacto.
    // El contacto es unico y no tiene q meterse con como administrar otros
    ArrayList <Contact> contacts = new ArrayList<Contact>();
    
    // debe ir afuera del loop
    System.out.println("Bienvenido a la agenda de Lucas v1");
    do { // divino
    
         System.out.println("¿Quieres [i]ngresar un nuevo contacto o [c]onsultar un contacto existente?");
         String option = input.nextLine().toLowerCase();
         switch (option) {
             case "i":
                  String nameInput, numberInput, email;

                  // Mejoor con un do while, ahorras varias lineas y se hace mas mantenible
                  do {
                     System.out.println("ingrese el nombre");
                     nameInput = input.nextLine();
                   } while (nameInput.isEmpty())
                    
                   do {
                    System.out.println("ingrese su numero");
                    numberInput =  input.nextLine();
                  } while (numberInput.isEmpty());
                  
                  // que te parece algo asi en vez...
                  do {
                    System.out.println("ingrese su mail (vacio opcional)");
                    email = input.nextLine();
                  } while (!email.isEmpty() && !mailIsValid(email)); // con mailIsValid con tu chequeo de mail 


                 if (contacts.size() >= 256) {
                    System.out.println("El contacto no puede ser creado, ya hay muchos en el sistema");
                  } else {
                      contacts.add(new Contact(nameInput, email, numberInput));
                  }

                 break;
         
             case "c":
                System.out.println("ingrese el nombre del contacto a consultar");
                String busqueda = input.nextLine();

                // si no tegusta aca podes delegarlo a una funcion en la clase Agenda.
                for (Contact contacto: contacts) {  
                  if (contacto.getNombre().equals(busqueda)) {
                      System.out.println("- Nombre: " + contacto.getNombre());
                      System.out.println("- Telefono: " + contacto.getTelefono());
                      System.out.println("- Email: " + contacto.getEmail());
                      
                  }else{
                      System.out.println("No se encontro el contacto");
                  }
                }
                break;
            // Ojo con la indentacion!
            case "q":
              quit = true;
              break;

             default: // divino
                System.out.println("comando no reconocido");
            
         }
        } while (!quit);
     }
}