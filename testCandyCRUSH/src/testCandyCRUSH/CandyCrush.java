package testCandyCRUSH;
/*
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
*/

import Bonbon.Bonbon;
import COR.Combinaison;
import COR.Combinaison3BonbonsNonRayeHorizonta;
import COR.Combinaison3BonbonsNonRayeVertical;
import COR.Combinaison3BonbonsRayeHorizontal;
import COR.Combinaison3BonbonsRayeVertical;
import COR.Combinaison4BonbonsNonRayeHorizonta;
import COR.Combinaison4BonbonsNonRayeVertical;

public class CandyCrush{

	/*
	 * Tableau 2D d'entiers. Chaque entier correspond à l'indice d'une image (0-->Candy_0, 1-->Candy_1,...)
	 * Faudra faire mieux évidemment dans le projet...
	 */
	private	Bonbon[][] grille = new Bonbon[10][10];
	
	public Bonbon getGrille(int x, int y) {
		return grille[x][y];
	}


	public void creerGrilleTest() {
		/**
		 * Pour cette démo, on initialise une simple grille "en dur" pour faire des tests.
		 * D'abord on la remplit de vide, puis on place quelques combinaisons
		 */
		int Vide = 0; 
		for (int l=0; l<10; l++) {
			for (int c=0; c<10; c++) {
				grille[l][c] = new Bonbon("Vide",false);
			}
		}
		
		
		/**
		 * On ajoute 3 bonbons bleus alignés horizontalement et commençant en (2,4)
		 */
		int Bleu = 1;
		grille[2][4] = new Bonbon("Bleu",false);
		grille[2][5] = new Bonbon("Bleu",false);
		grille[2][6] = new Bonbon("Bleu",false);
		
		/**
		 * On ajoute 3 bonbons violets alignés verticalement et commençant en (2,7)
		 */
		int Violet = 2;
		grille[2][7] = new Bonbon("Violet",false);
		grille[3][7] = new Bonbon("Violet",false);
		grille[4][7] = new Bonbon("Violet",false);
		
		/**
		 * On ajoute 3 bonbons jaunes alignés horizontalement et commençant en (3,3). Le bonbon du milieu est rayé
		 */
		int Jaune = 3;
		grille[3][3] = new Bonbon("Jaune",false);
		grille[3][4] = new Bonbon("Jaune",true);
		grille[3][5] = new Bonbon("Jaune",false);
		
		
		/**
		 * On ajoute 3 bonbons verts alignés verticalement et commençant en (2,2). Le bonbon du bas est rayé
		 */
		int Vert = 4;
		grille[2][2] = new Bonbon("Vert",false);
		grille[3][2] = new Bonbon("Vert",false);
		grille[4][2] = new Bonbon("Vert",true);

		/**
		 * On ajoute 4 bonbons verts alignés verticalement et commençant en (3,6). Le bonbon du bas est rayé
		 */
		grille[3][6] = new Bonbon("Vert",false);
		grille[4][6] = new Bonbon("Vert",false);
		grille[5][6] = new Bonbon("Vert",false);
		grille[6][6] = new Bonbon("Vert",true);
		
		/**
		 * On ajoute 4 bonbons jaunes alignés horizontalement et commençant en (7,4). Le bonbon du bas est rayé
		 */
		grille[7][4] = new Bonbon("Jaune",false);
		grille[7][5] = new Bonbon("Jaune",false);
		grille[7][6] = new Bonbon("Jaune",false);
		grille[7][7] = new Bonbon("Jaune",false);

		/**
		 * On ajoute 9 bonbons au milieu de la grille pour lesquels il n'y a pas de combinaisons
		 * Mais si l'on échange (4,4) et (5,4) alors une combinaison de 3 verts apparaît
		 */
		grille[4][3] = new Bonbon("Jaune",false);
		grille[4][4] = new Bonbon("Vert",false);
		grille[4][5] = new Bonbon("Violet",false);
		grille[5][3] = new Bonbon("Bleu",false);
		grille[5][4] = new Bonbon("Bleu",false);
		grille[5][5] = new Bonbon("Vert",false);		
		grille[6][3] = new Bonbon("Bleu",false);
		grille[6][4] = new Bonbon("Jaune",false);
		grille[6][5] = new Bonbon("Violet",false);
		
		/**
		 * On place une meringue en (3,8)
		 */
		int Meringue = 9;
		grille[3][8] = new Bonbon("Meringue",false);
		
		/**
		 * Si l'on échange ces deux cases, une combinaison de 4 vilets apparaît, donc bonbon rayé
		 */
		grille[1][8] = new Bonbon("Violet",false);
		grille[1][7] = new Bonbon("Bleu",false);
		
		
		
		/** 
		 * Pour afficher la liste des images
		 */
		grille[9][0] = new Bonbon("Vide",false);
		grille[9][1] = new Bonbon("Bleu",false);
		grille[9][2] = new Bonbon("Violet",false);
		grille[9][3] = new Bonbon("Jaune",false);
		grille[9][4] = new Bonbon("Vert",false);
		grille[9][5] = new Bonbon("Bleu",true);
		grille[9][6] = new Bonbon("Violet",true);
		grille[9][7] = new Bonbon("Jaune",true);
		grille[9][8] = new Bonbon("Vert",true);
		grille[9][9] = new Bonbon("Meringue",false);
	}
	
	
	public void quelleCouleur(int x,int y)throws CandyException{
		if(x>9 || x<0)
			throw new CandyException("CandyException");
		if(y>9 || y<0)
			throw new CandyException("CandyException");
		if(grille[x][y].getCouleur().equals("Bleu"))
			System.out.println("Bleue");
		if(grille[x][y].getCouleur().equals("Vide"))
			System.out.println("Vide");
		if(grille[x][y].getCouleur().equals("Violet"))
			System.out.println("Violet");
		if(grille[x][y].getCouleur().equals("Jaune"))
			System.out.println("Jaune");
		if(grille[x][y].getCouleur().equals("Vert"))
			System.out.println("Vert");
		if(grille[x][y].getCouleur().equals("Meringue"))
			System.out.println("Meringue");
	}
	
