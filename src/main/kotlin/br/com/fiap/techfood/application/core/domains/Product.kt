package br.com.fiap.techfood.application.core.domains

import br.com.fiap.techfood.application.core.domains.enums.CategoryEnum
import java.math.BigDecimal

class Product {

    var name : String? =null
    var description : String? =null
    var price : BigDecimal? =null
    var category : CategoryEnum? =null
    var imageURL : String? =null


}