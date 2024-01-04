interface Player {
    void playGame(String game, int skillLevel);
}

class EsportsTeam {
    public void recruitPlayer(String playerName, Player player) {
        System.out.println("Recruiting " + playerName);

        player.playGame("CS:GO", 75); 
    }
}

public class LabExercise_7 {
    public static void main(String[] args) {
        EsportsTeam team = new EsportsTeam();

        team.recruitPlayer("Shawn Biju Thomas", (game, skillLevel) -> {
            System.out.println("Playing " + game + " with skill level: " + skillLevel);
            
            if (skillLevel > 80) {
                System.out.println("This player is highly skilled!");
            } else {
                System.out.println("Improvement needed for this player.");
            }
        });

        team.recruitPlayer("Logan Paul", (game, skillLevel) -> {
            System.out.println("Playing " + game + " with skill level: " + skillLevel);

            if (skillLevel > 50) {
                System.out.println("This player has decent skills.");
            } else {
                System.out.println("This player needs more practice.");
            }
        });
    }
}
