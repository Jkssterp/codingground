/** Question :???
 * 100 people standing in a circle in an order 1 to 100.
 * No. 1 has a sword. He kills next person (i.e. no. 2) and gives sword to next to next (i.e no. 3).
 * All person does the same until only 1 survives.
 * Which number survives at the last?
 * Answer : 73
 * */

/**
 * What is JospehusProblem - http://en.wikipedia.org/wiki/Josephus_problem
 * */
 
public class JospehusProblem {
	public static void main(String[] args) throws java.lang.Exception {
		int N = 100;
		boolean[] deadArr = new boolean[N];
		int deadCount = 0;
		int swordHolder = 0;
		while (deadCount < N - 1) {
			// kill next alive
			int next = (swordHolder + 1) % N;
			while (deadArr[next]) {
				// chk next
				next = (next + 1) % N;
			}
			// kill him
			deadArr[next] = true;
			deadCount++;
			
			swordHolder = (swordHolder + 2) % N;
			while (deadArr[swordHolder]) {
				swordHolder = (swordHolder + 1) % N;
			}
		}
		System.out.println("Last sword holder(0 indexed)is : " + swordHolder+ " position i.e., person left alive is : "+ (swordHolder + 1));
	}
}
