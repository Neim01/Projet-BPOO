package COR;

import testCandyCRUSH.CandyCrush;

public class Combinaison3BonbonsNonRayeVertical implements Combinaison {

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
			if(test.getGrille(i,y).equals(test.getGrille(i+1,y))){
				NbBonbons++;
			}
			else
				break;
		}
		for(int j = x; j>=1; j--){
			if(test.getGrille(j,y).equals(test.getGrille(j-1,y))){
				NbBonbons++;
			}
			else
				break;
		}
		if (NbBonbons == 3 && !test.getGrille(x,y).getCouleur().equals("Vide")){
			System.out.println(+NbBonbons+" bonbons "+test.quelleCouleur2(x, y));
			return ("3BNRV");
		}
		else
			return this.next.verification(test, x, y);
	}
}
