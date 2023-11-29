import mypackage.Lab4Package;

interface TeamMember {
    void introduce();
    void play();
}

class Player implements TeamMember {
    private String playerName;
    private String playerTeam;
    private String playerGame;  



    public Player(String playerName,String playerTeam,String playerGame) {
        this.playerName = playerName;
	this.playerTeam = playerTeam;
	this.playerGame = playerGame;
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I'm " + playerName + ", a player on the team, " + playerTeam);
    }

    @Override
    public void play() {
        System.out.println("playing the game." + playerGame);
    }
}

class Coach implements TeamMember {
    private String coachName;

    public Coach(String coachName) {
        this.coachName = coachName;
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I'm Coach " + coachName + ".");
    }

    @Override
    public void play() {
        System.out.println(coachName + " is guiding the team.");
    }
}

public class LabExercise_4 {
    public static void main(String[] args) {
        Player player = new Player("Shawn Biju","Sentinels","Valorant");
        Coach coach = new Coach("Coach Johnny Bravo");

        player.introduce();
        player.play();

        System.out.println();

        coach.introduce();
        coach.play();

	    // Using TeamInfoPackage
        Lab4Package object = new Lab4Package();

        // Call the method from the package
        object.displayTeamInfo();
    }
}
