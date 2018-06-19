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

package br.com.uol.pagseguro.service.paymentrequest;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import br.com.uol.pagseguro.domain.Credentials;
import br.com.uol.pagseguro.domain.Error;
import br.com.uol.pagseguro.domain.paymentrequest.PaymentRequest;
import br.com.uol.pagseguro.domain.paymentrequest.PaymentRequestTransaction;
import br.com.uol.pagseguro.enums.HttpStatus;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.logs.Log;
import br.com.uol.pagseguro.parser.paymentrequest.PaymentRequestParser;
import br.com.uol.pagseguro.properties.PagSeguroSystem;
import br.com.uol.pagseguro.service.ConnectionData;
import br.com.uol.pagseguro.utils.HttpConnection;
import br.com.uol.pagseguro.xmlparser.ErrorsParser;

/**
 * 
 * Class Payment Request Service
 */
public class PaymentRequestService {

    private PaymentRequestService() {

    }

    /**
     * PagSeguro Log tool
     * 
     * @see Log
     */
    private static Log log = new Log(PaymentRequestService.class);

    /**
     * @var String
     */
    private static final String PREFIX = PaymentRequestService.class.getSimpleName() + ".";

    /**
     * @var String
     */
    private static final String SUFFIX_BEGIN = "( %1s ) - begin";

    /**
     * @var String
     */
    private static final String SUFFIX_END = " - end %2s )";

    /**
     * @var String
     */
    private static final String SUFFIX_ERROR = " - error %2s )";

    /**
     * @var String
     */
    private static final String REGISTER = "Register";

    /**
     * @var String
     */
    private static final String FIND_BY_CODE = "FindByCode";

    /**
     * 
     * @param ConnectionData
     *            connectionData
     * @return string
     * @throws PagSeguroServiceException
     */
    public static String buildPaymentRequestUrl(ConnectionData connectionData) throws PagSeguroServiceException {
        return connectionData.getWSPaymentRequestUrl() + "?" + connectionData.getCredentialsUrlQuery();
    }

    /**
     * Build Find Url By Code
     * 
     * @param ConnectionData
     *            connectionData
     * @param string
     *            paymentRequestCode
     * @return string
     * @throws PagSeguroServiceException
     */
    private static String buildPaymentRequestFindUrlByCode(ConnectionData connectionData, String paymentRequestCode)
            throws PagSeguroServiceException {
        return connectionData.getWSPaymentRequestFindByCodeUrl() + "/" + paymentRequestCode + "?"
                + connectionData.getCredentialsUrlQuery();
    }

    /**
     * 
     * @param credentials
     * @param paymentRequest
     * @return string
     * @throws Exception
     */
    public static String createPaymentRequest(Credentials credentials, PaymentRequest paymentRequest)
            throws PagSeguroServiceException {

        PaymentRequestService.log.info(String.format(PREFIX + REGISTER + SUFFIX_BEGIN, paymentRequest.toString()));

        ConnectionData connectionData = new ConnectionData(credentials);

        Map<Object, Object> data = PaymentRequestParser.getData(paymentRequest);

        String url = PaymentRequestService.buildPaymentRequestUrl(connectionData);

        HttpConnection connection = new HttpConnection();
        HttpStatus httpCodeStatus = null;

        HttpURLConnection response = connection.post(url, data, connectionData.getServiceTimeout(),
                connectionData.getCharset(), PagSeguroSystem.getAcceptHeaderXML());

        try {

            httpCodeStatus = HttpStatus.fromCode(response.getResponseCode());
            if (httpCodeStatus == null) {
                throw new PagSeguroServiceException("Connection Timeout");
            } else if (HttpURLConnection.HTTP_OK == httpCodeStatus.getCode().intValue()) {
                String code = PaymentRequestParser.readSuccessXml(response);

                PaymentRequestService.log.info(String.format(PREFIX + REGISTER + SUFFIX_END, paymentRequest.toString(),
                        code));

                return code;

            } else if (HttpURLConnection.HTTP_BAD_REQUEST == httpCodeStatus.getCode().intValue()) {

                List<Error> errors = ErrorsParser.readErrosXml(response.getErrorStream());

                PagSeguroServiceException exception = new PagSeguroServiceException(httpCodeStatus, errors);

                PaymentRequestService.log.error(String.format(PREFIX + REGISTER + SUFFIX_ERROR,
                        paymentRequest.toString(), exception.getMessage()));

                throw exception;

            } else {

                throw new PagSeguroServiceException(httpCodeStatus);
            }

        } catch (PagSeguroServiceException e) {
            throw e;
        } catch (Exception e) {

            PaymentRequestService.log.error(String.format(PREFIX + REGISTER + SUFFIX_ERROR, paymentRequest.toString(),
                    e.getMessage()));

            throw new PagSeguroServiceException(httpCodeStatus, e);

        } finally {
            response.disconnect();
        }
    }

    /**
     * 
     * @param credentials
     * @param paymentRequestCode
     * @return PaymentRequest
     * @throws Exception
     */
    public static PaymentRequestTransaction findByCode(Credentials credentials, String paymentRequestcode)
            throws PagSeguroServiceException {

        PaymentRequestService.log.info(String.format(PREFIX + FIND_BY_CODE + SUFFIX_BEGIN, paymentRequestcode));

        ConnectionData connectionData = new ConnectionData(credentials);

        HttpConnection connection = new HttpConnection();
        HttpStatus httpStatusCode = null;

        HttpURLConnection response = connection.get(
                PaymentRequestService.buildPaymentRequestFindUrlByCode(connectionData, paymentRequestcode),
                connectionData.getServiceTimeout(), connectionData.getCharset(), PagSeguroSystem.getAcceptHeaderXML());

        try {

            httpStatusCode = HttpStatus.fromCode(response.getResponseCode());

            if (HttpURLConnection.HTTP_OK == httpStatusCode.getCode().intValue()) {

                PaymentRequestTransaction paymentRequestTransaction = PaymentRequestParser.readPaymentRequest(response
                        .getInputStream());

                PaymentRequestService.log.info(String.format(PaymentRequestService.FIND_BY_CODE, paymentRequestcode,
                        paymentRequestTransaction.toString()));

                return paymentRequestTransaction;

            } else if (HttpURLConnection.HTTP_BAD_REQUEST == httpStatusCode.getCode().intValue()) {

                List<Error> listErrors = ErrorsParser.readErrosXml(response.getErrorStream());

                PagSeguroServiceException exception = new PagSeguroServiceException(httpStatusCode, listErrors);

                PaymentRequestService.log.error(String.format(PREFIX + FIND_BY_CODE + SUFFIX_ERROR, paymentRequestcode,
                        exception.getMessage()));

                throw exception;
            } else {
                throw new PagSeguroServiceException(httpStatusCode);
            }

        } catch (PagSeguroServiceException e) {
            throw e;
        } catch (Exception e) {

            PaymentRequestService.log.error(String.format(PREFIX + FIND_BY_CODE + SUFFIX_END, paymentRequestcode,
                    e.getMessage()));

            throw new PagSeguroServiceException(httpStatusCode, e);

        } finally {
            response.disconnect();
        }
    }
}