package com.example.appfortest.viewModel

import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.appfortest.data.item
import com.example.appfortest.layout.Hunter
import kotlinx.android.synthetic.main.activity_hunter.*

class hunter:ViewModel(){

    var monterHp = 1000000
    var HunterHp = 100000
    var mony = 1000
    var monhun = ArrayList<item>()

    fun buyItem(item: LinearLayout){
        when (item.visibility.toString()) {
            "0" -> item.visibility = View.GONE
            "8" -> item.visibility = View.VISIBLE
        }
    }
    fun up_hp(item_recycle:RecyclerView,buy_layout:LinearLayout,context:Hunter){
        if (monhun.size > 0) {
            buy_layout.visibility = View.GONE
            when (item_recycle.visibility.toString()) {
                "0" -> item_recycle.visibility = View.GONE
                "8" -> item_recycle.visibility = View.VISIBLE
            }
        }else{
            Toast.makeText(context, "ไม่มี item", Toast.LENGTH_SHORT).show()
        }
    }
    fun buy100(context: Hunter){
        if (mony-20 >=0){
            mony -= 20
            set(context)
            monhun.add(item("Hp+100"))
        }else{
            Toast.makeText(context, "point ไม่พอ", Toast.LENGTH_SHORT).show()
        }
    }
    fun buy1000(context: Hunter){
        if (mony-200 >=0){
            mony -= 20
            set(context)
            monhun.add(item("Hp+1000"))
        }else{
            Toast.makeText(context, "point ไม่พอ", Toast.LENGTH_SHORT).show()
        }
    }

    fun set(context:Hunter){
        context.monter_Hp.setText("Monter Hp\n"+"%,d".format(monterHp))
        context.hunter_Hp.setText("Hunter Hp\n"+"%,d".format(HunterHp)+"    point: "+mony)
    }

    fun setDamagemon(context: Hunter){
        var D = (1000..1250).random()
        monterHp -= D
        context.textView7.setText("- $D")
        set(context)
        Handler().postDelayed({
            context.textView7.setText(" ")
        }, 1500)
        setDamagehun(context)
    }
    fun setDamagehun(context: Hunter){
        var D = (1000..2000).random()
        HunterHp -= D

        Handler().postDelayed({
            context.textView8.setText("- $D")
            set(context)
        }, 1000)
    }
    fun hit(context: Hunter){
        context.item_recycle.visibility = View.GONE
        context.buy_layout.visibility = View.GONE
        setDamagemon(context)
        context.counter.isClickable=false

        Handler().postDelayed({
            context.counter.isClickable=true
            context.textView8.setText(" ")
            win(context)
        }, 3000)

    }

    fun win(context: Hunter){
        if(monterHp <= 0){
            context.textView7.setText("You Win!!")
            reset(context)
        }else if(HunterHp <= 0){
            context.textView7.setText("You Lost")
            reset(context)
        }
    }
    fun reset(context: Hunter){
        monterHp = 1000000
        HunterHp = 100000
        mony = 1000
        monhun.clear()
        set(context)
    }

    override fun onCleared() {
        onCleared()
        super.onCleared()
    }
}
