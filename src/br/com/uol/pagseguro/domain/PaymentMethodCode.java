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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Defines a list of known payment method codes.
 */
public final class PaymentMethodCode {

    /**
     * Payment method code Example: 101
     */
    private final int value;

    /**
     * VISA
     */
    public static final PaymentMethodCode VISA_CREDIT_CARD = new PaymentMethodCode(101);

    /**
     * MasterCard
     */
    public static final PaymentMethodCode MASTERCARD_CREDIT_CARD = new PaymentMethodCode(102);

    /**
     * American Express
     */
    public static final PaymentMethodCode AMEX_CREDIT_CARD = new PaymentMethodCode(103);

    /**
     * Diners
     */
    public static final PaymentMethodCode DINERS_CREDIT_CARD = new PaymentMethodCode(104);

    /**
     * Hipercard
     */
    public static final PaymentMethodCode HIPERCARD_CREDIT_CARD = new PaymentMethodCode(105);

    /**
     * Aura
     */
    public static final PaymentMethodCode AURA_CREDIT_CARD = new PaymentMethodCode(106);

    /**
     * Elo
     */
    public static final PaymentMethodCode ELO_CREDIT_CARD = new PaymentMethodCode(107);

    /**
     * PLENOCard
     */
    public static final PaymentMethodCode PLENO_CREDIT_CARD = new PaymentMethodCode(108);

    /**
     * PersonalCard
     */
    public static final PaymentMethodCode PERSONAL_CREDIT_CARD = new PaymentMethodCode(109);

    /**
     * JCB
     */
    public static final PaymentMethodCode JCB_CREDIT_CARD = new PaymentMethodCode(110);

    /**
     * Discover
     */
    public static final PaymentMethodCode DISCOVER_CREDIT_CARD = new PaymentMethodCode(111);

    /**
     * BrasilCard
     */
    public static final PaymentMethodCode BRASIL_CREDIT_CARD = new PaymentMethodCode(112);

    /**
     * FORTBRASIL
     */
    public static final PaymentMethodCode FORTBRASIL_CREDIT_CARD = new PaymentMethodCode(113);

    /**
     * CARDBAN
     */
    public static final PaymentMethodCode CARDBAN_CREDIT_CARD = new PaymentMethodCode(114);

    /**
     * VALECARD
     */
    public static final PaymentMethodCode VALECARD_CREDIT_CARD = new PaymentMethodCode(115);

    /**
     * Cabal
     */
    public static final PaymentMethodCode CABAL_CREDIT_CARD = new PaymentMethodCode(116);

    /**
     * Mais!
     */
    public static final PaymentMethodCode MAIS_CREDIT_CARD = new PaymentMethodCode(117);

    /**
     * Avista
     */
    public static final PaymentMethodCode AVISTA_CREDIT_CARD = new PaymentMethodCode(118);

    /**
     * GRANCARD
     */
    public static final PaymentMethodCode GRANDCARD_CREDIT_CARD = new PaymentMethodCode(119);

    /**
     * Bradesco - boleto
     */
    public static final PaymentMethodCode BRADESCO_BOLETO = new PaymentMethodCode(201);

    /**
     * Santander - boleto
     */
    public static final PaymentMethodCode SANTANDER_BOLETO = new PaymentMethodCode(202);

    /**
     * Bradesco on-line transfer
     */
    public static final PaymentMethodCode BRADESCO_ONLINE_TRANSFER = new PaymentMethodCode(301);

    /**
     * Itau on-line transfer
     */
    public static final PaymentMethodCode ITAU_ONLINE_TRANSFER = new PaymentMethodCode(302);

    /**
     * Unibanco on-line transfer
     */
    public static final PaymentMethodCode UNIBANCO_ONLINE_TRANSFER = new PaymentMethodCode(303);

    /**
     * Banco do Brasil on-line transfer
     */
    public static final PaymentMethodCode BANCO_BRASIL_ONLINE_TRANSFER = new PaymentMethodCode(304);

    /**
     * Banco Real on-line transfer
     */
    public static final PaymentMethodCode REAL_ONLINE_TRANSFER = new PaymentMethodCode(305);

    /**
     * Banrisul on-line transfer
     */
    public static final PaymentMethodCode BANRISUL_ONLINE_TRANSFER = new PaymentMethodCode(306);

    /**
     * HSBC on-line transfer
     */
    public static final PaymentMethodCode HSBC_ONLINE_TRANSFER = new PaymentMethodCode(307);

    /**
     * PagSeguro account balance
     */
    public static final PaymentMethodCode PS_BALANCE = new PaymentMethodCode(401);

    /**
     * OiPaggo
     */
    public static final PaymentMethodCode OI_PAGGO = new PaymentMethodCode(501);

    /**
     * The values map
     */
    private static final Map VALUE_MAP = new HashMap();

