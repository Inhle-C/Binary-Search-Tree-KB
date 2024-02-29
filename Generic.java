
/**
 * Class to hold the statements and the confidence score of the statements for a specific term
 * 
 * @author Inhle Cele
 * @since 25/02/2024 
*/
public class Generic 
{
	/**
	 * Holds the term/word
	 */
	
	/**
	 * The sentence or statement associated with the term
	 */
	private String term, sentence;
	/**
	 * The score in between 0 to 1 showing how confident we are in the statement, where 1 represents complete confidence
	 */
	private double confidence;

	/**
	 * default constructor for Generic class where the term and statement are empty and the confidence score is zero
	 */
	public Generic() 
	{
		term= null;
		sentence= null;
		confidence=0;
	}
	
	/**
	 * Constructor that takes given term, sentence and confidence score and constructs a Object
	 * @param t term
	 * @param s sentence
	 * @param c confidence score
	 */
	public Generic(String t, String s, String c)
	{
		term= t;
		sentence= s;
		confidence= Double.parseDouble(c);
	}
	
	/**
	 * returns confidence score of the object
	 * @return confidence score of the statement
	 */
	public double getConfidence() {
		return confidence;
	}
	
	/**
	 * returns sentence/statement associated with the term of the object
	 * @return statement of term
	 */
	public String getSentence() {
		return sentence;
	}
	
	/**
	 * returns the term of the object
	 * @return term of object
	 */
	public String getTerm() {
		return term;
	}
	
	/**
	 * Sets the confidence score of the statement
	 * @param confidnece the given confidence score
	 */
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	
	/**
	 * Sets the sentence for the term
	 * @param sentence the given sentence score
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	/**
	 * Sets the term of the object
	 * @param term the given term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	@Override
	/**
	 * returns the term, sentence and confidence score as a string output
	 * @return the data in the object in the format: Term\tSentence\tConfidence_score
	 */
		public String toString() {
			return (term + "\t" +sentence + " \t" + confidence);
		}
}
