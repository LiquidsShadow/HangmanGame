package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class that manages the new file saving system, where game data files are stored in a directory created by game.
 *
 * @author Chami Lamelas
 */
public class HangmanDataManager {

    /**
     * Game data files directory
     */
    File gameDataDirectory;

    /**
     * README generated by game
     */
    File gameData_README;

    /**
     * Constructor to instantiate objects of HangmanDataManager class.
     */
    public HangmanDataManager() {
        gameDataDirectory = new File("Hangman Data");
        // https://stackoverflow.com/questions/4801971/how-to-create-empty-folder-in-java
        gameDataDirectory.mkdir(); // makes empty directory

        gameData_README = new File(gameDataDirectory.getAbsolutePath() + "\\README.txt");

        //System.out.println(gameData_README.getAbsolutePath());

        try {
            // README generation
            PrintWriter README_writer = new PrintWriter(gameData_README.getAbsolutePath());
            README_writer.println("Hangman - README");
            README_writer.println("----------------");
            README_writer.println("");
            // https://stackoverflow.com/questions/797549/get-login-username-in-java
            README_writer.println("README Created on " + getDateAndTime() + " by " + System.getProperty("user.name"));
            README_writer.println("");
            README_writer.println("USER INSTRUCTIONS:");
            README_writer.println("");
            README_writer.println("DO NOT delete \"hangman.config\" and \"hangman_scores\" unless you wish to delete game configuration and saved scores.");
            README_writer.println("BEFORE running this program, please have the Java Development Kit installed for the Java version you are running. ");
            README_writer.println("");
            README_writer.println("GAME RULES: ");
            README_writer.println("");
            README_writer.println("1. The program will stop you if you try to type more than one word or if you don't enter anything. ");
            README_writer.println("This is following the idea that a human opponent would do the same for you.");
            README_writer.println("2. If you guess an incorrect character twice, the program will not deduct you of lives more than once.");
            README_writer.println("3. If you type in a word instead of a letter, which is legal, you will NOT be warned. ");
            README_writer.println("However, you will lose entirely if the word is not the actual word.");
            README_writer.println("4. In addition, if you guess a word that is not the same length as the actual word, the program will still not correct you.");
            README_writer.println("");
            README_writer.println("SCORING SYSTEM: ");
            README_writer.println("");
            README_writer.println("-15 points for guessing the word in 1 turn");
            README_writer.println("-2 points for each turn you have not used.");
            README_writer.println("-5 points for easy difficulty");
            README_writer.println("-10 points for medium difficulty");
            README_writer.println("-15 points for hard difficulty");
            README_writer.println("-20 points for extreme difficulty");
            README_writer.println("");
            README_writer.println("SET-UP: ");
            README_writer.println("");
            README_writer.println("1. The first set-up portion is to choose the configuration you would like for the game. ");
            README_writer.println("This includes five parts: ");
            README_writer.println("(i) the choice of difficulty, which determines your number of lives: ");
            README_writer.println("-easy: \"" + HangmanGame.LIVES_ON_EASY_DIFFICULTY + "\" lives");
            README_writer.println("-medium: \"" + HangmanGame.LIVES_ON_MEDIUM_DIFFICULTY + "\" lives");
            README_writer.println("-hard:\"" + HangmanGame.LIVES_ON_HARD_DIFFICULTY + "\" lives");
            README_writer.println("-extreme: \"" + HangmanGame.LIVES_ON_EXTREME_DIFFICULTY + "\" lives");
            README_writer.println("(ii) whether or not you wish to keep duplicate words");
            README_writer.println("(iii) whether or not you wish to keep proper nouns");
            README_writer.println("(iv) the minimum word length you would like to be allowed.");
            README_writer.println("(v) whether or not to display the file path");
            README_writer.println("However, for minimum word length, the minimum is 2, NOT 0.");
            README_writer.println("Also, as an idea, the largest word in most english dictionaries is \"" + HangmanGame.MAXIMUM_MINIMUM_WORD_LENGTH + "\" letters. ");
            README_writer.println("2. The next part of the set-up allows you to reset the configuration and scores saved on the computer. ");
            README_writer.println("This would erase all configuration data (including the last file you chose if you \\nhad one chosen). ");
            README_writer.println("Now you can start the game. ");
            README_writer.println("If there is no file specified, then a dialog window will open allowing you to choose a file from your computer. ");
            README_writer.println("If you have not yet downloaded a file, you can click the \\\"Browse\\\" button to open your browser to search for a source file. ");
            README_writer.println("The program will remove punctuation, related characters, and words that are 4 characters \\nor less.");
            README_writer.println("");
            README_writer.println("AUTHOR: Shadow76 // Chami Lamelas");
            README_writer.close();
        } catch (FileNotFoundException exception) {
            HangmanDisplay.displayError("Auto-generated Error: " + exception.getMessage());
        }
    }

    // https://stackoverflow.com/questions/18734452/display-current-time-in-12-hour-format-with-am-pm
    /**
     * Gets date and time for creation information
     * @return Date and time for creation information
     */
    public String getDateAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime()) + " at " + timeFormat.format(cal.getTime());
    }

    /**
     * Gets the game data's directory location on file system
     * @return Game data's directory location on file system
     */
    public String getGameDataDirPath() {
        return gameDataDirectory.getAbsolutePath();
    }
}
