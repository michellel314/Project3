import java.util.Scanner;
public class DungeonsRunner {
    public static void main(String[] args) {
        String ans = "";
        String encounter = "";
        boolean gameover = false;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter player 1 name: ");
        String p1 = scan.nextLine();

        System.out.print("Enter player 2 name: ");
        String p2 = scan.nextLine();

        Player first = new Player(p1, 100, 10);
        Player second = new Player(p2, 100, 10);

        while (gameover) {
            System.out.print("You find yourselves at a crossroad. Would you like to go forwards, left, or right? ");
            ans = scan.nextLine();
            while (!(ans.equals("forwards") || ans.equals("left") || ans.equals("right"))) {
                System.out.print("Please choose an available path: ");
                ans = scan.nextLine();
            }
            Encounters en = new Encounters(first, second);
            System.out.print("You go  " + ans + " and find a " + encounter);

            if (encounter.equals("Treasure Chest")) {
                en.chest();
            } else if (encounter.equals("Monster")) {
                en.monster();
            } else {
                en.npc();
            }

            if (first.isDead() && second.isDead()) {
                System.out.print("Both players are dead, would both like to restart for a new game? (y / n): ");
                String choice = scan.nextLine();
                if (choice.equals("y")) {
                    gameover = false;
                }
            } else {
                gameover = true;
                first.reset();
                second.reset();
            }
        }
        System.out.println("Thank you for playing the game!");
    }
}
