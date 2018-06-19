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

package br.com.uol.pagseguro.util;

/**
 * Class that provides useful function for String
 */
public class StringUtil {

    /**
     * Truncate a String and add final end chars to them
     * 
     * @param String
     *            value
     * @param Integer
     *            limit
     * @param String
     *            endChars
     * @return String
     */
    public static String truncateValue(String value, int limit, String endChars) {
        if (!value.equals(null) && value.length() > limit)
            value = value.substring(0, limit - endChars.length()) + endChars;
        return value;
    }

    /**
     * Remove extra spaces from String
     * 
     * @param String
     *            value
     * @return String
     */
    public static String removeExtraSpaces(String value) {
        return value.replaceAll("( +)", " ").trim();
    }

    /**
     * Format a String dropping extra spaces and truncate value
     * 
     * @param String
     *            value
     * @param Integer
     *            limit
     * @param String
     *            endChars
     * @return String
     */
    public static String formatString(String value, int limit, String endChars) {
        return StringUtil.truncateValue(StringUtil.removeExtraSpaces(value), limit, endChars);
    }

}
