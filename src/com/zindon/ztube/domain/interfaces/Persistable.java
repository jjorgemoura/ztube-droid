package com.zindon.ztube.domain.interfaces;


/**
 * This Interface define the required methods necessary to persist data entities into the persistence layer.
 * So far, this Interface is not needed because this version don't use DB yet.
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
     * This method refresh the data from de database into the entity.
     */
    public void refresh();
    
    /**
     * This method updates all changes made into this object to the database.
     * 
     */
    public void update();
       
    /**
     * This method remove the entity data from the persistence layer. This will not remove data from the instance entity.
     */
    public void disablePersistance();
}
