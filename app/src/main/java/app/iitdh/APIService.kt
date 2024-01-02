package app.iitdh

class APIService
{
    private val service: Api

    fun getService(): Api {
        return service
    }

    init {
        val baseUrl = "https://iitdh.ac.in/"
        val client = OkHttpClient.Builder()
        client.connectTimeout(2, TimeUnit.MINUTES)
        client.readTimeout(2, TimeUnit.MINUTES)
        client.writeTimeout(2, TimeUnit.MINUTES)
        val gson = GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").setLenient().create()
        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).client(client.build()).build()
        service = retrofit.create(Api::class.java)
    }
}