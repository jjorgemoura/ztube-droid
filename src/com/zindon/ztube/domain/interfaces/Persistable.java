package com.zindon.ztube.domain.interfaces;


/**
 * 
 * @author jorge
 *
 */
public interface Persistable {

	/**
     * This method persist the object into the database. Must be called only when this object is first saved to the Database. 
     * After the object was saved, each update must be persisted via the method refresh.
     * 
     */
    public void enablePersistance();
    
    /**
     * 
     */
    public void refresh();
    
    /**
     * This method updates all changes made into this object to the database.
     * 
     */
    public void update();
       
    /**
     * 
     */
    public void disablePersistance();
}
