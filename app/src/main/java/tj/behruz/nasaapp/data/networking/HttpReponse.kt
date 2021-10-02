
package tj.behruz.nasaapp.data.networking

interface HttpResponse {

    val statusCode: Int

    val statusMessage: String?

    val url: String?

}