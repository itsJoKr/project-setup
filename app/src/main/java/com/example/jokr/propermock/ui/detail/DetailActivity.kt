package com.example.jokr.propermock.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jokr.propermock.R
import com.example.jokr.propermock.common.extensions.toUrl
import com.example.jokr.propermock.models.Race
import com.fiaformulae.formulae.common.bindings.arg
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_race.view.*

class DetailActivity : AppCompatActivity() {

    val raceArg by arg<Race>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        raceArg?.let { race ->
            raceSequence.text = "R${race.sequence}"
            raceCode.text = race.raceCode
            raceName.text = race.circuitName
            description.text = race.description
            raceDate.text = race.raceDate
            val url = race.images!!.first().url!!.toUrl()
            Picasso.get().load(url).into(raceBackgroundImage)
        }

    }
}
