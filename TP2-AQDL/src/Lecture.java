import java.io.BufferedReader;
import java.io.IOException;

import outilsjava.OutilsFichier;

public class Lecture {
	
	String nomFichier;
	String ligne;
	BufferedReader ficLecture;
	String[] lignesFichier;
	int grosseur;
	int[] nbChaque = new int[3];
	int compteur = 0;
	
	public Lecture() throws IOException {
		lectureFichier();
	}
	
	public String[] lectureFichier() throws IOException {
		nbChaque[0] = -1;
		nbChaque[1] = -1;
		nbChaque[2] = -1;
		
		nomFichier = OutilsFichier.lireNomFichier("Entrez le nom du fichier de commandes: ");
		ficLecture = OutilsFichier.ouvrirFicTexteLecture(nomFichier);
		
		grosseur = getGrosseurFichier(ficLecture);
		lignesFichier = new String[grosseur+3];
		
		OutilsFichier.fermerFicTexteLecture(ficLecture, nomFichier);
		ficLecture = OutilsFichier.ouvrirFicTexteLecture(nomFichier);
		
		for (int i=0; (ligne = ficLecture.readLine()) != null ;i++) {
			lignesFichier[i] = ligne;
			
			switch (compteur) {
				
			case 1:
				nbChaque[0]++;
				break;
			case 2:
				nbChaque[1]++;
				break;
			case 3:
				nbChaque[2]++;
				break;
			
			}
			
			if (ligne == "Clients :") {
				compteur = 1;
			} else if (ligne == "Plats :") {
				compteur = 2;
			} else if (ligne == "Commandes :") {
				compteur = 3;
			} else if (ligne == "Fin") {
				compteur = 4;
			}
			
			
		}
		
		lignesFichier[lignesFichier.length-3] = "" + nbChaque[0];
		lignesFichier[lignesFichier.length-2] = "" + nbChaque[1];
		lignesFichier[lignesFichier.length-1] = "" + nbChaque[2];
		
		return lignesFichier;
	}
	
	public int getGrosseurFichier(BufferedReader ficLecture) throws IOException {
		
		int i = 0;
		
		
		while ((ligne = ficLecture.readLine()) != null) {
			i++;
		}
		
		
		return i;
		
	}
}
