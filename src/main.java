import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion = -1;
        ArrayList<String> usuarios= new ArrayList<String>();
        while(opcion != 0){

            System.out.println("""
                    BIENVENIDO A TECHBAND POR FAVOR INGRESE LA OPPCION DE LA ACCION QUE DESEA RALIZAR
                    1- CREAR USUARIO
                    2- LISTAR
                    3- BUSCAR/MODIFICAR
                    4- BORRAR
                    0- SALIR
                    """);
             entrada = new Scanner(System.in);
             opcion = entrada.nextInt();

            if(opcion==1){
                CreateUser(usuarios);
                pause();
            }else if(opcion==2){
                System.out.println("--------------------------------LISTANDO------------------------------------------------");
                ShowUser(usuarios);
                pause();
            } else if (opcion==3) {
                System.out.println("Modificando");
            }else if (opcion==4){
                System.out.println("Borrando");
            } else if (opcion==0) {
                System.out.println("Saliendo...");
            }else{
                System.out.println("Opcion no valida");
            }

        }

    }

    public  static void CreateUser(ArrayList<String> usuarios){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre y apellido de la persona: ");
        String nyp = entrada.nextLine();
        usuarios.add(nyp);
        System.out.println("Ingrese el DNI de la persona: ");
        String Dni = entrada.nextLine();
        usuarios.add(Dni);

    }
    public static void ShowUser(ArrayList<String> usuarios){
        for(String user:usuarios){
            System.out.println(user);
        }
    }
    public static void pause(){
        Scanner pausa = new Scanner(System.in);
        System.out.println("Presione ENTER para continuar...");
        pausa.nextLine();
    }
    public  static void SearchUser(ArrayList<String> usuarios){
        ArrayList<String> wanted = new ArrayList<String>();
        Scanner entrada =  new Scanner(System.in);
        System.out.print("Ingrese el nombre de la persona: ");
        String busqueda = entrada.nextline();

    }
}
