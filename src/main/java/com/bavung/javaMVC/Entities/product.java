package com.bavung.javaMVC.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Vui lòng điền tên sản phẩm")
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @NotNull( message="vui lòng nhập giá")
    @Min(value = 0 , message="Giá phải lớn hơn 0")
    private Double price;

    private String image;
     @Column(columnDefinition = "MEDIUMTEXT")
    private String detailDesc;
    private String shortDesc;

    @NotNull( message="Vui lòng nhập số lượng")
    @Min(value = 1 , message="Số lượng phải lớn hơn hoặc bằng 1")
    private Long quantity;
    private Long sold;
    private String factory;
    private String target;

    @OneToMany(mappedBy="product")
    private List<CartDetail> cartDetail;

    public List<CartDetail> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(List<CartDetail> cartDetail) {
        this.cartDetail = cartDetail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double Price) {
        this.price = Price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("product{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", Price=").append(price);
        sb.append(", image=").append(image);
        sb.append(", detailDesc=").append(detailDesc);
        sb.append(", shortDesc=").append(shortDesc);
        sb.append(", quantity=").append(quantity);
        sb.append(", sold=").append(sold);
        sb.append(", factory=").append(factory);
        sb.append(", target=").append(target);
        sb.append('}');
        return sb.toString();
    }


}
