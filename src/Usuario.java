public class Usuario {
    private String nombre;
    private String apellido;
    private String direccion;
    private String TipoDoc;
    private int Documento;
    private int fechaNAC;
    private String lugarNAC;
    private String Genero;
    private int Telefono;
    private String mail;

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoDoc() {
        return TipoDoc;
    }

    public int getDocumento() {
        return Documento;
    }

    public int getFechaNAC() {
        return fechaNAC;
    }

    public String getLugarNAC() {
        return lugarNAC;
    }

    public String getGenero() {
        return Genero;
    }

    public int getTelefono() {
        return Telefono;
    }

    public String getMail() {
        return mail;
    }

    //SETTERS entradas de datos


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Usuario( String TipoDoc, int Documento, int fechaNAC, String lugarNAC, String Genero){
        this.TipoDoc=TipoDoc;
        this.Documento=Documento;
        this.fechaNAC=fechaNAC;
        this.lugarNAC=lugarNAC;
        this.Genero=Genero;
    }

}
