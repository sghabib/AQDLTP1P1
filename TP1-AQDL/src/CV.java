
public class CV {

	private String nom;
	private String prenom;
	private String formation;
	private int exp;
	private String[] comp;
	private String attentes;
	
	public void CV(String nom, String prenom, String formation, int exp, String[] comp, String attentes) {
		this.nom = nom;
		this.prenom = prenom;
		this.formation = formation;
		this.exp = exp;
		this.comp = comp;
		this.attentes = attentes;
	}
	
	public void affiche() {
		System.out.println("Voici le CV de " + prenom + " " + nom + "\n");
		System.out.println("Formation : " + formation);
		System.out.println("Nombre d'années d'expérience : " + exp);
		System.out.println("Compétences : " );
		
		for(int i = 0 ; i < comp.length ; i++) {
			System.out.println(comp[i]);
		}
		
		System.out.println("\nAttentes envers le cours 4B4 : " + attentes);
	} 
	
}
