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
package br.com.uol.pagseguro.service;

import br.com.uol.pagseguro.domain.Credentials;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.helper.PagSeguroUtil;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.properties.PagSeguroSystem;

public class ConnectionData {

    private static final String SERVICE_NAME = "paymentService";

    private String serviceName;

    private Credentials credentials;

    private String environment;

    private String webServiceUrl;

    private String servicePath;

    private String serviceTimeout;

    private String charset;

    public ConnectionData(Credentials credentials, String serviceName) {

        this.credentials = credentials;
        this.serviceName = serviceName;

        this.environment = PagSeguroConfig.getEnvironment();
        this.webServiceUrl = validUrlWebService();
        this.charset = PagSeguroConfig.getApplicationCharset();

        if (serviceName.equals(ConnectionData.SERVICE_NAME)) {
            this.servicePath = PagSeguroSystem.getServicePath();
            this.serviceTimeout = PagSeguroSystem.getServiceTimeout();
        }
    }

    /**
     * Get Service Url
     * 
     * @return string
     */
    public String getServiceUrl() {
        return this.getWebServiceUrl() + this.getServicePath();
    }

    /**
     * Create url
     * 
     * @return string
     * @throws PagSeguroServiceException 
     */
    public String getCredentialsUrlQuery() throws PagSeguroServiceException {
        return PagSeguroUtil.urlQuery(this.getCredentials().getAttributes());
    }

    /**
     * Valid url web service production or development
     * 
     * @return string
     */
    private String validUrlWebService() {
        
        String url = PagSeguroSystem.getUrlDevelopment();

        if (getEnvironment().equals(PagSeguroConfig.getEnvironment())) {
            url = PagSeguroSystem.getUrlProduction();
        }

        return url + PagSeguroSystem.getServicePath();
        
    }

    /**
     * @return the credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * @param credentials
     *            the credentials to set
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName
     *            the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the environment
     */
    public String getEnvironment() {
        return environment;
    }

    /**
     * @param environment
     *            the environment to set
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    /**
     * @return the webServiceUrl
     */
    public String getWebServiceUrl() {
        return webServiceUrl;
    }

    /**
     * @param webServiceUrl
     *            the webServiceUrl to set
     */
    public void setWebServiceUrl(String webServiceUrl) {
        this.webServiceUrl = webServiceUrl;
    }

    /**
     * @return the charset
     */
    public String getCharset() {
        return charset;
    }

    /**
     * @param charset
     *            the charset to set
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * @return the servicePath
     */
    public String getServicePath() {
        return servicePath;
    }

    /**
     * @param servicePath
     *            the servicePath to set
     */
    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    /**
     * @return the serviceTimeout
     */
    public String getServiceTimeout() {
        return serviceTimeout;
    }

    /**
     * @param serviceTimeout
     *            the serviceTimeout to set
     */
    public void setServiceTimeout(String serviceTimeout) {
        this.serviceTimeout = serviceTimeout;
    }

    public String getCheckoutUrl() {
        return PagSeguroSystem.getCheckoutUrl();
    }

    public String getTransactionSearchUrl() {
        return PagSeguroSystem.getTransactionSearchUrl();
    }

}
