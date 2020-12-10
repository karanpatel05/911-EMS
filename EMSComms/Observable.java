
/**
 * This is Observable Interface which has few methods .
 *
 * @author (KaranKumar patel)
 * @version (06-15-2020)
 */
public interface Observable
{
   public  void registerObserver();
    

   public  void removeObserver();
    

   public  void notifyObservers();
    
}
