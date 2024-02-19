package dambi.unai.model;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import dambi.unai.model.Awards;

import jakarta.persistence.Id;

@Document(collection = "movies")
public class Movie {

    @Id
    private ObjectId _id;

    
    private List<Awards> awards;
    private String plot;
    private String[] genres;
    private String[] cast;
    private String[] countries;
    private String[] directors;
    private String fullplot;
    private List<Imbd> imbd;
    private String[] languages;
    private String lastupdated;
    private int metacritic;
    private int num_mflix_comments;
    private String poster;
    private String rated;
    private Date released;
    private int runtime;
    private String title;
    private List<Tomatoes> tomatoes;
    private String[] writers;
    private int year;
    
    public Movie() {
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String getFullplot() {
        return fullplot;
    }

    public void setFullplot(String fullplot) {
        this.fullplot = fullplot;
    }

    public List<Imbd> getImbd() {
        return imbd;
    }

    public void setImbd(List<Imbd> imbd) {
        this.imbd = imbd;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public int getNum_mflix_comments() {
        return num_mflix_comments;
    }

    public void setNum_mflix_comments(int num_mflix_comments) {
        this.num_mflix_comments = num_mflix_comments;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tomatoes> getTomatoes() {
        return tomatoes;
    }

    public void setTomatoes(List<Tomatoes> tomatoes) {
        this.tomatoes = tomatoes;
    }

    public String[] getWriters() {
        return writers;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
}
