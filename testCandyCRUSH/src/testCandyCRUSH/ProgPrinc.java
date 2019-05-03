package testCandyCRUSH;

import COR.Combinaison;
import COR.Combinaison3BonbonsNonRayeHorizonta;
import COR.Combinaison3BonbonsNonRayeVertical;
import COR.Combinaison3BonbonsRayeHorizontal;
import COR.Combinaison3BonbonsRayeVertical;
import COR.Combinaison4BonbonsNonRayeHorizonta;
import COR.Combinaison4BonbonsNonRayeVertical;

public class ProgPrinc {
	
	static CandyCrush test = new CandyCrush();
	
	public static void main(String[] args) {
		
		//initialisation des combinaisons dans la chaine de responsabilité
		Combinaison C1 = new Combinaison3BonbonsNonRayeHorizonta();
		Combinaison C2 = new Combinaison4BonbonsNonRayeHorizonta();
		Combinaison C3 = new Combinaison3BonbonsNonRayeVertical();
		Combinaison C4 = new Combinaison4BonbonsNonRayeVertical();
		Combinaison C5 = new Combinaison3BonbonsRayeHorizontal();
		Combinaison C6 = new Combinaison3BonbonsRayeVertical();
		
		
		C1.setNextCombinaison(C2);
		C2.setNextCombinaison(C3);
		C3.setNextCombinaison(C4);
		C4.setNextCombinaison(C5);
		C5.setNextCombinaison(C6);

		//initialisation de la grille
		test.creerGrilleTest();
		
		System.out.println("Tests des consultations de base sur la grille");
		
		try{
			try{
				test.quelleCouleur(3, 2);
				System.out.println(""+test.raye(3, 2));
				
				test.quelleCouleur(4, 2);
				System.out.println(""+test.raye(4, 2));
				
				test.quelleCouleur(3, 8);
				System.out.println(""+test.raye(3, 8));
				
				test.quelleCouleur(3, 0);
				System.out.println(""+test.raye(3, 0));
				
				test.quelleCouleur(3, 10);
				System.out.println(""+test.raye(3, 10));
			}catch(CandyException e){
				System.out.println(""+e);
			}
			
			System.out.println("");
			
			System.out.println("Tests de la détection des combinaisons");
			
			C1.verification(test, 3, 2);
			C1.verification(test, 3, 3);
			C1.verification(test, 2, 4);
			C1.verification(test, 2, 7);
			C1.verification(test, 6, 6);
			C1.verification(test, 7, 6);
			C1.verification(test, 5, 4);
			
			System.out.println("");
			
			System.out.println("Tests des échanges");
			
			try{
				test.echanger(4, 4, 5, 4, test);
			}catch(CandyException e){
				System.out.println(""+e);
			}
			test.quelleCouleur(3, 4);
			System.out.println(""+test.raye(3, 4));
			test.quelleCouleur(4, 4);
			test.quelleCouleur(5, 4);
			test.quelleCouleur(6, 4);
			
			try{
				try{
					try{
						try{
							test.echanger(4, 4, 3, 4, test);
						}catch(CandyException e4){
							System.out.println(""+e4);
						}
						test.echanger(3, 7, 3, 8, test);
					}catch(CandyException e3){
						System.out.println(""+e3);
					}
					test.echanger(2, 2, 3, 3, test);
				}catch(CandyException e2){
					System.out.println(""+e2);
				}
				test.echanger(2, 2, 2, 4, test);
			}catch(CandyException e){
				System.out.println(""+e);
			}
			//test.echanger(3, 7, 3, 8, test);
			//test.echanger(2, 2, 3, 3, test);
			//test.echanger(2, 2, 2, 4, test);
			
			System.out.println("");
			
			System.out.println("Traitement entier d'une combinaison");
			
			try{
				test.echanger(2, 7, 1, 7, test);
			}catch(CandyException e){
				System.out.println(""+e);
			}
			//C1.verification(test, 1, 7);
			//C1.verification(test, 2, 7);
			
			test.MettreAjour(C1.verification(test, 2, 7), 2, 7);
			test.quelleCouleur(2, 4);
			test.quelleCouleur(2, 5);
			test.quelleCouleur(2, 6);
			test.quelleCouleur(2, 7);
			System.out.println(""+test.raye(2, 7));
			
			
			
		}catch(CandyException e){
			System.out.println(""+e);
		}
		
		
		
	}

}