/*
 ************************************************************************
 Copyright [2014] [PagSeguro Internet Ltda.]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 ************************************************************************
 */

package br.com.uol.pagseguro.domain.paymentrequest;

import java.math.BigDecimal;

import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.enums.ShippingType;

/**
 * Shipping information
 */
public class PaymentRequestShipping {

    /**
     * Shipping cost - fixed value
     * 
     * Optional if PaymentRequestShippingPackage not null
     */
    private BigDecimal cost;

    /**
     * Shipping cost - value to calculate
     * 
     * Optional if cost not null
     */
    private PaymentRequestShippingPackage paymentRequestShippingPackage;

    /**
     * Shipping address
     */
    private Address address;

    /**
     * Shipping types
     */
    private ShippingType type;

    /**
     * Initializes a new instance of the PaymentRequestShipping class
     */
    public PaymentRequestShipping() {

    }

    /**
     * Initializes a new instance of the PaymentRequestShipping class with the specified arguments
     * 
     * @param cost
     */
    public PaymentRequestShipping(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * Initializes a new instance of the PaymentRequestShipping class with the specified arguments
     * 
     * @param paymentRequestshippingPackage
     */
    public PaymentRequestShipping(PaymentRequestShippingPackage paymentRequestShippingPackage) {
        this.paymentRequestShippingPackage = paymentRequestShippingPackage;
    }

    /**
     * Initializes a new instance of the PaymentRequestShipping class with the specified arguments
     * 
     * @param cost
     * @param address
     * @param type
     */
    public PaymentRequestShipping(BigDecimal cost, Address address, ShippingType type) {
        super();
        this.cost = cost;
        this.address = address;
        this.type = type;
    }

    /**
     * Initializes a new instance of the PaymentRequestShipping class with the specified arguments
     * 
     * @param paymentRequestShippingPackage
     * @param address
     * @param type
     */
    public PaymentRequestShipping(PaymentRequestShippingPackage paymentRequestShippingPackage, Address address,
            ShippingType type) {
        super();
        this.paymentRequestShippingPackage = paymentRequestShippingPackage;
        this.address = address;
        this.type = type;
    }

    /**
     * @return the cost
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * Sets the shipping cost (fixed value) of this shipping
     * 
     * @param cost
     *            the cost to set
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * @return the paymentRequestPackage
     */
    public PaymentRequestShippingPackage getPaymentRequestShippingPackage() {
        return paymentRequestShippingPackage;
    }

    /**
     * Sets the shipping cost (value to calculate) of this shipping
     * 
     * @param paymentRequestPackage
     */
    public void setPaymentRequestPackage(PaymentRequestShippingPackage paymentRequestShippingPackage) {
        this.paymentRequestShippingPackage = paymentRequestShippingPackage;
    }

    /**
     * Sets the shipping address
     * 
     * @param address
     * @see Address
     */
    public void setShippingAddress(Address address) {
        this.address = address;
    }
    
    /**
     * @return the shipping address
     * @see Address
     */
    public Address getShippingAddress() {
        if (this.address == null) {
            this.address = new Address();
        }
        return this.address;
    }
    
    /**
     * Sets the shipping type
     * 
     * @param type
     * @see ShippingType
     */
    public void setShippingType(ShippingType type) {
        this.type = type;
    }

    /**
     * @return the shipping type
     * @see ShippingType
     */
    public ShippingType getShippingType() {
        return this.type;
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "PaymentRequestShipping [cost=" + cost + ", paymentRequestShippingPackage="
                + paymentRequestShippingPackage + ", address=" + address + ", type=" + type + "]";
    }
}
