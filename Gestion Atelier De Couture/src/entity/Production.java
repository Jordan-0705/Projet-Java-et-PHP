package entity;

public class Production extends Operation {

    private  static int nbPro;
    
    public Production() {
        super();
        nbPro++;
        this.article = new ArticleVente();
        this.id = "PRO-" + nbPro;
        this.nature = "Production";
    }
}
