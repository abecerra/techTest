import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Network {

    public Network() { }

    @SuppressWarnings("unchecked")
    private ArrayList<String> findGroupA(
        HashMap<String, ArrayList<String>> network,
        HashMap<String, String> employer) {

        ArrayList<String> groupA = new ArrayList<>();

        for (String person : network.keySet()) {
            String employerName = employer.get(person);
            ArrayList friends = network.get(person);
            if ( friends.stream().noneMatch(
		friend -> employerName.equals(employer.get(friend))))
                    groupA.add(person);
        }
        return groupA;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> network = new HashMap<>();
        network.put("Alice",
                new ArrayList<>(Arrays.asList("Ben","Carrie")));
        network.put("Ben",
                new ArrayList<>(Arrays.asList("Alice","Carrie","Darcey","Eve")));
        network.put("Carrie",
                new ArrayList<>(Arrays.asList("Alice","Ben","Eve","Fred")));
        network.put("Darcey",
                new ArrayList<>(Arrays.asList("Ben","Eve")));
        network.put("Eve",
                new ArrayList<>(Arrays.asList("Ben","Carrie","Darcey","Fred")));
        network.put("Fred",
                new ArrayList<>(Arrays.asList("Carrie","Eve")));

        HashMap<String, String> employer = new HashMap<>();
        employer.put("Alice","UCA");
        employer.put("Ben","EBI");
        employer.put("Carrie","OFC");
        employer.put("Darcey","EBI");
        employer.put("Eve","BioB");
        employer.put("Fred","EBI");

        Network net = new Network();
        System.out.println(net.findGroupA(network, employer));
    }
}
