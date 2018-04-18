package Model;

import Controller.*;

public class Pokemon extends BasePokemon implements IPokemon{
	
	private String[] names = new String[3];
	private String[] imageLinks = new String[3];
	private TrainPokemon train = new TrainPokemon();
	
	public Pokemon(String[] names, String[] imageLinks) {
		super(1, 0, 0);
		
		for(int i = 0; i < 3; i++) {
			this.names[i] = names[i];
			this.imageLinks[i] = imageLinks[i];
		}
	}

	public String getName() {
		return this.names[this.devStage - 1];
	}

	public int getDevStage() {
		return devStage;
	}

	public void incDevStage() {
		this.devStage++;
	}

	public int getLevel() {
		int level = this.level;
		this.level = this.train.calcLevel(experiencePoints);
		int result = this.train.checkEvolution(level, this.level, this.devStage);
		
		if(result == 1) {
			this.incDevStage();
		}
		
		return this.level;
	}

	public void incLevel() {
		this.level++;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public void addExperiencePoints(int experiencePoints) {
		this.experiencePoints += experiencePoints;
	}

	public String getImageLink() {
		return imageLinks[this.devStage - 1];
	}
}
