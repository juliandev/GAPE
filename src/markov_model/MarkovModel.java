package markov_model;

public class MarkovModel {
	
	public static double[][] createTransitionMatrix(int numStates) {
		double [][] transitionMatrix = new double[numStates][numStates];
		double [] sumRowTransitionMatrix = new double[numStates];
		
		double sum = 0; 
		
		for (int i = 0; i < numStates; i++) {
			for (int j = 0; j < numStates; j++) {
				transitionMatrix[i][j] = Math.random();
				sum += transitionMatrix[i][j];
			}
			sumRowTransitionMatrix[i] = sum;
			sum = 0;
		}
		
		for (int i = 0; i < numStates; i++) {
			for (int j = 0; j < numStates; j++) {
				transitionMatrix[i][j] = transitionMatrix[i][j] / sumRowTransitionMatrix[i];
			}
		}
		
		return transitionMatrix;
	}
	
	public static double[] createAlpha(int numStates) {
		double [] alpha = new double[numStates];
		
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = Math.random();
		}
		
		return alpha;
	}

	public static double[] createSigma() {
		double [] phi = new double[2];
		
		double random_1 = Math.random();
		double random_2 = Math.random();
		
		while (random_2 <= random_1) {
			random_2 = Math.random();
		}
				
		phi[0] = random_1;
		phi[1] = random_2;
		
		return phi;
	}
	
}
