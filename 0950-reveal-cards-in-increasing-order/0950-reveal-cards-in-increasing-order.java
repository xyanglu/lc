import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        
        // Sort the deck
        Arrays.sort(deck);
        
        // Create a queue to simulate the process of revealing cards
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        
        int[] result = new int[n];
        for (int card : deck) {
            result[queue.poll()] = card; // reveal the card at the top of the deck
            if (!queue.isEmpty()) {
                queue.add(queue.poll()); // move the next top card to the bottom
            }
        }
        
        return result;
    }
}
