import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Agenda {
  private static String nameInput, numberInput, email;
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String regx = "^(.+)@(.+)$"; 
    Pattern pattern = Pattern.compile(regx);
    boolean quit = false;
    
    do {
    
         System.out.println("Bienvenido a la agenda de Lucas v1");
         System.out.println("¿Quieres [i]ngresar un nuevo contacto o [c]onsultar un contacto existente?");
         String option = input.nextLine().toLowerCase();
         switch (option) {
             case "i":
                   System.out.println("ingrese el nombre");
                    nameInput = input.nextLine();
                   while (nameInput.isEmpty()) {
                     System.out.println("ingrese el nombre");
                     nameInput = input.nextLine();
                   }
                   System.out.println("ingrese su numero");
                     numberInput = input.nextLine();
                    
                   while (numberInput.isEmpty()) {
                    System.out.println("ingrese su numero");
                    numberInput =  input.nextLine();
                  }

                  System.out.println("ingrese su mail");
                  email = input.nextLine();
                 Matcher mather = pattern.matcher(email);
                 while (mather.find() != true) {
                  System.out.println("El email ingresado es inválido.");
                  System.out.println("ingreselo devuelta");
                  email = input.nextLine();
                  mather = pattern.matcher(email);
                 }  

                 Contact.Register(nameInput, email, numberInput);

                 break;
         
             case "c":
             System.out.println("ingrese el nombre del contacto a consultar");
             String busqueda = input.nextLine();
             Contact.SearchContact(busqueda);
                 break;
              case "q":
              quit = true;
              break;

             default:
                System.out.println("comando no reconocido");
            
         }
        } while (!quit);
     }
}