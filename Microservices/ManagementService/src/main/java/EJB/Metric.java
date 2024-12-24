/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;
import java.util.HashMap;
import java.util.Map;

public class Metric {
    private final Map<String, Long> counters = new HashMap<>();

    public void increment(String metricName) {
        counters.put(metricName, counters.getOrDefault(metricName, 0L) + 1);
    }

    public long getCount(String metricName) {
        return counters.getOrDefault(metricName, 0L);
    }

    public void reset(String metricName) {
        counters.remove(metricName);
    }
}

