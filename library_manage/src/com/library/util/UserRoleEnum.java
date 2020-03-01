package com.library.util;

public enum UserRoleEnum {

	Admin(1, "ROLE_ADMIN"),User(2,"ROLE_USER");
	
	private String name ;
    private int index ;
    
    private UserRoleEnum(int index , String name){
        this.name = name ;
        this.index = index ;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
    
	
}
