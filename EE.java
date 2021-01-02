public class EE {

	private int cardinal; // stockage du cardinal de l'objet
	private int[] ensTab; // stockage des valeurs

	public EE(int max) { // creation d'un ensemble vide
		this.ensTab = new int[max];
		this.cardinal = 0;
	}

	public EE(int[] mesValeurs, int max) {

		this(max);

		this.cardinal = mesValeurs.length;

		for (int i = 0; i < cardinal; i++) {
			this.ensTab[i] = mesValeurs[i];
		}
	}

	public EE(EE e) {

		this(e.ensTab.length);

		this.cardinal = e.cardinal;

		for (int i = 0; i < cardinal; i++) {

			this.ensTab[i] = e.ensTab[i];
		}
	}

	public EE(String mesValeurs, int max) {

		this(max);

		String[] tabS = mesValeurs.split(" ");

		this.cardinal = tabS.length;

		for (int i = 0; i < this.cardinal; i++) {
			this.ensTab[i] = Integer.parseInt(tabS[i]);

		}
	}

	public String toString() {

		String str = "{";

		for (int i = 0; i < cardinal; i++) {
			str += this.ensTab[i];
			if (i != cardinal - 1) {
				str += ",";
			}
		}
		str += "}";
		return str;
	}

	public int getCardinal() {
		return this.cardinal;
	}

	private int contientPratique(int a) {

		for (int i = 0; i < this.cardinal; i++) {
			if (a == this.ensTab[i]) {
				return i;
			}
		}
		return -1;
	}

	public boolean contient(int a) {

//		if (contientPratique(a) == -1)
//			return false;
//		else
//			return true;

		return (contientPratique(a) != -1);

	}

	/**
	 * @param x est un element a ajouter ajoute x a l'objet courant
	 */
	private void ajoutPratique(int x) {

		this.ensTab[this.cardinal] = x;

		this.cardinal++;
	}

	/**
	 * @param i est l'indice de l'element du tableau this.ensTab à enlever
	 *          Avtion/résultat : retire this.ensTab[i] de l'ensemble courant et le
	 *          renvoie
	 */
	private int retraitPratique(int i) {

		int sauve = this.ensTab[i];

		this.ensTab[i] = this.ensTab[this.cardinal - 1]; // On bouche le trou
		this.cardinal--;

		return sauve;
	}

	/**
	 * @return booleen indiquant si l'ensemble est vide
	 */
	public boolean estVide() {
		return (this.cardinal == 0);
	}

	/**
	 * @return booleen indiquant si le tableau permettant de stocker l'ensemble est
	 *         plein
	 */
	public boolean deborde() {
		return (this.cardinal == this.ensTab.length);
	}

	/* ==================================================================== */

	/**
	 * @param x est l'entier a retirer l'ensemble
	 * @return false si this ne contenait pas x ; true si x present et est retire
	 */
	public boolean retraitElt(int x) {

		int res = this.contientPratique(x);

		if (res == -1)
			return false;
		else {
			this.retraitPratique(res);
			return true;
		}
	}

	/**
	 * @param x est l'entier a chercher dans l'ensemble
	 * @return -1 si this est plein ; 0 si x deja present et pas ajoute ; 1 si x
	 *         ajoute
	 */
	public int ajoutElt(int x) {

		if (this.deborde())
			return -1;

		else if (this.contient(x))
			return 0;

		else {
			this.ajoutPratique(x);
			return 1;
		}
	}

	/**
	 * @param e est un ensemble
	 * @return vrai si this est inclus dans l'ensemble e
	 */
	public boolean estInclus(EE e) {
		// parcours partiel
		int i = 0;
		while (i < this.cardinal && e.contient(this.ensTab[i])) {
			i++;
		}
		return (i == this.cardinal);
	}

	/**
	 * @param f est un ensemble
	 * @return vrai si les ensembles ont le meme nombre d'elements et que tous les
	 *         elements sont egaux
	 */
	public boolean estEgal(EE e) {

		return this.getCardinal() == e.getCardinal() && this.estInclus(e);
		// return this.getCardinal() == e.getCardinal() && e.estInclus(this);

	}

	/**
	 * @param f est un ensemble
	 * @return vrai si l'objet courant est disjoint de e
	 */
	public boolean estDisjoint(EE e) {
		//
		// principe: on verifie si chaque elt de l'objet courant n'appartient pas a e;
		// parcours partiel car des qu'un element existe dans les 2, on s'arrete en
		// retournant faux
		//
		int i = 0;

		while (i < this.cardinal && !e.contient(this.ensTab[i])) {
			i++;
		}
		return i == this.cardinal;
	}

	/**
	 * 
	 * @param f est un ensemble
	 * @return un ensemble representant l'intersection entre l'objet courant et f
	 */
	public EE intersection(EE e) {
		//
		// Principe: pour chaque x de l'objet courant on regarde s'il est present dans
		// e,
		// si oui on l'ajoute dans l'ensemble retourne
		//

		EE ens = new EE(this.ensTab.length);

		for (int i = 0; i < this.cardinal; i++) {
			if (e.contient(this.ensTab[i])) { // ensTab[i] appartient aux deux ensembles
				ens.ajoutPratique(this.ensTab[i]);
			}
		}
		return ens;
	}

	/**
	 * 
	 * @param e est un ensemble
	 * @return un ensemble representant l'union entre l'objet courant et f
	 */
	public EE reunion(EE e) {
		//
		// Principe: recopie l'objet courant puis lui ajoute (si besoin) les elements de
		// e
		//
		EE ens = new EE(this.ensTab.length + e.ensTab.length);

		for (int i = 0; i < this.cardinal; i++) {
			ens.ajoutElt(this.ensTab[i]);
		}

		for (int i = 0; i < e.cardinal; i++) {
			ens.ajoutElt(e.ensTab[i]);
		}

		return ens;
	}

	/**
	 * @param e est un ensemble
	 * @return un ensemble representant la difference entre l'objet courant et f
	 */
	public EE difference(EE e) {
		//
		// retourne un ensemble dans lequel figurent les elements qui existe dans
		// l'ensemble courant mais pas dans e
		//
		EE ens = new EE(this.ensTab.length);

		for (int i = 0; i < this.cardinal; i++) {
			if (!e.contient(this.ensTab[i])) {
				ens.ajoutPratique(this.ensTab[i]);
			}
		}
		return ens;
	}

	public int retraitEltAleatoirement() {
		// Pr ́e-requis : ensemble this est non vide
		// R ́esultat/action : enl`eve un ́el ́ement de this (al ́eatoirement) et le
		// renvoie
		int i = Ut.randomMinMax(0, this.cardinal - 1);
		int select = retraitPratique(i);
		return select;
	}

	public int selectionUnElt() {
		// Pr ́e-requis : ensemble this est non vide// R ́esultat : un ́el ́ement
		// quelconque de this (le dernier, par commodit ́e)
		return this.ensTab[this.cardinal - 1];
	}

public int selectEltAleatoirement() {
  int i = Ut.randomMinMax(0, this.cardinal - 1);
  int select = this.retraitPratique(i);
  return select;}
}