	public String quelleCouleur2(int x,int y){
		if(x>9 || x<0)
			throw new IllegalArgumentException("CandyException");
		if(y>9 || y<0)
			throw new IllegalArgumentException("CandyException");
		if(grille[x][y].getCouleur().equals("Bleu"))
			return "Bleue";
		if(grille[x][y].getCouleur().equals("Vide"))
			return "Vide";
		if(grille[x][y].getCouleur().equals("Violet"))
			return "Violet";
		if(grille[x][y].getCouleur().equals("Jaune"))
			return "Jaune";
		if(grille[x][y].getCouleur().equals("Vert"))
			return "Vert";
		return "Meringue";
	}
	
	
	public boolean raye(int x ,int y){
		if(x>9 || x<0)
			throw new IllegalArgumentException("En dehors de la grille");
		if(y>9 || y<0)
			throw new IllegalArgumentException("En dehors de la grille");
		if(grille[x][y].isRaye())
			return true;
		else
			return false;
	}
	
	
public void echanger(int x, int y, int x2, int y2,CandyCrush test)throws CandyException{
		
		Bonbon temp = new Bonbon("Vide",false);
		
		
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
		
		//On v�rifie que les coordonn�es sont bien dans la grille 
		if(x>9 || x<0 || x2>9 || x2<0)
			throw new CandyException("Coordon�es en dehors de la grille");
		if(y>9 || y<0 || y2>9 || y2<0)
			throw new CandyException("Coordon�es en dehors de la grille");
		
		//On verifie qu'on �change deux cases accessibles entre elles
		if(((x2 != x+1 && x2 != x-1) && (y2 != y-1 && y2 != y+1)) || (x == y && x2 == y2))
			throw new CandyException("Case inaccessible");
		
		//On verifie qu'aucune des deux cases n'est une meringue
		if(test.grille[x][y].getCouleur().equals("Meringue") || test.grille[x2][y2].getCouleur().equals("Meringue"))
			throw new CandyException("Meringue");
		
		
		temp = test.grille[x2][y2];
		grille[x2][y2] =grille[x][y];
		grille[x][y] = temp;
		
		//On v�rifie qu'il y a une combinaison sinon on remet les bonbons en place
		if(C1.verification(test, x2, y2).equals("Aucune") || C1.verification(test, x, y).equals("Aucune")) {
			temp = grille[x2][y2];
			grille[x2][y2] = grille[x][y];
			grille[x][y] = temp;
			throw new CandyException("Aucune combinaison");
		}
		
		
		
	}

