package genetic_algorithm;
import java.util.Random;

public class Replacement {
	
	Random rnd = new Random();
	
	public Replacement() {

	}
	
	public Individual[] steadyState(Individual father_1, Individual father_2, Individual son_1, Individual son_2) {
		
		Individual[] winners = new Individual[2];
		

		if (father_1.getFitness() < father_2.getFitness()) {
			if (son_1.getFitness() < son_2.getFitness()) {
				winners[0] = this.roulette(father_2, son_2); // Best father - Best son
				winners[1] = this.roulette(father_1, son_1); // Worst father - Worst son
			}
			else {
				winners[0] = this.roulette(father_2, son_1); // Best father - Best son
				winners[1] = this.roulette(father_1, son_2); // Worst father - Worst son
			}
		}
		else {
			if (son_1.getFitness() < son_2.getFitness()) {
				winners[0] = this.roulette(father_1, son_2); // Best father - Best son
				winners[1] = this.roulette(father_2, son_1); // Worst father - Worst son				 
			}
			else {
				winners[0] = this.roulette(father_1, son_1); // Best father - Best son
				winners[1] = this.roulette(father_2, son_2); // Worst father - Worst son
			}
		}
		
		return winners;
		
	}
	
	private Individual roulette(Individual player_1, Individual player_2) {
		
		double totalFitness = player_1.getFitness() + player_2.getFitness();
				
		double point = player_1.getFitness() / totalFitness;
		
		return rnd.nextDouble() < point ? player_1 : player_2;		
	}
	
}
