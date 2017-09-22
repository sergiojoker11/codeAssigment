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

import java.util.Arrays;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sj11.priceBasket.config.PersistenceAndBeansConfiguration;
import sj11.priceBasket.entities.DiscountApplied;
import sj11.priceBasket.entities.Product;
import sj11.priceBasket.entities.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceAndBeansConfiguration.class})
public class DiscountApplierTest {

    @Autowired
    private DiscountApplier discountApplier;

    private final float epsilon = 0.0000001f;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void applyDiscounts_applyDiscount1_totalIs10pLessThanSubtotal() {
        Ticket ticket = new Ticket();
        Product p1 = new Product("Apples", 1f);
        DiscountApplied da1 = new DiscountApplied(p1, 10f, null, null, null, null, null, null, null, null);
        ticket.setDiscountsApplied(new HashSet<>(Arrays.asList(da1)));
        ticket.setSubtotalInPounds(1f);

        discountApplier.applyDiscounts(ticket);

        assertTrue(compare(0.9f, ticket.getSubtotalInPounds() - 0.1f));
    }
    private boolean compare(float factor1, float factor2) {
        return Math.abs(factor1 - factor2) < this.epsilon;
    }

}
