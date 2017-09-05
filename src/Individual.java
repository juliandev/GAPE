
public class Individual {
	
	private double[][] transitionMatrix;
	private double[] alpha;
	private double[] sigma;
	private double fitness;
	
	public Individual(double[][] transitionMatrix, double[] alpha, double[] sigma, double fitness) {
		this.transitionMatrix = transitionMatrix;
		this.alpha = alpha;
		this.sigma = sigma;
		this.fitness = fitness;
	}
		
	public double[][] getTransitionMatrix() {
		return transitionMatrix;
	}



	public void setTransitionMatrix(double[][] transitionMatrix) {
		this.transitionMatrix = transitionMatrix;
	}

	public double[] getAlpha() {
		return alpha;
	}

	public void setAlpha(double[] alpha) {
		this.alpha = alpha;
	}

	public double[] getSigma() {
		return sigma;
	}

	public void setSigma(double[] sigma) {
		this.sigma = sigma;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public String getStringTransitionMatrix() {
		
		String matrix = "";
		
		for (int i = 0; i < transitionMatrix.length; i++) {
			
			for (int j = 0; j <transitionMatrix[i].length; j++) {
				
				matrix += transitionMatrix[i][j];
				
			}
			
			matrix += "\n";
			
		}
		
		return matrix;	
		
	}
	
	public String getStringAlphaMatrix() {
		
		String matrix = "";
		
		for (int i = 0; i < alpha.length; i++) {
			matrix += alpha[i] + " ";
		}
		
		return matrix;	
		
	}
	
	public String getStringPhiMatrix() {
		
		String matrix = "";
		
		for (int i = 0; i < sigma.length; i++) {
			matrix += sigma[i] + " ";
		}
		
		return matrix;	
		
	}
	
}