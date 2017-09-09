class ApiGatewayResponse(
        val statusCode: Int = 200,
        var body: String? = null,
        val headers: Map<String, String>? = emptyMap<String, String>(),
        val isBase64Encoded: Boolean = false
) {
    private constructor(builder: Builder) : this(
            builder.statusCode,
            builder.rawBody,
            builder.headers,
            builder.base64Encoded
    )

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    class Builder {

        var statusCode: Int = 200
        var rawBody: String? = null
        var headers: Map<String, String>? = emptyMap<String, String>()
        var objectBody: Response? = null
        var binaryBody: ByteArray? = null
        var base64Encoded: Boolean = false

        fun build(): ApiGatewayResponse {
            var body: String? = null

            if (rawBody != null) {
                body = rawBody as String
            }
            else if (objectBody != null) {
                // todo
            } else if (binaryBody != null) {
                // todo
            }

            return ApiGatewayResponse(statusCode, body, headers, base64Encoded)
        }
    }
}
