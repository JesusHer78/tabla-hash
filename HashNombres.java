import java.io.*;
import java.util.*;

public class HashNombres {

    private static final String BASE_PATH = "C:\\archivos\\";

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Archivo de entrada:");
            String input = br.readLine();

            System.out.println("Archivo de salida:");
            String output = br.readLine();

            List<String> datos = leer(BASE_PATH + input);

            HashSet<String> tabla = new HashSet<>(datos);

            List<String> lista = new ArrayList<>(tabla);

            Collections.sort(lista);

            guardar(BASE_PATH + output, lista);

            System.out.println("Archivo ordenado generado.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static List<String> leer(String ruta) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        List<String> list = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            for (String nombre : line.trim().split("\\s+"))
                list.add(nombre);  // ← Sin Integer.parseInt()
        }
        br.close();
        return list;
    }

    public static void guardar(String ruta, List<String> list) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (String nombre : list) 
            bw.write(nombre + "\n");
        bw.close();
    }
}