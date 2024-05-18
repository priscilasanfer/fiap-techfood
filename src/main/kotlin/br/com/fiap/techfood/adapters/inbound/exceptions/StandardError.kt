package br.com.fiap.techfood.adapters.inbound.exceptions

import java.io.Serial
import java.io.Serializable

class StandardError(var status: Int, var msg: String, var timeStamp: Long) : Serializable {
    companion object {
        @Serial
        private val serialVersionUID = 1L
    }
}
