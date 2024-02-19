package dambi.unai.model;


public class Awards{

    private int nominations;
    private String text;
    private int wins;
    
    public Awards() {
    }

    public int getNominations() {
        return nominations;
    }

    public void setNominations(int nominations) {
        this.nominations = nominations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    } 

    
}