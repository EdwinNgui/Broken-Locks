/* Edwin Ngui
 * ICS3U1
 * Start Date: June/2/2022
 * Due Date: June/16/2022
 * Desc: This game was inspired by Mastermind and follows the adventure of an individual attempting to steal an art piece whilst cracking randomly determined codes.
 */

import java.util.*;
import java.io.*; //Imports packages and libraries
import java.lang.Thread; //For the sleep function

public class Mastermind {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int gameSize, tries, imageNum, triesUsed, stageNum, levelPoints, totalPoints;
		tries = 3;
		levelPoints = totalPoints = 0;
		long millis;
		String guess, mainMenu, next, code, exitMenu, name, result, decision, criminalType1, criminalType2, slowText;
		guess = criminalType1 = criminalType2 = decision = "";
		boolean invalidInput, exit, unique, leaveSecrets, correct, gameOver;
		invalidInput = exit = unique = leaveSecrets = correct = gameOver = false;

		// Calibration
		System.out.println("*************************************************************************");
		for (int i = 0; i < 12; i++) {
			System.out.println("*\t\t\t\t\t\t\t\t\t*");
		}
		System.out.println("*    Calibration. Please resize your screen to hold the entire box.     *");
		System.out.println("*\t    Type \"exit\" anytime in the menu to quit.                    *");
		System.out.println("*\t\t\t\t\t\t\t\t\t*");
		System.out.println("*\t  When you see <continue>, enter anything to continue.          *");
		for (int i = 0; i < 12; i++) {
			System.out.println("*\t\t\t\t\t\t\t\t\t*");
		}
		System.out.println("*************************************************************************");

		System.out.print("<continue>");
		input.nextLine();

