public interface Clickable {

   void click();

   default void isElementActive(boolean On) throws DisableException {
      if (!On) {
         throw new DisableException();
      }
   }

}
