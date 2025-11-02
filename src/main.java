import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion = -1;
        ArrayList<Usuario> userslist = new ArrayList<>();
        SeedUsers(userslist);
        while(opcion != 0){

            System.out.println("""
                    BIENVENIDO A TECHBAND POR FAVOR INGRESE LA OPPCION DE LA ACCION QUE DESEA RALIZAR
                    1- CREAR USUARIO
                    2- LISTAR
                    3- MODIFICAR
                    4- BORRAR
                    5- BUSCAR
                    0- SALIR
                    """);
             opcion = entrada.nextInt();

            if(opcion==1){
                CreateUser(userslist);
                pause();
            }else if(opcion==2){
                ShowUser(userslist);
                pause();
            } else if (opcion==3) {
                UpdateUser(userslist);
                pause();
            }/*else if (opcion==4){
                DeleteUser(usuarios);
                pause();
            }*/ else if(opcion==5){
                SearchUser(userslist);
                pause();
            } else if (opcion==0) {
                System.out.println("Saliendo...");
            }else{
                System.out.println("Opcion no valida");
            }

        }

    }

    public  static void CreateUser(ArrayList<Usuario> userlist){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el Tipo de documento: ");
        String tipodoc = entrada.nextLine();
        System.out.println("Ingrese el Documento: ");
        int documento = entrada.nextInt();
        System.out.println("Fecha de nacimiento (DD/MM/AA): ");
        int fechanac=entrada.nextInt();
        entrada.nextLine();//esto por lo que averigue me limpia el buffer algo parecido a C con el gets()
        System.out.println("Ingrese el pais de nacimiento: ");
        String lugar= entrada.nextLine();
        String genero =  CheakGenero();
        Usuario u = new Usuario(tipodoc,documento,fechanac,lugar,genero);
        System.out.println("Ingrese el Nombre: ");
        u.setNombre(entrada.nextLine());
        System.out.println("Ingrese el Apellido: ");
        u.setApellido(entrada.nextLine());
        System.out.println("Ingrese el Direccion: ");
        u.setDireccion(entrada.nextLine());
        System.out.println("Ingrese el Telefono: ");
        u.setTelefono(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Ingrese un Email");
        u.setMail(entrada.nextLine());
        userlist.add(u);
    }

    public static void ShowUser(ArrayList<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("\nNo hay usuarios registrados.\n");
            return;
        }

        System.out.println("\n======= LISTADO DE USUARIOS ========\n");

        for (Usuario u:usuarios) {
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Apellido: " + u.getApellido());
            System.out.println("Dirección: " + u.getDireccion());
            System.out.println("Tipo Doc: " + u.getTipoDoc());
            System.out.println("DNI: " + u.getDocumento());
            System.out.println("Fecha Nac: " + u.getFechaNAC());
            System.out.println("Lugar Nac: " + u.getLugarNAC());
            System.out.println("Género: " + u.getGenero());
            System.out.println("Teléfono: " + u.getTelefono());
            System.out.println("Mail: " + u.getMail());
            System.out.println("===================================\n");
        }

        System.out.println("========= FIN DEL LISTADO =========\n");
    }
    public static void pause(){
        Scanner pausa = new Scanner(System.in);
        System.out.println("Presione ENTER para continuar...");
        pausa.nextLine();
    }
    public static void SearchUser(ArrayList<Usuario> usuarios){
        Scanner entrada = new Scanner(System.in);
        boolean encontrado= false;
        System.out.println("Ingrese el DNI/DOCUMENTO de la persona: ");
        int busqueda = entrada.nextInt();
        for (Usuario u:usuarios) {
            if(u.getDocumento()==busqueda) {
                System.out.println("Usuario encontrado:" + u.getDocumento());
                System.out.println("Nombre actual: " + u.getNombre());
                System.out.println("Apellido actual: " + u.getApellido());
                System.out.println("Dirección actual: " + u.getDireccion());
                System.out.println("Teléfono actual: " + u.getTelefono());
                System.out.println("Email actual: " + u.getMail());
                System.out.println("-----------------------------");
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Lo siento el usuario no existe");
        }

    }
    public static String CheakGenero(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el genero (M) and (F): ");
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
            for (int i = 3; i >= 0; i--) {
                usuarios.remove(base + i);
            }
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }
    public static void UpdateUser(ArrayList<Usuario> usuarios) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el DNI del usuario: ");
        int busqueda = entrada.nextInt();
        for (Usuario u:usuarios) {
            if(u.getDocumento()==busqueda) {
                System.out.println("Usuario encontrado:" + u.getDocumento());
                System.out.println("Nombre actual: " + u.getNombre());
                System.out.println("Apellido actual: " + u.getApellido());
                System.out.println("Dirección actual: " + u.getDireccion());
                System.out.println("Teléfono actual: " + u.getTelefono());
                System.out.println("Email actual: " + u.getMail());
                System.out.println("-----------------------------");
            }
        }

            /*switch (opcion) {
                case 1:
                    System.out.print("Nuevo Nombre y Apellido: ");
                    String nuevoNombre = entrada.nextLine();
                    usuarios.set(inicio, nuevoNombre);
                    break;

                case 2:
                    System.out.print("Nuevo DNI: ");
                    String nuevoDni = entrada.nextLine();
                    usuarios.set(inicio + 1, nuevoDni);
                    break;

                case 3:
                    System.out.print("Nueva Fecha de Nacimiento: ");
                    String nuevaFecha = entrada.nextLine();
                    usuarios.set(inicio + 2, nuevaFecha);
                    break;

                case 4:
                    System.out.print("Nuevo Género: ");
                    String nuevoGenero = entrada.nextLine();
                    usuarios.set(inicio + 3, nuevoGenero);
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println("✅ Datos actualizados correctamente.");*/

    }
    public static void SeedUsers(ArrayList<Usuario> usuarios) {
        // Crear 5 usuarios de ejemplo
        Usuario u1 = new Usuario("DNI", 12345678, 20010101, "Argentina", "M");
        u1.setNombre("Juan");
        u1.setApellido("Pérez");
        u1.setDireccion("Calle Falsa 123");
        u1.setTelefono(111111111);
        u1.setMail("juan.perez@example.com");

        Usuario u2 = new Usuario("DNI", 87654321, 19981212, "Argentina", "F");
        u2.setNombre("María");
        u2.setApellido("García");
        u2.setDireccion("Av. Siempreviva 742");
        u2.setTelefono(222222222);
        u2.setMail("maria.garcia@example.com");

        Usuario u3 = new Usuario("DNI", 11223344, 19950623, "Chile", "M");
        u3.setNombre("Carlos");
        u3.setApellido("López");
        u3.setDireccion("San Martín 45");
        u3.setTelefono(333333333);
        u3.setMail("carlos.lopez@example.com");

        Usuario u4 = new Usuario("DNI", 55667788, 20030914, "Uruguay", "M");
        u4.setNombre("Lucía");
        u4.setApellido("Rodríguez");
        u4.setDireccion("Belgrano 90");
        u4.setTelefono(444444444);
        u4.setMail("lucia.rodriguez@example.com");

        Usuario u5 = new Usuario("DNI", 99887766, 19991231, "Paraguay", "M");
        u5.setNombre("Diego");
        u5.setApellido("Fernández");
        u5.setDireccion("Rivadavia 250");
        u5.setTelefono(555555555);
        u5.setMail("diego.fernandez@example.com");

        // Agregarlos a la lista
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);
        usuarios.add(u5);
    }


}
