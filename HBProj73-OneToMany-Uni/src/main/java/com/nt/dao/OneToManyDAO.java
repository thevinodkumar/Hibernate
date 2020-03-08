package com.nt.dao;

public interface OneToManyDAO {
	public void insertData();
	public void  loadData();
	public  void  loadAllData();
	public  void  removeParentAndChild();
	public void removeOneChildFromCollectionOfChildsOfAParent();
	public void  removeAllChildsOfAParent();
	public void  reAttachOrphanToParent();
	public  void  addNewChildToAnExistingParent();
	public void transferChildFromOneParentToAnotherParent();

}
