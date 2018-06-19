/*
 ************************************************************************
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
 ************************************************************************
 */
package br.com.uol.pagseguro.properties;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Helper to get values from properties
 * 
 */
public class PagSeguroSystem {

    private PagSeguroSystem() {
    }

    private static ResourceBundle resourceBundle;

    private static final String LIB_VERSION = "2.2.0";

    private static final String LANGUAGE_ENGINE_DESCRIPTION = System.getProperty("java.version") + ":"
            + System.getProperty("java.vendor");

    static {
        resourceBundle = ResourceBundle.getBundle("pagseguro-system", Locale.getDefault());
    }

    public static String getCheckoutUrl() {
        return resourceBundle.getString("paymentService." + PagSeguroConfig.getEnvironment() + ".checkoutUrl");
    }

    /**
     * Get Url payment production
     * 
     * @return string
     */
    public static String getUrlProduction() {
        return resourceBundle.getString("environment." + PagSeguroConfig.getEnvironment() + ".webserviceUrl");
    }

    /**
     * Get Url to create a payment session
     * 
     * @return string
     */
    public static String getUrlPaymentSession() {
        return resourceBundle.getString("paymentService." + PagSeguroConfig.getEnvironment() + ".paymentSession");
    }

    /**
     * Get Url to Installments
     * 
     * @return string
     */
    public static String getUrlInstallments() {
        return resourceBundle.getString("paymentService." + PagSeguroConfig.getEnvironment() + ".installments");
    }

    /**
     * Get Url to Direct Payment
     * 
     * @return string
     */
    public static String getUrlDirectPayment() {
        return resourceBundle.getString("paymentService." + PagSeguroConfig.getEnvironment() + ".directPayment");
    }

    /**
     * Get Url to Payment-Methods
     * 
     * @return string
     */
    public static String getUrlPaymentMethods() {
        return resourceBundle.getString("paymentService." + PagSeguroConfig.getEnvironment() + ".paymentMethods");
    }

    /**
     * Get service path
     * 
     * @return string
     */
    public static String getServicePath() {
        return resourceBundle.getString("paymentService.servicePath");
    }

    public static String getServiceTimeout() {
        return resourceBundle.getString("serviceTimeout");
    }

    public static String getNotificationUrl() {
        return resourceBundle.getString("notificationService." + PagSeguroConfig.getEnvironment() + ".url");
    }

    public static String getUrlNotification() {
        return resourceBundle.getString("url.notification");
    }

    public static String getTransactionSearchUrl() {
        return resourceBundle.getString("transactionSearchService." + PagSeguroConfig.getEnvironment() + ".url");
    }

    public static String getUrlPaymentRedir() {
        return resourceBundle.getString("url.payment.redir");
    }

    public static String getContentTypeFormUrlEncoded() {
        return resourceBundle.getString("contentType.formUrlEncoded");
    }

    public static String getPagSeguroEncoding() {
        return resourceBundle.getString("encoding");
    }

    public static String getLibversion() {
        return LIB_VERSION;
    }

    public static String getLanguageEnginedescription() {
        return LANGUAGE_ENGINE_DESCRIPTION;
    }

}
