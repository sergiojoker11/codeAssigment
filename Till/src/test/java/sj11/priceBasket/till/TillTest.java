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

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(class =  PersistanceConfiguration.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
	DbUnitTestExecutionListener.class })
public class TillTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public TillTest() {
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
    public void test_offer1_from_document() {
        String[] shoppingItems = {"Apples", "Milk", "Bread"};
        Till till = new Till();
        till.charge(shoppingItems);

        assertEquals(createExpectation("£3.10", "£3.00", "10%", "10p"), outContent.toString());
    }

    @Test
    public void test_no_offer_applied() {
        String[] shoppingItems = {"Milk"};
        Till till = new Till();
        till.charge(shoppingItems);

        assertEquals(createExpectation("£1.3", "£1.3"), outContent.toString());
    }

    private String createExpectation(String subtotal, String total, String ... rateOffAndDiscountedPairs) {
        StringBuilder expectation = new StringBuilder();
        expectation.append("Subtotal: ").append(subtotal);
        expectation.append(System.lineSeparator());
        if (rateOffAndDiscountedPairs.length == 0) {
            expectation.append("(No offers available)");
        } else {
            int index = 0;
            for (String item: rateOffAndDiscountedPairs) {
                if (index % 2 == 0) {
                    expectation.append("Apples ").append(item);
                } else {
                    expectation.append(" off: -").append(item).append("");
                    expectation.append(System.lineSeparator());
                }
                index++;
            }
        }
        expectation.append("Total price: ").append(total);
        return expectation.append(System.lineSeparator()).toString();
    }

}