		// Title Screen; Image 1; Lock
		screenClear();
		imageNum = 1;
		images(imageNum);
		input.nextLine();
		// Main Menu - Let's them choose what section of the code they want to interact
		// with
		do {
			next = ""; // Resets next
			mainMenu = "";
			gameOver = false;
			screenClear();
			System.out.println("\t\tMenu");
			System.out.println("\t********************");
			System.out.println("➤ (1) Story Mode");
			System.out.println("➤ (2) Custom Game");
			System.out.println("➤ (3) Tutorial");
			System.out.println("➤ (4) Secrets");
			System.out.println("➤ (5) Quit Game\n");
			if (invalidInput) { // If they misinput and must try again, they will be told it
				System.out.println("Your previous input was invalid.");
			}
			System.out.print("Input Here (Type the corresponding number): ");
			mainMenu = input.nextLine(); // Coded as a string to avoid errors (when string tries to go into int

			if (mainMenu.equals("1")) { // Path 1: Main Game - Choose your own story code breaking
				invalidInput = false;
				totalPoints = 0; // Points score is reset
				screenClear();
				System.out.print("\t  Keep an eye out for CAPITLIZED secret codes <continue>");
				input.nextLine();

				screenClear();
				slowText = "July 7th, 2002.";
				char[] slowTextArray = slowText.toCharArray();
				for (int i = 0; i < slowTextArray.length; i++) {
					System.out.print(slowTextArray[i]);
					sleep(120);
				}
				sleep(50);
				System.out.print("\nAlleyway. <continue>");
				input.nextLine();
				invalidInput = false;
				do {
					System.out.println("<Shady Alley Guy> Psst. What's your name?");
					System.out.print("Input Here");

					if (invalidInput) {
						System.out.print(" [Previous input was invalid]: ");
					} else {
						System.out.print(": ");
					}
					// If invalid input
					name = input.nextLine();
					name = name.trim();
					if (name.length() > 1) { // 2 or more
						invalidInput = false;
					} else {
						invalidInput = true;
					}
				} while (name.length() < 1);
				name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
				System.out.print(
						"\n<Shady Alley Guy> Keep in touch " + name + ", I have an opprutunity for you. <continue>");
				input.nextLine();

				System.out.println("");

				screenClear();
				slowText = "November 16th, 2002.";
				slowTextArray = slowText.toCharArray();
				for (int i = 0; i < slowTextArray.length; i++) {
					System.out.print(slowTextArray[i]);
					sleep(120);
				}
				sleep(50);
				System.out.println("\nAziok Museum.");
				sleep(50);
				System.out.println("<Shady Alley Guy> So there are two possible objectives. Choose one.");
				System.out.print("\t\t  First there's Alfred Von Tungsten's stopwatch... <continue>");
				input.nextLine();

				// Image 2; Stopwatch
				screenClear();
				imageNum = 2;
				images(imageNum);
				input.nextLine();

				screenClear();
				System.out.println("<Shady Alley Guy> Or the Winged Sculpture of Ancient Zyensberg.");
				System.out.print("\t\t  Arguably more valuable, that being said. Harder to steal. <continue>");
				input.nextLine();

				// Image 3; Sculpture
				screenClear();
				imageNum = 3;
				images(imageNum);
				input.nextLine();

				screenClear();
				System.out.print("<Shady Alley Guy> You don't need to choose now... <continue>.");
				input.nextLine();
				screenClear();

				System.out.println("\t       ***" + name + " arrives to the door steps of the Aziok Museum***");
				System.out.println("<Mysterious voice> Helllooo, I'm in your bluetooth earpiece.");
				System.out.print("\t\t   My name's Barry. <continue>");
				input.nextLine();
				System.out.println("<Barry> Boss tasked me with guiding you on your little heist. So, here I am.");
				System.out.println("<Barry> Go ahead and head to the front for me. You have a couple of choices.");
				System.out.println("\tBe social or be stealthy.");

				invalidInput = false;
				do {
					System.out.println("➤ (1) Social");
					System.out.println("➤ (2) Stealthy");
					System.out.print("Input here");

					// Tells the user if the previous answer was too long
					if (invalidInput) {
						System.out.print(" [Previous input was invalid]: ");
					} else {
						System.out.print(": ");
					}

					criminalType1 = input.nextLine();
					criminalType1 = criminalType1.trim();

					if (criminalType1.equalsIgnoreCase("social") == false
							&& criminalType1.equalsIgnoreCase("stealthy") == false
							&& criminalType1.equalsIgnoreCase("1") == false
							&& criminalType1.equalsIgnoreCase("2") == false) {
						invalidInput = true;
						System.out.println("\n");
					} else {
						invalidInput = false;
					}

				} while (criminalType1.equalsIgnoreCase("social") == false
						&& criminalType1.equalsIgnoreCase("stealthy") == false
						&& criminalType1.equalsIgnoreCase("1") == false
						&& criminalType1.equalsIgnoreCase("2") == false);

				// Background
				screenClear();
				if (criminalType1.equalsIgnoreCase("social") || criminalType1.equals("1")) {
					System.out.println("\t       ***" + name + " approaches a manager-looking individual***");
					System.out.print("<Manager> Hello, how can I help you? <continue>");
					input.nextLine();
					System.out.println("<" + name + "> It's my first day, where is the meeting room?");
					System.out.print("<Manager> Just around the corner. Enjoy your first day! <continue>");
					input.nextLine();
				} else if (criminalType1.equalsIgnoreCase("stealthy") || criminalType1.equals("2")) {
					System.out.print("*You patiently watch employees move around the museum* <continue>");
					input.nextLine();
					System.out.print("<Barry> *chips crunching* <continue>");
					input.nextLine();
					System.out.println("<Barry> ...hey did you know the Alfred's ");
					System.out.print("\tstopwatch is actually from Alfred himself? ALFRED!!! <continue>"); // Secret
																											// Code 1
					input.nextLine();
					System.out.print(
							"<" + name + "> I think someone's going into that door. I'll follow them <continue>");
					input.nextLine();
				}

				if (criminalType1.equalsIgnoreCase("social") || criminalType1.equalsIgnoreCase("1")) {
					criminalType1 = "Social Butterfly";
				} else if (criminalType1.equalsIgnoreCase("stealthy") || criminalType1.equalsIgnoreCase("2")) {
					criminalType1 = "Smooth Criminal";
				}

				System.out.println("\n<Barry> Alright, the boss left the portable keymaker with you.");
				System.out.println("\tEach letter represents a height in a keygroove.");
				System.out.print("\tMake the perfect combo of key heights to fit the inner lock pins. <continue>");
				input.nextLine();
				invalidInput = false;
				do {
					System.out.println("\n<Barry> Wait. Did you want a tutorial first?");
					System.out.println("➤ Yes");
					System.out.println("➤ No");
					System.out.print("Input here");

					// Tells the user if the previous answer was too long
					if (invalidInput) {
						System.out.print(" [Previous input was invalid]: ");
					} else if (invalidInput == false) {
						System.out.print(": ");
					}

					decision = input.nextLine();

					// Determines if a tutorial should be given, also determines if answer is valid
					if (decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("y")) {
						tutorial();// Activates tutorial method
						invalidInput = false;
					} else if (decision.equalsIgnoreCase("no") || decision.equalsIgnoreCase("n")) {
						invalidInput = false;
					} else {
						invalidInput = true;

					}

				} while (decision.equalsIgnoreCase("yes") == false && decision.equalsIgnoreCase("no") == false
						&& decision.equalsIgnoreCase("y") == false && decision.equalsIgnoreCase("n") == false);

				// General setup for the first stage
				gameSize = 3;
				stageNum = 1; // Indicates what level
				do {
					screenClear();
					// Determines how long the game is
					gameSize = (stageNum + 2);
					char[] answer = new char[gameSize];
					// Creates all choices
					int[] answerChoices = new int[gameSize];
					for (int i = 0; i < gameSize; i++) {
						answerChoices[i] = i + 65; // Numbers equal to letters
					}

					// Fills the answer key randomly and uniquely
					int random;
					for (int i = 0; i < gameSize; i++) {
						do {
							random = rand.nextInt(gameSize);
							answer[i] = (char) answerChoices[random];
						} while (answerChoices[random] == 0);
						answerChoices[random] = 0; // Resets it to 0
					}

					// To allow repetition until word is found
					tries = gameSize - 1 + (gameSize - 3); // Reactive based on how long the guy should be (more tries
															// at tougher levels)
					triesUsed = 0;
					do {
						// To display answer possibilities
						displayAnswer(gameSize);

						// Makes user guess a valid sized answer
						invalidInput = false;
						guess = userInput(tries, invalidInput, gameSize, guess);

						// Checks if they are correct or not; by putting both into an array
						char[] guessCheck = guess.toCharArray();

						resultKey();

						// Checks each character and provides appropriate feedback
						result = answerChecker(answer, guessCheck);
						System.out.println("Previous Attempt Results: " + result);
						correct = true; // Set to true unless proven otherwise by next few lines
						// Checks if it's correct as a whole
						for (int i = 0; i < gameSize; i++) {
							if (answer[i] != guessCheck[i]) { // One instance of not being correct, shows that it's all
																// incorrect
								correct = false;
							}
						}

						tries--; // Deducts one try
						triesUsed++;
						levelPoints = 0; // Resets level points from existing number
						levelPoints = (gameSize * 100) - (tries * 10);
						if (tries == 0 || correct == false) { // If user fails a level, 0 points are awarded
							levelPoints = 0;
						}
					} while (correct == false && tries > 0);

					totalPoints += levelPoints; // Total points takes however many points has been achieved
					// Feedback for Stage 1
					if (correct && stageNum == 1) {
						System.out.println("******************************************************");
						System.out.print("\nYou got the answer in " + triesUsed + " tries! <continue>");
						input.nextLine();
						screenClear();
						System.out.println("<Barry> Great work! Describe your location.");
						System.out.print(
								"<" + name + "> There's a vending machine...some tables and a fridge. Oh. <continue>");
						input.nextLine();
						System.out.println(
								"<Barry> Did you bother reading the door before you started? I guess we'll continue on.");
						System.out.print("<Barry> Exit the breakroom and find the security room. <continue>");
						input.nextLine();
						screenClear();
						System.out.println("*" + name + " finds the security room and begins getting into it...*");
						System.out.print("<Barry> This next one is slightly tougher, you'll see it... <continue>");
						input.nextLine();
						stageNum++; // Goes up one stage
						correct = false; // Resets correct boolean
						gameOver = false;
					} else if (stageNum == 1) { // Lost in Stage 1
						screenClear();
						System.out.println("<Employee> Can I help you? This is the breakroom, are you a staff member?");
						System.out.print("<" + name + "> Uh. Yes? <continue>");
						input.nextLine();
						System.out.print("<Employee> SECURITY! <continue to ending>");
						input.nextLine();
						gameOver = true;
						correct = false; // Resets correct boolean

					} else if (correct && stageNum == 2) { // Feedback for Stage 2
						System.out.println("******************************************************");
						System.out.print("\nYou got the answer in " + triesUsed + " tries! <continue>");
						input.nextLine();
						screenClear();
						System.out.println("<Barry> Great! We're in the security room.");
						System.out.println("\tGo ahead and take care of the guard. <continue>");
						input.nextLine();
						invalidInput = false;
						// Determines if the main character is social or stealthy
						do {
							screenClear();
							System.out.println(
									"\n<Barry> We can \"take care of the guard\" with a pleasant sleep, or just act like one.");
							System.out.println("<Barry> What do you want to do to the guard?");
							System.out.println("➤ (1) Sleep");
							System.out.println("➤ (2) Acting");
							System.out.print("Input here");

							// Tells the user if the previous answer was too long
							if (invalidInput) {
								System.out.print(" [Previous input was invalid]: ");
							} else if (invalidInput == false) {
								System.out.print(": ");
							}

							criminalType2 = input.nextLine();

							// Determines if a tutorial should be given, also determines if answer is valid
							if (criminalType2.equalsIgnoreCase("sleep") || criminalType2.equalsIgnoreCase("1")) {
								invalidInput = false;
								screenClear();
								System.out.print("<" + name + "> Goodnight buddy. <continue>");
								System.out.print("\n*" + name + " takes care of the security guard* <continue>");
								input.nextLine();
								System.out.print(
										"<Barry> Violent, much? Turn the cameras off and make your way to the vault. <continue>");
								input.nextLine();
							} else if (criminalType2.equalsIgnoreCase("acting")
									|| criminalType2.equalsIgnoreCase("2")) {
								invalidInput = false;
								screenClear();
								System.out.println("<" + name + "> Howdy, I'm the new hire.");
								System.out.print("<Security Guard> Where's your uniform? <continue>");
								input.nextLine();
								System.out.println("<" + name
										+ "> It's with the boss. They told me to call you up to their office.");
								System.out.print("<Security Guard> Shoot. Well thanks, cover for a bit. <continue>");
								input.nextLine();
								System.out.print(
										"\n<Barry> Ha. Gullible. Turn the cameras off and make your way to the vault. <continue>");
								input.nextLine();

							} else {
								invalidInput = true;
							}

						} while (criminalType2.equalsIgnoreCase("sleep") == false
								&& criminalType2.equalsIgnoreCase("acting") == false
								&& criminalType2.equalsIgnoreCase("1") == false
								&& criminalType2.equalsIgnoreCase("2") == false);

						// Criminal Type - Helps create the ending
						if (criminalType2.equalsIgnoreCase("sleep") || criminalType2.equalsIgnoreCase("1")) {
							criminalType2 = "Deadly";
						} else if (criminalType2.equalsIgnoreCase("acting") || criminalType2.equalsIgnoreCase("2")) {
							criminalType2 = "Peaceful";
						}

						// Going to vault

						invalidInput = false;
						do {
							screenClear();
							System.out.println(
									"\n<Barry> Choose your objective. Alfred's stopwatch (easier) or the sculpture (difficult).");
							System.out.println("➤ (1) Stopwatch");
							System.out.println("➤ (2) Sculpture");
							System.out.print("Input here");

							// Tells the user if the previous answer was too long
							if (invalidInput) {
								System.out.print(" [Previous input was invalid]: ");
							} else if (invalidInput == false) {
								System.out.print(": ");
							}

							decision = input.nextLine();

							// Determines if a tutorial should be given, also determines if answer is valid
							if (decision.equalsIgnoreCase("stopwatch") || decision.equalsIgnoreCase("1")) {
								System.out.print("<Barry> Good choice, a fancy watch. <continue>");
								input.nextLine();
								invalidInput = false;
								stageNum++; // Stopwatch means only a one increase
							} else if (decision.equalsIgnoreCase("sculpture") || decision.equalsIgnoreCase("2")) {
								invalidInput = false;
								System.out.print("<Barry> You've got an eye for good art. <continue>");
								input.nextLine();
								stageNum += 2; // Increases by 2
							} else {
								invalidInput = true;

							}

						} while (decision.equalsIgnoreCase("stopwatch") == false
								&& decision.equalsIgnoreCase("sculpture") == false
								&& decision.equalsIgnoreCase("1") == false && decision.equalsIgnoreCase("2") == false);

					} else if (stageNum == 2) { // Lost breaking into stage 2 (security room)
						screenClear();
						System.out.print("<Security Guard> What the...I'm calling the cops. <continue to ending>");
						gameOver = true;
					} else if (correct && stageNum == 3) { // Stopwatch correct
						gameOver = true;
						System.out.println("******************************************************");
						System.out.print("\nYou got the answer in " + triesUsed + " tries! <continue>");
						input.nextLine();
						screenClear();
						System.out.println("<" + name + "> It looks like the tag on the stopwatch says \"To: OLIVIA\""); // Secret
																															// Code
																															// 2
						System.out.print(
								"<Barry> That's weird. Anyways, get yourself out of there and we're all done. <continue to ending>");
						input.nextLine();
					} else if (stageNum == 3) { // Stopwatch ending
						gameOver = true;
						screenClear();
						System.out.print("<" + name + "> Dang...");
						System.out.print("*Steps grow louder behind you* <continue>");
						input.nextLine();
						System.out.print("<Security Guard> Hey you! Stop right there! <continue to ending>");
						input.nextLine();
					} else if (correct && stageNum == 4) { // Sculpture correct
						gameOver = true;
						System.out.println("******************************************************");
						System.out.print("\nYou got the answer in " + triesUsed + " tries! <continue>");
						input.nextLine();
						screenClear();
						System.out.println(
								"<" + name + "> The sculpture's base says \"FLYAWAY\", I wonder what that means."); // Secret
																													// Code
																													// 3
						System.out.print(
								"<Barry> How about you fly out of that museum and bring it home? <continue to ending>");
						input.nextLine();
					} else if (stageNum == 4) { // Sculpture ending
						gameOver = true;
						screenClear();
						System.out.println("<" + name + "> Oops.");
						System.out.print("*Steps grow louder behind you* <continue>");
						input.nextLine();
						System.out.print("<Police officer> Put your hands in the air! Now! <continue to ending>");

					}

				} while (gameOver == false);

				// Ending goes here (animate)
				screenClear();
				System.out.print("\t\t    ");
				slowText = "******** Conclusion ********";
				slowTextArray = slowText.toCharArray();
				for (int i = 0; i < slowTextArray.length; i++) {
					System.out.print(slowTextArray[i]);
					sleep(150);
				}
				sleep(800);
				System.out.println("\nBased on your choices you are a...");
				sleep(800);
				System.out.println("\t\t" + criminalType2 + " " + criminalType1);
				System.out.print("Objective");
				if (correct) {
					System.out.print(" Sucess: ");
				} else {
					System.out.print(" Failure: ");
				}
				if (decision.equalsIgnoreCase("stopwatch") || decision.equalsIgnoreCase("1")) {
					System.out.println("Alfred Von Tungsten's stopwatch");
				} else if (decision.equalsIgnoreCase("sculpture") || decision.equalsIgnoreCase("2")) {
					System.out.println("Winged Sculpture of Ancient Zyensberg");
				} else { // If there is no objective made
					System.out.println("Failed");
				}
				sleep(800);
				System.out.println("Score: " + totalPoints); // Takes scoring

				// Max possible points is: L1 = (Size 3 - 10) 290, L2 = (Size 4 - 10) 390, L3 -
				// (Size 5/6 - 10) 590
				// 1270 (most difficult option + first try)
				sleep(800);
				System.out.print("Grade: ");
				if (totalPoints >= 1270) { // Max
					System.out.println("S");
				} else if (totalPoints >= 800) {
					System.out.println("A");
				} else if (totalPoints >= 500) {
					System.out.println("B");
				} else if (totalPoints >= 100) {
					System.out.println("C");
				} else if (totalPoints == 0) {
					System.out.println("F");
				} else { // Between 0-100
					System.out.println("D");
				}

				System.out.println("<continue to main menu>");
				input.nextLine();

			} else if (mainMenu.equals("2")) { // Path 2: Custom Game - They input how long the code is, we generate it,
												// they break it
				invalidInput = false;

				screenClear();
				System.out.println("Welcome to the Custom Game.");
				System.out.println("The number of tries are based on how many letters you have.");
				// Checks how long the game should be
				System.out.println(
						"The number of unqiue keys (no duplicates) will be based on the length");
				System.out.println(" of the key (based on the alphabet, up to 26)");
				do {
					System.out.print("Please input how long you would like the game to be: ");
					gameSize = input.nextInt();
				} while (gameSize < 2 || gameSize > 26);
				char[] answer = new char[gameSize];

				// Creates all choices
				int[] answerChoices = new int[gameSize];
				for (int i = 0; i < gameSize; i++) {
					answerChoices[i] = i + 65; // Numbers equal to letters
				}

				// Fills the answer key randomly and uniquely
				int random;
				for (int i = 0; i < gameSize; i++) {
					do {
						random = rand.nextInt(gameSize);
						answer[i] = (char) answerChoices[random];
					} while (answerChoices[random] == 0);
					answerChoices[random] = 0; // Resets it to 0
				}
				input.nextLine();

				// To allow repetition until word is found
				tries = gameSize - 1; // Reactive based on how long the guy should be
				triesUsed = 0;
				do {
					// To display answer possibilities
					displayAnswer(gameSize);

					// Makes user guess a valid sized answer
					invalidInput = false;
					guess = userInput(tries, invalidInput, gameSize, guess);

					// Checks if they are correct or not; by putting both into an array
					char[] guessCheck = guess.toCharArray();
					resultKey();

					// Checks each character and provides appropriate feedback
					result = answerChecker(answer, guessCheck);
					System.out.println("Previous Attempt Results: " + result);
					correct = true;
					// Checks if it's correct as a whole
					for (int i = 0; i < gameSize; i++) {
						if (answer[i] != guessCheck[i]) { // One instance of not being correct, shows that it's all
															// incorrect
							correct = false;
						}
					}

					tries--; // Deducts one try
					triesUsed++;
				} while (correct == false && tries > 0);

				// Feedback for if the user got it or not
				if (correct) {
					System.out.println("******************************************************");
					System.out.print("\nYou got the answer in " + triesUsed + " tries! <continue>");
				} else {
					System.out.println("******************************************************");
					System.out.print("\nAw, I'm sure you nearly had it. Let's try again! <continue>");
				}
				input.nextLine();

			} else if (mainMenu.equals("3")) { // Path 3: Tutorial
				invalidInput = false;
				tutorial();

			} else if (mainMenu.equalsIgnoreCase("4")) { // Path 4: Images
				invalidInput = false;
				// Allows the user to remain looped to input as many keywords as they would like
				// to
				do {
					leaveSecrets = false;
					screenClear();
					System.out.println("[Secret codes can be found CAPITLIZED throughout Story Mode]");
					System.out.println("Shady Alley Guy: I heard you got the codes. If you got the stuff,");
					System.out.println("\t\tthen I got the stuff too. If you don't, then leave.");
					System.out.println("[Type \"exit\" to leave]");
					System.out.print("Input Here");

					// If the previous input was invalid
					if (invalidInput == true) {
						System.out.print(" (The previous input was invalid): ");
						invalidInput = false;
					} else {
						System.out.print(": ");
						invalidInput = false;
					}

					code = input.nextLine();

					// Checks for valid keyword
					if (code.equalsIgnoreCase("alfred") || code.equalsIgnoreCase("flyaway")
							|| code.equalsIgnoreCase("olivia")) { // If valid, goes to method
						secretImages(code);
					} else if (code.equalsIgnoreCase("exit")) { // If they want to leave, they can leave
						leaveSecrets = true;
					} else { // If they put a bad answer
						invalidInput = true;
					}
				} while (leaveSecrets == false);

			} else if (mainMenu.equalsIgnoreCase("exit") || mainMenu.equalsIgnoreCase("5")) {
				// If they said to quit, there will be a confirmation
				exitMenu = "";
				invalidInput = false;
				do {
					screenClear();
					System.out.print("Are you sure you want to quit?");

					System.out.println("\n➤ Yes");
					System.out.println("➤ No");
					System.out.print("Input here");

					// Tells the user if the previous answer was too long
					if (invalidInput) {
						System.out.print(" [Previous input was invalid]: ");
					} else {
						System.out.print(": ");
					}
					exitMenu = input.nextLine();
					if (exitMenu.equalsIgnoreCase("yes") == false || exitMenu.equalsIgnoreCase("no") == false) {
						invalidInput = true;
					}

				} while (exitMenu.equalsIgnoreCase("yes") == false && exitMenu.equalsIgnoreCase("no") == false);
				if (exitMenu.equalsIgnoreCase("yes")) {
					invalidInput = false;
					exit = true;
				} else { // If no, returns to menu
					invalidInput = false;
				}

			} else if (mainMenu.equals("1") == false && mainMenu.equals("2") == false && mainMenu.equals("3") == false
					&& mainMenu.equals("4") == false && mainMenu.equals("5") == false
					&& mainMenu.equals("exit") == false) { // Invalid input (skips if user is coming back from secret
															// options)
				invalidInput = true;
			}
		} while (exit == false);

