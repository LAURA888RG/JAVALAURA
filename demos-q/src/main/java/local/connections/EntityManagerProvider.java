package local.connections;

import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {

    private final static String PERSISTENCE_UNI = "demos-q";
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory(
            PERSISTENCE_UNI,
                getProps());
    }

     public static void main(String[] args) {
        getEntityManager();
     }

    static Map<String, String> getProps() {
        Map<String, String> props = new HashMap<>();
        Dotenv dotEnv = Dotenv.load();
        props.put("jakarta.peristence.jdbc.url", dotEnv.get("DB_URL"));
        props.put("jakarta.peristence.jdbc.url", dotEnv.get("DB_USER"));
        props.put("jakarta.peristence.jdbc.url", dotEnv.get("DB_PASWORD"));
        return props;
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
