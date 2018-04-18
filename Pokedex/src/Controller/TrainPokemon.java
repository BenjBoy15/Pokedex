package Controller;

import Model.*;

public class TrainPokemon {

	void trainPokemon(int index) {
		Pokemon pokemon = PokeList.getByIndex(index);
		
		// Generate random XP Points
		int experiencePoints = (int)(Math.random() * Rules.getTrainedXPRange() + Rules.getTrainedXPStart());
		
		pokemon.addExperiencePoints(experiencePoints);
	}
	
	
	public int calcLevel(int xpPoints) {
		if(Rules.getFirstLevelXP() * Rules.getLevelMultiplicator() > xpPoints) {
			return 0;
		}
		
		for(int i = 1; true; i++) {
			double effectiveMultiplicator = Math.pow(Rules.getLevelMultiplicator(), i);			
			if(Rules.getFirstLevelXP() * effectiveMultiplicator <= xpPoints && xpPoints < Rules.getFirstLevelXP() * effectiveMultiplicator * Rules.getLevelMultiplicator()) {
				return i;
			}			
		}
	}
	
	public int checkEvolution(int oldLevel, int newLevel, int EvolutionLevel) {
		int nextEvoLevel = Rules.getNextEvolveLevel(EvolutionLevel);
		
		if(oldLevel < nextEvoLevel && newLevel >= nextEvoLevel) {
			return 1;
		}
		
		return 0;
	}
}
