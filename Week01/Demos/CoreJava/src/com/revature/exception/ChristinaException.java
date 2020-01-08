package com.revature.exception;

/*
 * We can create our own exceptions by simply extending the Exception
 * class. If you want to create a RuntimeException, you need onlh
 * extend RuntimeException.
 */
public class ChristinaException extends Exception {

	// Only here to get rid of an annoying warning.
	private static final long serialVersionUID = 1L;

	/*
	 * One way of handling an exception is to throw it using the "throws" keyword.
	 * The "throws" keyword is used here to denote that the ChristinaException might
	 * be thrown in this method.
	 */
	public static void main(String[] args) /* throws ChristinaException */ {

		/*
		 * Using an exception is as simply as, well, throwing it. So let's throw a
		 * Christina exception.
		 * 
		 * Now let's handle the ChristinaException by using a try-catch block. We can
		 * optionally use a finally block as well.
		 * 
		 * You can use a try-finally combination, a try-catch with as
		 * many catches as you want, or of course all three (a try, catch,
		 * and finally).
		 */

		try {
			throw new ChristinaException();
		}
// Make sure that you catch exceptions from the most specific to the least
// or you'll have unreachable code, and it won't compile.
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		catch (ChristinaException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			/*
			 * This is a finally block. It is optional, but it is good
			 * practice to use it if there is something that should always
			 * occur as the finally block always executes UNLESS 1 of 2 things
			 * happens:
			 * 
			 * System.exit is invoked.
			 * 
			 * OR
			 * 
			 * An unrecoverable error occurs.
			 */
		}
	}

}
