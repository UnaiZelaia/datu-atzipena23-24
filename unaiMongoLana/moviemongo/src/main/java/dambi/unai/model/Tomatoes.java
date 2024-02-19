package dambi.unai.model;

import java.util.Date;

public class Tomatoes {
    private String boxOffice;
    private String consensus;
    private Critic critic;
    private Date dvd;
    private int fresh;
    private Date lastUpdated;
    private String production;
    private int rotten;
    private Viewer viewer;
    private String website;
    
    public Tomatoes() {
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getConsensus() {
        return consensus;
    }

    public void setConsensus(String consensus) {
        this.consensus = consensus;
    }

    public Critic getCritic() {
        return critic;
    }

    public void setCritic(Critic critic) {
        this.critic = critic;
    }

    public Date getDvd() {
        return dvd;
    }

    public void setDvd(Date dvd) {
        this.dvd = dvd;
    }

    public int getFresh() {
        return fresh;
    }

    public void setFresh(int fresh) {
        this.fresh = fresh;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getRotten() {
        return rotten;
    }

    public void setRotten(int rotten) {
        this.rotten = rotten;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    
}
