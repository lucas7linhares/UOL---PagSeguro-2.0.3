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

    private static final String LIB_VERSION = "2.1.1";

    private static final String LANGUAGE_ENGINE_DESCRIPTION = System.getProperty("java.version") + ":"
            + System.getProperty("java.vendor");

    static {
        resourceBundle = ResourceBundle.getBundle("pagseguro-system", Locale.getDefault());
    }

    public static String getCheckoutUrl() {
        return resourceBundle.getString("paymentService.checkoutUrl");
    }

    /**
     * Get Url payment production
     * 
     * @return string
     */
    public static String getUrlProduction() {
        return resourceBundle.getString("environment.production.webserviceUrl");
    }

    /**
     * Get Url Payment Development
     * 
     * @return string
     */
    public static String getUrlDevelopment() {
        return resourceBundle.getString("environment.development.webserviceUrl");
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
        return resourceBundle.getString("paymentService.serviceTimeout");
    }

    public static String getNotificationUrl() {
        return resourceBundle.getString("notificationService.url");
    }

    public static String getUrlNotification() {
        return resourceBundle.getString("url.notification");
    }

    public static String getTransactionSearchUrl() {
        return resourceBundle.getString("transactionSearchService.url");
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
