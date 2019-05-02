package COR;

import testCandyCRUSH.CandyCrush;

public class Combinaison3BonbonsRayeHorizontal implements Combinaison {

	private Combinaison next;
	
	@Override
	public void setNextCombinaison(Combinaison nextCombinaison) {
		
		this.next = nextCombinaison;
	}

	@Override
	public String verification(CandyCrush test, int x, int y) {
		//test.creerGrilleTest();
		int NbBonbons=1;
		for(int i = y; i<=8; i++){
			if(test.quelleCouleur2(x, i).equals(test.quelleCouleur2(x, i+1)) || test.raye(x, i)) {
				NbBonbons++;
			}
			else
				break;
		}
		for(int j = y; j>=1; j--){
			if(test.quelleCouleur2(x, j).equals(test.quelleCouleur2(x, j-1)) || test.raye(x, j)) {
				NbBonbons++;
			}
			else
				break;
		}
		if (NbBonbons==3 && !test.getGrille(x,y).getCouleur().equals("Vide")){
			System.out.println(+NbBonbons+" bonbons "+test.quelleCouleur2(x, y)+" dont un rayé");
			return ("3BRH");
		}
		else
			return this.next.verification(test, x, y);
	}
}
