
public class Octaedro extends Poliedro {

    //private double arista;


    public Octaedro(long id, String color, double arista) {
        super(id, color, arista);
    }

    public Octaedro(long id, double arista) {
        super(id, arista);
    }

    /*
        public Octaedro(long id, double arista) {
            super(id, arista);
        }
        */
/*
    public Octaedro(long id) {
        super(id);
    }
*/
    public double calcularVolumen(){

        return (Math.sqrt(2) / 3) * (Math.pow(arista, 3));
    }

    @Override
    public String toString() {
        return "Octaedro{" +
                "id=" + id +
                "arista=" + arista +
                '}';
    }
}
