package genetic_algorithm;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Número de funciones de Prueba
		Vector<Integer> rowNames = new Vector<>();
		rowNames.add(8083);
		rowNames.add(4000);
		rowNames.add(3876);
		rowNames.add(34);
		
		// Id de la familia
		String idFamily = "PF02702";
		
		Population population = new Population(20, 10, 0.3, rowNames, idFamily);
		
		population.getBest();
		
	}

}
