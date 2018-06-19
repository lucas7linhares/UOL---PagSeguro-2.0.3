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
package br.com.uol.pagseguro.infra;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import br.com.uol.pagseguro.domain.Error;
import br.com.uol.pagseguro.domain.HttpError;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.logs.PagSeguroDummyLogger;
import br.com.uol.pagseguro.logs.Logger;
import br.com.uol.pagseguro.logs.PagSeguroLoggerFactory;
import br.com.uol.pagseguro.properties.PagSeguroConfig;
import br.com.uol.pagseguro.properties.PagSeguroSystem;
import br.com.uol.pagseguro.xmlparser.ErrorsParser;

/**
 * Encapsulates web service calls
 */
public class HttpURLConnectionUtil {

    /**
     * PagSeguro Log tool
     * 
     * @see PagSeguroDummyLogger
     */
    static Logger log = PagSeguroLoggerFactory.getLogger(HttpURLConnectionUtil.class);

    private static final String HTTP_METHOD_POST = "POST";

    private static final String HTTP_METHOD_GET = "GET";

    /**
     * Creates a http connection and makes a remote call
     * 
     * @param method
     * @param urlPath
     * @param contentType
     * @param xml
     * @return
     * @throws PagSeguroServiceException
     */
    private static HttpURLConnection getHttpURLConnection(String method, String urlPath, String contentType, String xml)
            throws PagSeguroServiceException {

        log.debug("method: " + method + ", Content-type:" + contentType + ", target URL: " + urlPath);

        URL url;
        HttpURLConnection connection;
        try {

            // Creates a connection
            url = new URL(urlPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-type", contentType);
            connection.setRequestProperty("lib-description", "java:" + PagSeguroSystem.getLibversion());
            connection.setRequestProperty("language-engine-description",
                    "java:" + PagSeguroSystem.getLanguageEnginedescription());

            // adding module version to header request
            if (PagSeguroConfig.getModuleVersion() != null) {
                connection.setRequestProperty("module-description", PagSeguroConfig.getModuleVersion());
            }

            // adding cms version to header request
            if (PagSeguroConfig.getCmsVersion() != null) {
                connection.setRequestProperty("cms-description", PagSeguroConfig.getCmsVersion());
            }

            // write the XML
            if (xml != null && !xml.equals("")) {
                log.debug("sending XML: " + xml);
                connection.getOutputStream().write(xml.getBytes(PagSeguroSystem.getPagSeguroEncoding()));
            }

            // handle the response
            int responseCode = connection.getResponseCode();

            if (responseCode != HttpURLConnection.HTTP_OK) {
                if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {

                    List errors = ErrorsParser.readErrosXml(connection.getErrorStream());
                    log(errors);

                    throw new PagSeguroServiceException(errors, HttpError.fromValue(responseCode));
                }

                log.error("HTTP: " + responseCode + ". Error during PagSeguro API call.");
                throw new PagSeguroServiceException(HttpError.fromValue(responseCode));
            }

            log.debug("API call success: " + responseCode);

            // returns the http connection
            return connection;

        } catch (IOException e) {
            log.error("Error while parsing the response", e);
            throw new PagSeguroServiceException(HttpURLConnectionUtil.generateErrorsList(e),
                    HttpError.INTERNAL_SERVER_ERROR);
        } catch (ParserConfigurationException e) {
            log.error("Error while parsing the response", e);
            throw new PagSeguroServiceException(HttpURLConnectionUtil.generateErrorsList(e), HttpError.BAD_REQUEST);
        } catch (SAXException e) {
            log.error("Error while parsing the response", e);
            throw new PagSeguroServiceException(HttpURLConnectionUtil.generateErrorsList(e), HttpError.BAD_REQUEST);
        }

    }

    /**
     * makes a post request in the informed URL
     * 
     * @param urlPath
     * @param contentType
     * @param xml
     * @return
     * @throws PagSeguroServiceException
     */
    public static HttpURLConnection getHttpPostConnection(String urlPath, String contentType, String xml)
            throws PagSeguroServiceException {
        return getHttpURLConnection(HTTP_METHOD_POST, urlPath, contentType, xml);
    }

    /**
     * makes a get request n the informed URL
     * 
     * @param urlPath
     * @param contentType
     * @return
     * @throws PagSeguroServiceException
     */
    public static HttpURLConnection getHttpGetConnection(String urlPath, String contentType)
            throws PagSeguroServiceException {
        return getHttpURLConnection(HTTP_METHOD_GET, urlPath, contentType, null);
    }

    private static void log(List errors) {
        String print = "HTTP: " + HttpsURLConnection.HTTP_BAD_REQUEST
                + ". Validation error in PagSeguro webservice: \n";

        for (int i = 0; i < errors.size(); i++) {
            Error error = (Error) errors.get(i);
            print += "> ";
            print += error.getCode() + " - " + error.getMessage();
            print += "\n";
        }

        log.error(print);
    }

    private static List generateErrorsList(Exception e) {
        List errors = new ArrayList();
        errors.add(new Error(null, e.getMessage()));

        return errors;
    }
}
