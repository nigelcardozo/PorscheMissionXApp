package com.elnimijogames.porschegarage.ui.detailsscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.elnimijogames.porschegarage.model.DetailItem
import com.elnimijogames.porschegarage.model.MenuId
import com.elnimijogames.porschegarage.model.MenuItem
import com.elnimijogames.porschegarage.model.MenuItemRepository
import com.elnimijogames.porschegarage.model.MenuPhotoGalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val detailsTitle: MutableState<String> = mutableStateOf("")
    val detailsText: MutableState<AnnotatedString> = mutableStateOf(buildAnnotatedString {})
    val detailsImagePath: MutableState<String> = mutableStateOf("")

    init {
        val menuId = savedStateHandle.get<String>("menuId")?: ""

        Timber.d("menuId == $menuId")

//        if (MenuId.MENU_ID_SUMMARY == menuId) {
//            detailsText.value = "SUMMARY"
//            Timber.d("detailsText set to SUMMARY")
//        } else if (MenuId.MENU_ID_HIGHLIGHTS == menuId) {
//            detailsText.value = "HIGHLIGHTS"
//            Timber.d("detailsText set to HIGHLIGHTS")
//        } else if (MenuId.MENU_ID_INTERIOR == menuId) {
//            detailsImagePath.value = "file:///android_asset/images/cars/porsche18.jpg"
//            detailsText.value =
//                "The Perfect Seat." + "Adapted to the driver via scans and integrated into the monocoque: the CFRP seat shells with custom upholstery, the six-point seat belt and the integrated LED light strip. The driver’s seat in Kalahari Grey also clearly stands out from the passenger seat in the contrasting colour of Andaluz Brown. An asymmetrical design that deliberately puts the driver at the heart of things." +
//                "Performance Made to Measure" + "Optimum ergonomics for rapid lap times: the leather pads on the seats of the Mission X are individually adapted for the driver. If desired, the top pad can be removed when driving with a helmet. The pedals can also be adjusted if necessary. A scale in the footwell area ensures optimum interaction." +
//                "Driver-orientated displays." + "Clear focus: centre screen, curved display and digital wing mirrors are all set up with the driver in mind. In addition, all essential controls are located on the driver’s axle. Also integrated into the Mission X: a Track Mode view, which clearly displays all key performance data." +
//                "Shared Emotions" + "A touch of a button on the multi-purpose controller is all it takes: six cameras bring the track experience to life and for all to see. Three exterior and three interior cameras capture the track, driver and passenger. A highlight video is then created automatically, which can be shared directly on social media."
//        } else if (MenuId.MENU_ID_EXTERIOR == menuId) {
        if (MenuId.MENU_ID_SUMMARY == menuId) {
            detailsTitle.value = getSummaryTitle()
            detailsImagePath.value = getSummaryImagePath()
            detailsText.value = getSummaryTextDetails()
        } else if (MenuId.MENU_ID_HIGHLIGHTS == menuId) {
            detailsTitle.value = getHighlightsTitle()
            detailsImagePath.value = getHighlightsImagePath()
            detailsText.value = getHighlightsTextDetails()
        } else if (MenuId.MENU_ID_INTERIOR == menuId) {
            detailsTitle.value = getInteriorTitle()
            detailsImagePath.value = getInteriorImagePath()
            detailsText.value = getInteriorTextDetails()
        } else if (MenuId.MENU_ID_EXTERIOR == menuId) {
            detailsTitle.value = getExteriorTitle()
            detailsImagePath.value = getExteriorImagePath()
            detailsText.value = getExteriorTextDetails()
        } else if (MenuId.MENU_ID_EXPERIENCE == menuId) {
            detailsTitle.value = getExperienceTitle()
            detailsImagePath.value = getExperienceImagePath()
            detailsText.value = getExperienceTextDetails()
        } else if (MenuId.MENU_ID_TECHNOLOGY == menuId) {
            detailsTitle.value = getTechnologyTitle()
            detailsImagePath.value = getTechnologyImagePath()
            detailsText.value = getTechnologyTextDetails()
        } else if (MenuId.MENU_ID_VIDEOS == menuId) {
            detailsTitle.value = getVideosTitle()
            detailsImagePath.value = getVideosImagePath()
            detailsText.value = getVideosTextDetails()
        } else if (MenuId.MENU_ID_ABOUT == menuId) {
            detailsTitle.value = getAboutTitle()
            detailsImagePath.value = getAboutImagePath()
            detailsText.value = getAboutTextDetails()
        }
        else {
            Timber.d("detailsText not set")
        }
    }
}

private fun getSummaryTitle(): String {
    return "Summary"
}

private fun getSummaryImagePath(): String {
    return "file:///android_asset/images/cars/porsche13.jpg"
}

private fun getSummaryTextDetails(): AnnotatedString {
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
        appendLine()
    }

    return annotatedString
}

private fun getHighlightsTitle(): String {
    return "Highlights"
}

private fun getHighlightsImagePath(): String {
    return "file:///android_asset/images/cars/porsche11.jpg"
}

private fun getHighlightsTextDetails(): AnnotatedString {
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
        appendLine()
    }

    return annotatedString
}


private fun getInteriorTitle(): String {
    return "Interior"
}

private fun getInteriorImagePath(): String {
    return "file:///android_asset/images/cars/porsche18.jpg"
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
        appendLine()
    }
    
    return annotatedString
}

private fun getExteriorTitle(): String {
    return "Exterior"
}

private fun getExteriorImagePath(): String {
    return "file:///android_asset/images/cars/porsche24.jpg"
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

private fun getExperienceTitle(): String {
    return "Experience"
}

private fun getExperienceImagePath(): String {
    return "file:///android_asset/images/cars/porsche9.jpg"
}

private fun getExperienceTextDetails(): AnnotatedString {
    val annotatedString = buildAnnotatedString {}
    return annotatedString
}

private fun getTechnologyTitle(): String {
    return "Technology"
}

private fun getTechnologyImagePath(): String {
    return "file:///android_asset/images/cars/porsche22.jpg"
}

private fun getTechnologyTextDetails(): AnnotatedString {
    val annotatedString = buildAnnotatedString {}
    return annotatedString
}

private fun getVideosTitle(): String {
    return "Videos"
}

private fun getVideosImagePath(): String {
    return "file:///android_asset/images/cars/porsche7.jpg"
}

private fun getVideosTextDetails(): AnnotatedString {
    val annotatedString = buildAnnotatedString {}
    return annotatedString
}

private fun getAboutTitle(): String {
    return "About"
}

private fun getAboutImagePath(): String {
    return "file:///android_asset/images/cars/porsche16.jpg"
}

private fun getAboutTextDetails(): AnnotatedString {
    val annotatedString = buildAnnotatedString {}
    return annotatedString
}