package net.engineeringdigest.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
/* This annotation does the work of three annotations
1.@Configuration     -
2.@EnableAutoConfiguration  - Automatically configures everything like while configuring database(mongodb), just by mentioning port number, service, admin name and password, springboot will automatically configure with ur db. Dont have to do anything else.
3.@ComponentScan    -   Scans for all classes that are component(has @Component written on it)
*/

// to allow @Transaction annotation in functions annotated with this.
@EnableTransactionManagement
public class JournalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(JournalApplication.class, args);
        ConfigurableEnvironment environment=context.getEnvironment();
        System.out.println(environment.getActiveProfiles()[0]);
    }

    @Bean
    public PlatformTransactionManager falana(MongoDatabaseFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }


}
