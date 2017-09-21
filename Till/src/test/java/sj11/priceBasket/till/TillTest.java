/*
 * THIS SOFTWARE IS PROVIDED BY COSTAIN LTD ``AS IS'', WITH NO WARRANTY, TERM
 * OR CONDITION OF ANY KIND, EXPRESS OR IMPLIED, AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL COSTAIN LTD BE LIABLE FOR ANY LOSSES, CLAIMS OR DAMAGES OF
 * WHATEVER NATURE, INCLUDING ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGES OR LOSSES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE.
 *
 * Copyright 2017 © Costain Ltd.
 * All Rights Reserved.
 */
package sj11.priceBasket.till;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TillTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public TillTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    /**
     * Test of charge method, of class Till.
     */
    @Test
    public void testCharge() {
        String[] shoppingItems = {"Apples", "Milk", "Bread"};
        Till instance = new Till();
        instance.charge(shoppingItems);

        StringBuilder expectation = new StringBuilder();
        expectation.append("Subtotal: £3.10");
        expectation.append(System.lineSeparator());
        expectation.append("Apples 10% off: -10p");
        expectation.append(System.lineSeparator());
        expectation.append("Total price: £3.00");
        expectation.append(System.lineSeparator());
        assertEquals(expectation.toString(), outContent.toString());
    }

}
