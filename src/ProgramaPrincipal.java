import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.*;

public class ProgramaPrincipal {

    public static final String TETRAEDROS = "Tetraedros"; // Este string es la "clave" mediante la cual se permite acceder al tipo de poliedro
    public static final String OCTAEDROS = "Octaedros";
    public static final String CUBOS = "Cubos"; // "final" significa que su valor no se puede cambiar

    //private static Map<String,List<? extends Poliedro>> mapPoliedros = new HashMap<>(); // El HashMap permite estructurar los datos introducidos un arrayList para cada tipo de poliedro
    //static ListMultimap<String, Poliedro> tipoMultimap = ArrayListMultimap.create();
    static ListMultimap<String, Poliedro> colorMultimap = ArrayListMultimap.create();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Poliedro> arrayList = new ArrayList<>(); // Creamos un array de tamaño dinamico
        int numFiguras = 2; // establece el numero de figuras entradas de cada tipo


        // Bucles de entrada de datos
        //-----------------------------
        obtenerTetraedro(sc, arrayList, numFiguras);


        obtenerCubo(sc, arrayList, numFiguras);


        obtenerOctaedro(sc, arrayList, numFiguras);


        // Bucle final para recorrer el arrayList y hacer los calculos
        //--------------------------------------------------------------
        procesarPoliedros(arrayList, numFiguras);

        //mostrarMapPoliedros();

        //colorMultimap.get(CUBOS);

        //consultarMapPoliedros(CUBOS);

        for ( String key : colorMultimap.keySet() ) {
            System.out.println( key );
        }

    }
