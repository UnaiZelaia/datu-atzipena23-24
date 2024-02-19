package dambi.unai.model;

import org.bson.types.ObjectId;

import jakarta.persistence.Id;

public class Shipwrecks {
    @Id
    private ObjectId objectId;

    private String chart;
    private double[] coodinates;
    private String depth;
    private String feature_type;
    private String gp_quality;
    private String history;
    private double latdec;
    private double londec;
    private String quasou;
    private String recrd;
    private String sounding_type;
    private String vesslterms;
    private String watlev;
}
