package Model;

public interface IPokemon {
	public String getName();
	public int getDevStage();
	public void incDevStage();
	public int getLevel();
	public void incLevel();
	public int getExperiencePoints();
	public void addExperiencePoints(int args);
	public String getImageLink();

}
