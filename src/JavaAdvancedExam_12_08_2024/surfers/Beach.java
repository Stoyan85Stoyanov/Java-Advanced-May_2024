package JavaAdvancedExam_12_08_2024.surfers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Beach {

    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getSurfboardsForRent() {
        return surfboardsForRent;
    }

    public List<Surfer> getSurfers() {
        return surfers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurfboardsForRent(int surfboardsForRent) {
        this.surfboardsForRent = surfboardsForRent;
    }

    public void setSurfers(List<Surfer> surfers) {
        this.surfers = surfers;
    }

    public int getCount() {
        return this.surfers.size();
    }

    public boolean removeSurfer(String name) {
        return surfers.removeIf(surfer -> surfer.getName().equals(name));
    }

    public Surfer getSurfer(String name) {
        return this.surfers.stream().filter(surfer -> surfer.getName().equals(name)).findFirst().orElse(null);
    }

    public String addSurfer(Surfer surfer) {

        if (!surfer.getOwnsASurfBoard()) {
            if (surfboardsForRent <= 0) {
                return "There are no free surfboards.";

            }
            if (surfer.getMoney() < 50) {
                return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
            }

        }
        if (surfboardsForRent == 0) {
            surfer.setMoney(surfer.getMoney() - 50);
            surfboardsForRent--;
        }

        surfers.add(surfer);
        return String.format("Surfer %s added.", surfer.getName());
    }

    public String getMostExperiencedSurfer() {
        Surfer surfer = surfers.stream().max(Comparator.comparing(Surfer::getExperience)).orElse(null);
        if (surfer == null) {
            return "There are no surfers.";

        } else {
            return String.format("%s is most experienced surfer with %d years experience.", surfer.getName(), surfer.getExperience());
        }
    }

   public String getSurfersWithPersonalSurfboards() {
       if (surfers.isEmpty()) {
           return "There are no surfers.";
       }
       List<String> surfersWithSurfboards =
               surfers.stream().filter(Surfer::getOwnsASurfBoard)
                       .map(Surfer::getName).collect(Collectors.toList());

       return "Surfers who have their own surfboards: " + String.join(", ", surfersWithSurfboards);
   }

    public String getReport() {

        if (surfers.isEmpty()) {
            return "There are no surfers on " + this.name + " beach.";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Beach %s was visited by the following surfers:", name)).append(System.lineSeparator());

        for (int i = 0; i < surfers.size(); i++) {
            Surfer surfer = surfers.get(i);
            builder.append(i + 1).append(". ").append(surfers.get(i).getName()).append(" with ");
            
            if (surfer.getExperience() > 0) {
                builder.append(surfer.getExperience()).append(" years experience.").append(System.lineSeparator());
            } else {
                builder.append("no experience.").append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}


