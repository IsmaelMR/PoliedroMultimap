

public class Tetraedro extends Poliedro {

    //private double arista;

    public Tetraedro(long id, String color, double arista) {
        super(id, color, arista);
    }

    public Tetraedro(long id, double arista) {
        super(id, arista);
    }


/*
    public Tetraedro(long id, double arista) {
        super(id, arista);
    }
 */

    /*
    public Tetraedro(long id) {
        super(id);
    }
*/
    public double calcularVolumen() {

        return (Math.sqrt(2) / 12) * (Math.pow(arista, 3));

    }

    @Override
    public String toString() {
        return "Tetraedro{" +
                "id=" + id +
                "arista=" + arista +
                '}';
    }
}
