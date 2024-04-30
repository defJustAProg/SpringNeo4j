
package com.learn.SpringNeo4j;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import static org.neo4j.driver.GraphDatabase.driver;
import org.neo4j.driver.Query;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import static org.neo4j.driver.Values.parameters;


public class Neo4jService implements AutoCloseable {
    
    private final Driver driver;
    
    public Neo4jService(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }


    @Override
    public void close() throws RuntimeException {
        driver.close();
    }


    public void printGreeting(final String message) {
        try (Session session = driver.session()) {
            String greeting = session.executeWrite(tx -> {
                Query query = new Query("CREATE (a:Greeting) SET a.message = $message RETURN a.message + ', from node ' + id(a)", parameters("message", message));
                Result result = tx.run(query);
                return result.single().get(0).asString();
            });
            System.out.println(greeting);
        }
    }

       
}


