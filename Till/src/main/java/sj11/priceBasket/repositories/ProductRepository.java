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

package sj11.priceBasket.repositories;

import java.util.List;
import org.springframework.data.repository.Repository;
import sj11.priceBasket.entities.Product;

public interface ProductRepository extends Repository<Product, Long> {

    List<Product> findAll();
    Product save(Product product);
}
