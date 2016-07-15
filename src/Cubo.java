
public class Cubo extends Poliedro {

    //private double arista;


    public Cubo(long id, String color, double arista) {
        super(id, color, arista);
    }

    public Cubo(long id, double arista) {
        super(id, arista);
    }

    /*
        public Cubo(long id, double arista) {
            super(id, arista);
        }
        */
/*
    public Cubo(long id) {
        super(id);
    }
*/
    public double calcularVolumen(){

        return Math.pow(arista, 3);
    }

    public double calcularDiagonal(){

        return Math.sqrt(3) * arista;
    }

    @Override
    public String toString() {
        return "Cubo{" +
                "id=" + id +
                "arista=" + arista +
                '}';
    }
}
