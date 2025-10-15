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
                DeleteUser(usuarios);
                pause();
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
        System.out.println("Ingrese su fecha de nacimiento: ");
        String Fecha = entrada.nextLine();
        usuarios.add(Fecha);
        String genero = CheakGenero();
        usuarios.add(genero);

    }
    public static void ShowUser(ArrayList<String> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("\nNo hay usuarios registrados.\n");
            return;
        }

        System.out.println("\n======= LISTADO DE USUARIOS =======\n");

        for (int i = 0; i < usuarios.size(); i += 4) {
            System.out.println("Persona " + ((i / 4) + 1));
            System.out.println("  Nombre:  " + usuarios.get(i));
            System.out.println("  DNI:  " + usuarios.get(i + 1));
            System.out.println("  Fecha de nacimiento:  " + usuarios.get(i + 2));
            System.out.println("  Género:  " + usuarios.get(i + 3));
            System.out.println("-----------------------------------");
        }

        System.out.println("========= FIN DEL LISTADO =========\n");
    }
    public static void pause(){
        Scanner pausa = new Scanner(System.in);
        System.out.println("Presione ENTER para continuar...");
        pausa.nextLine();
    }
    public static void SearchUser(ArrayList<String> usuarios){
        ArrayList<String> wanted = new ArrayList<String>();
        Scanner entrada =  new Scanner(System.in);
        System.out.print("Ingrese el nombre de la persona: ");
        String busqueda = entrada.nextLine();

    }
    public static String CheakGenero(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el genero (M) and (F): ");
        String genero = entrada.nextLine();
        while(!genero.equalsIgnoreCase("F") && !genero.equalsIgnoreCase("M")){
            System.out.print("Genero incorrecto, ingrese M o F: ");
            genero = entrada.nextLine();
        }
        return genero;

    }
    public static void DeleteUser(ArrayList<String> usuarios){
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios para borrar.");
            return;
        }

        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el DNI del usuario a eliminar: ");
        String dniBuscado = entrada.nextLine();

        int index = usuarios.indexOf(dniBuscado);
        if (index == -1) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        int base = (index / 4) * 4;

        System.out.println("Eliminando al usuario:");
        System.out.println("Nombre: " + usuarios.get(base));
        System.out.println("DNI: " + usuarios.get(base + 1));

        System.out.print("¿Está seguro que desea borrar este usuario? (S/N): ");
        String confirm = entrada.nextLine();
        if (confirm.equalsIgnoreCase("S")) {
            // borrar las 4 posiciones (en orden inverso para que no se muevan los índices)
            for (int i = 3; i >= 0; i--) {
                usuarios.remove(base + i);
            }
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }
}
