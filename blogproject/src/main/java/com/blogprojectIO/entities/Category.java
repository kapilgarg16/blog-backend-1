package com.blogprojectIO.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Categoroes")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer catId;
	
	@Column(name = "Category_name", nullable = false)
	String catName;
	
	@Column(name = "Category_Desc", nullable = false)
	String catDesc;

	@OneToMany(mappedBy = "category",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Post>posts = new ArrayList<>();
	
//	fetch = FetchType.LAZY : 
	
//	Is example me, Category entity me Post collection ko FetchType.LAZY ke sath define kiya gaya hai. Matlab 
//	jab hum kisi Category ko database se retrieve karte hain, to uska Post collection tab tak load nahi hota 
//	jab tak hum specifically usse access nahi karte.
	
//	cascade = CascadeType.ALL:
	
//	Maan lo humare paas do entities hain: Category aur Post. Ek Category ke multiple Post ho sakte hain, 
//	aur hum chahte hain ki jab Category ko save ya delete karein, to uski sari Post bhi accordingly save 
//	ya delete ho jayein.
	
	public Category() {
		super();
	}

	public Category(Integer catId, String catName, String catDesc) {
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
