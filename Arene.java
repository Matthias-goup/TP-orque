class Arene{
  private int nbo;
  private EE ensOrques;

  public Arene(int nboParam){
    this.nbo = nboParam;
    this.ensOrques = new EE(nboParam);
    for(int i = 0; i < nboParam; i++){
      this.ensOrques.ajoutElt(new Orque(this).getId());
    }
  }

  public Orque bataille() {
    Orque orque1;
    Orque orque2;
    
    while(this.ensOrques.getCardinal() > 1){
      orque1 = Orque.getOrqueById(this.ensOrques.selectEltAleatoirement());
      orque2 = Orque.getOrqueById(this.ensOrques.selectEltAleatoirement());
      this.ensOrques.ajoutElt(orque1.combat(orque2));
    }
    return Orque.getOrqueById(this.ensOrques.selectionUnElt());
  }
  
  public int getNbo(){
    return this.nbo;
  }

}