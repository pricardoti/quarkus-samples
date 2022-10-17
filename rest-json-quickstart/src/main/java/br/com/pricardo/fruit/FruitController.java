package br.com.pricardo.fruit;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/fruits")
public class FruitController {

    private static final Set<Fruit> FRUIT_DOMAINS = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    static {
        FRUIT_DOMAINS.add(new Fruit("Apple", "Winter fruit"));
        FRUIT_DOMAINS.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    public Set<Fruit> list() {
        return FRUIT_DOMAINS;
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        FRUIT_DOMAINS.add(fruit);
        return FRUIT_DOMAINS;
    }

    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        FRUIT_DOMAINS.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return FRUIT_DOMAINS;
    }
}