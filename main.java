import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TypingSpeedTest {

    static String[] sentences = {
        "Java is a powerful programming language.",
        "Typing speed matters in coding interviews.",
        "Practice typing daily to improve speed.",
        "Artificial Intelligence is changing the world.",
        "Consistency is the key to success."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pick a random sentence
        String testSentence = sentences[(int) (Math.random() * sentences.length)];
        System.out.println("\n💬 Type this sentence:");
        System.out.println("👉 " + testSentence);

        System.out.print("\nPress Enter to start...");
        scanner.nextLine();

        long startTime = System.nanoTime();
        System.out.println("\nStart typing below:");
        String typed = scanner.nextLine();
        long endTime = System.nanoTime();

        // Time taken in seconds
        double timeTaken = (endTime - startTime) / 1_000_000_000.0;

        // Words per minute
        int wordCount = typed.trim().split("\\s+").length;
        int speed = (int) ((wordCount / timeTaken) * 60);

        // Accuracy
        int correctChars = 0;
        int length = Math.min(testSentence.length(), typed.length());
        for (int i = 0; i < length; i++) {
            if (testSentence.charAt(i) == typed.charAt(i)) {
                correctChars++;
            }
        }
        double accuracy = ((double) correctChars / testSentence.length()) * 100;

        // Results
        System.out.printf("\n⏱️ Time Taken: %.2f seconds\n", timeTaken);
        System.out.println("📈 Typing Speed: " + speed + " WPM");
        System.out.printf("🎯 Accuracy: %.2f%%\n", accuracy);

        scanner.close();
    }
}
