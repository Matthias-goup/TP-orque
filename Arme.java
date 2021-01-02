class Arme{
  private String type;
  private int dommage;
  private int vitesseA;
  private int probatouche;
  static String [] tabArmes = {"hache","epée","lance","fléau","espadon","massue"};

  public Arme(){
    this.type = tabArmes[Ut.randomMinMax(0,tabArmes.length - 1)];
    if(this.type == "hache"){
      this.hache();
    }
    else if(this.type == "epée"){
      this.epee();
    }
    else if(this.type == "lance"){
      this.lance();
    }
    else if(this.type == "fléau"){
      this.fleau();
    }
    else if(this.type == "espadon"){
      this.espadon();
    }
    else if(this.type == "massue"){
      this.massue();
    }
  }

  private void hache() {
    this.dommage = 17;
    this.vitesseA = 4;
    this.probatouche = 60;

  }

  private void epee() {
    this.dommage = 10;
    this.vitesseA = 10;
    this.probatouche = 80;
  }

  private void lance() {
    this.dommage = 7;
    this.vitesseA = 12;
    this.probatouche = 100;
  }
  
  private void fleau() {
    this.dommage = 12;
    this.vitesseA = 9;
    this.probatouche = 90;
  }

  private void espadon() {
    this.dommage = 15;
    this.vitesseA = 5;
    this.probatouche = 70;
  }

  private void massue() {
    this.dommage = 20;
    this.vitesseA = 3;
    this.probatouche = 50;
  }

  public String getType(){
		return this.type;
	}

	public int getDommage(){
		return this.dommage;
	}

	public int getProbatouche(){
		return this.probatouche;
	}

  public int getvitesseA(){
		return this.vitesseA;
	}
}