package com.example.sensors_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.R
import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languages = resources.getStringArray(R.array.for_spinner)

        val sm = getSystemService(SENSOR_SERVICE) as SensorManager
        Log.d("everything", sm.getSensorList(1).toString())

        val spinner = findViewById<Spinner>(R.id.spinner)
        val listview=findViewById<ListView>(R.id.listview)
        Log.d("finding","creating string list")
        val strings_for_list= mutableListOf<String>("A")
        Log.d("finding","creating string list 1")
        val adapter_list = ArrayAdapter(this, android.R.layout.simple_list_item_1,strings_for_list)
        listview.adapter = adapter_list
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item, languages
            )
            spinner.adapter = adapter

            spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Log.d("AAAAAA","Ya tupoy")
                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if(languages[position]=="Состояние Человека")
                    {
                        var arrs=resources.getStringArray(R.array.Human)
                        var arrs_int=arrs.map { it.toInt() }
                        var mutable= mutableListOf<String>()
                        for(i in 0..(arrs_int.size-1))
                        {
                            var Sensorer=sm.getSensorList(arrs_int[i])
                            //Log.d("finding")
                            if(Sensorer!=null && Sensorer.isNotEmpty())
                                mutable.add(Sensorer[0].getName().toString())

                        }

                        Log.d("finding",mutable.toString())
                        strings_for_list.clear()

                        Log.d("finding","try")
                        strings_for_list.addAll(mutable)
                        Log.d("finding","except")
                        adapter_list.notifyDataSetChanged()
                    }
                    if(languages[position]=="Окружающая среда")
                    {
                        var arrs=resources.getStringArray(R.array.Wendsday)
                        var arrs_int=arrs.map { it.toInt() }
                        var mutable= mutableListOf<String>()
                        for(i in 0..(arrs_int.size-1))
                        {
                            var Sensorer=sm.getSensorList(arrs_int[i])
                            //Log.d("finding")
                            if(Sensorer!=null && Sensorer.isNotEmpty())
                                mutable.add(Sensorer[0].getName().toString())

                        }

                        Log.d("finding",mutable.toString())
                        strings_for_list.clear()

                        Log.d("finding","try")
                        strings_for_list.addAll(mutable)
                        Log.d("finding","except")
                        adapter_list.notifyDataSetChanged()
                    }
                    if(languages[position]=="Физическое положение ус-ва")
                    {
                        var arrs=resources.getStringArray(R.array.placing)
                        var arrs_int=arrs.map { it.toInt() }
                        var mutable= mutableListOf<String>()
                        for(i in 0..(arrs_int.size-1))
                        {
                            var Sensorer=sm.getSensorList(arrs_int[i])
                            //Log.d("finding")
                            if(Sensorer!=null && Sensorer.isNotEmpty())
                                mutable.add(Sensorer[0].getName().toString())

                        }

                        Log.d("finding",mutable.toString())
                        strings_for_list.clear()

                        Log.d("finding","try")
                        strings_for_list.addAll(mutable)
                        Log.d("finding","except")
                        adapter_list.notifyDataSetChanged()
                    }

                }

            }
        }
    }
}