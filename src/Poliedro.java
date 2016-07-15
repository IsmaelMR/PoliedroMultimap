
public abstract class Poliedro {

    protected long id; // identificador de cada figura geometrica
    private String color; // atributo
    protected double arista;

    public Poliedro(long id, String color, double arista) {
        this.id = id;
        this.color = color;
        this.arista = arista;
    }

    public Poliedro(long id, double arista) {
        this.id = id;
        this.color = "blue";
        this.arista = arista;
    }

    public long getId() {
        return id; // permite mostrar la figura geometrica por su identificador
    }

    public String getColor() {
        return color;
    }

    public abstract double calcularVolumen();

}
