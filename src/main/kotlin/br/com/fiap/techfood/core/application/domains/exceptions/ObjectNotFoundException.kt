package br.com.fiap.techfood.core.application.domains.exceptions

import java.io.Serial

class ObjectNotFoundException : RuntimeException {

    constructor(msg: String?) : super(msg)

    constructor(msg: String?, cause: Throwable?) : super(msg, cause)

    companion object {
        @Serial
        private val serialVersionUID = 1L
    }

}
