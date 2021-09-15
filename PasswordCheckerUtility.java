import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 
public class PasswordCheckerUtility {

  
  public static boolean isValidPassword(String passwordString)
      throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException,
      NoSpecialCharacterException, InvalidSequenceException {
    return isLongEnough(passwordString) && hasUpperCase(passwordString)
        && hasLowerCase(passwordString) && hasDigit(passwordString)
        && hasSpecialCharacter(passwordString) && hasValidSequence(passwordString);
  }

  
  private static boolean isLongEnough(String passwordString) {
    if (passwordString.length() >= 6) {
      return true;
    } else {
      throw new LengthException();
    }
  }

  
  private static boolean hasDigit(String passwordString) {
    for (Character h : passwordString.toCharArray()) {
      if (Character.isDigit(h)) {
        return true;
      }
    }
    throw new NoDigitException();
  }

  public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
	  ArrayList<String> invalidPasswords = new ArrayList<>();
	    for (String e : passwords) {
	  try {
	  isValidPassword(e);
	     } catch (Exception ex) {
	        invalidPasswords.add(e + " " + ex.getMessage());
	   }
	  }
	    return invalidPasswords;
	  }
  private static boolean hasLowerCase(String passwordString) {
    for (Character c : passwordString.toCharArray()) {
 if (Character.isLowerCase(c)) {
        return true;
   }
    }
    throw new NoLowerAlphaException();
  }


  public static boolean isWeakPassword(String passwordString) {
	    return isValidPassword(passwordString) && (passwordString.length() < 10);
	  }
  
  private static boolean hasSpecialCharacter(String passwordString) {
    Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
    Matcher match = pattern.matcher(passwordString);
    if (!match.find()) {
      throw new NoSpecialCharacterException();
    }
    return true;
  }
  
  
  private static boolean hasValidSequence(String passwordString) {
  for (int i = 0; i < passwordString.length() - 2; i++) {
      if (passwordString.charAt(i) == passwordString.charAt(i + 1)) {
   if (passwordString.charAt(i + 1) == passwordString.charAt(i + 2)) {
      throw new InvalidSequenceException();
        }
      }
    }
    return true;
  }
  
  
  private static boolean hasUpperCase(String passwordString) {
	    for (Character c : passwordString.toCharArray()) {
 if (Character.isUpperCase(c)) {
	        return true;
	      }
	 }
	    throw new NoUpperAlphaException();
	  }


}