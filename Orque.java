class Orque{

/*
---------------
---VARIABLES---
---------------
*/
  private int id;
  private Arene arene;
  static int nbOrques = 0;
  static Orque [] tabOrques = new Orque[1000];
  
  private int pdv;
  private Arme arme;
  private int agressivite;


/*
------------------
---CONSTRUCTEUR---
------------------
*/
  public Orque(Arene arene) {
    this.id = this.nbOrques;
    this.arene = arene;
    this.nbOrques++;
    this.tabOrques[this.id] = this;
    this.arme = new Arme();
    this.pdv = Ut.randomMinMax(80, 100);
    this.agressivite = Ut.randomMinMax(1, 3);
  }

/*
--------------
---MÉTHODES---
--------------
*/  
  public int combat(Orque Orque2Param) {
    Orque orque1 = this;
    Orque orque2 = Orque2Param;
    boolean orque1Attaque = true;
    int i;

    while(orque1.pdv > 0 && orque2.pdv > 0 ){
      if(orque1Attaque){
       //C'est au tour du premier orque d'attaquer
        if(orque1.getVitesseA() <= orque2.getVitesseA()) {
          // Si la vitesse d'attaque de l'orque est basse, il n'attaque qu'une fois
           if(Ut.randomMinMax(orque1.getProbatouche(), 100) <= orque1.getProbatouche() ) {
            Orque2.pdv -= Orque1.getDommage();
          }
        }
        
        else{
          i = 0;
          while(i < orque2.getProbatouche){
            // SI la vitesse d'attaque de l'orque est haute, il attaque plusieurs fois
            if(Ut.randomMinMax(orque1.getProbatouche(), 100) <= orque1.getProbatouche() ) {
            Orque2.pdv -= Orque1.getDommage();
            }
            i += Orque1.getVitesseA();
          }
        }
      }

      if(orque1Attaque){
       //C'est au tour du premier orque d'attaquer
        if(orque1.getVitesseA() <= orque2.getVitesseA()) {
          // Si la vitesse d'attaque de l'orque est basse, il n'attaque qu'une fois
           if(Ut.randomMinMax(orque1.getProbatouche(), 100) <= orque1.getProbatouche() ) {
            Orque2.pdv -= Orque1.getDommage();
          }
        }
        
        else{
          i = 0;
          while(i < orque2.getProbatouche){
            // SI la vitesse d'attaque de l'orque est haute, il attaque plusieurs fois
            if(Ut.randomMinMax(orque1.getProbatouche(), 100) <= orque1.getProbatouche() ) {
            Orque2.pdv -= Orque1.getDommage();
            }
            i += Orque1.getVitesseA();
          }
        }
      }






      orque1Attaque = !orque1Attaque;
    }
    
    return (orque1.pdv <= 0)?orque1:orque2; // Si orque1.pdv <= 0 Alors return orque1 Sinon return orque2
  }

/*
---------------
---ACCESSEUR---
---------------
*/
  public int getId(){
    return this.id;
  }
  
  static Orque getOrqueById(int indent){
    return Orque.tabOrques[indent];
  }

  public int getNbOrques() {
    return this.nbOrques;
  }

  public int getPdv(){
    return this.pdv;
  }
  
  public Arme getArme(){
    return this.arme;
  }

  public int getAgressivite(){
    return this.agressivite;
  }

}