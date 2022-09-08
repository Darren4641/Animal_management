package com.Animal;

public enum Query {

	INSERT("INSERT INTO `animal`.`animaluser`" + 
			"(`name`, `birth`,`kind`,`category`,`owner`,`ownerPhone`, `createDate`)" + 
			"VALUES(?,?,?,?,?,?,?)"),
	
	SELECTID("SELECT " + 
			"`animaluser`.`id`," + 
			"`animaluser`.`name`," + 
			"`animaluser`.`birth`," + 
			"`animaluser`.`kind`," + 
			"`animaluser`.`category`," + 
			"`animaluser`.`owner`," + 
			"`animaluser`.`ownerPhone`," +
			"`animaluser`.`createDate`" +
			"FROM `animal`.`animaluser` WHERE `animaluser`.`id` = ?"),
	
	SELECTALL("SELECT " + 
			"`animaluser`.`id`," + 
			"`animaluser`.`name`," + 
			"`animaluser`.`birth`," + 
			"`animaluser`.`kind`," + 
			"`animaluser`.`category`," + 
			"`animaluser`.`owner`," + 
			"`animaluser`.`ownerPhone`," + 
			"`animaluser`.`createDate`" +
			"FROM `animal`.`animaluser` order by `animaluser`.`createDate` desc"),
	
	SEARCH("SELECT " + 
			"`animaluser`.`id`," + 
			"`animaluser`.`name`," + 
			"`animaluser`.`birth`," + 
			"`animaluser`.`kind`," + 
			"`animaluser`.`category`," + 
			"`animaluser`.`owner`," + 
			"`animaluser`.`ownerPhone`," +
			"`animaluser`.`createDate`" +
			"FROM `animal`.`animaluser` WHERE `animaluser`.`name` like ? order by `animaluser`.`createDate` desc"),
	
	ORDERBYNAME("SELECT " + 
			"`animaluser`.`id`," + 
			"`animaluser`.`name`," + 
			"`animaluser`.`birth`," + 
			"`animaluser`.`kind`," + 
			"`animaluser`.`category`," + 
			"`animaluser`.`owner`," + 
			"`animaluser`.`ownerPhone`," + 
			"`animaluser`.`createDate`" +
			"FROM `animal`.`animaluser` order by `animaluser`.`name` asc"),
	
	ORDERBYOWNER("SELECT " + 
			"`animaluser`.`id`," + 
			"`animaluser`.`name`," + 
			"`animaluser`.`birth`," + 
			"`animaluser`.`kind`," + 
			"`animaluser`.`category`," + 
			"`animaluser`.`owner`," + 
			"`animaluser`.`ownerPhone`," + 
			"`animaluser`.`createDate`" +
			"FROM `animal`.`animaluser` order by `animaluser`.`owner` asc");
	
	private String value;
	
	public String getValue() {
		return value;
	}
	
	private Query(String value) {
		this.value = value;
	}
	
}
