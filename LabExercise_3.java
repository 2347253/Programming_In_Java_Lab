// Base class representing a generic player
class Player {
    private String name;
    private int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Base abstract class representing an Esports player
abstract class EsportsPlayer extends Player {
    public EsportsPlayer(String name, int age) {
        super(name, age);
    }

    // Abstract method to be implemented by subclasses
    public abstract void playGame();
}

// Subclass representing a Counter-Strike: Global Offensive player
class CsgoPlayer extends EsportsPlayer {
    private String role;

    public CsgoPlayer(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Game: Counter-Strike: Global Offensive");
        System.out.println("Role: " + role);
    }

    @Override
    public void playGame() {
        System.out.println("Playing CS:GO!");
    }
}

// Subclass representing a League of Legends player
class LeagueOfLegendsPlayer extends EsportsPlayer {
    private String position;

    public LeagueOfLegendsPlayer(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Game: League of Legends");
        System.out.println("Position: " + position);
    }

    @Override
    public void playGame() {
        System.out.println("Playing League of Legends!");
    }
}

// Demonstration class
public class LabExercise_3 {
    public static void main(String[] args) {
        // Creating instances of players
        CsgoPlayer csgoPlayer = new CsgoPlayer("Player1", 20, "Entry Fragger");
        LeagueOfLegendsPlayer lolPlayer = new LeagueOfLegendsPlayer("Player2", 22, "Mid Laner");

        // Displaying player information
        System.out.println("CS:GO Player Information:");
        csgoPlayer.displayInfo();
        csgoPlayer.playGame(); // Using the abstract method
        System.out.println("\nLeague of Legends Player Information:");
        lolPlayer.displayInfo();
        lolPlayer.playGame(); // Using the abstract method
    }
}
