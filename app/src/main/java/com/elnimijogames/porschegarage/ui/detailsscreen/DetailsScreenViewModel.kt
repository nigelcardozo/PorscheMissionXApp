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
        if (MenuId.MENU_ID_EXTERIOR == menuId) {
            detailsTitle.value = "Exterior"
            detailsImagePath.value = "file:///android_asset/images/cars/porsche18.jpg"
//            detailsText.value =
//                "<B>Carbon and Paintwork in perfect harmony.</B>" + "<BR>" + "‘Rocket Metallic’: this is the body colour of the Mission X, whose brown hue becomes darker depending on the viewing angle. To go with this: carbon surfaces varnished in Rocket Metallic (silky gloss) colour. This ensures a homogeneous transition from the exterior to the interior, underscoring the futuristic, sporty design." +
//                "<B>Pulsating Charging.</B>" + "<BR>" + "Charging the future: in addition to the front lights, the lighting on the support structure also blinks during charging, along with the letter ‘E’ in the <nobr>Porsche</nobr> Mission X at the rear. In the interior, the LED light strips in the seat shells and the Start/Stop button blink in sync with one another – all in white. A fascinating sight that doesn’t last long – thanks to the new high-voltage battery, the Mission X offers a charging experience like no e-vehicle before it." +
//                "<B>Le-Mans Style Doors.</B>" + "<BR>" + "Racing drama: the Le-Mans-style doors, which open upwards at the front, are attached to the A-pillar and the roof, and offer convenient access to the vehicle. This door concept was also used in the iconic <nobr>Porsche</nobr> 917. The Mission X also features side windows integrated into the Le-Mans-style doors." +
//                "<B>Adaptive Wing.</B>" + "<BR>" + "Maximum downforce for emotional thrust: the adaptive, extendable wing beside the support structure of the tail lights ensures optimum downforce. Together with the tuned underbody and targeted airflow, the Mission X generates extreme downforce, well above the level of the 911 GT3 RS."

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




            detailsText.value = annotatedString
        }
        else {
            Timber.d("detailsText not set")
        }
    }
}