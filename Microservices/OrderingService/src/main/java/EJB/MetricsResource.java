/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/metrics")
public class MetricsResource {

     @EJB
    private MetricRegistryManager metricRegistry;

    @GET
    @Produces(MediaType.TEXT_PLAIN) // or MediaType.TEXT_PLAIN depending on your preference
    public String getMetrics() {
        long _4xCount = metricRegistry.get4xCount();
        long _5xCount = metricRegistry.get5xCount();
       // return "total_success: " + requestCount ; // JSON response
        
       return "application_EJB_OrderBean_addOrder_4x{_app=\"orderingservice\"} "+ _4xCount+"\napplication_EJB_OrderBean_addOrder_5x{_app=\"orderingservice\"}"+ _5xCount;

        
    }
}
