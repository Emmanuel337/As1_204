public class UnmatchedException extends RuntimeException {
  public UnmatchedException() {
    super("The passwords do not match");
  }
}