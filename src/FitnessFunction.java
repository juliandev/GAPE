
public class FitnessFunction {
	
	public FitnessFunction() {
	
	}
	
	public double fitness( double[][] transitionMatrix, double[] alphaArray, double[] phiArray ) {
			
		double fitness = 0;
		double alphaM = alphaArray( alphaArray );
		double phiM = phiArray( phiArray );
		double transitionM = transitionMatrix( transitionMatrix );
			
		fitness = transitionM + alphaM + phiM;
		
		return fitness;
		
	}
	
	private double transitionMatrix( double[][] transitionMatrix ) {
		
		double sum = 0;
		
		int j = 1;
		
		for (int i = 1; i < transitionMatrix.length; i++) {
			sum += Math.log( transitionMatrix[i-1][j] );
			j++;
		}
		
		sum += Math.log( transitionMatrix[0][0] );
		
		return sum;
	}
	
	private double alphaArray( double[] alphaArray ) {
		
		double sum = 0;
		
		for (int i = 0; i < alphaArray.length; i++) {
			sum += Math.log(alphaArray[i]);
		}
		
		return sum;
	}
	
	private double phiArray( double[] phiArray ) {
		
		return phiArray[1] - phiArray[0];
		
	} 
	
}
