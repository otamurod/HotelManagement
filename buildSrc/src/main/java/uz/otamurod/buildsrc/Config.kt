package uz.otamurod.buildsrc

object Config {
    const val BASE_URL = "https://run.mocky.io"

    const val applicationId:String = "uz.otamurod.hotelmanagement"
    const val packageNameApp:String = "uz.otamurod.hotelmanagement"
    const val packageNameLibPresentation:String = "uz.otamurod.presentation"
    const val packageNameLibData:String = "uz.otamurod.data"

    object Build {
        const val versionCode: Int = 2
        const val versionName: String = "2.0.0"
    }

    object Sdk {
        const val min = 21
        const val target = 34
        const val compile = 34
    }
}