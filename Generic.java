package Assignment1;

/* Class to hold the statements and the confidence of the statements
 * 25/02/2024 
 * Inhle Cele
*/
public class Generic 
{
	private String term, sentence;
	private double confidence;

	public Generic() 
	{
		term= null;
		sentence= null;
		confidence=0;
	}
	
	public Generic(String t, String s, String c)
	{
		term= t;
		sentence= s;
		confidence= Double.parseDouble(c);
	}
	
	public double getConfidence() {
		return confidence;
	}
	
	public String getSentence() {
		return sentence;
	}
	
	public String getTerm() {
		return term;
	}
	
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	@Override
		public String toString() {
			return (term + "\t" +sentence + " \t" + confidence);
		}
}
