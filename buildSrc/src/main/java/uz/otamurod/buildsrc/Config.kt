package buildsrc

object Config {
    const val applicationId:String = "uz.otamurod.hotelmanagement"
    const val packageNameApp:String = "uz.otamurod.hotelmanagement"
    const val packageNameLibPresentation:String = "uz.otamurod.presentation"
    const val packageNameLibData:String = "uz.otamurod.data"
    const val packageNameLibDomain:String = "uz.otamurod.domain"

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