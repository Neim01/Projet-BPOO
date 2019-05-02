package COR;

import testCandyCRUSH.CandyCrush;

public interface Combinaison {
	
	public abstract void setNextCombinaison(Combinaison nextCombinaison);
	
	public abstract String verification(CandyCrush test, int x, int y);

	
}
