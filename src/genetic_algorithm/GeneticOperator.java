package genetic_algorithm;
import java.util.Random;
import java.util.Vector;

public class GeneticOperator {
	
	public GeneticOperator() {
	
	}
	
	public Vector<double[][]> mutationTransitionMatrix(double[][] parent_1, double[][] parent_2) {
		
		Random rnd = new Random();
		
		Vector<double[][]> sons = new Vector<>();
		
		double[][] firstSon = parent_1.clone();
		double[][] secondSon = parent_2.clone();
				
		// The first child is produced
		
		int x = rnd.nextInt(parent_1.length); // fila seleccionada
		int y = rnd.nextInt(parent_1.length); // posicion de la fila a cambiar
				
		double random = rnd.nextDouble(); // número aleatorio
		
		while (random > firstSon[x][y]) {
			random = rnd.nextDouble();
		}
				
		firstSon[x][y] -= random;
		
		double difference = random / (parent_1.length - 1);
				
		for (int j = 0; j < firstSon.length; j++) {
			
			if (j != y) {
				
				firstSon[x][j] += difference; 
						
			}
			
		}
		
	
		// The second child is produced
		
		x = rnd.nextInt(parent_2.length);
		y = rnd.nextInt(parent_2.length);
				
		random = rnd.nextDouble();
		
		while (random > secondSon[x][y]) {
			random = rnd.nextDouble();
		}
				
		secondSon[x][y] -= random;
		
		difference = random / (parent_2.length - 1);
				
		for (int j = 0; j < secondSon.length; j++) {
			
			if (j != y) {
				
				secondSon[x][j] += difference; 
						
			}
			
		}
		
		sons.add( firstSon );
		sons.add( secondSon );
				
		return sons;
	}
	

	public Vector<double[][]> mutationAlpha(double[] parent_1, double[] parent_2) {
		
		Random rnd = new Random();
		
		double[][] sons = new double[parent_1.length][parent_1.length];
		
		Vector<double[][]> childs = new Vector<>();
		
		sons[0] = parent_1.clone();
		sons[1] = parent_2.clone();
		
		int random_1 = rnd.nextInt(parent_1.length);
		int random_2 = rnd.nextInt(parent_2.length);
		double temp = 0;
		

		while(random_1 == random_2){
			random_2 = rnd.nextInt(parent_2.length);
		}
		
		temp = sons[0][random_1];
		sons[0][random_1] = sons[0][random_2];
		sons[0][random_2] = temp;
		
		temp = sons[1][random_1];
		sons[1][random_1] = sons[1][random_2];
		sons[1][random_2] = temp;
		
		childs.add(sons);
		
		return childs;
		
	}
	
	public Vector<double[][]> mutationSigma(double[] parent_1, double[] parent_2) { // TODO
				
		Random rnd = new Random();
		
		Vector<double[][]> childs = new Vector<>();
				
		double[][] sons = new double[parent_1.length][parent_1.length];
		
		sons[0] = parent_1.clone();
		sons[1] = parent_2.clone();
				
		int random_1 = rnd.nextInt(2); // posicion
						
		sons[0][random_1] = rnd.nextDouble();
								
		random_1 = rnd.nextInt(2);
		
		sons[1][random_1] = rnd.nextDouble();
		
		childs.add(sons);
		
		return childs;
	}
	
	public Vector<double[][]> crossoverTransitionMatrix(double[][] parent_1, double[][] parent_2) {
		
		Random rnd = new Random();
		
		Vector<double[][]> sons = new Vector<>();
		
		double[][] firstSon = parent_1.clone();
		double[][] secondSon = parent_2.clone();
		
		int point = rnd.nextInt(parent_1.length); // fila seleccionada
		
		double[] temp = firstSon[point];
		
		firstSon[point] = secondSon[point];
		
		secondSon[point] = temp;
		
		sons.addElement( firstSon );
		sons.addElement( secondSon );
		
		return sons;
		
	}
	
	public Vector<double[][]> crossoverAlpha(double[] parent_1, double[] parent_2) {
		
		Random rnd = new Random();
		
		Vector<double[][]> childs = new Vector<>();
		
		double[][] sons = new double[parent_1.length][parent_1.length];
		
		sons[0] = parent_1.clone();
		sons[1] = parent_2.clone();
		
		int point = rnd.nextInt(parent_1.length); // segmento seleccionado
		
		double temp = 0;
		
		for (int i = 0; i < point; i++) {
			temp = sons[0][i];
			sons[0][i] = sons[1][i];
			sons[1][i] = temp;
		}
		
		childs.add(sons);
			
		return childs;
		
	}
	
	public Vector<double[][]> crossoverSigma(double[] parent_1, double[] parent_2) { // TODO
		
		Random rnd = new Random();
		
		Vector<double[][]> childs = new Vector<>();
		
		double[][] sons = new double[parent_1.length][parent_1.length];
		
		sons[0] = parent_1.clone();
		sons[1] = parent_2.clone();
		
		int point = rnd.nextInt(parent_1.length); // posicion del evento
		
		double temp = sons[0][point];
		sons[0][point] = sons[1][point];
		sons[1][point] = temp;
		
		if (sons[0][0] > sons[0][1]) {
			
			temp = sons[0][0];
			sons[0][0] = sons[0][1];
			sons[0][1] = temp;
			
		}
		
		if (sons[1][0] > sons[1][1]) {
			
			temp = sons[1][0];
			sons[1][0] = sons[1][1];
			sons[1][1] = temp;
			
		}
		
		childs.add(sons);
					
		return childs;
		
	}

	public static void main(String[] args) {
		double[] sigma = {0.03, 0.05};
		double[] sima = {0.7, 0.8};
		
		GeneticOperator geneticOperator = new GeneticOperator();
		
		geneticOperator.crossoverSigma(sigma, sima);
	}
	
	
}
