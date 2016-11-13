package bowling;

public class SplitHappens {

	public static void main(String[] args) {
		if(args.length != 1) {
			return;
		}
		
		String game = null;
		char[] gameArray = null;
		int totalScore = 0;
		
		game = args[0];
		gameArray = game.toCharArray();

		for(int i = 0; i < determineLastNormalRoll(gameArray); i++) {
			char c = gameArray[i];
			int rollScore = 0;
			switch(c) {
				case '/':
					rollScore = 10 - getActualPoints(gameArray[i-1]) + getActualPoints(gameArray[i+1]);
					break;
				case 'X':
					if(gameArray[i+2] == '/') {
						rollScore = 20;
					} else {
						rollScore = 10 + getActualPoints(gameArray[i+1]) + getActualPoints(gameArray[i+2]);
					}
					break;
				default:
					rollScore = getActualPoints(c);
					break;
			}
			totalScore = totalScore + rollScore;	
		}
		
		System.out.println("Total Score: " + totalScore);

	}
	
	static private int getActualPoints(char c) {
		switch(c) {
			case '-':
				return 0;
			case '/':
			case 'X':
				return 10;
			default:
				return Integer.parseInt(String.valueOf(c));
		}
	}
	
	static private int determineLastNormalRoll(char[] gameArray) {
		if(gameArray[gameArray.length - 3] == 'X') {
			return gameArray.length - 2;
		}
		if(gameArray[gameArray.length - 2] == '/') {
			return gameArray.length - 1;
		}
		return gameArray.length;
	}

}
