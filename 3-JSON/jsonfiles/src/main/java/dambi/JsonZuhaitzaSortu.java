package dambi;

import javax.json.Json;
import javax.json.JsonObject;

public class JsonZuhaitzaSortu {
    public static void main(String[] args) {

        JsonObject model = Json.createObjectBuilder()
        .add("izena", "Unai")
        .add("Abizena", "Zelaia-Zugadi")
        .add("Adina", 25)
        .add("Helbidea", "Solozabal Kalea 14")
        .add("Herria", "Abadiño")
        .add("Autonomia", "Euskadi")
        .add("posta kodea", "48220")
        .add("telefono zenbakiak", Json.createArrayBuilder()
            .add(Json.createObjectBuilder()
                .add("mota", "mugikorra")
                .add("zenbakia", "666 66 66 66"))
            .add(Json.createObjectBuilder()
                .add("mota", "etxekoa")
                .add("zenbakia", "946 99 99 99"))
            )
        .build();
        System.out.println(model);
    }
}
