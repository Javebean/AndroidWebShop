package com.aw.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Goods")
public class Goods {
	@Id
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	@Column(name = "id")
	private Integer id;
	private String brand;
	private Float price;
	private Float discount;
	private Integer bcount;
	private String des;
	private String pic;
	private String dir;
	private String gid;
	private Integer type;
	private Integer pop;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	public Integer getBcount() {
		return bcount;
	}
	public void setBcount(Integer bcount) {
		this.bcount = bcount;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPop() {
		return pop;
	}
	public void setPop(Integer pop) {
		this.pop = pop;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", brand=" + brand + ", price=" + price
				+ ", discount=" + discount + ", bcount=" + bcount + ", des="
				+ des + ", pic=" + pic + ", dir=" + dir + ", gid=" + gid
				+ ", type=" + type + ", pop=" + pop + "]";
	}
	
	
	
}