    static {
        VALUE_MAP.put(new Integer(VISA_CREDIT_CARD.getValue()), VISA_CREDIT_CARD);
        VALUE_MAP.put(new Integer(MASTERCARD_CREDIT_CARD.getValue()), MASTERCARD_CREDIT_CARD);
        VALUE_MAP.put(new Integer(AMEX_CREDIT_CARD.getValue()), AMEX_CREDIT_CARD);
        VALUE_MAP.put(new Integer(DINERS_CREDIT_CARD.getValue()), DINERS_CREDIT_CARD);
        VALUE_MAP.put(new Integer(HIPERCARD_CREDIT_CARD.getValue()), HIPERCARD_CREDIT_CARD);
        VALUE_MAP.put(new Integer(AURA_CREDIT_CARD.getValue()), AURA_CREDIT_CARD);
        VALUE_MAP.put(new Integer(ELO_CREDIT_CARD.getValue()), ELO_CREDIT_CARD);
        VALUE_MAP.put(new Integer(PLENO_CREDIT_CARD.getValue()), PLENO_CREDIT_CARD);
        VALUE_MAP.put(new Integer(PERSONAL_CREDIT_CARD.getValue()), PERSONAL_CREDIT_CARD);
        VALUE_MAP.put(new Integer(JCB_CREDIT_CARD.getValue()), JCB_CREDIT_CARD);
        VALUE_MAP.put(new Integer(DISCOVER_CREDIT_CARD.getValue()), DISCOVER_CREDIT_CARD);
        VALUE_MAP.put(new Integer(BRASIL_CREDIT_CARD.getValue()), BRASIL_CREDIT_CARD);
        VALUE_MAP.put(new Integer(FORTBRASIL_CREDIT_CARD.getValue()), FORTBRASIL_CREDIT_CARD);
        VALUE_MAP.put(new Integer(CARDBAN_CREDIT_CARD.getValue()), CARDBAN_CREDIT_CARD);
        VALUE_MAP.put(new Integer(VALECARD_CREDIT_CARD.getValue()), VALECARD_CREDIT_CARD);
        VALUE_MAP.put(new Integer(CABAL_CREDIT_CARD.getValue()), CABAL_CREDIT_CARD);
        VALUE_MAP.put(new Integer(MAIS_CREDIT_CARD.getValue()), MAIS_CREDIT_CARD);
        VALUE_MAP.put(new Integer(AVISTA_CREDIT_CARD.getValue()), AVISTA_CREDIT_CARD);
        VALUE_MAP.put(new Integer(GRANDCARD_CREDIT_CARD.getValue()), GRANDCARD_CREDIT_CARD);
        VALUE_MAP.put(new Integer(BRADESCO_BOLETO.getValue()), BRADESCO_BOLETO);
        VALUE_MAP.put(new Integer(SANTANDER_BOLETO.getValue()), SANTANDER_BOLETO);
        VALUE_MAP.put(new Integer(BRADESCO_ONLINE_TRANSFER.getValue()), BRADESCO_ONLINE_TRANSFER);
        VALUE_MAP.put(new Integer(ITAU_ONLINE_TRANSFER.getValue()), ITAU_ONLINE_TRANSFER);
        VALUE_MAP.put(new Integer(UNIBANCO_ONLINE_TRANSFER.getValue()), UNIBANCO_ONLINE_TRANSFER);
        VALUE_MAP.put(new Integer(BANCO_BRASIL_ONLINE_TRANSFER.getValue()), BANCO_BRASIL_ONLINE_TRANSFER);
        VALUE_MAP.put(new Integer(REAL_ONLINE_TRANSFER.getValue()), REAL_ONLINE_TRANSFER);
        VALUE_MAP.put(new Integer(BANRISUL_ONLINE_TRANSFER.getValue()), BANRISUL_ONLINE_TRANSFER);
        VALUE_MAP.put(new Integer(HSBC_ONLINE_TRANSFER.getValue()), HSBC_ONLINE_TRANSFER);
        VALUE_MAP.put(new Integer(PS_BALANCE.getValue()), PS_BALANCE);
        VALUE_MAP.put(new Integer(OI_PAGGO.getValue()), OI_PAGGO);
    }

    public static PaymentMethodCode fromValue(Integer value) {

        Iterator i = VALUE_MAP.keySet().iterator();

        while (i.hasNext()) {
            Integer type = (Integer) i.next();
            if (type.intValue() == value.intValue()) {
                return (PaymentMethodCode) VALUE_MAP.get(type);
            }
        }

        return new PaymentMethodCode(value.intValue());
    }

    public boolean equals(PaymentMethodCode other) {
        return this.value == other.getValue();
    }

    public String toString() {
        return Integer.toString(getValue());
    }

    private PaymentMethodCode(int value) {
        this.value = value;
    }

    /**
     * @return the payment method code value Example: 101
     */
    public int getValue() {
        return value;
    }

}
