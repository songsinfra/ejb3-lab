package org.demo.garage.sale.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "sale_item")
public class SaleItem {

	@Id
	@GeneratedValue
	private long saleItemId;
	private House house;
	private String item;
	private double price;

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getSaleItemId() {
		return saleItemId;
	}

	public void setSaleItemId(long saleItemId) {
		this.saleItemId = saleItemId;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
