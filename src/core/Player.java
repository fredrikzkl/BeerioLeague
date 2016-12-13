package core;

public class Player {
	
	private String name;
	private double rating;
	
	public Player(String name){
		this.name = name;
		rating = 2000;//Standard rating
	}
	
	public String toString(){
		return "" + getName();
	}
	
	public Player(String name, double currentRating){
		this.name = name;
		rating = currentRating;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}
	
	
	
}