/*
    private static void consultarMapPoliedros(String tipoPoliedro) {

        //List<Cubo> cuboList = (List<Cubo>) mapPoliedros.get(CUBOS);
        List<Poliedro> poliedroList = (List<Poliedro>) colorMultimap.get(tipoPoliedro);

        System.out.println("La lista de cubos es: ");
        //System.out.println(cuboList);
        System.out.println(poliedroList);
        //System.out.println(mapPoliedros.get(CUBOS)); // Cast
    }
*/
    private static void mostrarMapPoliedros() {
        System.out.println("Map de poliedros: ");
        //System.out.println(tipoMultimap);
        System.out.println(colorMultimap);
    }

    private static void procesarPoliedros(List<Poliedro> arrayList, int numFiguras) {
        //Poliedro maxArea = null; // Por defecto no esta apuntando a ninguna figura geometrica
        Poliedro maxVolumen = null;
        Poliedro minVolumen = null;

        //double totalArea = 0.0; // utilizaremos esta variable para sumar todas las areas y calcular la media
        double totalVolumen = 0.0;
        int menos20 = 0;
        int entre20y100 = 0;
        int mas100 = 0;
        String obtenerColor = " ";
        int figuraAzul = 0;
        int figuraAmarillo = 0;
        int figuraRojo = 0;
        int figuraVerde = 0;


        for (Poliedro poliedro : arrayList) { // Recorremos el arrayList

            double volumenActual = poliedro.calcularVolumen();
            double volumen = poliedro.calcularVolumen();

            totalVolumen = totalVolumen + volumenActual; // sumamos todas las areas del bucle

            //System.out.println("El area de la figura geometrica " + poliedro.getId() + " es: " + area);
            System.out.println("El volumen del poliedro " + poliedro.getId() + " es: " + volumen);


            if (poliedro instanceof Cubo) { // Si es una Circumferencia

                Cubo cubo = (Cubo) poliedro; // Cast que permite tratar la figura_geometrica como una circumferencia

                double diagonal = cubo.calcularDiagonal();

                System.out.println("La diagonal del cubo es " + poliedro.getId() + "  es: " + diagonal);

            }


            if (maxVolumen == null) { // si la variable max no apunta a ninguna figura geometrica...

                maxVolumen = poliedro; // ... la variable "max" cogerá el valor de la posicion actual del arrayList

            } else {


                if (volumenActual > maxVolumen.calcularVolumen()){

                    maxVolumen = poliedro;

                }

            }

            if (minVolumen == null) {

                minVolumen = poliedro;

            } else {

                if (volumenActual < minVolumen.calcularVolumen()) {

                    minVolumen = poliedro;

                }
            }

            if (volumen < 20) {

                menos20++;

            } else if (volumen > 100) {

                mas100++;

            } else {

                entre20y100++;

            }


            String color = poliedro.getColor(); // Con getColor() obtenemos el color devuelto por el método solicitarColor()

            switch (color) { // sitch para controlar la cantidad de figuras de cada color

                case "azul":

                    figuraAzul++;
                    break;

                case "amarillo":

                    figuraAmarillo++;
                    break;

                case "rojo":

                    figuraRojo++;
                    break;

                case "verde":

                    figuraVerde++;
                    break;

                default:

                    break;
            }

        }


        int totalFiguras = numFiguras * 3; // Se divide la suma de todas las Areas entre el numero de figuras entradas
        double mediaVolumen = totalVolumen / totalFiguras; // Se divide la suma de todas las Areas entre el numero de figuras entradas
        //System.out.println("El area media encontrada es: " + mediaArea);
        //System.out.println("El area maxima encontrada es: " + maxArea);

        System.out.println("El volumen maximo encontrado es: " + maxVolumen);
        System.out.println("El volumen minimo encontrado es: " + minVolumen);

        System.out.println("La cantidad de poliedros con volumen menos que 20 es: " + menos20);
        System.out.println("La cantidad de poliedros con volumen entre 20 y 100: " + entre20y100);
        System.out.println("La cantidad de poliedros con volumen mayor que 100 es: " + mas100);

        System.out.println("La cantidad de figuras de color azul es: " + figuraAzul);
        System.out.println("La cantidad de figuras de color blanco es: " + figuraAmarillo);
        System.out.println("La cantidad de figuras de color rojo es: " + figuraRojo);
        System.out.println("La cantidad de figuras de color verde es: " + figuraVerde);

        // System.out.println("El volumen minimo encontrado es: " + minVolumen);
    }

    private static void obtenerTetraedro(Scanner sc, List<Poliedro> arrayList, int numFiguras) {

        //List<Tetraedro> tetraedroList = new ArrayList<>();

        for (int i = 0 ; i < numFiguras ; i++){

            System.out.println("Introduce la arista del tetraedro " + i + " : ");
            double arista = sc.nextDouble();

            String color = solicitarColor(); // Invocamos el metodo "solicitarColor" y guardamos en una variable la cadena que devuelve
            System.out.println("El color seleccionado es: " + color);

            Tetraedro tetraedro = new Tetraedro(i, color, arista);
            arrayList.add(tetraedro);
            //tetraedroList.add(tetraedro);
            colorMultimap.put(color,tetraedro);

        }

        //colorMultimap.put(TETRAEDROS,tetraedroList);
    }

    private static void obtenerOctaedro(Scanner sc, List<Poliedro> arrayList, int numFiguras) {

        //List<Octaedro> octaedroList = new ArrayList<>();

        for (int i = 0 ; i < numFiguras ; i++) {

            System.out.println("Introduce la arista del octaedro " + i + " : ");
            double arista = sc.nextDouble();

            String color = solicitarColor(); // Invocamos el metodo "solicitarColor" y guardamos en una variable la cadena que devuelve
            System.out.println("El color seleccionado es: " + color);

            Octaedro octaedro = new Octaedro(i + (numFiguras * 2), color, arista);
            arrayList.add(octaedro);
            //octaedroList.add(octaedro);
            colorMultimap.put(color,octaedro);

        }

        //colorMultimap.put(OCTAEDROS,octaedroList);
    }

    private static void obtenerCubo(Scanner sc, List<Poliedro> arrayList, int numFiguras) {

        //List<Cubo> cuboList = new ArrayList<>();

        for (int i = 0 ; i < numFiguras ; i++){

            System.out.println("Introduce la arista del cubo " + i + " : ");
            double arista = sc.nextDouble();

            String color = solicitarColor(); // Invocamos el metodo "solicitarColor" y guardamos en una variable la cadena que devuelve
            System.out.println("El color seleccionado es: " + color);

            Cubo cubo = new Cubo(i+ numFiguras, color, arista);
            arrayList.add(cubo); // Añade el cubo al ArrayList general que almacena todos los poliedros
            //cuboList.add(cubo); // Añade el cubo al ArrayList especifico "cuboList"
            // No obstante, el cubo es almacenado una sola vez en memoria, pero es apuntado desde los dos arrays
            colorMultimap.put(color,cubo);

        }

        //colorMultimap.put(CUBOS,cuboList);
    }

    private static String solicitarColor() { // Este método se situa fuera del método "void main"
        // crear con el scanner una petición
        // el usuario debera introducir el numero entero de 1 a 5
        // por lo tanto se mostrará un menu del estilo de :
        //1.azul 2.blanco 3.rojo 4.verde 5.naranja
        //si selecciona el cuatro, se debera devolver 4.verde

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el color de poliedro: ");
        System.out.println("1. Azul / 2. Amarillo / 3. Rojo / 4. Verde: ");
        int numeroColor = sc.nextInt();
        String colorSeleccionado = " ";

        switch (numeroColor) {

            case 1:
                //return "azul";
                colorSeleccionado = "azul";
                break;

            case 2:
                //return "blanco";
                colorSeleccionado = "amarillo";
                break;

            case 3:
                //return "rojo";
                colorSeleccionado = "rojo";
                break;

            case 4:
                //return "verde";
                colorSeleccionado = "verde";
                break;

            default:
                //return " ";
                colorSeleccionado = " ";
                break;

        }

        return colorSeleccionado;

    }

}


