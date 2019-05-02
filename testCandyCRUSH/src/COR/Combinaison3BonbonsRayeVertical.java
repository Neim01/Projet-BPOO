package COR;

import testCandyCRUSH.CandyCrush;

public class Combinaison3BonbonsRayeVertical implements Combinaison {
	
	private Combinaison next;
	
	@Override
	public void setNextCombinaison(Combinaison nextCombinaison) {
		
		this.next = nextCombinaison;
	}

	@Override
	public String verification(CandyCrush test, int x, int y) {
		//test.creerGrilleTest();
		int NbBonbons=1;
		for(int i = x; i<=8; i++){
			//if((test.getGrille(i,y) == test.getGrille(i+1,y)) || (test.getGrille(i,y) == test.getGrille(i+1,y)+4)){
			if(test.quelleCouleur2(i, y).equals(test.quelleCouleur2(i+1, y)) || test.raye(y,i)) {
				NbBonbons++;
			}
			else
				break;
		}
		for(int j = x; j>=1; j--){
			//if((test.getGrille(j,y) == test.getGrille(j-1,y)) || (test.getGrille(j,y) == test.getGrille(j-1,y)+4)){
			if(test.quelleCouleur2(j, y).equals(test.quelleCouleur2(j-1, y)) || test.raye(j,y)) {
				NbBonbons++;
			}
			else
				break;
		}
		if (NbBonbons==3 && !test.getGrille(x,y).getCouleur().equals("Vide")){
			System.out.println(+NbBonbons+" bonbons "+test.quelleCouleur2(x, y)+" dont un rayé");
			return ("3BRV");
		}
		else {
			System.out.println("aucune combinaison");
			return "Aucune";
		}
		
	}
}
