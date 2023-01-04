package com.example.lesson02.model;

import java.util.Date; //date클래스는 항상 java

//컬럼명들을 멤버로, getter setter를 가지는 데이터를 저장하는 클래스
//스프링빈으로 만들때도 아닐때도 있다

//model, DTO, VO, domain, entity로불림
public class UsedGoods {
	//필드
	//워크벤치에서 desc로 조회(칼럼조회)후 붙여넣기
	//null이 가능한 필드라면 Integer로 (int로안됨)
	private int id;
	private String title;
	private int price;
	private String description;
	private String picture;
	private int sellerId;
	private Date createdAt;
	private Date updatedAt;
	
	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
}
