/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int202.classicmodel.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Student
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByProductCode", query = "SELECT p FROM Products p WHERE p.productCode = :productCode"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findAllAttribute", query = "SELECT p FROM Products p WHERE p.productName like :param OR p.productDescription like :param OR p.productLine.productLine like :param"),
    @NamedQuery(name = "Products.findByProductScale", query = "SELECT p FROM Products p WHERE p.productScale = :productScale"),
    @NamedQuery(name = "Products.findByProductVendor", query = "SELECT p FROM Products p WHERE p.productVendor = :productVendor"),
    @NamedQuery(name = "Products.findByQuantityInStock", query = "SELECT p FROM Products p WHERE p.quantityInStock = :quantityInStock"),
    @NamedQuery(name = "Products.findByBuyPrice", query = "SELECT p FROM Products p WHERE p.buyPrice = :buyPrice"),
    @NamedQuery(name = "Products.findByMsrp", query = "SELECT p FROM Products p WHERE p.msrp = :msrp")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String productCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String productScale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String productVendor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    private String productDescription;
    @Basic(optional = false)
    @NotNull
    private short quantityInStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    private BigDecimal buyPrice;
    @Basic(optional = false)
    @NotNull
    private BigDecimal msrp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Orderdetails> orderdetailsList;
    @JoinColumn(name = "productLine", referencedColumnName = "productLine")
    @ManyToOne(optional = false)
    private Productlines productLine;

    public Products() {
    }

    public Products(String productCode) {
        this.productCode = productCode;
    }

    public Products(String productCode, String productName, String productScale, String productVendor, String productDescription, short quantityInStock, BigDecimal buyPrice, BigDecimal msrp) {
        this.productCode = productCode;
        this.productName = productName;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    public List<Orderdetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<Orderdetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    public Productlines getProductLine() {
        return productLine;
    }

    public void setProductLine(Productlines productLine) {
        this.productLine = productLine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productCode != null ? productCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productCode == null && other.productCode != null) || (this.productCode != null && !this.productCode.equals(other.productCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sit.int202.classicmodel.entity.Products[ productCode=" + productCode + " ]";
    }
    
}
