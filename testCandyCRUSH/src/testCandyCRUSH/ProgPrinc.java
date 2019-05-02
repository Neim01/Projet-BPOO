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
			test.quelleCouleur(3, 2);
			System.out.println(""+test.raye(3, 2));
			
			test.quelleCouleur(4, 2);
			System.out.println(""+test.raye(4, 2));
			
			test.quelleCouleur(3, 8);
			System.out.println(""+test.raye(3, 8));
			
			test.quelleCouleur(3, 0);
			System.out.println(""+test.raye(3, 0));
			
			//test.quelleCouleur(3, 10);
			//System.out.println(""+test.raye(3, 10));
			
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
			
			test.echanger(4, 4, 5, 4, test);
			test.quelleCouleur(3, 4);
			System.out.println(""+test.raye(3, 4));
			test.quelleCouleur(4, 4);
			test.quelleCouleur(5, 4);
			test.quelleCouleur(6, 4);
			
			test.echanger(4, 4, 3, 4, test);
			test.echanger(3, 7, 3, 8, test);
			test.echanger(2, 2, 3, 3, test);
			test.echanger(2, 2, 2, 4, test);
			
			System.out.println("");
			
			System.out.println("Traitement entier d'une combinaison");
			
			test.echanger(2, 7, 1, 7, test);
			C1.verification(test, 1, 7);
			C1.verification(test, 2, 7);
			
			test.MettreAjour(C1.verification(test, 2, 7), 2, 7);
			test.quelleCouleur(2, 4);
			test.quelleCouleur(2, 5);
			test.quelleCouleur(2, 6);
			test.quelleCouleur(2, 7);
			System.out.println(""+test.raye(2, 7));
			
			
			
		}catch(CandyException e){
			System.out.println(""+e);
		}
		
		/*
		
		String t1 = C1.verification(test, 3, 2);
		String t2 = C1.verification(test, 3, 4);
		String t3 = C1.verification(test, 2, 4);
		String t4 = C1.verification(test, 2, 7);
		String t5 = C1.verification(test, 6, 6);
		String t6 = C1.verification(test, 7, 6);
		String t7 = C1.verification(test, 5, 4);
		
		System.out.println("Tests des echanges");
		System.out.println("");
		
		test.MettreAjour("3BRV", 3, 2);
		try {
			test.quelleCouleur(4,2);
			test.quelleCouleur(2,2);
			test.quelleCouleur(9,2);
			System.out.println("");
			
		}catch(CandyException e) {
			e.printStackTrace();
		}
		
		
		
		test.MettreAjour("3BNRV", 3, 7);
		try {
			test.quelleCouleur(4,7);
			test.quelleCouleur(3,7);
			test.quelleCouleur(2,7);
			test.quelleCouleur(1,7);
			test.quelleCouleur(0,7);
			System.out.println("");
			
		}catch(CandyException e) {
			e.printStackTrace();
		}
		
		test.MettreAjour("4BNRV", 3, 6);
		try {
			test.quelleCouleur(6,6);
			boolean essai = test.raye(6, 6);
			System.out.println(""+essai);
			test.quelleCouleur(5,6);
			test.quelleCouleur(4,6);
			test.quelleCouleur(3,6);
			test.quelleCouleur(2,6);
			test.quelleCouleur(1,6);
			test.quelleCouleur(0,6);
			System.out.println("");
			
		}catch(CandyException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		test.chute();
		try{
			test.quelleCouleur(0, 0);
			test.quelleCouleur(0, 1);
			test.quelleCouleur(0, 2);
			test.quelleCouleur(0, 3);
			test.quelleCouleur(0, 4);
			test.quelleCouleur(0, 5);
			test.quelleCouleur(0, 6);
			test.quelleCouleur(0, 7);
			test.quelleCouleur(0, 8);
			test.quelleCouleur(0, 9);
			
			System.out.println("");

			test.quelleCouleur(1, 0);
			test.quelleCouleur(1, 1);
			test.quelleCouleur(1, 2);
			test.quelleCouleur(1, 3);
			test.quelleCouleur(1, 4);
			test.quelleCouleur(1, 5);
			test.quelleCouleur(1, 6);
			test.quelleCouleur(1, 7);
			test.quelleCouleur(1, 8);
			test.quelleCouleur(1, 9);
			
			System.out.println("");

			test.quelleCouleur(2, 0);
			test.quelleCouleur(2, 1);
			test.quelleCouleur(2, 2);
			test.quelleCouleur(2, 3);
			test.quelleCouleur(2, 4);
			test.quelleCouleur(2, 5);
			test.quelleCouleur(2, 6);
			test.quelleCouleur(2, 7);
			test.quelleCouleur(2, 8);
			test.quelleCouleur(2, 9);
			
			System.out.println("");

			test.quelleCouleur(3, 0);
			test.quelleCouleur(3, 1);
			test.quelleCouleur(3, 2);
			test.quelleCouleur(3, 3);
			test.quelleCouleur(3, 4);
			test.quelleCouleur(3, 5);
			test.quelleCouleur(3, 6);
			test.quelleCouleur(3, 7);
			test.quelleCouleur(3, 8);
			test.quelleCouleur(3, 9);
			
			System.out.println("");

			test.quelleCouleur(4, 0);
			test.quelleCouleur(4, 1);
			test.quelleCouleur(4, 2);
			test.quelleCouleur(4, 3);
			test.quelleCouleur(4, 4);
			test.quelleCouleur(4, 5);
			test.quelleCouleur(4, 6);
			test.quelleCouleur(4, 7);
			test.quelleCouleur(4, 8);
			test.quelleCouleur(4, 9);
			
			System.out.println("");

			test.quelleCouleur(5, 0);
			test.quelleCouleur(5, 1);
			test.quelleCouleur(5, 2);
			test.quelleCouleur(5, 3);
			test.quelleCouleur(5, 4);
			test.quelleCouleur(5, 5);
			test.quelleCouleur(5, 6);
			test.quelleCouleur(5, 7);
			test.quelleCouleur(5, 8);
			test.quelleCouleur(5, 9);
			
			System.out.println("");

			test.quelleCouleur(6, 0);
			test.quelleCouleur(6, 1);
			test.quelleCouleur(6, 2);
			test.quelleCouleur(6, 3);
			test.quelleCouleur(6, 4);
			test.quelleCouleur(6, 5);
			test.quelleCouleur(6, 6);
			test.quelleCouleur(6, 7);
			test.quelleCouleur(6, 8);
			test.quelleCouleur(6, 9);
			
			System.out.println("");
			
			test.quelleCouleur(7, 0);
			test.quelleCouleur(7, 1);
			test.quelleCouleur(7, 2);
			test.quelleCouleur(7, 3);
			test.quelleCouleur(7, 4);
			test.quelleCouleur(7, 5);
			test.quelleCouleur(7, 6);
			test.quelleCouleur(7, 7);
			test.quelleCouleur(7, 8);
			test.quelleCouleur(7, 9);

			System.out.println("");

			test.quelleCouleur(8, 0);
			test.quelleCouleur(8, 1);
			test.quelleCouleur(8, 2);
			test.quelleCouleur(8, 3);
			test.quelleCouleur(8, 4);
			test.quelleCouleur(8, 5);
			test.quelleCouleur(8, 6);
			test.quelleCouleur(8, 7);
			test.quelleCouleur(8, 8);
			test.quelleCouleur(8, 9);
			
			System.out.println("");

			test.quelleCouleur(9, 0);
			test.quelleCouleur(9, 1);
			test.quelleCouleur(9, 2);
			test.quelleCouleur(9, 3);
			test.quelleCouleur(9, 4);
			test.quelleCouleur(9, 5);
			test.quelleCouleur(9, 6);
			test.quelleCouleur(9, 7);
			test.quelleCouleur(9, 8);
			test.quelleCouleur(9, 9);

		}catch(CandyException e){
			e.printStackTrace();
		}
		

		/*
		C1.verification(test,4,2);
		C1.verification(test,3,3);
		C1.verification(test,2,4);
		C1.verification(test,2,7);
		C1.verification(test,6,6);
		C1.verification(test,7,6);
		C1.verification(test,5,4);
		
		
		
		try {
			test.creerGrilleTest();
			test.echanger(2,7,1,7);
			String inutile = C1.verification(test, 1, 7);
			String inutile2 = C1.verification(test, 2, 7);
			test.quelleCouleur(2, 4);
			test.quelleCouleur(2, 5);
			test.quelleCouleur(2, 6);
			test.quelleCouleur(2, 7);
			test.estRaye(2, 7);
		}catch(CandyException e) {
			e.printStackTrace();
		}
		
		*/
		
		/*
		try {
		test.quelleCouleur(2,6);
		test.quelleCouleur(2,7);

		}catch(CandyException e) {
			e.printStackTrace();
		}
		
		test.MettreAjour("3BNRH", 3, 3);
		try {
			
			test.quelleCouleur(2,4);
			test.quelleCouleur(2,5);
			
			test.quelleCouleur(3,4);
			test.quelleCouleur(3,5);
			
			test.quelleCouleur(4,4);
			test.quelleCouleur(4,5);



			
			
		}catch(CandyException e) {
			e.printStackTrace();
		}
		*/
		
	}

}