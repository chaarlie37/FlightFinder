package sd.a2.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Vuelo{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String codigo;
    private Date salida;
    private Date llegada;   // hemos añadido tambien un atributo de llegada por sencillez a la hora de mostrar la hora de llegada
    private int duracion;  // en minutos
    private int precio;  // euros
    private String aerolinea; // codigo de la aerolinea
    @ManyToOne
    private Aeropuerto origen;  // nombre del aeropuerto
    @ManyToOne
    private Aeropuerto destino;  // nombre del aeropuerto

    public Vuelo(){}

    public Vuelo(String codigo, Date salida, int duracion, int precio, String aerolinea, Aeropuerto origen, Aeropuerto destino) {
        this.codigo = codigo;
        this.salida = salida;
        // Se usa la clase Calendar para calcular el Date llegada a partir de la duracion
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(salida);
        calendar.add(Calendar.MINUTE, duracion);
        this.llegada = calendar.getTime();
        this.duracion = duracion;
        this.precio = precio;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public Date getLlegada() {
        return llegada;
    }

    public void setLlegada(Date llegada) {
        this.llegada = llegada;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigo='" + codigo + '\'' +
                ", salida=" + salida +
                ", llegada=" + llegada +
                ", duracion=" + duracion +
                ", precio=" + precio +
                ", aerolinea='" + aerolinea + '\'' +
                ", origen=" + origen +
                ", destino=" + destino +
                '}';
    }
}
