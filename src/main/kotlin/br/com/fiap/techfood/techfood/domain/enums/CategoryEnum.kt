package br.com.fiap.techfood.techfood.domain.enums

enum class CategoryEnum(val categoryName: String, val id: Int) {
    SNACK("Lanche", 1),
    SIDE_DISH("Acompanhamento", 2),
    DRINK("Bebida", 3),
    DESSERT("Sobremesa", 4),
}
