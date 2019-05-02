package COR;

import testCandyCRUSH.CandyCrush;

public class Combinaison3BonbonsNonRayeHorizonta implements Combinaison {

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
			if((test.getGrille(x,i).equals(test.getGrille(x, i+1)))){
				NbBonbons++;
			}
			else
				break;
		}
		for(int j = y; j>=1; j--){
			if((test.getGrille(x,j).equals(test.getGrille(x, j-1)))){
				NbBonbons++;
			}
			else
				break;
		}
		if (NbBonbons==3 && !test.getGrille(x,y).getCouleur().equals("Vide")){
			System.out.println(+NbBonbons+" bonbons "+test.quelleCouleur2(x, y));
			return ("3BNRH");
		}
		else
			return this.next.verification(test, x, y);
		
		
		/*if(test.getGrille(x,y) == test.getGrille(x, y+1) && test.getGrille(x, y+2) == test.getGrille(x,y) && (test.getGrille(x, y) !=0)){
			System.out.println("3 bonbons "+test.quelleCouleur2(x, y));
		}
		else
			this.next.verification(test, x, y);
		*/
		
		

		
	}
}