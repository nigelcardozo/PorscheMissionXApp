package com.elnimijogames.porschegarage.model

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.elnimijogames.porschegarage.R
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_ABOUT
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_EXPERIENCE
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_EXTERIOR
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_HIGHLIGHTS
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_INTERIOR
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_SUMMARY
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_TECHNOLOGY
import com.elnimijogames.porschegarage.model.MenuId.MENU_ID_VIDEOS
import timber.log.Timber
import javax.inject.Inject

class MenuDetailsRepository @Inject constructor(private val stringResourceProvider: StringResourceProvider) {

    fun getTitle(menuId: String): String {
        when (menuId) {
            MENU_ID_SUMMARY -> return stringResourceProvider.getString(R.string.menu_details_title_summary, "")
            MENU_ID_HIGHLIGHTS -> return stringResourceProvider.getString(R.string.menu_details_title_highlights, "")
            MENU_ID_INTERIOR -> return stringResourceProvider.getString(R.string.menu_details_title_interior, "")
            MENU_ID_EXTERIOR -> return stringResourceProvider.getString(R.string.menu_details_title_exterior, "")
            MENU_ID_EXPERIENCE -> return stringResourceProvider.getString(R.string.menu_details_title_experience, "")
            MENU_ID_TECHNOLOGY -> return stringResourceProvider.getString(R.string.menu_details_title_technology, "")
            MENU_ID_VIDEOS -> return stringResourceProvider.getString(R.string.menu_details_title_videos, "")
            MENU_ID_ABOUT -> return stringResourceProvider.getString(R.string.menu_details_title_about, "")
        }

        Timber.d("Illegal menuId value $menuId")
        return ""
    }

    fun getImagePath(menuId: String): String {
        when (menuId) {
            MENU_ID_SUMMARY -> return "file:///android_asset/images/cars/porsche13.jpg"
            MENU_ID_HIGHLIGHTS -> return "file:///android_asset/images/cars/porsche11.jpg"
            MENU_ID_INTERIOR -> return "file:///android_asset/images/cars/porsche18.jpg"
            MENU_ID_EXTERIOR -> return "file:///android_asset/images/cars/porsche24.jpg"
            MENU_ID_EXPERIENCE -> return "file:///android_asset/images/cars/porsche9.jpg"
            MENU_ID_TECHNOLOGY -> return "file:///android_asset/images/cars/porsche22.jpg"
            MENU_ID_VIDEOS -> return "file:///android_asset/images/cars/porsche7.jpg"
            MENU_ID_ABOUT -> return "file:///android_asset/images/cars/porsche16.jpg"
        }

        Timber.d("Illegal menuId value $menuId")
        return ""
    }

    fun getDetails(menuId: String): AnnotatedString {
        when (menuId) {
            MENU_ID_SUMMARY -> return getSummaryTextDetails()
            MENU_ID_HIGHLIGHTS -> return getHighlightsTextDetails()
            MENU_ID_INTERIOR -> return getInteriorTextDetails()
            MENU_ID_EXTERIOR -> return getExteriorTextDetails()
            MENU_ID_EXPERIENCE -> return getExperienceTextDetails()
            MENU_ID_TECHNOLOGY -> return getTechnologyTextDetails()
            MENU_ID_VIDEOS -> return getVideosTextDetails()
            MENU_ID_ABOUT -> return getAboutTextDetails()
        }

        Timber.d("Illegal menuId value $menuId")
        return buildAnnotatedString {  }
    }

