package coding_challenge.books.exception;

public class InvalidIdException extends Exception{
	private String message;

	public InvalidIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
