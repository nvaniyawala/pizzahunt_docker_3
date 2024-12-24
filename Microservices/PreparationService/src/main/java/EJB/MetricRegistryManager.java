/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class MetricRegistryManager {
    
    
   private final Metric metric = new Metric();

    @PostConstruct
    public void init() {
        // Initialization logic if needed
    }

    public void increment4xCount() {
        metric.increment("app.4x.total");
    }

    public long get4xCount() {
        return metric.getCount("app.4x.total");
    }

    public void increment5xCount() {
        metric.increment("app.5x.total");
    }

    public long get5xCount() {
        return metric.getCount("app.5x.total");
    }
    
    
    
    @PreDestroy
    public void cleanup() {
        // Cleanup logic if necessary
    }}