    private fun getSummaryTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Mission X")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Many Porsche vehicles have created history. The Mission X is about to create the future – the spectacular reinterpretation of a lightweight hypercar with Le-Mans-style doors and high-performance electric drive is an innovative vision of the future. Like the iconic sports cars of the past – the 959, Carrera GT and 918 Spyder – the Mission X will set new standards for the development of futuristic vehicle concepts and reinterpret distinctive Porsche elements. Its motorsport DNA is unmistakeable, just like its commitment to maximum e-performance. The Mission X is our vision of the fastest road-legal vehicle on the Nürburgring’s famous Nordschleife loop. This is based on its 1:1 power/weight ratio, high-performance electric drive and extreme downforce values.")
            }
            appendLine()
        }

        return annotatedString
    }

    private fun getHighlightsTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Lightweight Glass Dome.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Resembling an aircraft cockpit: a lightweight glass dome with a carbon exoskeleton encompasses both occupants. The Daytona windscreen is another standout element: it provided added visibility around sharp turns in historic race cars, and it gives the Mission X an even more open feeling of space.")
            }
            appendLine()
            appendLine()


            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Lightweight Structure.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Top-class lightweight design: inspired by architectural support structures, there isn’t a single superfluous gram of weight in the Mission X.")
            }
            appendLine()
            appendLine()


            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Iconic Light Signature.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Following in the path of earlier motorsport vehicles: the distinctive four-point light signature of the main headlights has been reinterpreted and vertically arranged.")
            }
            appendLine()
            appendLine()


            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Driving Experience of the Future.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("The driving experience of tomorrow: the interior has been focused on the driver down to the finest detail – from the individually adapted seat shells to the driver-focused curved display and the colour concept.")
            }
            appendLine()
            appendLine()
        }

        return annotatedString
    }

    private fun getInteriorTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("The Perfect Seat.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Adapted to the driver via scans and integrated into the monocoque: the CFRP seat shells with custom upholstery, the six-point seat belt and the integrated LED light strip. The driver’s seat in Kalahari Grey also clearly stands out from the passenger seat in the contrasting colour of Andaluz Brown. An asymmetrical design that deliberately puts the driver at the heart of things.")
            }
            appendLine()
            appendLine()


            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Performance Made to Measure.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Optimum ergonomics for rapid lap times: the leather pads on the seats of the Mission X are individually adapted for the driver. If desired, the top pad can be removed when driving with a helmet. The pedals can also be adjusted if necessary. A scale in the footwell area ensures optimum interaction.")
            }
            appendLine()
            appendLine()


            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Driver-orientated displays.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Clear focus: centre screen, curved display and digital wing mirrors are all set up with the driver in mind. In addition, all essential controls are located on the driver’s axle. Also integrated into the Mission X: a Track Mode view, which clearly displays all key performance data.")
            }
            appendLine()
        }

        return annotatedString
    }

    private fun getExteriorTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Carbon and Paintwork in perfect harmony.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("‘Rocket Metallic’: this is the body colour of the Mission X, whose brown hue becomes darker depending on the viewing angle. To go with this: carbon surfaces varnished in Rocket Metallic (silky gloss) colour. This ensures a homogeneous transition from the exterior to the interior, underscoring the futuristic, sporty design.")
            }
            appendLine()
            appendLine()

            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Le-Mans Style Doors.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Racing drama: the Le-Mans-style doors, which open upwards at the front, are attached to the A-pillar and the roof, and offer convenient access to the vehicle. This door concept was also used in the iconic Porsche 917. The Mission X also features side windows integrated into the Le-Mans-style doors.")
            }
            appendLine()
            appendLine()


            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Adaptive Wing.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Maximum downforce for emotional thrust: the adaptive, extendable wing beside the support structure of the tail lights ensures optimum downforce. Together with the tuned underbody and targeted airflow, the Mission X generates extreme downforce, well above the level of the 911 GT3 RS.")
            }
            appendLine()
        }

        return annotatedString
    }

    private fun getExperienceTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("The Experience of the Future.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("The driving experience of tomorrow: the interior has been focused on the driver down to the finest detail – from the individually adapted seat shells to the driver-focused curved display and the colour concept.")
            }
            appendLine()
            appendLine()

            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Shared Emotions.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("A touch of a button on the multi-purpose controller is all it takes: six cameras bring the track experience to life and for all to see. Three exterior and three interior cameras capture the track, driver and passenger. A highlight video is then created automatically, which can be shared directly on social media.")
            }
            appendLine()
        }

        return annotatedString
    }

    private fun getTechnologyTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Pulsating Charging.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("Charging the future: in addition to the front lights, the lighting on the support structure also blinks during charging, along with the letter ‘E’ in the Porsche Mission X at the rear. In the interior, the LED light strips in the seat shells and the Start/Stop button blink in sync with one another – all in white. A fascinating sight that doesn’t last long – thanks to the new high-voltage battery, the Mission X offers a charging experience like no e-vehicle before it.")
            }
            appendLine()
            appendLine()

            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Shared Emotions.")
            }
            appendLine()
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Normal
                )
            ) {
                append("A touch of a button on the multi-purpose controller is all it takes: six cameras bring the track experience to life and for all to see. Three exterior and three interior cameras capture the track, driver and passenger. A highlight video is then created automatically, which can be shared directly on social media.")
            }
            appendLine()
        }

        return annotatedString
    }

    private fun getVideosTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {}
        return annotatedString
    }

    private fun getAboutTextDetails(): AnnotatedString {
        val annotatedString = buildAnnotatedString {}
        return annotatedString
    }
}