/*
 * ***********************************************************************
 Copyright [2011] [PagSeguro Internet Ltda.]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 * ***********************************************************************
 */

package br.com.uol.pagseguro.domain;

import java.util.ArrayList;
import java.util.List;

import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.helper.PagSeguroUtil;

/**
 * Represents the party on the transaction that is sending the money
 */
public class Sender {

    /** Sender name */
    private String name;

    /** Sender email */
    private String email;

    /** Sender born date */
    private String bornDate;

    /** Sender phone */
    private Phone phone;

    /** Sender documents */
    private List<SenderDocument> documents;

    /**
     * Initializes a new instance of the Sender class
     */
    public Sender() {
    }

    /**
     * Initializes a new instance of the Sender class
     * 
     * @param name
     * @param email
     * @param phone
     */
    public Sender(String name, String email, Phone phone, String bornDate) {
        this.name = PagSeguroUtil.removeExtraSpaces(name);
        this.email = email;
        this.phone = phone;
        this.bornDate = bornDate;
    }

    /**
     * Sets the Sender name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = PagSeguroUtil.removeExtraSpaces(name);
    }

    /**
     * @return the sender name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the Sender e-mail
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sender e-mail
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the Sender born date
     * 
     * @param email
     */
    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    /**
     * @return the sender born date
     */
    public String getBornDate() {
        return this.bornDate;
    }

    /**
     * Sets the sender phone
     * 
     * @param phone
     */
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    /**
     * @return the sender phone
     */
    public Phone getPhone() {
        if (this.phone == null) {
            this.phone = new Phone();
        }
        return this.phone;
    }

    /**
     * Gets sender documents list
     * 
     * @return the sender documents list
     */
    public List<SenderDocument> getDocuments() {
        if (this.documents == null) {
            this.documents = new ArrayList<SenderDocument>();
        }
        return this.documents;
    }

    /**
     * Sets the sender documents list
     * 
     * @param documents
     */
    public void setDocuments(List<SenderDocument> documents) {
        this.documents = documents;
    }

    /**
     * Add a document for sender documents list
     * 
     * @param document
     */
    public void addDocument(SenderDocument document) {
        this.getDocuments().add(document);
    }

    /**
     * Add a document for sender documents list
     * 
     * @param type
     * @param value
     */
    public void addDocument(DocumentType type, String value) {
        this.getDocuments().add(new SenderDocument(type, value));
    }

    /**
     * return string
     */
    @Override
    public String toString() {
        return "Sender [name=" + name + ", email=" + email + ", phone=" + phone + ", documents=" + documents
                + ", bornDate=" + bornDate + "]";
    }

}