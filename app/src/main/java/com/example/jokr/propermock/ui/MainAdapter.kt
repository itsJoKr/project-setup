package com.example.jokr.propermock.ui

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.jokr.propermock.R
import com.example.jokr.propermock.common.SimpleViewHolder
import com.example.jokr.propermock.common.extensions.inflateIntoSelf
import com.example.jokr.propermock.dagger.modules.NetworkModule.Companion.BASE_URL
import com.example.jokr.propermock.models.Race
import com.example.jokr.propermock.models.Races
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_race.view.*

class MainAdapter(
    private var races: Races,
    private var onRaceClick: ((Race) -> Unit)
): RecyclerView.Adapter<SimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(parent.inflateIntoSelf(R.layout.item_race))
    }

    override fun getItemCount() = races.count()

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val race = races[position]
        holder.itemView.apply {
            raceSequence.text = "R${race.sequence}"
            raceCode.text = race.raceCode
            raceName.text = race.circuitName
            raceCityName.text = race.city
            raceDate.text = race.raceDate

            val url = fullUrl(race.images!!.first().url!!)
            Picasso.get().load(url).into(raceBackgroundImage)
            val flagUrl = fullUrl(race.raceFlag!!.url!!)
            Picasso.get().load(flagUrl).into(raceCountryFlag)
        }
    }

    private fun fullUrl(url: String): String {
        return if (url.startsWith("/")) {
            BASE_URL + url
        } else {
            url
        }
    }
}