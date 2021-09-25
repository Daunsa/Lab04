
package lab4;

public class Paquete {
    private int id;
    private String fecha_res;
    private String fecha_ent;
    private double peso;
    private String direccion;
    private double costo;
    private boolean estado = false;
    private Persona_paquete persona;

    public Paquete(int id, String fecha_res, double peso, String direccion, double costo, String persona_nombre, String persona_dni, String persona_numero) {
        this.id = id;
        this.fecha_res = fecha_res;
        this.peso = peso;
        this.direccion = direccion;
        this.costo = costo;
        this.persona = new Persona_paquete(persona_dni, persona_nombre, persona_numero);
    }

    public void setFecha_ent(String fecha_ent) {
        this.fecha_ent = fecha_ent;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getFecha_res() {
        return fecha_res;
    }

    public String getFecha_ent() {
        return fecha_ent;
    }

    public double getPeso() {
        return peso;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getCosto() {
        return costo;
    }

    public Persona_paquete getPersona() {
        return persona;
    }

    public boolean isEstado() {
        return estado;
    }
        
}
