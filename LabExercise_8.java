import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.LinkedList;

class LabExercise_8 {

    public static void main(String[] args) {
        List<String> teamPlayers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> playerGameMap = new LinkedHashSet<>();
        Queue<String> playerQueue = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            teamPlayers.add(playerName);
            playerQueue.add(playerName); // Enqueue player

            System.out.print("Enter favorite game for " + playerName + ": ");
            String favoriteGame = scanner.nextLine();
            playerGameMap.add(playerName + ": " + favoriteGame);
        }
        System.out.println();
        System.out.println("Esports Team Players: " + teamPlayers);
        System.out.println("Player to Favorite Game Mapping: " + playerGameMap);

        System.out.print("Player Queue: " + playerQueue);
        System.out.println("\nFront of the Queue: " + playerQueue.peek());
        
        System.out.println();
        System.out.print("Enter the index to access a player: ");
        int indexToAccess = scanner.nextInt();
        scanner.nextLine();
        if (indexToAccess >= 0 && indexToAccess < teamPlayers.size()) {
            String player = teamPlayers.get(indexToAccess);
            System.out.println("Accessed Player: " + player);
            System.out.println("Favorite Game: " + playerGameMap.stream()
                    .filter(entry -> entry.startsWith(player))
                    .findFirst()
                    .orElse("Favorite game not available."));
        } else {
            System.out.println("Invalid index.");
        }

        System.out.println();
        System.out.print("Enter the index to remove a player: ");
        int indexToRemove = scanner.nextInt();
        scanner.nextLine();
        if (indexToRemove >= 0 && indexToRemove < teamPlayers.size()) {
            String removedPlayer = teamPlayers.remove(indexToRemove);
            System.out.println("Removed Player: " + removedPlayer);
            playerGameMap.removeIf(entry -> entry.startsWith(removedPlayer));
            playerQueue.remove(removedPlayer); // Remove player from the queue
        } else {
            System.out.println("Invalid index.");
        }
        System.out.println();
        System.out.println("Updated Esports Team Players: " + teamPlayers);
        System.out.println("Updated Player to Favorite Game Mapping: " + playerGameMap);
        System.out.println("Updated Player Queue: " + playerQueue);

        scanner.close();
    }
}
