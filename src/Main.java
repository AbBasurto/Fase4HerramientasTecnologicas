import java.util.*;

class Usuario {
    private static int contadorUsuarios = 0;
    private String nombre;
    private String apellido;
    private String id;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = generarIDUnico();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId() {
        return id;
    }

    private String generarIDUnico() {
        contadorUsuarios++;
        String formatoID = String.format("A%04d", contadorUsuarios);
        return formatoID;
    }
}

class Expediente {
    private Usuario usuario;
    private List<String> documentosEntregados;
    private String folio;

    public Expediente(Usuario usuario, List<String> documentosEntregados) {
        this.usuario = usuario;
        this.documentosEntregados = documentosEntregados;
        this.folio = generarFolioUnico();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<String> getDocumentosEntregados() {
        return documentosEntregados;
    }

    public String getFolio() {
        return folio;
    }

    private String generarFolioUnico() {
        return UUID.randomUUID().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese su apellido:");
        String apellidoUsuario = scanner.nextLine();

        Usuario usuario = new Usuario(nombreUsuario, apellidoUsuario);

        System.out.println("Ingrese la cantidad de documentos que entregara:");
        int cantidadDocumentos = scanner.nextInt();
        scanner.nextLine();

        List<String> documentos = new ArrayList<>();
        for (int i = 1; i <= cantidadDocumentos; i++) {
            System.out.println("Ingrese el nombre del documento " + i + ":");
            String nombreDocumento = scanner.nextLine();
            documentos.add(nombreDocumento);
        }

        Expediente expedienteUsuario = new Expediente(usuario, documentos);
        System.out.println("\nMatricula del Alumno: " + expedienteUsuario.getUsuario().getId());
        System.out.println("Nombre del alumno: " + expedienteUsuario.getUsuario().getNombre() + " " + expedienteUsuario.getUsuario().getApellido());
        System.out.println("Documentos entregados: " + expedienteUsuario.getDocumentosEntregados());
        System.out.println("Folio: " + expedienteUsuario.getFolio());

        scanner.close();
    }
}