	public void MettreAjour(String c,int x, int y) {
		int i = 0;
		int j = 0;
		
		if(c.equals("3BNRH")) {
			if(x==0 && !(grille[x][y].equals("Vide"))) {
				if(y<8 && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y+2].getCouleur()) ){
					grille[x][y].setCouleur("Vide");
					grille[x][y].setRaye(false);
					grille[x][y+1].setCouleur("Vide");
					grille[x][y+1].setRaye(false);
					grille[x][y+2].setCouleur("Vide");
					grille[x][y+2].setRaye(false);
				}
				else if((y>0 && y<9 && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()))) {
					grille[x][y].setCouleur("Vide");
					grille[x][y].setRaye(false);
					grille[x][y+1].setCouleur("Vide");
					grille[x][y+1].setRaye(false);
					grille[x][y-1].setCouleur("Vide");
					grille[x][y-1].setRaye(false);
				}
				else if(y>2 && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-2].getCouleur())){
					grille[x][y].setCouleur("Vide");
					grille[x][y].setRaye(false);
					grille[x][y-1].setCouleur("Vide");
					grille[x][y-1].setRaye(false);
					grille[x][y-2].setCouleur("Vide");
					grille[x][y-2].setRaye(false);
				}
			}
			if(y<8 && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y+2].getCouleur()) ){
				for(j=y;j<=y+3;j++) {
					grille[0][j].setCouleur("Vide");
					grille[0][j].setRaye(false);
					for(i=x;i>0;i--) {
						grille[i][j]=grille[i-1][j];
					}
				}
			}
			else if(y>0 && y<9 && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur())) {
				grille[0][y].setCouleur("Vide");
				grille[0][y].setRaye(false);
				grille[0][y+1].setCouleur("Vide");
				grille[0][y+1].setRaye(false);
				grille[0][y-1].setCouleur("Vide");
				grille[0][y-1].setRaye(false);
				
				for(i=x;i>0;i--) {
					grille[i][y]=grille[i-1][y];
				}
				for(i=x;i>0;i--) {
					grille[i][y+1]=grille[i-1][y+1];
				}
				for(i=x;i>0;i--) {
					grille[i][y-1]=grille[i-1][y-1];
				}
			}
			else if(y>2 && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-2].getCouleur())) {
				for(j=y;j>y-3;j--) {
					grille[0][j].setCouleur("Vide");
					grille[0][j].setRaye(false);
					for(i=x;i>0;i--) {
						grille[i][j]=grille[i-1][j];
					}
				}
			}
		}
		else if(c.equals("3BRH")) {
			if(x==0) {
				for(j=0;j<10;j++) {
					grille[x][j].setCouleur("Vide");
					grille[x][j].setRaye(false);
				}
			}
			else {
				for(j=0;j<10;j++) {
					grille[0][j].setCouleur("Vide");
					grille[0][j].setRaye(false);
					for(i=x;i>0;i--) {
						grille[i][j]=grille[i-1][j];
					}
				}
			}
		}
		else if(c.equals("4BNRH")) {
			if(x==0) {
				if(y<7 && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y+2].getCouleur().equals(grille[x][y+3].getCouleur())) {
					grille[x][y].setRaye(true);
					for(j=y+1;j<=y+3;j++) {
						grille[0][j].setCouleur("Vide");
						grille[0][j].setRaye(false);
					}
				}
				else if(y>3 && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y-2].getCouleur().equals(grille[x][y-3].getCouleur())) {
					grille[x][y].setRaye(true);
					for(j=y-1;j>=y-3;j--) {
						grille[0][j].setCouleur("Vide");
						grille[0][j].setRaye(false);
					}
				}
				else if(y>0 && y<8 && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y+2].getCouleur().equals(grille[x][y+3].getCouleur())) {
					grille[x][y].setRaye(true);
					grille[x][y-1].setCouleur("Vide");
					grille[x][y+1].setCouleur("Vide");
					grille[x][y+2].setCouleur("Vide");
				}
				else if(y>1 && y<9 && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y-2].getCouleur().equals(grille[x][y+1].getCouleur())) {
					grille[x][y].setRaye(true);
					grille[x][y-1].setCouleur("Vide");
					grille[x][y-2].setCouleur("Vide");
					grille[x][y+1].setCouleur("Vide");
				}
			}
			else {
					if(y<7 && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y+2].getCouleur().equals(grille[x][y+3].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y+2].getCouleur())) {
						grille[x][y].setRaye(true);
						for(j=y+1;j<=y+3;j++) {
							grille[0][j].setCouleur("Vide");
							grille[0][j].setRaye(false);
							for(i=x;i>0;i--) {
								grille[i][j]=grille[i-1][j];
							}
						}
					}
				}
				if(y>3 && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-2].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-3].getCouleur())) {
					grille[x][y].setRaye(true);
					for(j=y-1;j>=y-3;j--) {
						grille[0][j].setCouleur("Vide");
						grille[0][j].setRaye(false);
						for(i=x;i>0;i--) {	
							grille[i][j]=grille[i-1][j];
						}
					}
				}
				else if(y>0 && y<8 && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y+2].getCouleur())) {
					grille[x][y].setRaye(true);
					for(j=y+1;j<=y+2;j++) {
						grille[0][j].setCouleur("Vide");
						for(i=x;i>0;i--) {
							grille[i][j]=grille[i-1][j];
						}
					}
					grille[0][y-1].setCouleur("Vide");
					for(i=x;i>0;i--) {
						grille[i][y-1]=grille[i-1][y-1];
					}
					
				}
				else if( y>1 && y<9 && grille[x][y].getCouleur().equals(grille[x][y+1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-1].getCouleur()) && grille[x][y].getCouleur().equals(grille[x][y-2].getCouleur())) {
					grille[x][y].setRaye(true);
					for(j=y-1;j>=y-2;j--) {
						grille[0][j].setCouleur("Vide");
						for(i=x;i>0;i--) {
							grille[i][j]=grille[i-1][j];
						}
					}
					grille[0][y+1].setCouleur("Vide");
					for(i=x;i>0;i--) {
						grille[i][y+1]=grille[i-1][y+1];
					}
				}
			}
		
		
		if(c.equals("3BRV")){
			for(j=0;j<10;j++){
				grille[j][y].setCouleur("Vide");
				grille[j][y].setRaye(false);
			}
		}
		
		if(c.equals("3BNRV")){

			if(grille[x][y].getCouleur().equals(grille[x+1][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x+2][y].getCouleur())){
				if(x==0){
					for(j=x;j<x+3;j++){
						grille[j][y].setCouleur("Vide");
						grille[j][y].setRaye(false);
						
					}
				}
				else{
					grille[0][y].setCouleur("Vide");
					grille[0][y].setRaye(false);
					for(j=x; j<x+3; j++){
						for(i=j;i>0;i--) {
							grille[i][y]=grille[i-1][y];
						}
					}
				}
			}
			
			else if(grille[x][y].getCouleur().equals(grille[x+1][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x-1][y].getCouleur())){
				if(x-1==0){
					for(j=x-1;j<(x-1)+3;j++){
						grille[j][y].setCouleur("Vide");
						grille[j][y].setRaye(false);
					}
				}
				else{
					grille[0][y].setCouleur("Vide");
					grille[0][y].setRaye(false);
					for(j=x-1; j<(x-1)+3; j++){
						for(i=j;i>0;i--) {
							grille[i][y]=grille[i-1][y];
						}
					}
				}
			}
			
			else if(grille[x-1][y].getCouleur().equals(grille[x][y].getCouleur()) && grille[x-2][y].getCouleur().equals(grille[x][y].getCouleur())){
				if(x-2==0){
					for(j=x-2;j<(x-2)+3;j++){
						grille[j][y].setCouleur("Vide");
						grille[j][y].setRaye(false);
					}
				}
				else{
					grille[0][y].setCouleur("Vide");
					grille[0][y].setRaye(false);
					for(j=x-2; j<(x-2)+3; j++){
						for(i=j;i>0;i--) {
							grille[i][y]=grille[i-1][y];
						}
					}
				}
			}
		}
		
		if(c.equals("4BNRV")){
			
			if(grille[x][y].getCouleur().equals(grille[x+1][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x+2][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x+3][y].getCouleur())){
				if(x==0){
					for(j=x;j<x+3;j++){
						grille[j][y].setCouleur("Vide");
						grille[j][y].setRaye(false);
					}
					grille[x+3][y].setRaye(true);
				}
				else{
					grille[0][y].setCouleur("Vide");
					grille[0][y].setRaye(false);
					for(j=x; j<x+3; j++){
						for(i=j;i>0;i--) {
							grille[i][y]=grille[i-1][y];
						}
					}
					grille[x+3][y].setRaye(true);
				}
			}
			
			if(grille[x][y].getCouleur().equals(grille[x-1][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x+1][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x+2][y].getCouleur())){
				if(x-1==0){
					for(j=x-1;j<(x-1)+3;j++){
						grille[j][y].setCouleur("Vide");
						grille[j][y].setRaye(false);
					}
					grille[x+2][y].setRaye(true);
				}
				else{
					grille[0][y].setCouleur("Vide");
					grille[0][y].setRaye(false);
					for(j=x-1; j<(x-1)+3; j++){
						for(i=j;i>0;i--) {
							grille[i][y]=grille[i-1][y];
						}
					}
					grille[x+2][y].setRaye(true);
				}
			}
			
			if(grille[x][y].getCouleur().equals(grille[x-2][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x-1][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x+1][y].getCouleur())){
				if(x-2==0){
					for(j=x-2;j<(x-2)+3;j++){
						grille[j][y].setCouleur("Vide");
						grille[j][y].setRaye(false);
					}
					grille[x+1][y].setRaye(true);
				}
				else{
					grille[0][y].setCouleur("Vide");
					grille[0][y].setRaye(false);
					for(j=x-2; j<(x-2)+3; j++){
						for(i=j;i>0;i--) {
							grille[i][y]=grille[i-1][y];
						}
					}
					grille[x+1][y].setRaye(true);
				}
			}
			
			if(grille[x][y].getCouleur().equals(grille[x-3][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x-2][y].getCouleur()) && grille[x][y].getCouleur().equals(grille[x-1][y].getCouleur())){
				if(x-3==0){
					for(j=x-3;j<(x-3)+3;j++){
						grille[j][y].setCouleur("Vide");
						grille[j][y].setRaye(false);
					}
					grille[x][y].setRaye(true);
				}
				else{
					grille[0][y].setCouleur("Vide");
					grille[0][y].setRaye(false);
					for(j=x-3; j<(x-3)+3; j++){
						for(i=j;i>0;i--) {
							grille[i][y]=grille[i-1][y];
						}
					}
					grille[x][y].setRaye(true);
				}
			}
			
			
			
		}			
	}
	
	
	/*CHUTE DE LUCAS
	 * int x = 1;
		int y = 9;
		boolean test=true;
		
		
		for(y=0;y<10;y++) {
			for(x=1;x<9;x++) {
				if(grille[x+1][y].estVide()) {
					grille[x+1][y]=grille[x][y];
					grille[x][y]=grille[x-1][y];
					grille[x-1][y].setCouleur("Vide");
				}
			}
		}
	 */
	
	
}
