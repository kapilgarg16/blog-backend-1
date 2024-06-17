package com.blogprojectIO.payloads;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//@Entity
//@Table(name = "Categoroes")
public class CategoryDto {
	
	Integer catId;
	
	@NotEmpty
	@Size(min = 3, message = "cat. name should have 3 char")
	String catName;
	
	@NotEmpty
	@Size(min = 6, message = "cat. name should have 6 char")
	String catDesc;

	
	public CategoryDto() {
		super();
	}

	public CategoryDto(Integer catId, @NotEmpty @Size(min = 3, message = "cat. name should have 3 char") String catName,
			@NotEmpty @Size(min = 6, message = "cat. name should have 6 char") String catDesc) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catDesc = catDesc;
	}

	public Integer getCatId() {
		return catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	
	

	
	
	
}
