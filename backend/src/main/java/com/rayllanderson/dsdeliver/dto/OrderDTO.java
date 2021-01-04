package com.rayllanderson.dsdeliver.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rayllanderson.dsdeliver.entities.Order;
import com.rayllanderson.dsdeliver.entities.OrderStatus;

public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String address;
    private String latitude;
    private String longitude;
    private Instant moment;
    private OrderStatus status;

    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO() {
    };

    public OrderDTO(Long id, String address, String latitude, String longitude, Instant moment, OrderStatus status) {
	this.id = id;
	this.address = address;
	this.latitude = latitude;
	this.longitude = longitude;
	this.moment = moment;
	this.status = status;
    }

    public OrderDTO(Order entity) {
	id = entity.getId();
	address = entity.getAddress();
	latitude = entity.getLatitude();
	longitude = entity.getLongitude();
	moment = entity.getMoment();
	status = entity.getStatus();
	products = entity.getProducts().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getLatitude() {
	return latitude;
    }

    public void setLatitude(String latitude) {
	this.latitude = latitude;
    }

    public String getLongitude() {
	return longitude;
    }

    public void setLongitude(String longitude) {
	this.longitude = longitude;
    }

    public Instant getMoment() {
	return moment;
    }

    public void setMoment(Instant moment) {
	this.moment = moment;
    }

    public OrderStatus getStatus() {
	return status;
    }

    public void setStatus(OrderStatus status) {
	this.status = status;
    }
    
    public List<ProductDTO> getProducts() {
	return products;
    }


    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	OrderDTO other = (OrderDTO) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}