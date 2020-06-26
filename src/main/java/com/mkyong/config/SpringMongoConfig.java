package com.mkyong.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class SpringMongoConfig{

//    public @Bean
//    MongoTemplate mongoTemplate() throws Exception {
//
//        //MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"),"yourdb");
//        MongoTemplate mongoTemplate = new MongoTemplate((MongoDatabaseFactory) MongoClients.create());
//
//        return mongoTemplate;
//    }
    public @Bean
    MongoClient mongoTemplate() throws Exception {

        //MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient("127.0.0.1"),"yourdb");
        MongoClient mongoTemplate = MongoClients.create();

        return mongoTemplate;
    }
}
