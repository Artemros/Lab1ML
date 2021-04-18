package example;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Recognizer recognizer = new Recognizer();
        Generator generator = new Generator();
        boolean globalFlag = true;
        Scanner in = new Scanner(System.in);
        while (globalFlag) {
            boolean flagLengthGenerator = true;
            boolean flagLengthRecognizer = true;
            boolean flagRecognizerSequence = true;
            if (globalFlag) {
                System.out.println("Choose how to use program: ");
                System.out.println("0 - Use generator.");
                System.out.println("1 - Use recognizer. ");
                System.out.println("Or type 'q' to end program ");
                boolean flagAnswer = true;
                int answer = 0;
                while (flagAnswer) {
                    String s = in.nextLine();
                    String toCheck = StringUtils.substringBefore(s, " ");
                    if (toCheck.matches("\\d+")) {
                        int gotAnswer = Integer.parseInt(toCheck);
                        if (gotAnswer < 0 || gotAnswer > 1) {
                            System.out.println("Wrong input of chose how to create initial line. Out of range.");
                        } else {
                            answer = gotAnswer;
                            flagAnswer = false;
                        }
                    } else {
                        if (toCheck.toLowerCase().equals("q")) {
                            flagAnswer = false;
                            globalFlag = false;
                        } else {
                            System.out.println("Wrong input of chose how to use program.");
                        }
                    }
                }
                if (globalFlag) {
                    if (answer == 0) {
                        int length = 0;
                        while (flagLengthGenerator) {
                            System.out.println("Enter length for generator.");
                            System.out.println("Or enter q to end program here.");
                            String s = in.nextLine();
                            String toCheck = StringUtils.substringBefore(s, " ");
                            if (toCheck.matches("\\d+")) {
                                length = Integer.parseInt(toCheck);
                                flagLengthGenerator = false;
                            } else {
                                if (s.toLowerCase().equals("q")) {
                                    globalFlag = false;
                                    flagLengthGenerator = false;
                                } else {
                                    System.out.println("Wrong input of length. Non int symbols in input.");
                                }
                            }
                        }
                        System.out.println("Correct sequence for this length:"+generator.generate(length));
                    } else {
                        int length = 0;
                        while (flagLengthRecognizer) {
                            System.out.println("Enter length for recognizer.");
                            System.out.println("Or enter q to end program here.");
                            String s = in.nextLine();
                            String toCheck = StringUtils.substringBefore(s, " ");
                            if (toCheck.matches("\\d+")) {
                                length = Integer.parseInt(toCheck);
                                flagLengthRecognizer = false;
                            } else {
                                if (s.toLowerCase().equals("q")) {
                                    globalFlag = false;
                                    flagLengthRecognizer = false;
                                } else {
                                    System.out.println("Wrong input of length. Non int symbols in input.");
                                }
                            }
                        }
                        System.out.println("Enter sequence of 0 and 1 with " + length + " length");
                        String sequence = "";
                        while (flagRecognizerSequence) {
                            System.out.println("Enter length for recognizer without spaces.");
                            System.out.println("Or enter q to end program here.");
                            String s = in.nextLine();
                            String toCheck = StringUtils.substringBefore(s, " ");
                            if (toCheck.matches("\\d+")) {
                                if (toCheck.length() != length) {
                                    System.out.println("Wrong input of length. Inputed sequence have wrong length.");
                                } else {
                                    boolean innerFlag = true;
                                    for (int z = 0; z < length; z++) {
                                        int checkZChar = Integer.parseInt(String.valueOf(toCheck.charAt(z)));
                                        if (checkZChar != 0 && checkZChar != 1) {
                                            System.out.println("Wrong input of length. Sequence have to have only 0 and 1 in it.");
                                            innerFlag = false;
                                            break;
                                        }
                                    }
                                    if (innerFlag) {
                                        sequence = toCheck;
                                        flagRecognizerSequence = false;
                                    }
                                }
                            } else {
                                if (s.toLowerCase().equals("q")) {
                                    globalFlag = false;
                                    flagRecognizerSequence = false;
                                } else {
                                    System.out.println("Wrong input of length. Non int symbols in input.");
                                }
                            }
                        }
                        if (recognizer.nextState(length, 0, sequence, 1)) {
                            System.out.println("Your sequence belongs to this language");
                        }else{
                            System.out.println("Your sequence do not belong to this to this language");
                        }
                    }
                }
            }
        }
        System.out.println("Program ended successfully.");
    }
}
