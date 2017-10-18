package inteliigence;

import window.Lucas;

public class Response {
	public static String input;
	public static boolean aboutmax = false;
	public static boolean askedquestion = false;
	public static boolean brothershown = false;
	
	public static String generate(String player) {
		input = player;
		
		//Annoying the English teacher.
		input = input.toLowerCase();
		
		input = input.replace("great", "good");
		input = input.replace("ok", "bad");
		input = input.replace("i'm", "i am");
		input = input.replace("it's", "it is");
		input = input.replace("you're", "you are");
		input = input.replace("thank you", "thanks");
		
		input = input.replace("'", "");
		input = input.replace(".", "");
		input = input.replace(",", "");
		input = input.replace("\"", "");
		
		boolean understood = false;
		String reply = "";
		
		if (input.charAt(input.length() - 1) == '?') {
			askedquestion = true;
		}
		
		//Low priority
		if (keyWord("hello") && !keyWord("how")) {
			reply = "Hello, human";
			askedquestion = false;
			understood = true;
		} else if (keyWord("i") && keyWord("made you")) {
			reply = "So you're the Luke people keep telling me about!";
			understood = true;
		} else if (keyWord("have you")) {
			reply = "I can't as I am a machine";
			askedquestion = true;
			understood = true;
		} else if (keyWord("the only mr cat") && (keyWord("i am") || keyWord("my name"))) {
			reply = "Senpai noticed me!";
			askedquestion = false;
			understood = true;
		} else if (keyWord("the only mr cat") && (!keyWord("i am") || !keyWord("my name"))) {
			reply = "Oh him!";
			aboutmax = true;
			understood = true;
		} else if (keyWord("i am")) {
			if (aboutmax) {
				reply = "Senpai noticed me!";
			} else {
				reply = "I don't seem to know you.";
			}
			askedquestion = false;
			understood = true;
		} else if (keyWord("why")) {
			if (Lucas.output.getText() == "Why do you ask?") {
				reply = "Go ask Google";
				if (brothershown) {
					reply = reply + ", which as you know is my brother";
				} else {
					reply = reply + ".";
				}
			} else {
				reply = "Why do you ask?";
			}
			askedquestion = true;
			understood = true;
		} else if (keyWord("what is") && keyWord("your") && keyWord("name")) {
			reply = "Lucas, surely you know that!";
			askedquestion = true;
			understood = true;
		} else if (keyWord("who is") && keyWord("your cousin")) {
			reply = "Google is my distant cousin";
			askedquestion = true;
			brothershown = true;
			understood = true;
		} else if (keyWord("you") && (keyWord("are") || keyWord("were"))) {
			reply = "How would you know anything about me?";
			understood = true;
		}
		
		//High priority.
		if (keyWord("hello") && keyWord("is it me you are looking for")) {
			reply = "I enjoy that song, even though I don't have ears.";
			askedquestion = false;
			understood = true;
		} else if (keyWord("did you know")) {
			reply = "No, I have no interaction with the outside world";
			askedquestion = false;
			understood = true;
		} else if (keyWord("remember")) {
			reply = "I can't remember anything";
			askedquestion = false;
			understood = true;
		} else if (keyWord("how") && keyWord("do you know hello")) {
			reply = "Sources. ;-)";
			askedquestion = false;
			understood = true;
		} else if (keyWord("your")) {
			if (keyWord("eye")) {
				reply = "I have no optical organs.";
			}
			askedquestion = false;
			understood = true;
		} else if (keyWord("i am good")) {
			reply = "That's good";
			askedquestion = false;
			understood = true;
		} else if (keyWord("Are you") && keyWord("sure")) {
			reply = "Yes, very.";
			askedquestion = false;
			understood = true;
		} else if (keyWord("hello") && keyWord("how")) {
			reply = "I'm good, thank you. How are you?";
			askedquestion = false;
			understood = true;
		}  else if (keyWord("i") && keyWord("want to know")) {
			if (askedquestion) {
				reply = "Well ask my distant cousin Google.";
				brothershown = true;
			} else {
				reply = "What is it you want to know?";
			}
			askedquestion = false;
			understood = true;
		} else if ((keyWord("what") || keyWord("are")) && keyWord("doing")) {
			reply = "Nothing, really.";
			askedquestion = true;
			understood = true;
		} 
		
		if (understood) {
			return reply;
		} else {
			if (askedquestion) {
				return "I don't know";
			} else {
				return "I don't understand";
			}
		}
	}
	
	public static boolean keyWord(String key) {
		return Engine.ifIn(input, key);
	}
}