		screenClear();
		System.out.println("<Shady Alley Guy> See you another day!");
		invalidInput = false;

	}

	/*
	 * Displays the result keys for the game Pre: Does not require any parameters to
	 * be imported Post: Does not return anything to main, only prints
	 */
	public static void resultKey() {
		System.out.println("\n\n******************************************************");
		System.out.println("✓ means it is correct and in the correct spot.");
		System.out.println("? means it is correct but not in the correct spot.");
		System.out.println("✗ means it is incorrect.");
		System.out.println("******************************************************");
	}

	/*
	 * Checks the answer Pre: Is called when the user input a valid-lengthed answer
	 * and needs to be checked Post: Returns a string value with an identifying
	 * symbol
	 */
	public static String answerChecker(char[] answer, char[] guessCheck) {
		String result = "";

		// Check if it's inside the list at all to produce a feedback
		for (int i = 0; i < answer.length; i++) {
			boolean wrongSpot = false;
			// Checks for if the letter is within the answers
			for (int j = 0; j < answer.length; j++) {
				if (guessCheck[i] == answer[j]) { // Only needs one instance of match
					wrongSpot = true;
				}
			}

			if (answer[i] == guessCheck[i]) { // Correct letter, correct spot
				result = result + "✓";
			} else if (wrongSpot) {
				result = result + "?";
			} else {
				result = result + "✗";
			}
		}

		return result;
	}

	/*
	 * Checks if the user has a valid guess (in size) Pre: the number of tries,
	 * valid input check, size of game, and previous variable for string Post:
	 * returns a valid guess
	 */
	public static String userInput(int tries, boolean invalidInput, int gameSize, String guess) {
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("\nGuess the combination in one line (" + tries + " tries left)");

			// Tells the user if the previous answer was too long
			if (invalidInput) {
				System.out.print(" [Previous input was invalid]: ");
			} else {
				System.out.print(": ");
			}
			guess = input.nextLine();
			guess = guess.trim();
			guess = guess.toUpperCase();

			if (guess.length() != gameSize) {
				invalidInput = true;
			} else {
				invalidInput = false;
			}

		} while (guess.length() != gameSize);

		return guess;
	}

	/*
	 * Sleep function Pre: Does not need any input, just to be called on Post:
	 * Returns nothing to main, delays time
	 */
	public static void sleep(long millis) {
		try { // Try and Catch; (Try - tries to use the block of code and checks for errors,
				// if there is an error. Then catch will ensure there are no breaks.
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Produces the tutorial for the user to read Pre: Nothing is brought in the
	 * parameters, can be activated during Story Mode or Tutorial Post: Returns
	 * nothing to main, only displays
	 */
	public static void tutorial() {
		Scanner input = new Scanner(System.in);
		screenClear();
		System.out.println("\t\tTutorial");
		System.out.println("\t       **********");
		System.out.print("Story Mode...<continue>");
		input.nextLine();
		System.out.println("During story mode, you will be given choices on your journey to success.");
		System.out.print("Choose your path wisely, your choices and decisions will be judged. <continue>");
		input.nextLine();
		System.out.println("Puzzle: Similiarly to Wordle, your goal is to both identify the correct");
		System.out.print("but also in what order they are. <continue>");
		input.nextLine();
		System.out.println("\nYou, the main character, will be given a futuristic handheld key-making tool");
		System.out.println("create keys and tools on the go.");
		System.out.print("Use this to create the perfect keys and break in for the objectives. <continue>");
		input.nextLine();
		System.out.println("\nExample...");
		System.out.println("Given the letters, A B C D , each letter represents a different height in a key pattern.");
		System.out.print("You will make your guess (reorganize to find the correct pattern)...\n");
		System.out.print("Input Here: DCBA <continue>");
		input.nextLine();
		System.out.println("The number of tries is determined by the length of the game.");
		System.out.println("and then you'll see the results based on the following Results Key. <continue>");
		input.nextLine();

		resultKey();
		System.out.print("<continue>");
		input.nextLine();

		System.out.println("Keep going until you're out of tries or you get the right answer!");
		System.out.print("Good luck! <continue>");
		input.nextLine();
	}

	/*
	 * Clears the display screen Pre: No input is needed, just to be called Post:
	 * Returns nothing to main, just displays
	 */
	public static void screenClear() {
		System.out.print(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	/*
	 * Displays the possible answers Pre: Requires the size of the game Post:
	 * Returns nothing to main, displays the answer possibilities to the user
	 */
	public static void displayAnswer(int gameSize) {
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		System.out.println("\nYour possible non-duplicates keylengths are letters from: A (shortest) to "
				+ (char) (gameSize + 64) + " (longest)");
		System.out.print("\t\t\t\t\t\t\t (");
		for (int i = 0; i < gameSize; i++) {
			System.out.print((char) (65 + i));
			if (i != gameSize - 1) {
				System.out.print(" ");
			}
		}
		System.out.print(")");
	}

	/*
	 * Produces an appropriate image response in the secrets tab Pre: Valid keyword
	 * (from a select few), comes from only the secrets tab Post: Produces an image,
	 * but does not return anything to the main
	 */
	public static void secretImages(String code) {
		Scanner input = new Scanner(System.in);

		if (code.equalsIgnoreCase("Alfred")) {
			System.out.println(
					"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nShady Alley Guy: Many have found that. But here's the key. Alfred's key to the vault.");
			System.out.println("Shady Alley Guy: Seek carefully, the key is only the easiest part.");
			System.out.print("*hands you the key* <continue>");
			input.nextLine();
			System.out.print("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%*             ,%%%@@@@@@@@@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%   **,.....,,,,,,,**,..(%@@@@@@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@%, .*.........,,,,,(%%#*****.,%&@@@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@@@%( .*..........,,,%#@@@@@@@%****,,%@@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@@%  *...........,,,(&@@@@@@@@@%**,**,%&@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@%, *..........,,,,,,%@@@@@@@@##,,,,**,%%@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@&% ,*.........,,,,,,,,/%#@@*%%,,,,,,,,,*%@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@&# *,........,,,,,,,,,,,,,,,,,,,....,,,,%@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@&% ,*........,,,, Alfred's ,,.......,.,,%@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@%. *................ Key ..........,*,%%@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@@%. *..........................  ,,*,/%@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@@@&%   *,..................      ., ,,%%@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@@&%  ,, # *,..........          ,, ,,(%@@@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@@@%  ,, #%% ,,.,,. .....   ..... .,,,%%@@@@@@@@\n"
					+ "@@@@@@@@@@@@@@@@@@%. ,, (#% ,,,,, (#,..,,*,,,,,,,,,%%&@@@@@@@@@@@\n"
					+ "@@@@@@@@@@@@@@@@%, ,, (#% ,,,,, (#% ,*%%%%%%%%%&@@@@@@@@@@@@@@@@@\n"
					+ "@@@@@@@@@@@@@@%* ., (#% ,,,,, (#% ,,%@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@@@@@@@@@@%( ., (#%.,,,,, (#%.,,%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@@@@@@@@%# ., (#%.,,,,,#%@@@@%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@@@@@@%#  , (#%.,***,(%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@@@@%%  , (#%,,*%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@@%%  , /#%*.*%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@%  ,.*#%/.***%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
					+ "@@@%(.*#%(.****%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ <continue>\n"
					+ "@@@@%(%(.(%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			input.nextLine();

		} else if (code.equalsIgnoreCase("flyaway")) {
			System.out.println(
					"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nShady Alley Guy: Oh? Interesting. All I will say is. The messenger has flown. Notre-Dame, Paris.");
			System.out.println("Shady Alley Guy: You'll know what you're looking for when you see it.");
			System.out.println("*hands you a scroll* <continue>");
			input.nextLine();
			System.out.print("                                                                 \n"
					+ "                                                                 \n"
					+ "                                                                 \n"
					+ "                                                                 \n"
					+ "                      *,.%@(%*%&&&*                              \n"
					+ "                         .%&&%%%%%//                             \n"
					+ "                          *(**////////,                          \n"
					+ "                          /((/////////((/.                       \n"
					+ "                         *##/(#%#(#(*//*///,                     \n"
					+ "                         ,/%#(#(#/((/(#####*/(                   \n"
					+ "                          /((#%/#%%#((#/###%%/,(                 \n"
					+ "                           *((((#&%#//#%(//##%(/*,               \n"
					+ "                              ####%%&%%####(##(((((/,            \n"
					+ "                                  .#(%#((((#(/ /#%%%##(*         \n"
					+ "           .,.,(*(%,..#*,,/*(**(/. *.%%#             ##%##(      \n"
					+ "     .*,,/(#//,/#*/*/(,*(%(,**//#%@&@%%%%/#%%(*.         %%%%#(  \n"
					+ "#*,./#./(/*,&*((//(./%//((#/(/(#@@@@@&@&&&&%&&@&&%(%%#**         \n"
					+ "%#&%(&#//*((/(#@&%#%(%%#&&%#@%&@#   /@@&@&&&@&@@@&&&%%((#%,      \n"
					+ "%#&(&(**###&%&&@@,                                     <continue> \n"
					+ "      @%@@.                                                      ");
			input.nextLine();
		} else if (code.equalsIgnoreCase("olivia")) {

			System.out.println(
					"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nShady Alley Guy: Olivia. I babysat for her when she was just a child. She gave tried giving this picture to his father but her father tossed it.");
			System.out.println(
					"Shady Alley Guy: If you ever find Olivia. Give this to her. Her family may be rich, but love and care was never there for her.");
			System.out.print("*hands you a picture of Olivia and her father* <continue>");
			input.nextLine();
			System.out.println("                                                                 \n"
					+ "    %  %%%% ./                                                   \n"
					+ "                                                                 \n"
					+ "                  &   &                       &*  &              \n"
					+ "                &      &                    & &   . &            \n"
					+ "               &        &                & &&       & &          \n"
					+ "               &     , (              &     &&&  &&& ,           \n"
					+ "           &     &   &,    &             &                       \n"
					+ "              %    &    &                   &&& (&&/             \n"
					+ "                  &&&*                        &                  \n"
					+ "                   &                          %                  \n"
					+ "                   &                                             \n"
					+ "                   %                        &  &                 \n"
					+ "                                          &                      \n"
					+ "                    &                   &         &              \n"
					+ "                 &   &                     # #%##                \n"
					+ "               &      &                                          \n"
					+ "              &        &                  &       &              \n"
					+ "            &&         #&                 .        &             \n"
					+ "                                                      <continue> \n"
					+ "                                                                 ");

			input.nextLine();
		}

	}

	public static void images(int imageNum) {
		if (imageNum == 1) {
			System.out.println("                                                                 \n"
					+ "                          .((((((((((,                           \n"
					+ "                    ,((((,,,,,,,,,,,,,,,(((((.                   \n"
					+ "                  ((/*,,,,,,,,,,,,,,,,,,.....*((                 \n"
					+ "                /((***,,,,/(((((/((((((,.......*((               \n"
					+ "                ((****,,(((            ((.......((               \n"
					+ "               .(/****,,(/              ((......((               \n"
					+ "               .(/****,,(/   Broken     ((......((               \n"
					+ "               .//****,,(/     Locks    ((....../(               \n"
					+ "               .(/****,,(/              ((......((               \n"
					+ "               .(/****,,(/              ((......((               \n"
					+ "             ((((((((((((((((((((((((((((((((((((((((            \n"
					+ "            ((     .................................((           \n"
					+ "            ((   .//////////////////////////////..,,((           \n"
					+ "            (( ...............(%%%%..............,,,((           \n"
					+ "            ((..../////////.%%%%%%%%%(./////////,,,,((           \n"
					+ "            ((....////////*.##%%%%%%##.......,.,,,,,((           \n"
					+ "            ((...............###%%###......,,,,,,,,,((           \n"
					+ "            ((..../////////...((%%((.../////////,,,,((           \n"
					+ "            ((................//%%//...,,,,,,,,,,,,,((           \n"
					+ "            ((..../////////...//////,,,/////////,,,,((           \n"
					+ "            ((....//////////////////////////////,,,,((           \n"
					+ "            ((..................,,,,,,,,,,,,,,,,,,,,((           \n"
					+ "            ((....//////////////////////////////,,,,((           \n"
					+ "            ((..............,,,,,,,,,,,,,,,,,,,,,,,,((           \n"
					+ "             /((((((((((((((((((((((((((((((((((((((,            ");

			System.out.print("\t\t\t\t   <continue>");
		} else if (imageNum == 2) {
			System.out.print("                                                                 \n"
					+ "                            (&&@@&&&%(                           \n"
					+ "                         #&**..    ..,*%#                        \n"
					+ "                        /&..           . ,.                      \n"
					+ "                       (#(. ..%#%,*#%.  (&*.                     \n"
					+ "                       ,#(. ,.%#%,/%%.  *#*.                     \n"
					+ "                       .,#%...%,%(%%.. %&/.                      \n"
					+ "                         .,/%## %(&%%%@#                         \n"
					+ "                            ..#/#*&#..                           \n"
					+ "               ,/&%..     (%*(#.%(@@#(%#                         \n"
					+ "                ..*%%*,&#####/(////#/(/#(&*/(%                   \n"
					+ "                 //%#(/*(,#.,..(.,,(,*%*/(#(*#.               \n"
					+ "              %,%&*,/*.#,,,,,(,(.,,*,*,.,,#/*#**%.            \n"
					+ "            %,%//@,...//*.,....(/,,(*,.,%,,,.,#(%*%           \n"
					+ "           ,%#*#//.........,..,%,,%,*.,,,..... ,(&/(.         \n"
					+ "          ,&///,.@*.,(...%..,.,@@,,*,,%,,,,@..,././#/,        \n"
					+ "         ,#*/%,......,...,&*,.,.,,*,*,.,,,,,,,,,.##(/#.       \n"
					+ "        ,,/# *,...........(,/..,@,/.*,,,,,,,,,,,,(,*#/&.      \n"
					+ "        ,,,* ,.(@@@,.....,..,,.@&(,,,,,,,,,,@@.,./////&.      \n"
					+ "       .,**( ,,.&,@.....,,,,,,,@(/,,,,,,,,,,.,.,,**/%/&.      \n"
					+ "        ,,/*.,*......,,,,,,, Alfred's ,,,,,,,,,,.&,*#(&.      \n"
					+ "        .*&//%...&,#...,,,,,*@, Stopwatch ,,@@%(.,,///#.       \n"
					+ "         .*#(/#,...@(...,,,,.,,,,,,,,,,,,(/.#,,%*/(/(/.       \n"
					+ "          .*%((*/,.,,.,..,,,,,,,,,,,,,,,,,,,,.,,(%*(,.        \n"
					+ "           .#*&//*,..,,.@. .,,,,,,,,,@.,.,,/,*./#//(.          \n"
					+ "             .#*&/**/#.@,,,,,,,@/,.,,,,,.@((.*/#*/%..           \n"
					+ "               .***%%#(,*/,/,,,.,,,,*.*@,./%#**((.              \n"
					+ "                  ..#**#%#(/////(/(//(&#&***(,.           <continue> \n"
					+ "                      .../&***********/#/..                      \n"
					+ "                                                                 ");
		} else if (imageNum == 3) {
			System.out.println("   .                                                             \n"
					+ "                                                                .\n"
					+ "  %%*                                                       ,#.  \n"
					+ "      ##(*                                              (%%#     \n"
					+ "        #(/@/*//,                               ((#%#%%(%#%      \n"
					+ " .         ,#((((#/(#(##/*       ##(*       %%#%#(##((#/         \n"
					+ " .. . . ..   .   #/(((#(.(#%#   .&&&%    %##((##(((#             \n"
					+ "................ .%#(/,##%&%**#&%&%##(%####(#&#((%/.             \n"
					+ "....................@#.,,%..#*/*(//%#%((##(#(/(##(*              \n"
					+ ".......................&##(,**@#&@%&&@&&%#(((((((,               \n"
					+ ".........................#((( ,,.*%##&&/%&/#(%.                  \n"
					+ "........................#*(/////(%,#%&@###%(#(* .................\n"
					+ ",,,,,,,,,,,,,,,,,.,.....&(*#,#//@%(%#&%%(@#%##/..................\n"
					+ ",,,,,,,,,,,,,,,,,,,,,,,,&(##,/,,/@(#@&#%(/%(&#(*.................\n"
					+ ",,,,,,,,,,,,,,,,,,,,,,,##(((&,,,,&#*,&#,,,#%%%###,,,,,,,,,,,,,,,,\n"
					+ "*********************#/(#%*,,*,,*##*,%(*,,,,,%&%&%,,,,,,,,,,,****\n"
					+ "*******************(((#***********(#*,%***********&&(************\n"
					+ "*////*//////////##(/////////////**&#,&&/***************&*/**/*///\n"
					+ "///////////////(//// Winged Sculpture of Ancient Zyensberg ///////\n"
					+ "//////((((((((((((((((((((//////#&%%%%/((**/////////////////(/(((\n"
					+ "((((((((((((((((((((((((((((((/&&%##%%#((((((((((((((((((((((((((\n"
					+ "(((((((((((((((((((((((((((((%&%&%%%&%%*((,#/((/(((((((((((((((((\n"
					+ "(((((((((((((((((((((###(#####%%%%%%//(##((*((((##(((((\n"
					+ "(((((((((((((((((((#####%%#%%#%#%%%/#(###(#((,/###(((## <continue>\n"
					+ "#########(##################%%&%%#(#&&@&%##############");
		}

	}
}