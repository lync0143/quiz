package example.states;

import java.util.*;

public class StatePopulations {
    public static void main(String... args) {
        /* California 39,237,836
           Kansas 2,934,582
           West Virginia 1,782,959
           Michigan 10,050,811

           Enter a state name: Michigan
           There are 10050811 people living in Michigan.
         */

        Map<String, Integer> statePops = new HashMap<>();
        Map<Integer, String> fipsLookup = new HashMap<>();
        fipsLookup.put(27, "MN");
        statePops.put("California", 39237836);
        statePops.put("Kansas", 2934582);
        statePops.put("West Virginia", 1782959);
        statePops.put("Michigan", 10050811);

        int code = 27;
        System.out.println("The state abbreviation for FIPS code " + code + " is " + fipsLookup.get(code));

        System.out.print("Enter a state name: ");
        Scanner scanner = new Scanner(System.in);
        String stateName = scanner.nextLine();
        // check whether the user entered a valid state name
        if (statePops.get(stateName) == null) {
            System.out.println("No entry for state: " + stateName);
            return;
        }
        int population = statePops.get(stateName);
        System.out.println("There are " + population + " people living in " + stateName);
/*
        for (Map<String,Integer> statePop : statePops) {
            for (Map.Entry entry : statePop.entrySet()) {
                System.out.println(entry.getKey() + "     " + entry.getValue());
            }
        }

 */
    }
}
