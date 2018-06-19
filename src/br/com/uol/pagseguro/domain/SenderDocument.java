/**
 * Copyright [2011] [PagSeguro Internet Ltda.]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package br.com.uol.pagseguro.domain;

import br.com.uol.pagseguro.util.NumberUtil;

public class SenderDocument {

    /** Sender document type */
    private String type;

    /** Sender document value */
    private Long value;

    /**
     * The constructor
     */
    public SenderDocument() {

    }

    /**
     * The constructor
     * 
     * @param type
     * @param value
     */
    public SenderDocument(String type, Long value) {
        this.setType(type);
        this.setValue(value);
    }

    /**
     * The constructor
     * 
     * @param type
     * @param value
     */
    public SenderDocument(String type, String value) {
        this.setType(type);
        this.setValue(value);
    }

    /**
     * Gets document type
     * 
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Sets document type
     * 
     * @param String
     *            type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets document value
     * 
     * @return Long
     */
    public Long getValue() {
        return value;
    }

    /**
     * Sets document value
     * 
     * @param Long
     *            value
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * Sets document value
     * 
     * @param Long
     *            value
     */
    public void setValue(String value) {
        this.value = NumberUtil.getOnlyNumbers(value);
    }

    public String toString() {
        return "Document [type=" + type + ", value=" + value + "]";
    }

}
