package mt.base_converter.Base_Encryptions;




import java.io.ByteArrayOutputStream;

/**
 * Modified version of Jochaim Henke's original code from
 * http://base91.sourceforge.net/
 *
 * basE91 encoding/decoding routines
 *
 * Copyright (c) 2000-2006 Joachim Henke All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. - Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials provided
 * with the distribution. - Neither the name of Joachim Henke nor the names of
 * his contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * @author Joachim Henke (Original version)
 * @author Benedikt Waldvogel (Modifications)
 */
 
 /**
 * ReCreated by @Maharna's Tech (Subscribe our YT Channel and learn Android Application Reversing using Android Device by the Help of MT Manager) on 4-Dec-22.
 */


public class Base91MT {

    private static final String BASE91_ALPHABET = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" +
        "!#$%&()*+,./:;<=>?@[]^_`{|}~\"";

    private static final int[] BASE91_DECODE_TABLE = new int[256];

    static {
        for (int i = 0; i < BASE91_DECODE_TABLE.length; i++) {
            BASE91_DECODE_TABLE[i] = -1;
        }
        for (int i = 0; i < BASE91_ALPHABET.length(); i++) {
            BASE91_DECODE_TABLE[BASE91_ALPHABET.charAt(i)] = i;
        }
    }

    // Base91 Encoding
    public static String encode(byte[] input) {
        StringBuilder encoded = new StringBuilder();
        int n = 0, b = 0, v = 0;

        for (byte c : input) {
            n |= (c & 0xFF) << b;
            b += 8;
            if (b > 13) {
                v = n & 8191;
                if (v > 88) {
                    n >>= 13;
                    b -= 13;
                } else {
                    v = n & 16383;
                    n >>= 14;
                    b -= 14;
                }
                encoded.append(BASE91_ALPHABET.charAt(v % 91));
                encoded.append(BASE91_ALPHABET.charAt(v / 91));
            }
        }
        if (b != 0) {
            encoded.append(BASE91_ALPHABET.charAt(n % 91));
            if (b > 7 || n > 90) {
                encoded.append(BASE91_ALPHABET.charAt(n / 91));
            }
        }
        return encoded.toString();
    }

    // Base91 Decoding
    public static byte[] decode(String input) {
        java.util.ArrayList<Byte> output = new java.util.ArrayList<>();
        int n = 0, b = 0, v = -1;

        for (char c : input.toCharArray()) {
            if (BASE91_DECODE_TABLE[c] == -1) {
                continue;  // Skip invalid characters
            }

            if (v == -1) {
                v = BASE91_DECODE_TABLE[c];
            } else {
                v += BASE91_DECODE_TABLE[c] * 91;
                n |= v << b;
                b += (v & 8191) > 88 ? 13 : 14;

                while (b > 7) {
                    output.add((byte) (n & 0xFF));
                    n >>= 8;
                    b -= 8;
                }
                v = -1;
            }
        }

        if (v != -1) {
            output.add((byte) ((n | v << b) & 0xFF));
        }

        byte[] decodedBytes = new byte[output.size()];
        for (int i = 0; i < output.size(); i++) {
            decodedBytes[i] = output.get(i);
        }
        return decodedBytes;
    }
}
