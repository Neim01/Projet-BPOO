package Bonbon;

import testCandyCRUSH.CandyException;

public class Bonbon {
	
	private String couleur;
	private boolean raye;
	
	public Bonbon(String couleur, boolean raye) {
		super();
		this.couleur = couleur;
		this.raye = raye;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public boolean isRaye() {
		return raye;
	}

	public void setRaye(boolean raye) {
		this.raye = raye;
	}

	@Override
	public String toString() {
		return "Bonbon [couleur=" + couleur + ", raye=" + raye + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bonbon other = (Bonbon) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (raye != other.raye)
			return false;
		return true;
	}
	
	public boolean estVide(){
		if(this.couleur.equals("Vide")){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	
}
