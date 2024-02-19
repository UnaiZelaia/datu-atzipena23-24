package dambi.unai;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistries;

@Configuration
public class SpringConfiguration {
    
    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Bean  
    public MongoClient mongoClient() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );
            return MongoClients.create(MongoClientSettings.builder()
                                                    .applyConnectionString(new ConnectionString(connectionString))
                                                    .codecRegistry(pojoCodecRegistry)
                                                    .build());
    }
}
